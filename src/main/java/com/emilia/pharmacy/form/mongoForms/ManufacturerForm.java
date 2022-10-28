package com.emilia.pharmacy.form.mongoForms;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerForm
  @version 1.0.0
  @since 09.08.2022
*/
public class ManufacturerForm {
    private String id;

    private String manufacturerName;
    private String agentName;
    private String agentPhNum;
    private String country;

    public ManufacturerForm() {
    }

    public ManufacturerForm(String id, String manufacturerName, String agentName, String agentPhNum, String country) {
        this.id = id;
        this.manufacturerName = manufacturerName;
        this.agentName = agentName;
        this.agentPhNum = agentPhNum;
        this.country = country;
    }

    public ManufacturerForm(String manufacturerName, String agentName, String agentPhNum, String country) {
        this.manufacturerName = manufacturerName;
        this.agentName = agentName;
        this.agentPhNum = agentPhNum;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentPhNum() {
        return agentPhNum;
    }

    public void setAgentPhNum(String agentPhNum) {
        this.agentPhNum = agentPhNum;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "ManufacturerForm{" +
                "id='" + id + '\'' +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", agentName='" + agentName + '\'' +
                ", agentPhNum='" + agentPhNum + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
