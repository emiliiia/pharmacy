package com.emilia.pharmacy.repository.mongo;
/*
 * Interface ITechnologyBookMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.mongo.TechnologyBook;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITechnologyBookMongoRepository extends MongoRepository<TechnologyBook, String> {

    @Aggregation(pipeline = {
            "{'$sort':{'type':1}}"
    })
    List<TechnologyBook> sortNameAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'type':-1}}"
    })
    List<TechnologyBook> sortNameDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<TechnologyBook> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<TechnologyBook> sortCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'updatedAt':1}}"
    })
    List<TechnologyBook> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'updatedAt':-1}}"
    })
    List<TechnologyBook> sortUpdatedAtDsce();
    @Aggregation(pipeline = {
            "{'$match':{'method':'DISSOLVING'}}"
    })
    List<TechnologyBook> sortMethodDISSOLVING();

    @Aggregation(pipeline = {
            "{'$match':{'method':'SWELLING'}}"
    })
    List<TechnologyBook> sortMethodSWELLING();

    @Aggregation(pipeline = {
            "{'$match':{'method':'HEATING'}}"
    })
    List<TechnologyBook> sortMethodHEATING();

    @Aggregation(pipeline = {
            "{'$match':{'method':'DILUTION'}}"
    })
    List<TechnologyBook> sortMethodDILUTION();

    @Aggregation(pipeline = {
            "{'$match':{'method':'FILTERING'}}"
    })
    List<TechnologyBook> sortMethodFILTERING();

    @Aggregation(pipeline = {
            "{'$match':{'method':'EMULSIFYING'}}"
    })
    List<TechnologyBook> sortMethodEMULSIFYING();

    @Aggregation(pipeline = {
            "{'$match':{'method':'DISPERSING'}}"
    })
    List<TechnologyBook> sortMethodDISPERSING();

    @Aggregation(pipeline = {
            "{'$match':{'method':'MIXING'}}"
    })
    List<TechnologyBook> sortMethodMIXING();
}
