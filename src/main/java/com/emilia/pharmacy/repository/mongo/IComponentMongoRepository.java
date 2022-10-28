package com.emilia.pharmacy.repository.mongo;
/*
 * Interface IComponentMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.Component;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComponentMongoRepository extends MongoRepository<Component, String> {

    @Aggregation(pipeline = {
            "{'$sort':{'componentName':1}}"
    })
    List<Component> sortNameAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'componentName':-1}}"
    })
    List<Component> sortNameDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<Component> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<Component> sortCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':1}}"
    })
    List<Component> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':-1}}"
    })
    List<Component> sortUpdatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'measure':'kg'}}"
    })
    List<Component> sortMeasureKg();

    @Aggregation(pipeline = {
            "{'$match':{'measure':'l'}}"
    })
    List<Component> sortMeasureL();

    @Aggregation(pipeline = {
            "{'$match':{'measure':'g'}}"
    })
    List<Component> sortMeasureG();

    @Aggregation(pipeline = {
            "{'$match':{'measure':'ml'}}"
    })
    List<Component> sortMeasureML();

    @Aggregation(pipeline = {
            "{'$match':{'measure':'mg'}}"
    })
    List<Component> sortMeasureMG();
}
