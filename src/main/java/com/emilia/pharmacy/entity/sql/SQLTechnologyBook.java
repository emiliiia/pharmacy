package com.emilia.pharmacy.entity.sql;

/*
  @author emilia
  @project pharmacy
  @className TechnologyBook
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.enums.ExtemporalMethod;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "technologybook")
@TypeDef(name="enum", typeClass = PostgreSQLEnumType.class)
@ApiModel(value = "TechnologyBookModel", description = "TechnologyBook model for TechnologyBook table")
public class SQLTechnologyBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    @ApiModelProperty(value = "id of object",
            name = "id",
            dataType = "Integer",
            example = "1")
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
            example = "TechnologyBook")
    @Column(name = "description", nullable = false)
    private String description;

    @ApiModelProperty(value = "type of the technology",
            name = "type",
            dataType = "String",
            example = "TechnologyBook")
    @Column(name = "type")
    private String type;
    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    @Type(type="enum")
    @ApiModelProperty(value = "method of the technology",
            name = "method",
            dataType = "ENUM",
            example = "DILUTION")
    private ExtemporalMethod method;

    @ApiModelProperty(value = "timeReady of the technology",
            name = "timeReady",
            dataType = "String",
            example = "7 days")
    @Column(name = "timeready")
    private String timeReady;

    public SQLTechnologyBook() {
    }

    public SQLTechnologyBook(Integer id) {
        this.id = id;
    }

    public SQLTechnologyBook(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String type, ExtemporalMethod method, String timeReady) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.type = type;
        this.method = method;
        this.timeReady = timeReady;
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
        SQLTechnologyBook that = (SQLTechnologyBook) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TechnologyBook{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", method=" + method +
                ", timeReady='" + timeReady + '\'' +
                '}';
    }
}
