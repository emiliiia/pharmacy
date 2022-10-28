package com.emilia.pharmacy.entity.sql;
/*
  @author emilia
  @project pharmacy
  @className OfficinalDrug
  @version 1.0.0
  @since 28.06.2022
*/

import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
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
@Table(name = "drug")
@ApiModel(value = "DrugModel", description = "Drug model for Drug table")
@TypeDef(name="enum", typeClass = PostgreSQLEnumType.class)
public class SQLDrug {
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
            example = "Drug")
    @Column(name = "description", nullable = false)
    private String description;

    @ApiModelProperty(value = "name of the drug",
            name = "drugName",
            dataType = "String",
            example = "Pantenol Darnitsa")
    @Column(name = "drugname")
    private String drugName;

    @ApiModelProperty(value = "volume of the drug",
            name = "volume",
            dataType = "double",
            example = "34.6")
    @Column(name = "volume")
    private double volume;

    @ApiModelProperty(value = "use of the drug",
            name = "use",
            dataType = "ENUM",
            example = "EXTEMPORAL")
    @Column(name = "use")
    @Enumerated(EnumType.STRING)
    @Type(type="enum")
    private Use use;

    @ApiModelProperty(value = "prescription of the drug",
            name = "prescript",
            dataType = "String",
            example = "From coughing")
    @Column(name = "prescript")
    private String prescript;

    @ApiModelProperty(value = "release form of the drug",
            name = "releaseForm",
            dataType = "ENUM",
            example = "TABLETS")
    @Column(name = "releaseform")
    @Enumerated(EnumType.STRING)
    @Type(type="enum")
    private ReleaseForm releaseForm;

    @ApiModelProperty(value = "expiration date form of the drug",
            name = "expirationDate",
            dataType = "ENUM",
            example = "3 years")
    @Column(name = "expirationdate")
    private String expirationDate;

    @ApiModelProperty(value = "price of the drug",
            name = "price",
            dataType = "double",
            example = "354.65")
    @Column(name = "price")
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "technologyid")
    @ApiModelProperty(value = "technology of the drug",
            name = "technologyId",
            dataType = "SQLTechnologyBook",
            example = "object")
    private SQLTechnologyBook technologyId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "componentid")
    @ApiModelProperty(value = "component of the drug",
            name = "componentId",
            dataType = "SQLComponent",
            example = "object")
    private SQLComponent componentId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturerid")
    @ApiModelProperty(value = "manufacturer of the drug",
            name = "manufacturerId",
            dataType = "SQLManufacturer",
            example = "object")
    private SQLManufacturer manufacturerId;

    @Column(name = "officinalexpirationdate")
    @ApiModelProperty(value = "expiration date of the officinal drug",
            name = "officinalExpirationDate",
            dataType = "LocalDate",
            example = "22-09-11")
    private LocalDate officinalExpirationDate;

    @Column(name = "officinalinstock")
    @ApiModelProperty(value = "in stock of the officinal drug",
            name = "officinalInStock",
            dataType = "int",
            example = "456")
    private int officinalInStock;

    public SQLDrug() {
    }

    public SQLDrug(Integer id) {
        this.id = id;
    }

    public SQLDrug(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, String expirationDate, double price, SQLTechnologyBook technologyId, SQLComponent componentId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.drugName = drugName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.expirationDate = expirationDate;
        this.price = price;
        this.technologyId = technologyId;
        this.componentId = componentId;
    }

    public SQLDrug(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, String expirationDate, double price, SQLTechnologyBook technologyId, SQLComponent componentId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.drugName = drugName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.expirationDate = expirationDate;
        this.price = price;
        this.technologyId = technologyId;
        this.componentId = componentId;
    }

    public SQLDrug(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, double price, SQLManufacturer manufacturerId, LocalDate officinalExpirationDate, int officinalInStock) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.drugName = drugName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.price = price;
        this.manufacturerId = manufacturerId;
        this.officinalExpirationDate = officinalExpirationDate;
        this.officinalInStock = officinalInStock;
    }

    public SQLDrug(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, double price, SQLManufacturer manufacturerId, LocalDate officinalExpirationDate, int officinalInStock) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.drugName = drugName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.price = price;
        this.manufacturerId = manufacturerId;
        this.officinalExpirationDate = officinalExpirationDate;
        this.officinalInStock = officinalInStock;
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

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Use getUse() {
        return use;
    }

    public void setUse(Use use) {
        this.use = use;
    }

    public String getPrescript() {
        return prescript;
    }

    public void setPrescript(String prescript) {
        this.prescript = prescript;
    }

    public ReleaseForm getReleaseForm() {
        return releaseForm;
    }

    public void setReleaseForm(ReleaseForm releaseForm) {
        this.releaseForm = releaseForm;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SQLTechnologyBook getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(SQLTechnologyBook technologyId) {
        this.technologyId = technologyId;
    }

    public SQLComponent getComponentId() {
        return componentId;
    }

    public void setComponentId(SQLComponent componentId) {
        this.componentId = componentId;
    }

    public SQLManufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(SQLManufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public LocalDate getOfficinalExpirationDate() {
        return officinalExpirationDate;
    }

    public void setOfficinalExpirationDate(LocalDate officinalExpirationDate) {
        this.officinalExpirationDate = officinalExpirationDate;
    }

    public int getOfficinalInStock() {
        return officinalInStock;
    }

    public void setOfficinalInStock(int officinalInStock) {
        this.officinalInStock = officinalInStock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SQLDrug drug = (SQLDrug) o;
        return Objects.equals(getId(), drug.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", drugName='" + drugName + '\'' +
                ", volume='" + volume + '\'' +
                ", use=" + use +
                ", prescript='" + prescript + '\'' +
                ", releaseForm=" + releaseForm +
                ", expirationDate='" + expirationDate + '\'' +
                ", price=" + price +
                ", technologyId=" + technologyId +
                ", componentId=" + componentId +
                ", manufacturerId=" + manufacturerId +
                ", officinalExpirationDate=" + officinalExpirationDate +
                ", officinalInStock=" + officinalInStock +
                '}';
    }
}
