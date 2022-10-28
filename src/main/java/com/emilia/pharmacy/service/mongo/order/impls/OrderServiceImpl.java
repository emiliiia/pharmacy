package com.emilia.pharmacy.service.mongo.order.impls;

import com.emilia.pharmacy.entity.mongo.*;
import com.emilia.pharmacy.enums.OrderStatus;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.IOrderMongoRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.mongo.order.interfaces.IOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalOrderServiceImp
  @version 1.0.0
  @since 29.06.2022
*/
@Service
public class OrderServiceImpl implements IOrderService {
    List<Order> list = new ArrayList<>(
            Arrays.asList(
                    new Order("1", LocalDateTime.now(), LocalDateTime.now(), "Extemporal Order", new Client("1"), "Derabina O. V.", "Seborrhea", new Drug("1"), 2, OrderStatus.INPROGRESS, 145, LocalDate.of(2002, Calendar.MARCH, 14))
            )
    );
    Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    IOrderMongoRepository orderMongoRepository;
/*
    @PostConstruct
    void init() {orderMongoRepository.saveAll(list);}
*/
    public Order create(Order order) {
        return orderMongoRepository.save(order);
    }


    public Order get(String id) {
        return orderMongoRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found order with id = " + id));
    }

    public Order update(Order order) {
        return orderMongoRepository.save(order);
    }


    public void delete(String id) {
        if (!orderMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found order with id = " + id);
        }
        orderMongoRepository.deleteById(id);
    }


    public List<Order> getAll() {
        return
                orderMongoRepository.findAll();
    }

    public List<Order> sortNameAsce() {
        return this.getAll().stream().sorted(Comparator.comparing(Order::getDrugName))
                .collect(Collectors.toList());
    }
    public List<Order> sortNameDsce() {
        return this.getAll().stream().sorted(Comparator.comparing(Order::getDrugName).reversed())
                .collect(Collectors.toList());
    }

    public List<Order> sortStatusPendingInProgress() {
        return orderMongoRepository.sortStatusPendingInProgress();
    }


    public List<Order> sortExtemporalNameAsce() {

        return orderMongoRepository.sortExtemporalNameAsce();}
    public List<Order> sortExtemporalNameDsce() {
        return orderMongoRepository.sortExtemporalNameDsce();}
    public List<Order> sortQuantityAsce() {
        return orderMongoRepository.sortQuantityAsce();
    }
    public List<Order> sortQuantityDsce() {
        return orderMongoRepository.sortQuantityDsce();
    }
    public List<Order> sortPriceAsce() {
        return orderMongoRepository.sortPriceAsce();
    }
    public List<Order> sortPriceDsce() {
        return orderMongoRepository.sortPriceDsce();
    }
    public List<Order> sortCreatedAtAsce() {
        return orderMongoRepository.sortCreatedAtAsce();
    }
    public List<Order> sortCreatedAtDsce() {
        return orderMongoRepository.sortCreatedAtDsce();
    }
    public List<Order> sortUpdatedAtAsce() {
        return orderMongoRepository.sortUpdatedAtAsce();
    }
    public List<Order> sortUpdatedAtDsce() {
        return orderMongoRepository.sortUpdatedAtDsce();
    }
    public List<Order> sortOrderGoAsce() {
        return orderMongoRepository.sortOrderGoAsce();
    }
    public List<Order> sortOrderGoDsce() {
        return orderMongoRepository.sortOrderGoDsce();
    }
    public List<Order> sortStatusInprogress() {
        return orderMongoRepository.sortStatusInprogress();
    }
    public List<Order> sortStatusGone() {
        return orderMongoRepository.sortStatusGone();
    }
    public List<Order> sortStatusPending() {
        return orderMongoRepository.sortStatusPending();
    }

    public List<Order> sortExtemporal() {
        return orderMongoRepository.sortExtemporal();
    }
    public List<Order> sortOfficinal() {
        return orderMongoRepository.sortOfficinal();
    }




