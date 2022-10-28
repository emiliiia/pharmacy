package com.emilia.pharmacy.repository.mongo;
/*
 * Interface IRequestComponentMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.RequestComponent;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRequestComponentMongoRepository extends MongoRepository<RequestComponent, String> {
    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<RequestComponent> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<RequestComponent> sortCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'updatedAt':1}}"
    })
    List<RequestComponent> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'updatedAt':-1}}"
    })
    List<RequestComponent> sortUpdatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'status':'INPROGRESS'}}"
    })
    List<RequestComponent> sortStatusInprogress();

    @Aggregation(pipeline = {
            "{'$match':{'status':'GOTTEN'}}"
    })
    List<RequestComponent> sortStatusGotten();
}
