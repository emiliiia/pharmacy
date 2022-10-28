package com.emilia.pharmacy.form.sqlForms;

import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;

import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalDrugForm
  @version 1.0.0
  @since 13.08.2022
*/
public class SQLExtemporalDrugForm {
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
    private String extemporalName;
    private double volume;
    private Use use;
    private String prescript;
    private ReleaseForm releaseForm;
    private String expirationDate;
    private double price;
    private String technologyId;
    private String componentId;

    public SQLExtemporalDrugForm() {
    }

    public SQLExtemporalDrugForm(Integer id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String extemporalName, double volume, Use use, String prescript, ReleaseForm releaseForm, String expirationDate, double price, String technologyId, String componentId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.extemporalName = extemporalName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.expirationDate = expirationDate;
        this.price = price;
        this.technologyId = technologyId;
        this.componentId = componentId;
    }

    public SQLExtemporalDrugForm(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String extemporalName, double volume, Use use, String prescript, ReleaseForm releaseForm, String expirationDate, double price, String technologyId, String componentId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.extemporalName = extemporalName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.expirationDate = expirationDate;
        this.price = price;
        this.technologyId = technologyId;
        this.componentId = componentId;
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

    public String getExtemporalName() {
        return extemporalName;
    }

    public void setExtemporalName(String extemporalName) {
        this.extemporalName = extemporalName;
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

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }


    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return "ExtemporalDrugForm{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", extemporalName='" + extemporalName + '\'' +
                ", volume=" + volume +
                ", use=" + use +
                ", prescript='" + prescript + '\'' +
                ", releaseForm=" + releaseForm +
                ", expirationDate='" + expirationDate + '\'' +
                ", price=" + price +
                ", technologyId=" + technologyId +
                ", componentId=" + componentId +
                '}';
    }
}
