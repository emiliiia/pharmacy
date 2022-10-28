package com.emilia.pharmacy.entity.mongo;

/*
  @author emilia
  @project pharmacy
  @className Manufacturer
  @version 1.0.0
  @since 09.08.2022
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "manufacturer")
@ApiModel(value = "ManufacturerModel", description = "Manufacturer model for Manufacturer table")
public class Manufacturer {

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
            example = "Manufacturer")
    private String description;

    @Field("manufacturername")
    @ApiModelProperty(value = "name of the manufacturer",
            name = "manufacturerName",
            dataType = "String",
            example = "Pfizer")
    private String manufacturerName;
    @Field("agentname")
    @ApiModelProperty(value = "agent name from the manufacturer",
            name = "agentName",
            dataType = "String",
            example = "Olya Chechul")
    private String agentName;
    @Field("agentphnum")
    @ApiModelProperty(value = "phone number of the agent",
            name = "agentName",
            dataType = "String",
            example = "+380505814239")
    private String agentPhNum;
    @Field("country")
    @ApiModelProperty(value = "country of the manufacturer",
            name = "country",
            dataType = "String",
            example = "USA")
    private String country;

    public Manufacturer() {
    }

    public Manufacturer(String id) {
        this.id = id;
    }

    public Manufacturer(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String manufacturerName, String agentName, String agentPhNum, String country) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.agentName = agentName;
        this.agentPhNum = agentPhNum;
        this.country = country;
    }

    public Manufacturer(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String manufacturerName, String agentName, String agentPhNum, String country) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.agentName = agentName;
        this.agentPhNum = agentPhNum;
        this.country = country;
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

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPhNum() {
        return agentPhNum;
    }

    public void setAgentPhNum(String agentPhNum) {
        this.agentPhNum = agentPhNum;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentPhNum='" + agentPhNum + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}


