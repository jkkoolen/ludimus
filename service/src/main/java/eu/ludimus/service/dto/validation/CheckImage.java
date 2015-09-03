package eu.ludimus.service.dto.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=ImageValidator.class)
public @interface CheckImage {
    String message() default "Not a valid image";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}
