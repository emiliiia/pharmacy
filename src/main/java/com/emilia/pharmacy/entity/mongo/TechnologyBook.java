package com.emilia.pharmacy.entity.mongo;
/*
  @author emilia
  @project pharmacy
  @className TechnologyBook
  @version 1.0.0
  @since 28.06.2022
*/

import com.emilia.pharmacy.enums.ExtemporalMethod;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Objects;

@Document(collection = "technologyBook")
@ApiModel(value = "TechnologyBookModel", description = "TechnologyBook model for TechnologyBook table")
public class TechnologyBook {
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
            example = "TechnologyBook")
    private String description;
    @Field("type")
    @ApiModelProperty(value = "type of the technology",
            name = "type",
            dataType = "String",
            example = "TechnologyBook")
    private String type;
    @Field("method")
    @ApiModelProperty(value = "method of the technology",
            name = "method",
            dataType = "ENUM",
            example = "DILUTION")
    private ExtemporalMethod method;
    @Field("timeReady")
    @ApiModelProperty(value = "timeReady of the technology",
            name = "timeReady",
            dataType = "String",
            example = "7 days")
    private String timeReady;

    public TechnologyBook() {
    }

    public TechnologyBook(String id) {
        this.id = id;
    }

    public TechnologyBook(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String type, ExtemporalMethod method, String timeReady) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.type = type;
        this.method = method;
        this.timeReady = timeReady;
    }

    public TechnologyBook(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String type, ExtemporalMethod method, String timeReady) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.type = type;
        this.method = method;
        this.timeReady = timeReady;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ExtemporalMethod getMethod() {
        return method;
    }

    public void setMethod(ExtemporalMethod method) {
        this.method = method;
    }

    public String getTimeReady() {
        return timeReady;
    }

    public void setTimeReady(String timeReady) {
        this.timeReady = timeReady;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechnologyBook that = (TechnologyBook) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TechnologyBook{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", method=" + method +
                ", timeReady='" + timeReady + '\'' +
                '}';
    }
}

