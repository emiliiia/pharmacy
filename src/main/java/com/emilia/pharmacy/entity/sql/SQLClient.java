package com.emilia.pharmacy.entity.sql;
/*
  @author emilia
  @project pharmacy
  @className OfficinalClient
  @version 1.0.0
  @since 28.06.2022
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name = "client")
@ApiModel(value = "ClientModel", description = "Client model for Client table")
public class SQLClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @ApiModelProperty(value = "id of object",
            name = "id",
            dataType = "Integer",
            example = "1")
    private Integer id;
    @Column(name = "createdat", nullable = false)
    @ApiModelProperty(value = "object's creation date",
            name = "createdAt",
            dataType = "LocalDateTime",
            example = "022-09-11T01:37:55.199895")
    private LocalDateTime createdAt;
    @Column(name = "updatedat", nullable = false)
    @ApiModelProperty(value = "the object's update date",
            name = "updatedAt",
            dataType = "LocalDateTime",
            example = "022-09-11T01:37:55.199895")
    private LocalDateTime updatedAt;
    @Column(name = "description", nullable = false)
    @ApiModelProperty(value = "description of object",
            name = "description",
            dataType = "String",
            example = "Client")
    private String description;

    @Column(name = "clientname")
    @ApiModelProperty(value = "name of the client",
            name = "clientName",
            dataType = "String",
            example = "Olga Okorokova")
    private String clientName;
    @Column(name = "clientphnum")
    @ApiModelProperty(value = "phone number of the client",
            name = "clientPhNum",
            dataType = "String",
            example = "+380505372122")
    private String clientPhNum;
    @Column(name = "clientemail")
    @ApiModelProperty(value = "email of the client",
            name = "clientEmail",
            dataType = "String",
            example = "examplecv@gmail.com")
    private String clientEmail;
    @Column(name = "clientdatebirth")
    @ApiModelProperty(value = "date of birth of the client",
            name = "clientDateBirth",
            dataType = "LocalDate",
            example = "examplecv@gmail.com")
    private LocalDate clientDateBirth;

    public SQLClient() {
    }

    public SQLClient(Integer id) {
        this.id = id;
    }

    public SQLClient(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientName, String clientPhNum, String clientEmail, LocalDate clientDateBirth) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientName = clientName;
        this.clientPhNum = clientPhNum;
        this.clientEmail = clientEmail;
        this.clientDateBirth = clientDateBirth;
    }


    public SQLClient(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientName, String clientPhNum, String clientEmail, LocalDate clientDateBirth) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientName = clientName;
        this.clientPhNum = clientPhNum;
        this.clientEmail = clientEmail;
        this.clientDateBirth = clientDateBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public LocalDate getClientDateBirth() {
        return clientDateBirth;
    }

    public void setClientDateBirth(LocalDate clientDateBirth) {
        this.clientDateBirth = clientDateBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SQLClient client = (SQLClient) o;
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
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
