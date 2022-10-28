package com.emilia.pharmacy.entity.sql;

/*
  @author emilia
  @project pharmacy
  @className Component
  @version 1.0.0
  @since 12.08.2022
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "component")
@ApiModel(value = "ComponentModel", description = "Component model for Component table")
public class SQLComponent {

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
            example = "Component")
    @Column(name = "description", nullable = false)
    private String description;

    @ApiModelProperty(value = "name of the component",
            name = "componentName",
            dataType = "String",
            example = "Pantenol")
    @Column(name = "componentname")
    private String componentName;

    @ApiModelProperty(value = "measure of the component",
            name = "measure",
            dataType = "String",
            example = "ml")
    @Column(name = "measure")
    private String measure;

    @ApiModelProperty(value = "critical norm of the component",
            name = "criticalNorm",
            dataType = "double",
            example = "87.6")
    @Column(name = "criticalnorm")
    private double criticalNorm;

    @ApiModelProperty(value = "in stock of the component",
            name = "inStock",
            dataType = "double",
            example = "87.6")
    @Column(name = "instock")
    private double inStock;

    @ApiModelProperty(value = "price of the component",
            name = "price",
            dataType = "double",
            example = "87.6")
    @Column(name = "price")
    private double price;


    public SQLComponent() {
    }

    public SQLComponent(Integer id) {
        this.id = id;
    }

    public SQLComponent(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String componentName, String measure, double criticalNorm, double inStock, double price) {
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

    public SQLComponent(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String componentName, String measure, double criticalNorm, double inStock, double price) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentName = componentName;
        this.measure = measure;
        this.criticalNorm = criticalNorm;
        this.inStock = inStock;
        this.price = price;
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
        SQLComponent component = (SQLComponent) o;
        return Objects.equals(getId(), component.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
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
