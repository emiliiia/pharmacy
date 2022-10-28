package com.emilia.pharmacy.controller.mongo.order;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalOrderUIController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Client;
import com.emilia.pharmacy.entity.mongo.Drug;
import com.emilia.pharmacy.entity.mongo.Order;
import com.emilia.pharmacy.enums.OrderStatus;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.mongoForms.OrderForm;
import com.emilia.pharmacy.repository.mongo.IOrderMongoRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.mongo.drug.impls.DrugServiceImpl;
import com.emilia.pharmacy.service.mongo.order.impls.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongoDB/orders/extemporal")
public class ExtemporalOrderUIController {
    @Autowired
    OrderServiceImpl service;

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    DrugServiceImpl drugService;


    @Autowired
    IOrderMongoRepository mongoRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<Order> extemporalOrders = service.sortExtemporal();
        SearchForm searchForm = new SearchForm();

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();

        List<Order> extemporalOrders = service.sortExtemporal();
        if(service.searchByDrug(word, extemporalOrders) != null && !service.searchByDrug(word, extemporalOrders).isEmpty()){
            extemporalOrders = service.searchByDrug(word, extemporalOrders);
        }
        else {
            extemporalOrders = service.searchByClient(word, extemporalOrders);
        }

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);

        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/orders/extemporal/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addExtemporalOrder(Model model){
        OrderForm extemporalOrderForm = new OrderForm();
        List<OrderStatus> orderStatus = Arrays.asList(OrderStatus.values());

        Map<String, String> drugMap = drugService.sortExtemporal().stream()
                .collect(Collectors.toMap(Drug::getId, Drug::getDrugName));

        List<String> drugList = drugService.sortExtemporal().stream()
                .map(Drug::getDrugName).collect(Collectors.toList());

        Map<String, String> clientMap = clientService.getAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::getClientName));

        List<String> clientList = clientService.getAll().stream()
                .map(Client::getClientName).collect(Collectors.toList());

        model.addAttribute("form", extemporalOrderForm);
        model.addAttribute("orderStatus", orderStatus);
        model.addAttribute("drugMap", drugMap);
        model.addAttribute("drugList", drugList);
        model.addAttribute("clientMap", clientMap);
        model.addAttribute("clientList", clientList);
        return "add/add-extemporalOrder";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addExtemporalOrder(Model model, @ModelAttribute("form") OrderForm form){
        Order extemporalOrder = new Order();

        extemporalOrder.setCreatedAt(LocalDateTime.now());
        extemporalOrder.setUpdatedAt(LocalDateTime.now());
        extemporalOrder.setDescription("Extemporal Order");

        Drug extemporalDrug = drugService.sortExtemporal().stream()
                .filter(drug->drug.getDrugName().equals(form.getDrugId()))
                .findFirst().orElse(new Drug());
        extemporalOrder.setDrugId(extemporalDrug);

        Client extemporalClient = clientService.getAll().stream()
                .filter(client->client.getClientName().equals(form.getClientId()))
                .findFirst().orElse(new Client());
        extemporalOrder.setClientId(extemporalClient);
        extemporalOrder.setOrderStatus(form.getOrderStatus());

        extemporalOrder.setDrugQuantity(form.getDrugQuantity());
        extemporalOrder.setDocName(form.getDocName());
        extemporalOrder.setDiagnos(form.getDiagnos());

        double orderPrice = form.getDrugQuantity() * extemporalDrug.getPrice();
        extemporalOrder.setPrice(orderPrice);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        extemporalOrder.setOrderGo(LocalDate.parse(form.getOrderGo(), formatter));

        service.create(extemporalOrder);
        return "redirect:/ui/v1/mongoDB/orders/extemporal/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateExtemporalOrder(Model model, @PathVariable("id") String id) {
        Order order = service.get(id);
        OrderForm extemporalOrderForm = new OrderForm();

        extemporalOrderForm.setDrugId(order.getDrugId().getDrugName());
        extemporalOrderForm.setClientId(order.getClientId().getClientName());
        extemporalOrderForm.setOrderStatus(order.getOrderStatus());
        extemporalOrderForm.setDrugQuantity(order.getDrugQuantity());
        extemporalOrderForm.setDocName(order.getDocName());
        extemporalOrderForm.setDiagnos(order.getDiagnos());
        extemporalOrderForm.setOrderStatus(order.getOrderStatus());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        extemporalOrderForm.setOrderGo(order.getOrderGo().toString());
        List<OrderStatus> orderStatus = Arrays.asList(OrderStatus.values());

        Map<String, String> drugMap = drugService.sortExtemporal().stream()
                .collect(Collectors.toMap(Drug::getId, Drug::getDrugName));

        List<String> drugList = drugService.sortExtemporal().stream()
                .map(Drug::getDrugName).collect(Collectors.toList());

        Map<String, String> clientMap = clientService.getAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::getClientName));

        List<String> clientList = clientService.getAll().stream()
                .map(Client::getClientName).collect(Collectors.toList());

        model.addAttribute("form", extemporalOrderForm);
        model.addAttribute("orderStatus", orderStatus);
        model.addAttribute("drugMap", drugMap);
        model.addAttribute("drugList", drugList);
        model.addAttribute("clientMap", clientMap);
        model.addAttribute("clientList", clientList);
        return "edit/edit-extemporalOrder";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateExtemporalOrder(Model model, @PathVariable("id") String id,
                                       @ModelAttribute("form") OrderForm form) {

        Order extemporalOrder = service.get(form.getId());

        extemporalOrder.setUpdatedAt(LocalDateTime.now());

        Drug extemporalDrug = drugService.sortExtemporal().stream()
                .filter(drug->drug.getDrugName().equals(form.getDrugId()))
                .findFirst().orElse(new Drug());
        extemporalOrder.setDrugId(extemporalDrug);

        Client extemporalClient = clientService.getAll().stream()
                .filter(client->client.getClientName().equals(form.getClientId()))
                .findFirst().orElse(new Client());
        extemporalOrder.setClientId(extemporalClient);
        extemporalOrder.setOrderStatus(form.getOrderStatus());
        if(form.getOrderStatus().equals(OrderStatus.GONE)){
            extemporalOrder.setOrderGo(LocalDate.now());
        }
        extemporalOrder.setDrugQuantity(form.getDrugQuantity());
        extemporalOrder.setDocName(form.getDocName());
        extemporalOrder.setDiagnos(form.getDiagnos());

        double orderPrice = form.getDrugQuantity() * extemporalDrug.getPrice();
        extemporalOrder.setPrice(orderPrice);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        extemporalOrder.setOrderGo(LocalDate.parse(form.getOrderGo(), formatter));

        service.update(extemporalOrder);
        return "redirect:/ui/v1/mongoDB/orders/extemporal/";
    }

    /*****************************************/
    @RequestMapping(value = "sortExtemporalNameAsce", method = RequestMethod.GET)
    String sortExtemporalNameAsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalNameAsce")
    public String searchSortExtemporalNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalNameDsce", method = RequestMethod.GET)
    String sortExtemporalNameDsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalNameDsce")
    public String searchSortExtemporalNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalCreatedAtAsce", method = RequestMethod.GET)
    String sortExtemporalCreatedAtAsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalCreatedAtAsce")
    public String searchSortExtemporalCreatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalCreatedAtDsce", method = RequestMethod.GET)
    String sortExtemporalCreatedAtDsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalCreatedAtDsce")
    public String searchSortExtemporalCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalUpdatedAtAsce", method = RequestMethod.GET)
    String sortExtemporalUpdatedAtAsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalUpdatedAtAsce")
    public String searchSortExtemporalUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalUpdatedAtDsce", method = RequestMethod.GET)
    String sortExtemporalUpdatedAtDsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalUpdatedAtDsce")
    public String searchSortExtemporalUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalQuantityAsce", method = RequestMethod.GET)
    String sortExtemporalQuantityAsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalQuantityAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalQuantityAsce")
    public String searchSortExtemporalQuantityAsce(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalQuantityDsce", method = RequestMethod.GET)
    String sortExtemporalQuantityDsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalQuantityDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalQuantityDsce")
    public String searchSortExtemporalQuantityDsce(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalOrderGoAsce", method = RequestMethod.GET)
    String sortExtemporalOrderGoAsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalOrderGoAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalOrderGoAsce")
    public String searchSortExtemporalOrderGoAsce(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalOrderGoDsce", method = RequestMethod.GET)
    String sortExtemporalOrderGoDsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalOrderGoDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalOrderGoDsce")
    public String searchSortExtemporalOrderGoDsce(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalPriceAsce", method = RequestMethod.GET)
    String sortExtemporalPriceAsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalPriceAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalPriceAsce")
    public String searchSortExtemporalPriceAsce(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    @RequestMapping(value = "sortExtemporalPriceDsce", method = RequestMethod.GET)
    String sortExtemporalPriceDsce(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalPriceDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalPriceDsce")
    public String searchSortExtemporalPriceDsce(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalStatusInprogress", method = RequestMethod.GET)
    String sortExtemporalStatusInprogress(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalStatusInprogress();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalStatusInprogress")
    public String searchSortExtemporalStatusInprogress(Model model,
                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalStatusGone", method = RequestMethod.GET)
    String sortExtemporalStatusGone(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalStatusGone();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalStatusGone")
    public String searchSortExtemporalStatusGone(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }


    @RequestMapping(value = "sortExtemporalStatusPending", method = RequestMethod.GET)
    String sortExtemporalStatusPending(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalStatusPending();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortExtemporalStatusPending")
    public String searchSortExtemporalStatusPending(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }
    /*****/

    @RequestMapping(value = "sortByOrderGoTerminate", method = RequestMethod.GET)
    String sortByOrderGoTerminate(Model model) {

        List<Order> extemporalOrders2 = service.terminateOrders(LocalDate.now());
        /*
        List<Order> extemporalOrders = new ArrayList<>();

        for (Order order:extemporalOrders2) {
            if(order.getOrderGo().isBefore(LocalDate.now()) && order.getOrderStatus() == OrderStatus.INPROGRESS){
                extemporalOrders.add(order);
            }
        }*/
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders2);
        return "getAll/extemporalOrders-all";
    }

    @PostMapping(value = "sortByOrderGoTerminate")
    public String searchSortByOrderGoTerminate(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "getAll/extemporalOrders-all";
    }

    /****************CLIENTS___WAIT********************/

    @RequestMapping(value = "clientsWait", method = RequestMethod.GET)
    String sortclientsWait(Model model) {
        List<Order> extemporalOrders = service.sortExtemporalStatusPending();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait")
    public String searchSortclientsWait(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }


    @RequestMapping(value = "clientsWait/sortClientWaitClientNameAsce", method = RequestMethod.GET)
    String sortClientWaitClientNameAsce(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitClientNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitClientNameAsce")
    public String searchSortClientWaitClientNameAsce(Model model,
                                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitClientNameDsce", method = RequestMethod.GET)
    String sortClientWaitClientNameDsce(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitClientNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitClientNameDsce")
    public String searchSortClientWaitClientNameDsce(Model model,
                                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }


    @RequestMapping(value = "clientsWait/sortClientWaitDrugNameAsce", method = RequestMethod.GET)
    String sortClientWaitDrugNameAsce(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitDrugNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitDrugNameAsce")
    public String searchSortClientWaitDrugNameAsce(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitDrugNameDsce", method = RequestMethod.GET)
    String sortClientWaitDrugNameDsce(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitDrugNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitDrugNameDsce")
    public String searchSortClientWaitDrugNameDsce(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitUseExternal", method = RequestMethod.GET)
    String sortClientWaitUseExternal(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitUseExternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitUseExternal")
    public String searchSortClientWaitUseExternal(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitUseInternal", method = RequestMethod.GET)
    String sortClientWaitUseInternal(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitUseInternal")
    public String searchSortClientWaitUseInternal(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitUseExternalInternal", method = RequestMethod.GET)
    String sortClientWaitUseExternalInternal(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitUseExternalInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitUseExternalInternal")
    public String searchSortClientWaitUseExternalInternal(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitUseMix", method = RequestMethod.GET)
    String sortClientWaitUseMix(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitUseMix")
    public String searchSortClientWaitUseMix(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitFormTablets", method = RequestMethod.GET)
    String sortClientWaitFormTablets(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitFormTablets();

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitFormTablets")
    public String searchSortClientWaitFormTablets(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitFormOintment", method = RequestMethod.GET)
    String sortClientWaitFormOintment(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitFormOintment();

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitFormOintment")
    public String searchSortClientWaitFormOintment(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitFormPotion", method = RequestMethod.GET)
    String sortClientWaitFormPotion(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitFormPotion();

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitFormPotion")
    public String searchSortClientWaitFormPotion(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitFormAqua", method = RequestMethod.GET)
    String sortClientWaitFormAqua(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitFormAqua();

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitFormAqua")
    public String searchSortClientWaitFormAqua(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitFormFlour", method = RequestMethod.GET)
    String sortClientWaitFormFlour(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitFormFlour();

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }

    @PostMapping(value = "clientsWait/sortClientWaitFormFlour")
    public String searchSortClientWaitFormFlour(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "clientsWait/sortClientWaitFormTincture", method = RequestMethod.GET)
    String sortClientWaitFormTincture(Model model) {
        List<Order> extemporalOrders = service.sortClientWaitFormTincture();

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", extemporalOrders);
        return "other/extemporal-client-wait";
    }


    @PostMapping(value = "clientsWait/sortClientWaitFormTincture")
    public String searchSortClientWaitFormTincture(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortExtemporal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalOrders", list);
        return "other/extemporal-client-wait";
    }

    @RequestMapping(value = "needComponentNow", method = RequestMethod.GET)
    String needComponentNow(Model model) {

        SearchForm searchForm = new SearchForm();

        List<Order> list = service.sortStatusPendingInProgress();

        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.get(i).getDrugId().getComponentList().size(); k++) {
                double count = 1;
                for (int j = i+1; j < list.size(); j++) {
                    for (int r = 0; r < list.get(j).getDrugId().getComponentList().size(); r++) {
                        if(list.get(i).getDrugId().getComponentList().get(k).getId().equals(list.get(j).getDrugId().getComponentList().get(r).getId())){
                            count++;
                            list.get(j).getDrugId().getComponentList().remove(r);
                        }
                    }
                }
                list.get(i).getDrugId().getComponentList().get(k).setInStock(count * list.get(i).getDrugQuantity());
                count = (count * list.get(i).getDrugId().getComponentList().get(k).getPrice() * list.get(i).getDrugQuantity());
                list.get(i).getDrugId().getComponentList().get(k).setPrice(count);
                double a = list.get(i).getDrugId().getComponentList().get(k).getCriticalNorm();
                list.get(i).getDrugId().getComponentList().get(k).setCriticalNorm(list.get(i).getDrugId().getComponentList().get(k).getInStock() * a);
                a = 0;
            }
        }

        list.stream().sorted(Comparator.comparing(Order::getOrderGo))
                .collect(Collectors.toList());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/components-need-now";
    }

    @RequestMapping(value = "UsedComponents", method = RequestMethod.GET)
    String UsedComponents(Model model) {

        List<Order> list = service.sortExtemporalStatusGone();

        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.get(i).getDrugId().getComponentList().size(); k++) {
                double count = 1;
                for (int j = i+1; j < list.size(); j++) {
                    for (int r = 0; r < list.get(j).getDrugId().getComponentList().size(); r++) {
                        if(list.get(i).getDrugId().getComponentList().get(k).getId().equals(list.get(j).getDrugId().getComponentList().get(r).getId())){
                            count++;
                            list.get(j).getDrugId().getComponentList().remove(r);
                        }
                    }
                }
                list.get(i).getDrugId().getComponentList().get(k).setInStock(count * list.get(i).getDrugQuantity());
                count = (count * list.get(i).getDrugId().getComponentList().get(k).getPrice() * list.get(i).getDrugQuantity());
                list.get(i).getDrugId().getComponentList().get(k).setPrice(count);
                double a = list.get(i).getDrugId().getComponentList().get(k).getCriticalNorm();
                list.get(i).getDrugId().getComponentList().get(k).setCriticalNorm(list.get(i).getDrugId().getComponentList().get(k).getInStock() * a);
                a = 0;
            }
        }
        model.addAttribute("orders", list);
        return "other/components-used";
    }


    @RequestMapping(value = "UsedComponents")
    public String searchSortInRange(Model model,
                                    @Param("from") String from, @Param("to") String to) {
        LocalDate From= LocalDate.parse(from);
        LocalDate To= LocalDate.parse(to);
        List<Order> list = service.sortExtemporalStatusGone();

        for (int i = 0; i < list.size(); i++) {
            for (int k = 0; k < list.get(i).getDrugId().getComponentList().size(); k++) {
                double count = 1;
                for (int j = i+1; j < list.size(); j++) {
                    for (int r = 0; r < list.get(j).getDrugId().getComponentList().size(); r++) {
                        if(list.get(i).getDrugId().getComponentList().get(k).getId().equals(list.get(j).getDrugId().getComponentList().get(r).getId())){
                            count++;
                            list.get(j).getDrugId().getComponentList().remove(r);
                        }
                    }
                }
                list.get(i).getDrugId().getComponentList().get(k).setInStock(count * list.get(i).getDrugQuantity());
                count = (count * list.get(i).getDrugId().getComponentList().get(k).getPrice() * list.get(i).getDrugQuantity());
                list.get(i).getDrugId().getComponentList().get(k).setPrice(count);
                double a = list.get(i).getDrugId().getComponentList().get(k).getCriticalNorm();
                list.get(i).getDrugId().getComponentList().get(k).setCriticalNorm(list.get(i).getDrugId().getComponentList().get(k).getInStock() * a);
                a = 0;
            }
        }
        if(From.isAfter(To) || To.isBefore(From)){
            list = new ArrayList<>();
        }
        else {
            list = service.dateRange(From, To, list);
        }
        model.addAttribute("orders", list);
        return "other/components-used";
    }

    @RequestMapping(value = "extemporalCertainPeriod")
    public String sortCertainPeriod(Model model,
                                    @Param("from") String from, @Param("to") String to) {
        List<Order> list;
        LocalDate From= LocalDate.parse(from);
        LocalDate To= LocalDate.parse(to);

        if(From.isAfter(To) || To.isBefore(From)){
            list = new ArrayList<>();
        }
        else {
            list = service.extemporalDateRange(From, To);
        }
        model.addAttribute("orders", list);
        return "other/certaint-period-orders-extemporal";
    }
}
