package com.emilia.pharmacy.form.mongoForms;

import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
  @author emilia
  @project pharmacy
  @className OfficinalDrugForm
  @version 1.0.0
  @since 09.08.2022
*/
public class OfficinalDrugForm {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
    private String drugName;
    private double volume;
    private Use use;
    private String prescript;
    private ReleaseForm releaseForm;
    private String officinalExpirationDate;
    private double price;
    private String manufacturerId;
    private int officinalInStock;

    public OfficinalDrugForm() {
    }

    public OfficinalDrugForm(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, String officinalExpirationDate, double price, String manufacturerId, int officinalInStock) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.drugName = drugName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.officinalExpirationDate = officinalExpirationDate;
        this.price = price;
        this.manufacturerId = manufacturerId;
        this.officinalInStock = officinalInStock;
    }

    public OfficinalDrugForm(LocalDateTime createdAt, LocalDateTime updatedAt, String description, String drugName, double volume, Use use, String prescript, ReleaseForm releaseForm, String officinalExpirationDate, double price, String manufacturerId, int officinalInStock) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.drugName = drugName;
        this.volume = volume;
        this.use = use;
        this.prescript = prescript;
        this.releaseForm = releaseForm;
        this.officinalExpirationDate = officinalExpirationDate;
        this.price = price;
        this.manufacturerId = manufacturerId;
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

    public String getOfficinalExpirationDate() {
        return officinalExpirationDate;
    }

    public void setOfficinalExpirationDate(String officinalExpirationDate) {
        this.officinalExpirationDate = officinalExpirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public int getOfficinalInStock() {
        return officinalInStock;
    }

    public void setOfficinalInStock(int officinalInStock) {
        this.officinalInStock = officinalInStock;
    }

    @Override
    public String toString() {
        return "OfficinalDrugForm{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", drugName='" + drugName + '\'' +
                ", volume=" + volume +
                ", use=" + use +
                ", prescript='" + prescript + '\'' +
                ", releaseForm=" + releaseForm +
                ", officinalExpirationDate='" + officinalExpirationDate + '\'' +
                ", price=" + price +
                ", manufacturerId='" + manufacturerId + '\'' +
                ", officinalInStock=" + officinalInStock +
                '}';
    }
}
