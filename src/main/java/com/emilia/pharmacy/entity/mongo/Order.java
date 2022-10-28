package com.emilia.pharmacy.entity.mongo;
/*
  @author emilia
  @project pharmacy
  @className ExtemporalOrder
  @version 1.0.0
  @since 28.06.2022
*/

import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Document(collection = "order")
@ApiModel(value = "OrderModel", description = "Order model for Order table")
public class Order {
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
            example = "Order")
    private String description;
    @DBRef
    @Field("clientId")
    @ApiModelProperty(value = "client of the order",
            name = "clientId",
            dataType = "Client",
            example = "object")
    private Client clientId;
    @Field("docName")
    @ApiModelProperty(value = "doctor name of the order",
            name = "docName",
            dataType = "String",
            example = "Olya Chinhil")
    private String docName;
    @Field("diagnos")
    @ApiModelProperty(value = "diagnos of the order",
            name = "diagnos",
            dataType = "String",
            example = "Headache")
    private String diagnos;
    @DBRef
    @Field("drugId")
    @ApiModelProperty(value = "drug of the order",
            name = "drugId",
            dataType = "Drug",
            example = "object")
    private Drug drugId;
    @Field("drugdrugQuantity")
    @ApiModelProperty(value = "drug quantity of the order",
            name = "drugQuantity",
            dataType = "int",
            example = "6")
    private int drugQuantity;
    @Field("orderStatus")
    @ApiModelProperty(value = "status of the order",
            name = "orderStatus",
            dataType = "OrderStatus",
            example = "GONE")
    private OrderStatus orderStatus;
    @Field("price")
    @ApiModelProperty(value = "price of the order",
            name = "price",
            dataType = "double",
            example = "66.4")
    private double price;
    @Field("orderGo")
    @ApiModelProperty(value = "date of the order`s gone",
            name = "orderGo",
            dataType = "LocalDate",
            example = "22-09-11")
    private LocalDate orderGo;

    public Order() {
    }

    public Order(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, Client clientId, String docName, String diagnos, Drug drugId, int drugQuantity, OrderStatus orderStatus, double price, LocalDate orderGo) {
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

    public Order(LocalDateTime createdAt, LocalDateTime updatedAt, String description, Client clientId, String docName, String diagnos, Drug drugId, int drugQuantity, OrderStatus orderStatus, double price, LocalDate orderGo) {
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

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
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

    public Drug getDrugId() {
        return drugId;
    }

    public void setDrugId(Drug drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugId.getDrugName();
    }
    public String getClientName() {
        return clientId.getClientName();
    }
    public ReleaseForm getDrugReleaseForm() {
        return drugId.getReleaseForm();
    }
    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public void plustDrugQuantity(int a) {
        this.drugQuantity = drugQuantity + a;
    }

    public void plustDrugPrice(double a) {
        this.price = price + a;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getOrderGo() {
        return orderGo;
    }

    public void setOrderGo(LocalDate orderGo) {
        this.orderGo = orderGo;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order extemporalOrder = (Order) o;
        return Objects.equals(getId(), extemporalOrder.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "ExtemporalOrder{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", clientId=" + clientId +
                ", docName='" + docName + '\'' +
                ", diagnos='" + diagnos + '\'' +
                ", drugId=" + drugId +
                ", drugQuantity='" + drugQuantity + '\'' +
                ", orderStatus=" + orderStatus +
                ", price=" + price +
                ", orderGo=" + orderGo +
                '}';
    }
}
