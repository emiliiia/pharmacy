package com.emilia.pharmacy.form;

/*
  @author emilia
  @project pharmacy_2
  @className AdminHoem
  @version 1.0.0
  @since 19.08.2022
*/
public class AdminHomeForm {
    String username;
    int mongoClient;
    int mongoDrug;
    int mongoOrder;
    int mongoRequest;

    int sqlClient;
    int sqlDrug;
    int sqlOrder;
    int sqlRequest;

    public AdminHomeForm() {
    }

    public AdminHomeForm(String username, int mongoClient, int mongoDrug, int mongoOrder, int mongoRequest, int sqlClient, int sqlDrug, int sqlOrder, int sqlRequest) {
        this.username = username;
        this.mongoClient = mongoClient;
        this.mongoDrug = mongoDrug;
        this.mongoOrder = mongoOrder;
        this.mongoRequest = mongoRequest;
        this.sqlClient = sqlClient;
        this.sqlDrug = sqlDrug;
        this.sqlOrder = sqlOrder;
        this.sqlRequest = sqlRequest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(int mongoClient) {
        this.mongoClient = mongoClient;
    }

    public int getMongoDrug() {
        return mongoDrug;
    }

    public void setMongoDrug(int mongoDrug) {
        this.mongoDrug = mongoDrug;
    }

    public int getMongoOrder() {
        return mongoOrder;
    }

    public void setMongoOrder(int mongoOrder) {
        this.mongoOrder = mongoOrder;
    }

    public int getMongoRequest() {
        return mongoRequest;
    }

    public void setMongoRequest(int mongoRequest) {
        this.mongoRequest = mongoRequest;
    }

    public int getSqlClient() {
        return sqlClient;
    }

    public void setSqlClient(int sqlClient) {
        this.sqlClient = sqlClient;
    }

    public int getSqlDrug() {
        return sqlDrug;
    }

    public void setSqlDrug(int sqlDrug) {
        this.sqlDrug = sqlDrug;
    }

    public int getSqlOrder() {
        return sqlOrder;
    }

    public void setSqlOrder(int sqlOrder) {
        this.sqlOrder = sqlOrder;
    }

    public int getSqlRequest() {
        return sqlRequest;
    }

    public void setSqlRequest(int sqlRequest) {
        this.sqlRequest = sqlRequest;
    }

    @Override
    public String toString() {
        return "AdminHomeForm{" +
                "username='" + username + '\'' +
                ", mongoClient=" + mongoClient +
                ", mongoDrug=" + mongoDrug +
                ", mongoOrder=" + mongoOrder +
                ", mongoRequest=" + mongoRequest +
                ", sqlClient=" + sqlClient +
                ", sqlDrug=" + sqlDrug +
                ", sqlOrder=" + sqlOrder +
                ", sqlRequest=" + sqlRequest +
                '}';
    }
}
