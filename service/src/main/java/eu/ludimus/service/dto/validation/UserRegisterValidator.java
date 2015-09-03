package eu.ludimus.service.dto.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eu.ludimus.service.dto.UserRegisterDto;

public class UserRegisterValidator implements ConstraintValidator<CheckUserRegister, UserRegisterDto> {

        @Override
        public void initialize(CheckUserRegister arg0) {
        }

        @Override
        public boolean isValid(UserRegisterDto userRegisterDto, ConstraintValidatorContext context) {
        	if(userRegisterDto == null 
        			|| userRegisterDto.getEmail() == null 
        			|| userRegisterDto.getPassword1() == null
        			|| userRegisterDto.getPassword2() == null)
        		return true;
                context
            .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
            .addPropertyNode("password1").addConstraintViolation()
            .disableDefaultConstraintViolation();
            return userRegisterDto.getPassword1().equals(userRegisterDto.getPassword2());
        }
}

