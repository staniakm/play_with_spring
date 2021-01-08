package pl.mariusz.demoannoatation.annotation;

import org.springframework.validation.annotation.Validated;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy= AddressValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Validated
public @interface AddressConstraint {

    String message() default "Invalid address";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default{};


}
