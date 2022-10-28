package com.emilia.pharmacy.entity.mongo;
/*
  @author emilia
  @project pharmacy
  @className ExtemporalClient
  @version 1.0.0
  @since 28.06.2022
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Document(collection = "client")
@ApiModel(value = "ClientModel", description = "Client model for Client table")
public class Client {
    @Id
    @ApiModelProperty(value = "id of object",
            name = "id",
            dataType = "String",
            example = "1")
    private String id;
    @Field("createdAt")
    @ApiModelProperty(value = "object's creation date",
            name = "createdAt",
            dataType = "LocalDateTime",
            example = "022-09-11T01:37:55.199895")
    private LocalDateTime createdAt;
    @Field("updatedAt")
    @ApiModelProperty(value = "the object's update date",
            name = "updatedAt",
            dataType = "LocalDateTime",
            example = "022-09-11T01:37:55.199895")
    private LocalDateTime updatedAt;
    @Field("description")
    @ApiModelProperty(value = "description of object",
            name = "description",
            dataType = "String",
            example = "Client")
    private String description;
    @Field("clientName")
    @ApiModelProperty(value = "name of the client",
            name = "clientName",
            dataType = "String",
            example = "Olga Okorokova")
    private String clientName;
    @Field("clientPhNum")
    @ApiModelProperty(value = "phone number of the client",
            name = "clientPhNum",
            dataType = "String",
            example = "+380505372122")
    private String clientPhNum;
    @Field("clientEmail")
    @ApiModelProperty(value = "email of the client",
            name = "clientEmail",
            dataType = "String",
            example = "examplecv@gmail.com")
    private String clientEmail;
    @Field("clientDateBirth")
    @ApiModelProperty(value = "date of birth of the client",
            name = "clientDateBirth",
            dataType = "LocalDate",
            example = "examplecv@gmail.com")
    private LocalDate clientDateBirth;

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientName, String clientPhNum, String clientEmail, LocalDate clientDateBirth) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientName = clientName;
        this.clientPhNum = clientPhNum;
        this.clientEmail = clientEmail;
        this.clientDateBirth = clientDateBirth;
    }

    public Client(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientName, String clientPhNum, String clientEmail, LocalDate clientDateBirth) {
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
        Client that = (Client) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "ExtemporalClient{" +
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
