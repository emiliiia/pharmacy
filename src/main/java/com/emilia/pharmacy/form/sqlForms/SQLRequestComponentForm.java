package com.emilia.pharmacy.form.sqlForms;

import com.emilia.pharmacy.enums.Status;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className RequestComponentForm
  @version 1.0.0
  @since 12.08.2022
*/
public class SQLRequestComponentForm {
    private Integer id;
    private String componentId;
    private double requestQuantity;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public SQLRequestComponentForm() {
    }

    public SQLRequestComponentForm(Integer id, String componentId, double requestQuantity, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.componentId = componentId;
        this.requestQuantity = requestQuantity;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SQLRequestComponentForm(String componentId, double requestQuantity, Status status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.componentId = componentId;
        this.requestQuantity = requestQuantity;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public double getRequestQuantity() {
        return requestQuantity;
    }

    public void setRequestQuantity(double requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @Override
    public String toString() {
        return "RequestComponentForm{" +
                "id='" + id + '\'' +
                ", componentId='" + componentId + '\'' +
                ", requestQuantity=" + requestQuantity +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