    /***********************************************************/
    public List<Order> sortExtemporalQuantityAsce() {
        return orderMongoRepository.sortExtemporalQuantityAsce();
    }
    public List<Order> sortExtemporalQuantityDsce() {
        return orderMongoRepository.sortExtemporalQuantityDsce();
    }
    public List<Order> sortExtemporalPriceAsce() {
        return orderMongoRepository.sortExtemporalPriceAsce();
    }
    public List<Order> sortExtemporalPriceDsce() {
        return orderMongoRepository.sortExtemporalPriceDsce();
    }
    public List<Order> sortExtemporalCreatedAtAsce() {
        return orderMongoRepository.sortExtemporalCreatedAtAsce();
    }
    public List<Order> sortExtemporalCreatedAtDsce() {
        return orderMongoRepository.sortExtemporalCreatedAtDsce();
    }
    public List<Order> sortExtemporalUpdatedAtAsce() {
        return orderMongoRepository.sortExtemporalUpdatedAtAsce();
    }
    public List<Order> sortExtemporalUpdatedAtDsce() {
        return orderMongoRepository.sortExtemporalUpdatedAtDsce();
    }
    public List<Order> sortExtemporalOrderGoAsce() {
        return orderMongoRepository.sortExtemporalOrderGoAsce();
    }
    public List<Order> sortExtemporalOrderGoDsce() {
        return orderMongoRepository.sortExtemporalOrderGoDsce();
    }
    public List<Order> sortExtemporalStatusInprogress() {
        return orderMongoRepository.sortExtemporalStatusInprogress();
    }
    public List<Order> sortExtemporalStatusGone() {
        return orderMongoRepository.sortExtemporalStatusGone();
    }
    public List<Order> sortExtemporalStatusPending() {
        return orderMongoRepository.sortExtemporalStatusPending();
    }
    public List<Order> sortByOrderGoTerminate(LocalDate date) {
        return orderMongoRepository.findAll();
    }
    public  List<Order> terminateOrders(LocalDate date){
        return orderMongoRepository.terminateOrders(date);
    }


    public  List<Order> sortClientWaitClientNameAsce(){
        return orderMongoRepository.sortClientWaitClientNameAsce();
    }

    public  List<Order> sortClientWaitClientNameDsce(){
        return orderMongoRepository.sortClientWaitClientNameDsce();
    }
    public  List<Order> sortClientWaitDrugNameAsce(){
        return orderMongoRepository.sortClientWaitDrugNameAsce();
    }

    public  List<Order> sortClientWaitDrugNameDsce(){
        return orderMongoRepository.sortClientWaitDrugNameDsce();
    }

    public  List<Order> sortClientWaitUseExternal(){
        return orderMongoRepository.sortClientWaitUseExternal();
    }

    public  List<Order> sortClientWaitUseInternal(){
        return orderMongoRepository.sortClientWaitUseInternal();
    }

    public  List<Order> sortClientWaitUseExternalInternal(){
        return orderMongoRepository.sortClientWaitUseExternalInternal();
    }

    public  List<Order> sortClientWaitUseMix(){
        return orderMongoRepository.sortClientWaitUseMix();
    }



    public  List<Order> sortClientWaitFormTablets(){
        return orderMongoRepository.sortClientWaitFormTablets();
    }
    public  List<Order> sortClientWaitFormOintment(){
        return orderMongoRepository.sortClientWaitFormOintment();
    }
    public  List<Order> sortClientWaitFormPotion(){
        return orderMongoRepository.sortClientWaitFormPotion();
    }
    public  List<Order> sortClientWaitFormAqua(){
        return orderMongoRepository.sortClientWaitFormAqua();
    }
    public  List<Order> sortClientWaitFormFlour(){
        return orderMongoRepository.sortClientWaitFormFlour();
    }
    public  List<Order> sortClientWaitFormTincture(){
        return orderMongoRepository.sortClientWaitFormTincture();
    }



/***************************************************/
    public List<Order> sortOfficinalNameAsce() {

    return orderMongoRepository.sortOfficinalNameAsce();}
    public List<Order> sortOfficinalNameDsce() {
        return orderMongoRepository.sortOfficinalNameDsce();}

