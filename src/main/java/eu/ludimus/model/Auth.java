package eu.ludimus.model;

public class Auth {
    private String email;
    private String password;

    public Auth() {

    }

    public Auth(final String email,final String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public Auth setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Auth setPassword(String password) {
        this.password = password;
        return this;
    }
}
