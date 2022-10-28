package com.emilia.pharmacy.entity.mongo;
/*
  @author emilia
  @project pharmacy
  @className Component
  @version 1.0.0
  @since 28.06.2022
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "component")
@ApiModel(value = "ComponentModel", description = "Component model for Component table")
public class Component {
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
            example = "Component")
    private String description;
    @Field("componentName")
    @ApiModelProperty(value = "name of the component",
            name = "componentName",
            dataType = "String",
            example = "Pantenol")
    private String componentName;
    @Field("measure")
    @ApiModelProperty(value = "measure of the component",
            name = "measure",
            dataType = "String",
            example = "ml")
    private String measure;
    @Field("criticalNorm")
    @ApiModelProperty(value = "critical norm of the component",
            name = "criticalNorm",
            dataType = "double",
            example = "87.6")
    private double criticalNorm;
    @Field("inStock")
    @ApiModelProperty(value = "in stock of the component",
            name = "inStock",
            dataType = "double",
            example = "87.6")
    private double inStock;

    @Field("price")
    @ApiModelProperty(value = "price of the component",
            name = "price",
            dataType = "double",
            example = "87.6")
    private double price;

    public Component() {
    }

    public Component(String id) {
        this.id = id;
    }

    public Component(String id, String componentName) {
        this.id = id;
        this.componentName = componentName;
    }

    public Component(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String componentName, String measure, double criticalNorm, double inStock, double price) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentName = componentName;
        this.measure = measure;
        this.criticalNorm = criticalNorm;
        this.inStock = inStock;
        this.price = price;
    }

    public Component(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String componentName, String measure, double criticalNorm, double inStock, double price) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentName = componentName;
        this.measure = measure;
        this.criticalNorm = criticalNorm;
        this.inStock = inStock;
        this.price = price;
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

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public double getCriticalNorm() {
        return criticalNorm;
    }

    public void setCriticalNorm(double criticalNorm) {
        this.criticalNorm = criticalNorm;
    }

    public double getInStock() {
        return inStock;
    }

    public void setInStock(double inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Objects.equals(getId(), component.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Component{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", componentName='" + componentName + '\'' +
                ", measure='" + measure + '\'' +
                ", criticalNorm=" + criticalNorm +
                ", inStock=" + inStock +
                ", price=" + price +
                '}';
    }
}