    public List<Order> sortOfficinalCreatedAtAsce() {
        return orderMongoRepository.sortOfficinalCreatedAtAsce();
    }
    public List<Order> sortOfficinalCreatedAtDsce() {
        return orderMongoRepository.sortOfficinalCreatedAtDsce();
    }
    public List<Order> sortOfficinalUpdatedAtAsce() {
        return orderMongoRepository.sortOfficinalUpdatedAtAsce();
    }
    public List<Order> sortOfficinalUpdatedAtDsce() {
        return orderMongoRepository.sortOfficinalUpdatedAtDsce();
    }

    public List<Order> sortOfficinalQuantityAsce() {
        return orderMongoRepository.sortOfficinalQuantityAsce();
    }
    public List<Order> sortOfficinalQuantityDsce() {
        return orderMongoRepository.sortOfficinalQuantityDsce();
    }
    public List<Order> sortOfficinalPriceAsce() {
        return orderMongoRepository.sortOfficinalPriceAsce();
    }
    public List<Order> sortOfficinalPriceDsce() {
        return orderMongoRepository.sortOfficinalPriceDsce();
    }
    public List<Order> sortOfficinalOrderGoAsce() {
        return orderMongoRepository.sortOfficinalOrderGoAsce();
    }
    public List<Order> sortOfficinalOrderGoDsce() {
        return orderMongoRepository.sortOfficinalOrderGoDsce();
    }

/************************************************/
public  List<Order> sortUseExternal(){
    return orderMongoRepository.sortUseExternal();
}

    public  List<Order> sortUseInternal(){
        return orderMongoRepository.sortUseInternal();
    }

    public  List<Order> sortUseExternalInternal(){
        return orderMongoRepository.sortUseExternalInternal();
    }

    public  List<Order> sortUseMix(){
        return orderMongoRepository.sortUseMix();
    }

    public  List<Order> sortFormTablets(){
        return orderMongoRepository.sortFormTablets();
    }
    public  List<Order> sortFormOintment(){
        return orderMongoRepository.sortFormOintment();
    }
    public  List<Order> sortFormPotion(){
        return orderMongoRepository.sortFormPotion();
    }
    public  List<Order> sortFormAqua(){
        return orderMongoRepository.sortFormAqua();
    }
    public  List<Order> sortFormFlour(){
        return orderMongoRepository.sortFormFlour();
    }
    public  List<Order> sortFormTincture(){
        return orderMongoRepository.sortFormTincture();
    }



    public List<Order> searchByClient(String word, List<Order> list) {
        return list.stream()
                .filter(extemporalOrder -> extemporalOrder.getClientId().getClientName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Order> dateRange(LocalDate from, LocalDate to, List<Order> orderList) {
            List<Order> list = new ArrayList<>();
            long numOfDaysBetween = ChronoUnit.DAYS.between(LocalDate.of(from.getYear(), from.getMonth(), from.getDayOfMonth()), LocalDate.of(to.getYear(), to.getMonth(), to.getDayOfMonth()));
            List<LocalDate> listDate =  IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(from::plusDays)
                    .collect(Collectors.toList());

            for (LocalDate date: listDate) {
                for (Order order: orderList) {
                    if(order.getOrderGo().equals(date)){
                        list.add(order);
                    }
                }
            }

        return  list;
    }

    public  List<Order> dateRange(LocalDate from, LocalDate to){
        return orderMongoRepository.dateRange(from, to);
    }

    public  List<Order> extemporalDateRange(LocalDate from, LocalDate to){
        return orderMongoRepository.extemporalDateRange(from, to);
    }
    public  List<Order> officinalDateRange(LocalDate from, LocalDate to){
        return orderMongoRepository.officinalDateRange(from, to);
    }


    public List<Order> searchByDrug(String word, List<Order> list) {
        return list.stream()
                .filter(extemporalOrder -> extemporalOrder.getDrugId().getDrugName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Order> searchByRange(String word) {
        return this.getAll().stream()
                .filter(extemporalOrder -> extemporalOrder.getDrugId().getDrugName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
