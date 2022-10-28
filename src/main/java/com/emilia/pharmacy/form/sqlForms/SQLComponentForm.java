package com.emilia.pharmacy.form.sqlForms;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className componentForm
  @version 1.0.0
  @since 12.08.2022
*/
public class SQLComponentForm {

    private Integer id;
    private String componentName;
    private String measure;
    private double criticalNorm;
    private double inStock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private double price;

    public SQLComponentForm() {
    }

    public SQLComponentForm(Integer id, String componentName, String measure, double criticalNorm, double inStock, LocalDateTime createdAt, LocalDateTime updatedAt, double price) {
        this.id = id;
        this.componentName = componentName;
        this.measure = measure;
        this.criticalNorm = criticalNorm;
        this.inStock = inStock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
    }

    public SQLComponentForm(String componentName, String measure, double criticalNorm, double inStock, LocalDateTime createdAt, LocalDateTime updatedAt, double price) {
        this.componentName = componentName;
        this.measure = measure;
        this.criticalNorm = criticalNorm;
        this.inStock = inStock;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComponentForm{" +
                "id='" + id + '\'' +
                ", componentName='" + componentName + '\'' +
                ", measure='" + measure + '\'' +
                ", criticalNorm=" + criticalNorm +
                ", inStock=" + inStock +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", price=" + price +
                '}';
    }
}
