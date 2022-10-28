package com.emilia.pharmacy.form.mongoForms;

import com.emilia.pharmacy.enums.OrderStatus;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalOrderForm
  @version 1.0.0
  @since 28.07.2022
*/
public class OrderForm {

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;

    private String clientId;
    private String docName;
    private String diagnos;
    private String drugId;
    private int drugQuantity;

    private OrderStatus orderStatus;
    private int price;

    private String orderGo;

    public OrderForm() {
    }

    public OrderForm(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientId, String docName, String diagnos, String drugId, int drugQuantity, OrderStatus orderStatus, int price, String orderGo) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientId = clientId;
        this.docName = docName;
        this.diagnos = diagnos;
        this.drugId = drugId;
        this.drugQuantity = drugQuantity;
        this.orderStatus = orderStatus;
        this.price = price;
        this.orderGo = orderGo;
    }

    public OrderForm(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String clientId, String docName, String diagnos, String drugId, int drugQuantity, OrderStatus orderStatus, int price, String orderGo) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.clientId = clientId;
        this.docName = docName;
        this.diagnos = diagnos;
        this.drugId = drugId;
        this.drugQuantity = drugQuantity;
        this.orderStatus = orderStatus;
        this.price = price;
        this.orderGo = orderGo;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
    public String getDiagnos() {
        return diagnos;
    }

    public void setDiagnos(String diagnos) {
        this.diagnos = diagnos;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderGo() {
        return orderGo;
    }

    public void setOrderGo(String orderGo) {
        this.orderGo = orderGo;
    }

    @Override
    public String toString() {
        return "ExtemporalOrderForm{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", clientId='" + clientId + '\'' +
                ", docName='" + docName + '\'' +
                ", diagnos='" + diagnos + '\'' +
                ", drugId='" + drugId + '\'' +
                ", drugAmount='" + drugQuantity + '\'' +
                ", orderStatus=" + orderStatus +
                ", price=" + price +
                ", orderGo=" + orderGo +
                '}';
    }
}
