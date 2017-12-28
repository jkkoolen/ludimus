package eu.ludimus.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name="user")
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

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
    @Setter
	private String password;
	
	@Column(name = "active")
	private boolean active;
	
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    
    @Column(name = "bank")
    private String bank;

    @Column(name = "iban")
    private String iban;

    @Column(name = "bic")
    private String bic;

    @Column(name = "coc")
    private Long coc;

    @Column(name = "vat_number")
    private String vatNumber;

    @Column(name = "full_name")
    private String fullName;

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public String getBank() {
//        return bank;
//    }
//
//    public void setBank(String bank) {
//        this.bank = bank;
//    }
//
//    public String getIban() {
//        return iban;
//    }
//
//    public void setIban(String iban) {
//        this.iban = iban;
//    }
//
//    public String getBic() {
//        return bic;
//    }
//
//    public void setBic(String bic) {
//        this.bic = bic;
//    }
//
//    public Long getCoc() {
//        return coc;
//    }
//
//    public void setCoc(Long coc) {
//        this.coc = coc;
//    }
//
//    public String getVatNumber() {
//        return vatNumber;
//    }
//
//    public void setVatNumber(String vatNumber) {
//        this.vatNumber = vatNumber;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "--> User{" +
//                "email='" + email + '\'' +
//                ", active=" + active +
//                ", role=" + role +
//                ", bank='" + bank + '\'' +
//                ", iban='" + iban + '\'' +
//                ", bic='" + bic + '\'' +
//                ", coc=" + coc +
//                ", vatNumber='" + vatNumber + '\'' +
//                ", fullName='" + fullName + '\'' +
//                '}';
//    }
}
