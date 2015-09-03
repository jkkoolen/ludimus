package eu.ludimus.service.dto.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UserRegisterValidator.class)
public @interface CheckUserRegister {
    String message() default "Passwords are not the same";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}
