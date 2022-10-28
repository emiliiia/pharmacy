package com.emilia.pharmacy.repository.mongo;

import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.entity.mongo.Manufacturer;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Interface IManufacturerMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
@Repository
public interface IManufacturerMongoRepository extends MongoRepository<Manufacturer, String> {

    @Aggregation(pipeline = {
            "{'$sort':{'manufacturerName':1}}"
    })
    List<Manufacturer> sortManufacturerAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'manufacturerName':-1}}"
    })
    List<Manufacturer> sortManufacturerDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<Manufacturer> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<Manufacturer> sortCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':1}}"
    })
    List<Manufacturer> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':-1}}"
    })
    List<Manufacturer> sortUpdatedAtDsce();
}
