package com.emilia.pharmacy.entity.sql;

/*
  @author emilia
  @project pharmacy
  @className RequestComponent
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.enums.Status;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "requestcomponent")
@TypeDef(name="enum", typeClass = PostgreSQLEnumType.class)
@ApiModel(value = "RequestComponentModel", description = "RequestComponent model RequestComponent table")
public class SQLRequestComponent {

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
            example = "RequestComponent")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "componentid", nullable = false)
    @ApiModelProperty(value = "component of the request",
            name = "componentId",
            dataType = "SQLComponent",
            example = "object")
    private SQLComponent componentId;

    @ApiModelProperty(value = "request quantity of the request",
            name = "requestQuantity",
            dataType = "double",
            example = "66.44")
    @Column(name = "requestquantity")
    private double requestQuantity;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @Type(type="enum")
    @ApiModelProperty(value = "request quantity of the request",
            name = "status",
            dataType = "ENUM",
            example = "GOTTEN")
    private Status status;

    public SQLRequestComponent() {
    }

    public SQLRequestComponent(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, SQLComponent componentId, double requestQuantity, Status status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentId = componentId;
        this.requestQuantity = requestQuantity;
        this.status = status;
    }

    public SQLRequestComponent(LocalDateTime createdAt, LocalDateTime updatedAt, String description, SQLComponent componentId, double requestQuantity, Status status) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentId = componentId;
        this.requestQuantity = requestQuantity;
        this.status = status;
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

    public SQLComponent getComponentId() {
        return componentId;
    }

    public void setComponentId(SQLComponent componentId) {
        this.componentId = componentId;
    }

    public String getComponentName() {
        return componentId.getComponentName();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SQLRequestComponent that = (SQLRequestComponent) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "RequestComponent{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", componentId=" + componentId +
                ", requestQuantity=" + requestQuantity +
                ", status=" + status +
                '}';
    }
}
