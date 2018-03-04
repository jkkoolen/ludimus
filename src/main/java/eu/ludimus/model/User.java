package eu.ludimus.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import eu.ludimus.model.serializer.UserSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@JsonSerialize(using = UserSerializer.class)
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {
    public enum Role {
        ROLE_ADMIN,
        ROLE_USER
    }

	private String email;
	
    @Setter
	private String password;
	
	private boolean active;
	
    private Role role;
    
    private String bank;

    private String iban;

    private String bic;

    private Long coc;

    private String vatNumber;

    private String fullName;
}
