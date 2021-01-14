package pl.mariusz.springtraining;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringTrainingApplication implements CommandLineRunner {

    private final PriceService service;

    public SpringTrainingApplication(PriceService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringTrainingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("price; " + service.getPrice(new Movie("Title", MovieType.REGULAR), 3));
        System.out.println("price; " + service.getPrice(new Movie("Title", MovieType.CHILDREN), 3));
        System.out.println("price; " + service.getPrice(new Movie("Title", MovieType.ELDER), 3));
    }
}

@Service
class PriceService {
    private final PriceRepo repo;

    PriceService(PriceRepo repo) {
        this.repo = repo;
    }

    public int getPrice(Movie movie, int days) {
        return measure(() -> movie.getType().algorytm.apply(this, days));
    }

    private int measure(Supplier<Integer> function) {
        long start = System.nanoTime();
        Integer price =  function.get();
        repo.logTime((System.nanoTime() - start)/1000);
        return price;
    }

    public Integer calcRegularPrice(int days) {
        return repo.getValue(MovieType.REGULAR) + 1;
    }

    public Integer calcChildrenPrice(int days) {
        return 5;
    }

    public Integer calcElderPrice(int days) {
        return repo.getValue(MovieType.ELDER) + 2;
    }

}

@Component
@Slf4j
class PriceRepo {

    public int getValue(MovieType type) {
        switch (type) {
            case CHILDREN:
                return 1;
            case REGULAR:
                return 2;
            case ELDER:
                return 4;
        }
        return 0;
    }

    public void logTime(long l) {
        log.info("Log database execution time " + l);
    }
}

enum MovieType {
    REGULAR(PriceService::calcRegularPrice),
    CHILDREN(PriceService::calcChildrenPrice),
    ELDER(PriceService::calcElderPrice);

    public final BiFunction<PriceService, Integer, Integer> algorytm;

    MovieType(BiFunction<PriceService, Integer, Integer> algorytm) {
        this.algorytm = algorytm;
    }
}

@Getter
class Movie {
    private String title;
    private MovieType type;

    public Movie(String title, MovieType type) {
        this.title = title;
        this.type = type;
    }
}

