package com.emilia.pharmacy.form.sqlForms;

import com.emilia.pharmacy.enums.ExtemporalMethod;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className TechnologyBookForm
  @version 1.0.0
  @since 06.07.2022
*/
public class SQLTechnologyBookForm {

    private Integer id;

    private ExtemporalMethod method;
    private String type;

    private String timeReady;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SQLTechnologyBookForm() {
    }

    public SQLTechnologyBookForm(Integer id, ExtemporalMethod method, String type, String timeReady, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.method = method;
        this.type = type;
        this.timeReady = timeReady;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SQLTechnologyBookForm(ExtemporalMethod method, String type, String timeReady, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.method = method;
        this.type = type;
        this.timeReady = timeReady;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExtemporalMethod getMethod() {
        return method;
    }

    public void setMethod(ExtemporalMethod method) {
        this.method = method;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTimeReady() {
        return timeReady;
    }

    public void setTimeReady(String timeReady) {
        this.timeReady = timeReady;
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
        return "TechnologyBookForm{" +
                "id='" + id + '\'' +
                ", method=" + method +
                ", type='" + type + '\'' +
                ", timeReady='" + timeReady + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
