package eu.ludimus.model;

import lombok.Data;

@Data
public class Auth {
    private String email;
    private String password;

    public Auth() {

    }

    public Auth(final String email,final String password) {
        this.email = email;
        this.password = password;
    }

}
