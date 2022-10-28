package com.emilia.pharmacy.form.sqlForms;

import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.enums.Role;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className SQLKeyForm
  @version 1.0.0
  @since 16.08.2022
*/
public class SQLKeyForm {
    private int id;
    private String username;
    private String password;
    private String confirmPassword;
    private String role;

    public SQLKeyForm() {
    }

    public SQLKeyForm(int id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public SQLKeyForm(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public SQLKeyForm(int id, String username, String password, String confirmPassword, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public SQLKeyForm(String username, String password, String confirmPassword, String role) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "SQLKeyForm{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
