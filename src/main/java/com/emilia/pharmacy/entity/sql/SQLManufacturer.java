package com.emilia.pharmacy.entity.sql;
/*
  @author emilia
  @project pharmacy
  @className Manufacturer
  @version 1.0.0
  @since 28.06.2022
*/


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name = "manufacturer")
@ApiModel(value = "ManufacturerModel", description = "Manufacturer model for Manufacturer table")
public class SQLManufacturer {

    @Id
    @ApiModelProperty(value = "id of object",
            name = "id",
            dataType = "Integer",
            example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Integer id;

    @ApiModelProperty(value = "object's creation date",
            name = "createdAt",
            dataType = "LocalDateTime",
            example = "022-09-11T01:37:55.199895")
    @Column(name = "createdat", nullable = false)
    private LocalDateTime createdAt;

    @ApiModelProperty(value = "the object's update date",
            name = "updatedAt",
            dataType = "LocalDateTime",
            example = "022-09-11T01:37:55.199895")
    @Column(name = "updatedat", nullable = false)
    private LocalDateTime updatedAt;

    @ApiModelProperty(value = "description of object",
            name = "description",
            dataType = "String",
            example = "Manufacturer")
    @Column(name = "description", nullable = false)
    private String description;


    @ApiModelProperty(value = "name of the manufacturer",
            name = "manufacturerName",
            dataType = "String",
            example = "Pfizer")
    @Column(name = "manufacturername")
    private String manufacturerName;

    @ApiModelProperty(value = "agent name from the manufacturer",
            name = "agentName",
            dataType = "String",
            example = "Olya Chechul")
    @Column(name = "agentname")
    private String agentName;

    @ApiModelProperty(value = "phone number of the agent",
            name = "agentName",
            dataType = "String",
            example = "+380505814239")
    @Column(name = "agentphnum")
    private String agentPhNum;

    @ApiModelProperty(value = "country of the manufacturer",
            name = "country",
            dataType = "String",
            example = "USA")
    @Column(name = "country")
    private String country;

    public SQLManufacturer() {
    }

    public SQLManufacturer(Integer id) {
        this.id = id;
    }

    public SQLManufacturer(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String manufacturerName, String agentName, String agentPhNum, String country) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.agentName = agentName;
        this.agentPhNum = agentPhNum;
        this.country = country;
    }

    public SQLManufacturer(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String manufacturerName, String agentName, String agentPhNum, String country) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.manufacturerName = manufacturerName;
        this.agentName = agentName;
        this.agentPhNum = agentPhNum;
        this.country = country;
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
        SQLManufacturer manufacturer = (SQLManufacturer) o;
        return Objects.equals(getId(), manufacturer.getId());
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
