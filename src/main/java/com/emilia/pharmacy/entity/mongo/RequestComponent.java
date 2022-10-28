package com.emilia.pharmacy.entity.mongo;
/*
  @author emilia
  @project pharmacy
  @className RequestComponent
  @version 1.0.0
  @since 28.06.2022
*/

import com.emilia.pharmacy.enums.Status;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Objects;
@Document(collection = "requestComponent")
@ApiModel(value = "RequestComponentModel", description = "RequestComponent model RequestComponent table")
public class RequestComponent {
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
            example = "RequestComponent")
    private String description;
    @DBRef
    @Field("componentId")
    @ApiModelProperty(value = "component of the request",
            name = "componentId",
            dataType = "Component",
            example = "object")
    private Component componentId;
    @Field("requestQuantity")
    @ApiModelProperty(value = "request quantity of the request",
            name = "requestQuantity",
            dataType = "double",
            example = "66.44")
    private double requestQuantity;

    @Field("status")
    @ApiModelProperty(value = "request quantity of the request",
            name = "status",
            dataType = "ENUM",
            example = "GOTTEN")
    private Status status;


    public RequestComponent() {
    }

    public RequestComponent(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, Component componentId, double requestQuantity, Status status) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentId = componentId;
        this.requestQuantity = requestQuantity;
        this.status = status;
    }

    public RequestComponent(LocalDateTime createdAt, LocalDateTime updatedAt, String description, Component componentId, double requestQuantity, Status status) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.componentId = componentId;
        this.requestQuantity = requestQuantity;
        this.status = status;
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

    public Component getComponentId() {
        return componentId;
    }

    public String getComponentName() {
        return componentId.getComponentName();
    }

    public void setComponentId(Component componentId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestComponent that = (RequestComponent) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "RequestComponent{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", componentId=" + componentId +
                ", requestQuantity=" + requestQuantity +
                ", status=" + status +
                '}';
    }
}

