package com.emilia.pharmacy.repository.mongo;

/*
 * Interface IExtemporalOrderMongoRepository
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
public interface IOrderMongoRepository extends MongoRepository<Order, String> {

    /***************************/
    @Aggregation(pipeline = {
            "{'$sort':{'drugName':1}}"
    })
    List<Order> sortNameAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'drugName':-1}}"
    })
    List<Order> sortNameDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':1}}"
    })
    List<Order> sortCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'createdAt':-1}}"
    })
    List<Order> sortCreatedAtDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':1}}"
    })
    List<Order> sortUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'UpdatedAt':-1}}"
    })
    List<Order> sortUpdatedAtDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$sort':{'orderGo':1}}"
    })
    List<Order> sortOrderGoAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'orderGo':-1}}"
    })
    List<Order> sortOrderGoDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'orderStatus':'INPROGRESS'}}"
    })
    List<Order> sortStatusInprogress();

    @Aggregation(pipeline = {
            "{'$match':{'orderStatus':'GONE'}}"
    })
    List<Order> sortStatusGone();

    @Aggregation(pipeline = {
            "{'$match':{'orderStatus':'PENDING'}}"
    })
    List<Order> sortStatusPending();

    @Aggregation(pipeline = {
            "{'$match':{'orderStatus': {$in : ['INPROGRESS', 'PENDING']}}}",
    })
    List<Order> sortStatusPendingInProgress();
    /***********************/

    @Aggregation(pipeline = {
            "{'$sort':{'price':1}}"
    })
    List<Order> sortPriceAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'price':-1}}"
    })
    List<Order> sortPriceDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$sort':{'drugQuantity':1}}"
    })
    List<Order> sortQuantityAsce();

    @Aggregation(pipeline = {
            "{'$sort':{'drugQuantity':-1}}"
    })
    List<Order> sortQuantityDsce();

    @Aggregation(
            pipeline = {
                    "{'$match':{'description':'Officinal Order'}}"
            })
    List<Order> sortOfficinal();
    /*************************************/
    @Aggregation(
            pipeline = {
            "{'$match':{'description':'Extemporal Order'}}"
    })
    List<Order> sortExtemporal();


    /*************************************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$sort':{'drug.drugName':1}}"
    })
    List<Order> sortExtemporalNameAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$sort':{'drug.drugName':-1}}"
    })
    List<Order> sortExtemporalNameDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$sort':{'drug.drugName':1}}"
    })
    List<Order> sortOfficinalNameAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$sort':{'drug.drugName':-1}}"
    })
    List<Order> sortOfficinalNameDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'createdAt':1}}"
    })
    List<Order> sortExtemporalCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'createdAt':-1}}"
    })
    List<Order> sortExtemporalCreatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'createdAt':1}}"
    })
    List<Order> sortOfficinalCreatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'createdAt':-1}}"
    })
    List<Order> sortOfficinalCreatedAtDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'updatedAt':1}}"
    })
    List<Order> sortExtemporalUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'updatedAt':-1}}"
    })
    List<Order> sortExtemporalUpdatedAtDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'updatedAt':1}}"
    })
    List<Order> sortOfficinalUpdatedAtAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'updatedAt':-1}}"
    })
    List<Order> sortOfficinalUpdatedAtDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'orderGo':1}}"
    })
    List<Order> sortExtemporalOrderGoAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'orderGo':-1}}"
    })
    List<Order> sortExtemporalOrderGoDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'orderGo':1}}"
    })
    List<Order> sortOfficinalOrderGoAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'orderGo':-1}}"
    })
    List<Order> sortOfficinalOrderGoDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order', 'orderStatus':'INPROGRESS'}}",
    })
    List<Order> sortExtemporalStatusInprogress();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order', 'orderStatus':'GONE'}}",
    })
    List<Order> sortExtemporalStatusGone();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order', 'orderStatus':'PENDING'}}",
    })
    List<Order> sortExtemporalStatusPending();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order', 'orderStatus': {$in : ['INPROGRESS', 'PENDING']}}}",
    })
    List<Order> sortExtemporalStatusPendingInProgress();
    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'price':1}}"
    })
    List<Order> sortExtemporalPriceAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'price':-1}}"
    })
    List<Order> sortExtemporalPriceDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'price':1}}"
    })
    List<Order> sortOfficinalPriceAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'price':-1}}"
    })
    List<Order> sortOfficinalPriceDsce();

    /***********************/

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'drugQuantity':1}}"
    })
    List<Order> sortExtemporalQuantityAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order'}}",
            "{'$sort':{'drugQuantity':-1}}"
    })
    List<Order> sortExtemporalQuantityDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'drugQuantity':1}}"
    })
    List<Order> sortOfficinalQuantityAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Officinal Order'}}",
            "{'$sort':{'drugQuantity':-1}}"
    })
    List<Order> sortOfficinalQuantityDsce();

    /************************/
    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order','orderStatus':'INPROGRESS', 'orderGo': {$lt: ?0} }}",
    })
    List<Order> terminateOrders(LocalDate date);

    /************************/
    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING'}}",
            "{'$lookup': {'from': 'client', 'localField': 'clientId.$id', 'foreignField': '_id', 'as': 'client'}}",
            "{'$sort':{'client.clientName':1}}"
    })
    List<Order> sortClientWaitClientNameAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING'}}",
            "{'$lookup': {'from': 'client', 'localField': 'clientId.$id', 'foreignField': '_id', 'as': 'client'}}",
            "{'$sort':{'client.clientName':-1}}"
    })
    List<Order> sortClientWaitClientNameDsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING'}}",
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$sort':{'drug.drugName':1}}"
    })
    List<Order> sortClientWaitDrugNameAsce();

    @Aggregation(pipeline = {
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING'}}",
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$sort':{'drug.drugName':-1}}"
    })
    List<Order> sortClientWaitDrugNameDsce();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.use':  'EXTERNAL'}}",
    })
    List<Order> sortClientWaitUseExternal();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.use':  'INTERNAL'}}",
    })
    List<Order> sortClientWaitUseInternal();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.use':  'INTERNALEXTERNAL'}}",
    })
    List<Order> sortClientWaitUseExternalInternal();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.use':  'MIX'}}",
    })
    List<Order> sortClientWaitUseMix();



    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.releaseForm':  'TABLETS'}}",
    })
    List<Order> sortClientWaitFormTablets();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.releaseForm':  'OINTMENT'}}",
    })
    List<Order> sortClientWaitFormOintment();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.releaseForm':  'POTION'}}",
    })
    List<Order> sortClientWaitFormPotion();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.releaseForm':  'AQUA'}}",
    })
    List<Order> sortClientWaitFormAqua();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.releaseForm':  'FLOUR'}}",
    })
    List<Order> sortClientWaitFormFlour();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'description':'Extemporal Order','orderStatus':'PENDING', 'drug.releaseForm':  'TINCTURE'}}",
    })
    List<Order> sortClientWaitFormTincture();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.use':  'EXTERNAL'}}",
    })
    List<Order> sortUseExternal();
    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.use':  'INTERNAL'}}",
    })
    List<Order> sortUseInternal();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.use':  'INTERNALEXTERNAL'}}",
    })
    List<Order> sortUseExternalInternal();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.use':  'MIX'}}",
    })
    List<Order> sortUseMix();



    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.releaseForm':  'TABLETS'}}",
    })
    List<Order> sortFormTablets();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.releaseForm':  'OINTMENT'}}",
    })
    List<Order> sortFormOintment();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.releaseForm':  'POTION'}}",
    })
    List<Order> sortFormPotion();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.releaseForm':  'AQUA'}}",
    })
    List<Order> sortFormAqua();

    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.releaseForm':  'FLOUR'}}",
    })
    List<Order> sortFormFlour();
    @Aggregation(pipeline = {
            "{'$lookup': {'from': 'drug', 'localField': 'drugId.$id', 'foreignField': '_id', 'as': 'drug'}}",
            "{'$match':{'drug.releaseForm':  'TINCTURE'}}",
    })
    List<Order> sortFormTincture();


    @Aggregation(pipeline = {
            "{'$match':{'orderGo': {$gt: ?0}}}",
            "{'$match':{'orderGo': {$lt: ?1}}}",
    })
    List<Order> dateRange(LocalDate from, LocalDate to);

    @Aggregation(pipeline = {
            "{'$match':{'orderGo': {$gt: ?0},'description':'Extemporal Order'}}",
            "{'$match':{'orderGo': {$lt: ?1}}}",
    })
    List<Order> extemporalDateRange(LocalDate from, LocalDate to);

    @Aggregation(pipeline = {
            "{'$match':{'orderGo': {$gt: ?0},'description':'Officinal Order'}}",
            "{'$match':{'orderGo': {$lt: ?1}}}",
    })
    List<Order> officinalDateRange(LocalDate from, LocalDate to);
}
