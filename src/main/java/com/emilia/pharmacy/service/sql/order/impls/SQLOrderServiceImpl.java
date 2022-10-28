package com.emilia.pharmacy.service.sql.order.impls;

/*
  @author emilia
  @project pharmacy
  @className OrderServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLOrder;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IOrderPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.order.interfaces.ISQLOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SQLOrderServiceImpl implements ISQLOrderService {
    @Autowired
    IOrderPostgreSQLRepository orderPostgreSQLRepository;

    public SQLOrder create(SQLOrder order) {
        return orderPostgreSQLRepository.save(order);
    }


    public SQLOrder get(Integer id) {
        return orderPostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found order with id = " + id));
    }

    public SQLOrder update(SQLOrder order) {
        return orderPostgreSQLRepository.save(order);
    }


    public void delete(Integer id) {
        if (!orderPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found order with id = " + id);
        }
        orderPostgreSQLRepository.deleteById(id);
    }


    public List<SQLOrder> getAll() {
        return
                orderPostgreSQLRepository.findAll();
    }


    public List<SQLOrder> sortNameAsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "drugId.drugName"));
    }
    public List<SQLOrder> sortNameDsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "drugId.drugName"));
    }

    public List<SQLOrder> sortStatusPendingInProgress() {
        return orderPostgreSQLRepository.sortExtemporalStatusPendingInProgress();
    }


    public List<SQLOrder> sortExtemporalNameAsce() {

        return orderPostgreSQLRepository.sortExtemporalNameAsce();}
    public List<SQLOrder> sortExtemporalNameDsce() {
        return orderPostgreSQLRepository.sortExtemporalNameDsce();}
    public List<SQLOrder> sortQuantityAsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "drugQuantity"));
    }
    public List<SQLOrder> sortQuantityDsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "drugQuantity"));
    }
    public List<SQLOrder> sortPriceAsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
    }
    public List<SQLOrder> sortPriceDsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "price"));
    }
    public List<SQLOrder> sortCreatedAtAsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }
    public List<SQLOrder> sortCreatedAtDsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
    public List<SQLOrder> sortUpdatedAtAsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }
    public List<SQLOrder> sortUpdatedAtDsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }
    public List<SQLOrder> sortOrderGoAsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "orderGo"));
    }
    public List<SQLOrder> sortOrderGoDsce() {
        return orderPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "orderGo"));
    }
    public List<SQLOrder> sortStatusInprogress() {
        return orderPostgreSQLRepository.sortStatusInprogress();
    }
    public List<SQLOrder> sortStatusGone() {
        return orderPostgreSQLRepository.sortStatusGone();
    }
    public List<SQLOrder> sortStatusPending() {
        return orderPostgreSQLRepository.sortStatusPending();
    }

    public List<SQLOrder> sortExtemporal() {
        return orderPostgreSQLRepository.sortExtemporal();
    }
    public List<SQLOrder> sortOfficinal() {
        return orderPostgreSQLRepository.sortOfficinal();
    }




    /***********************************************************/
    public List<SQLOrder> sortExtemporalQuantityAsce() {
        return orderPostgreSQLRepository.sortExtemporalQuantityAsce();
    }
    public List<SQLOrder> sortExtemporalQuantityDsce() {
        return orderPostgreSQLRepository.sortExtemporalQuantityDsce();
    }
    public List<SQLOrder> sortExtemporalPriceAsce() {
        return orderPostgreSQLRepository.sortExtemporalPriceAsce();
    }
    public List<SQLOrder> sortExtemporalPriceDsce() {
        return orderPostgreSQLRepository.sortExtemporalPriceDsce();
    }
    public List<SQLOrder> sortExtemporalCreatedAtAsce() {
        return orderPostgreSQLRepository.sortExtemporalCreatedAtAsce();
    }
    public List<SQLOrder> sortExtemporalCreatedAtDsce() {
        return orderPostgreSQLRepository.sortExtemporalCreatedAtDsce();
    }
    public List<SQLOrder> sortExtemporalUpdatedAtAsce() {
        return orderPostgreSQLRepository.sortExtemporalUpdatedAtAsce();
    }
    public List<SQLOrder> sortExtemporalUpdatedAtDsce() {
        return orderPostgreSQLRepository.sortExtemporalUpdatedAtDsce();
    }
    public List<SQLOrder> sortExtemporalOrderGoAsce() {
        return orderPostgreSQLRepository.sortExtemporalOrderGoAsce();
    }
    public List<SQLOrder> sortExtemporalOrderGoDsce() {
        return orderPostgreSQLRepository.sortExtemporalOrderGoDsce();
    }
    public List<SQLOrder> sortExtemporalStatusInprogress() {
        return orderPostgreSQLRepository.sortExtemporalStatusInprogress();
    }
    public List<SQLOrder> sortExtemporalStatusGone() {
        return orderPostgreSQLRepository.sortExtemporalStatusGone();
    }
    public List<SQLOrder> sortExtemporalStatusPending() {
        return orderPostgreSQLRepository.sortExtemporalStatusPending();
    }
    public List<SQLOrder> sortByOrderGoTerminate(LocalDate date) {
        return orderPostgreSQLRepository.findAll();
    }
    public  List<SQLOrder> terminateOrders(LocalDate date){
        return orderPostgreSQLRepository.terminateOrders(date);
    }


    public  List<SQLOrder> sortClientWaitClientNameAsce(){
        return orderPostgreSQLRepository.sortClientWaitClientNameAsce();
    }

    public  List<SQLOrder> sortClientWaitClientNameDsce(){
        return orderPostgreSQLRepository.sortClientWaitClientNameDsce();
    }
    public  List<SQLOrder> sortClientWaitDrugNameAsce(){
        return orderPostgreSQLRepository.sortClientWaitDrugNameAsce();
    }

    public  List<SQLOrder> sortClientWaitDrugNameDsce(){
        return orderPostgreSQLRepository.sortClientWaitDrugNameDsce();
    }

    public  List<SQLOrder> sortClientWaitUseExternal(){
        return orderPostgreSQLRepository.sortClientWaitUseExternal();
    }

    public  List<SQLOrder> sortClientWaitUseInternal(){
        return orderPostgreSQLRepository.sortClientWaitUseInternal();
    }

    public  List<SQLOrder> sortClientWaitUseExternalInternal(){
        return orderPostgreSQLRepository.sortClientWaitUseExternalInternal();
    }

    public  List<SQLOrder> sortClientWaitUseMix(){
        return orderPostgreSQLRepository.sortClientWaitUseMix();
    }



    public  List<SQLOrder> sortClientWaitFormTablets(){
        return orderPostgreSQLRepository.sortClientWaitFormTablets();
    }
    public  List<SQLOrder> sortClientWaitFormOintment(){
        return orderPostgreSQLRepository.sortClientWaitFormOintment();
    }
    public  List<SQLOrder> sortClientWaitFormPotion(){
        return orderPostgreSQLRepository.sortClientWaitFormPotion();
    }
    public  List<SQLOrder> sortClientWaitFormAqua(){
        return orderPostgreSQLRepository.sortClientWaitFormAqua();
    }
    public  List<SQLOrder> sortClientWaitFormFlour(){
        return orderPostgreSQLRepository.sortClientWaitFormFlour();
    }
    public  List<SQLOrder> sortClientWaitFormTincture(){
        return orderPostgreSQLRepository.sortClientWaitFormTincture();
    }



    /***************************************************/
    public List<SQLOrder> sortOfficinalNameAsce() {

        return orderPostgreSQLRepository.sortOfficinalNameAsce();}
    public List<SQLOrder> sortOfficinalNameDsce() {
        return orderPostgreSQLRepository.sortOfficinalNameDsce();}

    public List<SQLOrder> sortOfficinalCreatedAtAsce() {
        return orderPostgreSQLRepository.sortOfficinalCreatedAtAsce();
    }
    public List<SQLOrder> sortOfficinalCreatedAtDsce() {
        return orderPostgreSQLRepository.sortOfficinalCreatedAtDsce();
    }
    public List<SQLOrder> sortOfficinalUpdatedAtAsce() {
        return orderPostgreSQLRepository.sortOfficinalUpdatedAtAsce();
    }
    public List<SQLOrder> sortOfficinalUpdatedAtDsce() {
        return orderPostgreSQLRepository.sortOfficinalUpdatedAtDsce();
    }

    public List<SQLOrder> sortOfficinalQuantityAsce() {
        return orderPostgreSQLRepository.sortOfficinalQuantityAsce();
    }
    public List<SQLOrder> sortOfficinalQuantityDsce() {
        return orderPostgreSQLRepository.sortOfficinalQuantityDsce();
    }
    public List<SQLOrder> sortOfficinalPriceAsce() {
        return orderPostgreSQLRepository.sortOfficinalPriceAsce();
    }
    public List<SQLOrder> sortOfficinalPriceDsce() {
        return orderPostgreSQLRepository.sortOfficinalPriceDsce();
    }
    public List<SQLOrder> sortOfficinalOrderGoAsce() {
        return orderPostgreSQLRepository.sortOfficinalOrderGoAsce();
    }
    public List<SQLOrder> sortOfficinalOrderGoDsce() {
        return orderPostgreSQLRepository.sortOfficinalOrderGoDsce();
    }

    /************************************************/
    public  List<SQLOrder> sortUseExternal(){
        return orderPostgreSQLRepository.sortUseExternal();
    }

    public  List<SQLOrder> sortUseInternal(){
        return orderPostgreSQLRepository.sortUseInternal();
    }

    public  List<SQLOrder> sortUseExternalInternal(){
        return orderPostgreSQLRepository.sortUseExternalInternal();
    }

    public  List<SQLOrder> sortUseMix(){
        return orderPostgreSQLRepository.sortUseMix();
    }

    public  List<SQLOrder> sortFormTablets(){
        return orderPostgreSQLRepository.sortFormTablets();
    }
    public  List<SQLOrder> sortFormOintment(){
        return orderPostgreSQLRepository.sortFormOintment();
    }
    public  List<SQLOrder> sortFormPotion(){
        return orderPostgreSQLRepository.sortFormPotion();
    }
    public  List<SQLOrder> sortFormAqua(){
        return orderPostgreSQLRepository.sortFormAqua();
    }
    public  List<SQLOrder> sortFormFlour(){
        return orderPostgreSQLRepository.sortFormFlour();
    }
    public  List<SQLOrder> sortFormTincture(){
        return orderPostgreSQLRepository.sortFormTincture();
    }






    public List<SQLOrder> searchByClient(String word, List<SQLOrder> list) {
        return list.stream()
                .filter(extemporalOrder -> extemporalOrder.getClientId().getClientName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLOrder> dateRange(LocalDate from, LocalDate to, List<SQLOrder> orderList) {
        List<SQLOrder> list = new ArrayList<>();
        long numOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.of(from.getYear(), from.getMonth(), from.getDayOfMonth()), LocalDate.of(to.getYear(), to.getMonth(), to.getDayOfMonth()));
        List<LocalDate> listDate =  IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(from::plusDays)
                .collect(Collectors.toList());

        for (LocalDate date: listDate) {
            for (SQLOrder order: orderList) {
                if(order.getOrderGo().equals(date)){
                    list.add(order);
                }
            }
        }

        return  list;
    }

    public  List<SQLOrder> dateRange(LocalDate from, LocalDate to){
        return orderPostgreSQLRepository.dateRange(from, to);
    }

    public  List<SQLOrder> extemporalDateRange(LocalDate from, LocalDate to){
        return orderPostgreSQLRepository.extemporalDateRange(from, to);
    }
    public  List<SQLOrder> officinalDateRange(LocalDate from, LocalDate to){
        return orderPostgreSQLRepository.officinalDateRange(from, to);
    }


    public List<SQLOrder> searchByDrug(String word, List<SQLOrder> list) {
        return list.stream()
                .filter(extemporalOrder -> extemporalOrder.getDrugId().getDrugName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLOrder> searchByRange(String word) {
        return this.getAll().stream()
                .filter(extemporalOrder -> extemporalOrder.getDrugId().getDrugName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
