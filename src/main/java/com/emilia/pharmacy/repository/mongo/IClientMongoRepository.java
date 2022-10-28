package com.emilia.pharmacy.repository.mongo;
/*
 * Interface IExtemporalClientMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.mongo.Client;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientMongoRepository extends MongoRepository<Client, String> {


    @Aggregation(pipeline = {
            "{'$sort':{'clientName':1}}"
    })
    List<Client> sortNameAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'clientName':-1}}"
    })
    List<Client> sortNameDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<Client> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<Client> sortCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':1}}"
    })
    List<Client> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':-1}}"
    })
    List<Client> sortUpdatedAtDsce();

}
