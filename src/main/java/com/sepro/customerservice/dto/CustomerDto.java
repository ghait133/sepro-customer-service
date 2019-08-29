package com.sepro.customerservice.dto;

import com.sepro.customerservice.validation.PasswordMatches;
import com.sepro.customerservice.validation.ValidEmail;
import com.sepro.customerservice.validation.ValidPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
public class CustomerDto {

    private String vorname;
    private String nachname;
    private String telNumbre;

    @ValidPassword
    private String password;

    @NotNull
    @Size(min = 1)
    private String confirmPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;


    public CustomerDto(String password, @NotNull @Size(min = 1) String matchingPassword, @NotNull @Size(min = 1, message = "{Size.userDto.email}") String email) {
        this.password = password;
        this.confirmPassword = matchingPassword;
        this.email = email;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("UserDto [username=").append(email).append(", password=").append(password).append(", matchingPassword=").append(confirmPassword).append(", email=").append(email).append(", isUsing2FA=")
               .append("]");
        return builder.toString();
    }
}
