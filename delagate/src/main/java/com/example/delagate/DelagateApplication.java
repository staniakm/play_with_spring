package com.example.delagate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SpringBootApplication
public class DelagateApplication {

    private final IComputeClass computeClass;
    private final IComputeClass computeClass2;

    public DelagateApplication(@WithCache IComputeClass computeClass,
                               @WithoutCache IComputeClass computeClass2) {
        this.computeClass = computeClass;
        this.computeClass2 = computeClass2;
    }


    public static void main(String[] args) {
        SpringApplication.run(DelagateApplication.class, args);
    }

    @PostConstruct
    public void compute() throws InterruptedException {
        System.out.println("Start");
        computeClass.doSomeStuff(1);
        computeClass.doSomeStuff(1);
        computeClass2.doSomeStuff(2);
        System.out.println("Stop");
    }

}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface WithCache {
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@interface WithoutCache {
}
