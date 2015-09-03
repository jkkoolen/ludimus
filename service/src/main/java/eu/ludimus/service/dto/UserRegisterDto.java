package eu.ludimus.service.dto;

import eu.ludimus.service.dto.validation.CheckUserRegister;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@CheckUserRegister
@Data
public class UserRegisterDto {
	@NotNull
    @NotEmpty
    private String email;
    @NotNull
    @NotEmpty
    private String password1;
    @NotNull
    @NotEmpty
    private String password2;

}

