package com.emilia.pharmacy.repository.mongo;

/*
 * Interface IExtemporalDrugMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.Drug;
import com.emilia.pharmacy.entity.mongo.Order;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IDrugMongoRepository extends MongoRepository<Drug, String> {

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}"
    })
    List<Drug> sortExtemporal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}"
    })
    List<Drug> sortOfficinal();
    /*************************************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$sort':{'drugName':1}}"
    })
    List<Drug> sortExtemporalNameAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$sort':{'drugName':-1}}"
    })
    List<Drug> sortExtemporalNameDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'drugName':1}}"
    })
    List<Drug> sortOfficinalNameAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'drugName':-1}}"
    })
    List<Drug> sortOfficinalNameDsce();
    /*************************************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$sort':{'createdAt':1}}"
    })
    List<Drug> sortExtemporalCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$sort':{'createdAt':-1}}"
    })
    List<Drug> sortExtemporalCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$sort':{'updatedAt':1}}"
    })
    List<Drug> sortExtemporalUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$sort':{'updatedAt':-1}}"
    })
    List<Drug> sortExtemporalUpdatedAtDsce();


    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'createdAt':1}}"
    })
    List<Drug> sortOfficinalCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'createdAt':-1}}"
    })
    List<Drug> sortOfficinalCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'updatedAt':1}}"
    })
    List<Drug> sortOfficinalUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'updatedAt':-1}}"
    })
    List<Drug> sortOfficinalUpdatedAtDsce();
    /*************************************/
    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'use':'EXTERNAL'}}"
    })
    List<Drug> sortExtemporalUseExternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'use':'INTERNAL'}}"
    })
    List<Drug> sortExtemporalUseInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'use':'INTERNALEXTERNAL'}}"
    })
    List<Drug> sortExtemporalUseExInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'use':'MIX'}}"
    })
    List<Drug> sortExtemporalUseMix();
    /*************************************/
    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'use':'EXTERNAL'}}"
    })
    List<Drug> sortOfficinalUseExternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'use':'INTERNAL'}}"
    })
    List<Drug> sortOfficinalUseInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'use':'INTERNALEXTERNAL'}}"
    })
    List<Drug> sortOfficinalUseExInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'use':'MIX'}}"
    })
    List<Drug> sortOfficinalUseMix();
    /*************************************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'releaseForm':'TABLETS'}}"
    })
    List<Drug> sortExtemporalFormTablets();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'releaseForm':'OINTMENT'}}"
    })
    List<Drug> sortExtemporalFormOintment();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'releaseForm':'POTION'}}"
    })
    List<Drug> sortExtemporalFormPotion();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'releaseForm':'AQUA'}}"
    })
    List<Drug> sortExtemporalFormAQUA();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'releaseForm':'FLOUR'}}"
    })
    List<Drug> sortExtemporalFormFlour();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Drug'}}",
            "{'$match':{'releaseForm':'TINCTURE'}}"
    })
    List<Drug> sortExtemporalFormTincture();


    /*************************************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'releaseForm':'TABLETS'}}"
    })
    List<Drug> sortOfficinalFormTablets();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'releaseForm':'OINTMENT'}}"
    })
    List<Drug> sortOfficinalFormOintment();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$match':{'releaseForm':'TINCTURE'}}"
    })
    List<Drug> sortOfficinalFormTincture();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'INTERNAL'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceUseInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'EXTERNAL'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceUseExternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'INTERNALEXTERNAL'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceUseExternalInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'MIX'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceUseMix();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'releaseForm': 'TABLETS'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceFormTablets();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'releaseForm': 'OINTMENT'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceFormOintment();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'releaseForm': 'TINCTURE'}}",
            "{'$sort':{'officinalInStock': 1}}"
    })
    List<Drug> sortOfficinalInStockAsceFormTincture();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'INTERNAL'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceUseInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'EXTERNAL'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceUseExternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'INTERNALEXTERNAL'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceUseExternalInternal();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'use': 'MIX'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceUseMix();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'releaseForm': 'TABLETS'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceFormTablets();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'releaseForm': 'OINTMENT'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceFormOintment();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'releaseForm': 'TINCTURE'}}",
            "{'$sort':{'officinalInStock': -1}}"
    })
    List<Drug> sortOfficinalInStockDsceFormTincture();
    /******************DRUGS*********************/
    @Aggregation(pipeline = {
            "{'$match':{'releaseForm':'TABLETS'}}"
    })
    List<Drug> sortFormTablets();

    @Aggregation(pipeline = {
            "{'$match':{'releaseForm':'OINTMENT'}}"
    })
    List<Drug> sortFormOintment();

    @Aggregation(pipeline = {
            "{'$match':{'releaseForm':'POTION'}}"
    })
    List<Drug> sortFormPotion();

    @Aggregation(pipeline = {
            "{'$match':{'releaseForm':'AQUA'}}"
    })
    List<Drug> sortFormAQUA();

    @Aggregation(pipeline = {
            "{'$match':{'releaseForm':'FLOUR'}}"
    })
    List<Drug> sortFormFlour();

    @Aggregation(pipeline = {
            "{'$match':{'releaseForm':'TINCTURE'}}"
    })
    List<Drug> sortFormTincture();

    @Aggregation(pipeline = {
            "{'$sort':{'drugName':1}}"
    })
    List<Drug> sortNameAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'drugName':-1}}"
    })
    List<Drug> sortNameDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<Drug> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<Drug> sortCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$sort':{'updatedAt':1}}"
    })
    List<Drug> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'updatedAt':-1}}"
    })
    List<Drug> sortUpdatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'use':'EXTERNAL'}}"
    })
    List<Drug> sortUseExternal();

    @Aggregation(pipeline = {
            "{'$match':{'use':'INTERNAL'}}"
    })
    List<Drug> sortUseInternal();

    @Aggregation(pipeline = {
            "{'$match':{'use':'INTERNALEXTERNAL'}}"
    })
    List<Drug> sortUseExInternal();

    @Aggregation(pipeline = {
            "{'$match':{'use':'MIX'}}"
    })
    List<Drug> sortUseMix();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Drug', 'officinalExpirationDate': {$lt: ?0} }}",
    })
    List<Drug> expireDrugs(LocalDate date);

}
