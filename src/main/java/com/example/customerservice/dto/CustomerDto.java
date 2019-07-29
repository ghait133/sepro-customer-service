package com.example.customerservice.dto;

import com.example.customerservice.validation.PasswordMatches;
import com.example.customerservice.validation.ValidEmail;
import com.example.customerservice.validation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class CustomerDto {

    String vorname;
    String nachname;
    String telNumbre;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    private String role;

    public CustomerDto(String password, @NotNull @Size(min = 1) String matchingPassword, @NotNull @Size(min = 1, message = "{Size.userDto.email}") String email, String role) {
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
        this.role = role;
    }
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTelNumbre() {
        return telNumbre;
    }

    public void setTelNumbre(String telNumbre) {
        this.telNumbre = telNumbre;
    }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role;}

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }



    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [username=").append(email).append(", password=").append(password).append(", matchingPassword=").append(matchingPassword).append(", email=").append(email).append(", isUsing2FA=")
                .append(role).append("]");
        return builder.toString();
    }
}
