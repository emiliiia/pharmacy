package com.emilia.pharmacy.form.mongoForms;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalClientForm
  @version 1.0.0
  @since 15.07.2022
*/
public class ClientForm {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;

    private String clientName;
    private String clientPhNum;
    private String clientEmail;
    private String clientDateBirth;

    public ClientForm() {
    }

    public ClientForm(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientName, String clientPhNum, String clientEmail, String clientDateBirth) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientName = clientName;
        this.clientPhNum = clientPhNum;
        this.clientEmail = clientEmail;
        this.clientDateBirth = clientDateBirth;
    }

    public ClientForm(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientName, String clientPhNum, String clientEmail, String clientDateBirth) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientName = clientName;
        this.clientPhNum = clientPhNum;
        this.clientEmail = clientEmail;
        this.clientDateBirth = clientDateBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhNum() {
        return clientPhNum;
    }

    public void setClientPhNum(String clientPhNum) {
        this.clientPhNum = clientPhNum;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientDateBirth() {
        return clientDateBirth;
    }

    public void setClientDateBirth(String clientDateBirth) {
        this.clientDateBirth = clientDateBirth;
    }

    @Override
    public String toString() {
        return "ExtemporalClientForm{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientPhNum='" + clientPhNum + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", clientDateBirth=" + clientDateBirth +
                '}';
    }
}
