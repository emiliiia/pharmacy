package com.emilia.pharmacy.entity.mongo;
/*
  @author emilia
  @project pharmacy
  @className extemporalDrug
  @version 1.0.0
  @since 28.06.2022
*/

import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
@Document(collection = "drug")
@ApiModel(value = "DrugModel", description = "Drug model for Drug table")
public class Drug {
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
            example = "Drug")
    private String description;


    @Field("drugName")
    @ApiModelProperty(value = "name of the drug",
            name = "drugName",
            dataType = "String",
            example = "Pantenol Darnitsa")
    private String drugName;
    @Field("volume")
    @ApiModelProperty(value = "volume of the drug",
            name = "volume",
            dataType = "double",
            example = "34.6")
    private double volume;
    @Field("use")
    @ApiModelProperty(value = "use of the drug",
            name = "use",
            dataType = "ENUM",
            example = "EXTEMPORAL")
    private Use use;
    @Field("prescript")
    @ApiModelProperty(value = "prescription of the drug",
            name = "prescript",
            dataType = "String",
            example = "From coughing")
    private String prescript;
    @Field("releaseForm")
    @ApiModelProperty(value = "release form of the drug",
            name = "releaseForm",
            dataType = "ENUM",
            example = "TABLETS")
    private ReleaseForm releaseForm;
    @Field("expirationDate")
    @ApiModelProperty(value = "expiration date form of the drug",
            name = "expirationDate",
            dataType = "ENUM",
            example = "3 years")
    private String expirationDate;
    @Field("price")
    @ApiModelProperty(value = "price of the drug",
            name = "price",
            dataType = "double",
            example = "354.65")
    private double price;
    @DBRef
    @Field("technologyId")
    @ApiModelProperty(value = "technology of the drug",
            name = "technologyId",
            dataType = "TechnologyBook",
            example = "object")
    private TechnologyBook technologyId;
    @DBRef
    @Field("componentList")
    @ApiModelProperty(value = "list of components of the drug",
            name = "componentList",
            dataType = "List<Component>",
            example = "list of objects")
    private List<Component> componentList;

    @DBRef
    @Field("manufacturerId")
    @ApiModelProperty(value = "manufacturer of the drug",
            name = "manufacturerId",
            dataType = "Manufacturer",
            example = "object")
    private Manufacturer manufacturerId;

    @Field("officinalExpirationDate")
    @ApiModelProperty(value = "expiration date of the officinal drug",
            name = "officinalExpirationDate",
            dataType = "LocalDate",
            example = "22-09-11")
    private LocalDate officinalExpirationDate;

    @Field("officinalInStock")
    @ApiModelProperty(value = "in stock of the officinal drug",
            name = "officinalInStock",
            dataType = "int",
            example = "456")
    private int officinalInStock;

    public Drug() {
    }

    public Drug(String id) {
        this.id = id;
    }

    public Drug(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, String expirationDate, double price, TechnologyBook technologyId, String timeReady, List<Component> componentList) {
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
        this.componentList = componentList;
    }

    public Drug(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, String expirationDate, double price, TechnologyBook technologyId, List<Component> componentList) {
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
        this.componentList = componentList;
    }

    public Drug(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, double price, Manufacturer manufacturerId, LocalDate officinalExpirationDate, int officinalInStock) {
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

    public Drug(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, double price, Manufacturer manufacturerId, LocalDate officinalExpirationDate, int officinalInStock) {
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

    public TechnologyBook getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(TechnologyBook technologyId) {
        this.technologyId = technologyId;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
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
        Drug that = (Drug) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Drug{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", drugName='" + drugName + '\'' +
                ", volume=" + volume +
                ", use=" + use +
                ", prescript='" + prescript + '\'' +
                ", releaseForm=" + releaseForm +
                ", expirationDate='" + expirationDate + '\'' +
                ", price=" + price +
                ", technologyId=" + technologyId +
                ", componentList=" + componentList +
                ", manufacturerId=" + manufacturerId +
                ", officinalExpirationDate=" + officinalExpirationDate +
                ", officinalInStock=" + officinalInStock +
                '}';
    }
}
