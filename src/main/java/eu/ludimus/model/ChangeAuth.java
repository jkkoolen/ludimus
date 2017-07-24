package eu.ludimus.model;

public class ChangeAuth extends Auth {
    private String newPassword1;
    private String newPassword2;

    public ChangeAuth() {

    }

    public ChangeAuth(final String email, final String password, final String newPassword1, final String newPassword2) {
        super(email, password);
        this.newPassword1 = newPassword1;
        this.newPassword2 = newPassword2;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public ChangeAuth setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
        return this;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public ChangeAuth setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
        return this;
    }
}
