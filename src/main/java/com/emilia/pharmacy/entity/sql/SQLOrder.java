package com.emilia.pharmacy.entity.sql;
/*
  @author emilia
  @project pharmacy
  @className OfficinalOrder
  @version 1.0.0
  @since 28.06.2022
*/

import com.emilia.pharmacy.enums.OrderStatus;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
@Entity
@Table(name = "orderr")
@TypeDef(name="enum", typeClass = PostgreSQLEnumType.class)
@ApiModel(value = "OrderModel", description = "Order model for Order table")
public class SQLOrder {
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
            example = "Order")
    @Column(name = "description", nullable = false)
    private String description;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "clientid")
    @ApiModelProperty(value = "client of the order",
            name = "clientId",
            dataType = "SQLClient",
            example = "object")
    private SQLClient clientId;

    @ApiModelProperty(value = "doctor name of the order",
            name = "docName",
            dataType = "String",
            example = "Olya Chinhil")
    @Column(name = "docname")
    private String docName;

    @ApiModelProperty(value = "diagnos of the order",
            name = "diagnos",
            dataType = "String",
            example = "Headache")
    @Column(name = "diagnos")
    private String diagnos;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "drugid")
    @ApiModelProperty(value = "drug of the order",
            name = "drugId",
            dataType = "SQLDrug",
            example = "object")
    private SQLDrug drugId;

    @ApiModelProperty(value = "drug quantity of the order",
            name = "drugQuantity",
            dataType = "int",
            example = "6")
    @Column(name = "drugquantity")
    private int drugQuantity;

    @Column(name = "orderstatus")
    @Enumerated(EnumType.STRING)
    @Type(type="enum")
    @ApiModelProperty(value = "status of the order",
            name = "orderStatus",
            dataType = "OrderStatus",
            example = "GONE")
    private OrderStatus orderStatus;

    @ApiModelProperty(value = "price of the order",
            name = "price",
            dataType = "double",
            example = "66.4")
    @Column(name = "price")
    private double price;

    @ApiModelProperty(value = "date of the order`s gone",
            name = "orderGo",
            dataType = "LocalDate",
            example = "22-09-11")
    @Column(name = "ordergo")
    private LocalDate orderGo;

    public SQLOrder() {
    }

    public SQLOrder(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, SQLClient clientId, String docName, String diagnos, SQLDrug drugId, int drugQuantity, OrderStatus orderStatus, double price, LocalDate orderGo) {
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

    public SQLOrder(LocalDateTime createdAt, LocalDateTime updatedAt, String description, SQLClient clientId, String docName, String diagnos, SQLDrug drugId, int drugQuantity, OrderStatus orderStatus, double price, LocalDate orderGo) {
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

    public SQLClient getClientId() {
        return clientId;
    }

    public void setClientId(SQLClient clientId) {
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

    public SQLDrug getDrugId() {
        return drugId;
    }

    public void setDrugId(SQLDrug drugId) {
        this.drugId = drugId;
    }
    public String getDrugName() {
        return drugId.getDrugName();
    }
    public String getClientName() {
        return clientId.getClientName();
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


    public void plustDrugQuantity(int a) {
        this.drugQuantity = drugQuantity + a;
    }

    public void plustDrugPrice(double a) {
        this.price = price + a;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SQLOrder order = (SQLOrder) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", clientId=" + clientId +
                ", docName='" + docName + '\'' +
                ", diagnos='" + diagnos + '\'' +
                ", drugId=" + drugId +
                ", drugQuantity=" + drugQuantity +
                ", orderStatus=" + orderStatus +
                ", price=" + price +
                ", orderGo=" + orderGo +
                '}';
    }
}
