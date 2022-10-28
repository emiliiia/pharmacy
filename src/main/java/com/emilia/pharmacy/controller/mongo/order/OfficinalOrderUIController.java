package com.emilia.pharmacy.controller.mongo.order;

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

/*
  @author emilia
  @project pharmacy
  @className OfficinalOrderUIController
  @version 1.0.0
  @since 10.08.2022
*/
@Controller
@RequestMapping("/ui/v1/mongoDB/orders/officinal")
public class OfficinalOrderUIController {
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
        List<Order> officinalOrders = service.sortOfficinal();
        SearchForm searchForm = new SearchForm();

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();

        List<Order> officinalOrders = service.sortOfficinal();
        if(service.searchByDrug(word, officinalOrders) != null && !service.searchByDrug(word, officinalOrders).isEmpty()){
            officinalOrders = service.searchByDrug(word, officinalOrders);
        }
        else {
            officinalOrders = service.searchByClient(word, officinalOrders);
        }

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);

        return "getAll/officinalOrders-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortOfficinal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/orders/officinal/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addOfficinalOrder(Model model){
        OrderForm orderForm = new OrderForm();
        List<OrderStatus> orderStatus = Arrays.asList(OrderStatus.GONE);

        Map<String, String> drugMap = drugService.sortOfficinal().stream()
                .collect(Collectors.toMap(Drug::getId, Drug::getDrugName));

        List<String> drugList = drugService.sortOfficinal().stream()
                .map(Drug::getDrugName).collect(Collectors.toList());

        Map<String, String> clientMap = clientService.getAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::getClientName));

        List<String> clientList = clientService.getAll().stream()
                .map(Client::getClientName).collect(Collectors.toList());

        model.addAttribute("form", orderForm);
        model.addAttribute("orderStatus", orderStatus);
        model.addAttribute("drugMap", drugMap);
        model.addAttribute("drugList", drugList);
        model.addAttribute("clientMap", clientMap);
        model.addAttribute("clientList", clientList);
        return "add/add-officinalOrder";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addOfficinalOrder(Model model, @ModelAttribute("form") OrderForm form){
        Order officinalOrder = new Order();

        officinalOrder.setCreatedAt(LocalDateTime.now());
        officinalOrder.setUpdatedAt(LocalDateTime.now());
        officinalOrder.setDescription("Officinal Order");

        Drug officinalDrug = drugService.sortOfficinal().stream()
                .filter(drug->drug.getDrugName().equals(form.getDrugId()))
                .findFirst().orElse(new Drug());
        officinalOrder.setDrugId(officinalDrug);

        Client officinalclient = clientService.getAll().stream()
                .filter(client->client.getClientName().equals(form.getClientId()))
                .findFirst().orElse(new Client());
        officinalOrder.setClientId(officinalclient);
        officinalOrder.setOrderStatus(form.getOrderStatus());

        officinalOrder.setDrugQuantity(form.getDrugQuantity());
        officinalOrder.setDocName(form.getDocName());
        officinalOrder.setDiagnos(form.getDiagnos());

        double orderPrice = form.getDrugQuantity() * officinalDrug.getPrice();
        officinalOrder.setPrice(orderPrice);

        officinalOrder.setOrderGo(LocalDate.now());

        service.create(officinalOrder);
        return "redirect:/ui/v1/mongoDB/orders/officinal/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateOfficinalOrder(Model model, @PathVariable("id") String id) {
        Order order = service.get(id);
        OrderForm officinalOrderForm = new OrderForm();

        officinalOrderForm.setDrugId(order.getDrugId().getDrugName());
        officinalOrderForm.setClientId(order.getClientId().getClientName());
        officinalOrderForm.setOrderStatus(order.getOrderStatus());
        officinalOrderForm.setDrugQuantity(order.getDrugQuantity());
        officinalOrderForm.setDocName(order.getDocName());
        officinalOrderForm.setDiagnos(order.getDiagnos());
        officinalOrderForm.setOrderStatus(order.getOrderStatus());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        officinalOrderForm.setOrderGo(order.getOrderGo().toString());
        List<OrderStatus> orderStatus = Arrays.asList(OrderStatus.GONE);

        Map<String, String> drugMap = drugService.sortOfficinal().stream()
                .collect(Collectors.toMap(Drug::getId, Drug::getDrugName));

        List<String> drugList = drugService.sortOfficinal().stream()
                .map(Drug::getDrugName).collect(Collectors.toList());

        Map<String, String> clientMap = clientService.getAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::getClientName));

        List<String> clientList = clientService.getAll().stream()
                .map(Client::getClientName).collect(Collectors.toList());

        model.addAttribute("form", officinalOrderForm);
        model.addAttribute("orderStatus", orderStatus);
        model.addAttribute("drugMap", drugMap);
        model.addAttribute("drugList", drugList);
        model.addAttribute("clientMap", clientMap);
        model.addAttribute("clientList", clientList);
        return "edit/edit-officinalOrder";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateOfficinalOrder(Model model, @PathVariable("id") String id,
                                        @ModelAttribute("form") OrderForm form) {

        Order officinalOrder = service.get(form.getId());

        officinalOrder.setUpdatedAt(LocalDateTime.now());

        Drug officinalDrug = drugService.sortOfficinal().stream()
                .filter(drug->drug.getDrugName().equals(form.getDrugId()))
                .findFirst().orElse(new Drug());
        officinalOrder.setDrugId(officinalDrug);

        Client officinalClient = clientService.getAll().stream()
                .filter(client->client.getClientName().equals(form.getClientId()))
                .findFirst().orElse(new Client());
        officinalOrder.setClientId(officinalClient);
        officinalOrder.setOrderStatus(form.getOrderStatus());

        officinalOrder.setDrugQuantity(form.getDrugQuantity());
        officinalOrder.setDocName(form.getDocName());
        officinalOrder.setDiagnos(form.getDiagnos());

        double orderPrice = form.getDrugQuantity() * officinalDrug.getPrice();
        officinalOrder.setPrice(orderPrice);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        officinalOrder.setOrderGo(LocalDate.parse(form.getOrderGo(), formatter));

        service.update(officinalOrder);
        return "redirect:/ui/v1/mongoDB/orders/officinal/";
    }

    /*****************************************/
    @RequestMapping(value = "sortOfficinalNameAsce", method = RequestMethod.GET)
    String sortOfficinalNameAsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalNameAsce")
    public String searchSortOfficinalNameAsce(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortOfficinal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalNameDsce", method = RequestMethod.GET)
    String sortOfficinalNameDsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalNameDsce")
    public String searchSortOfficinalNameDsce(Model model,
                                              @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.sortOfficinal();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalCreatedAtAsce", method = RequestMethod.GET)
    String sortOfficinalCreatedAtAsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalCreatedAtAsce")
    public String searchSortOfficinalCreatedAtAsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalCreatedAtDsce", method = RequestMethod.GET)
    String sortOfficinalCreatedAtDsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalCreatedAtDsce")
    public String searchSortOfficinalCreatedAtDsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalUpdatedAtAsce", method = RequestMethod.GET)
    String sortOfficinalUpdatedAtAsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalUpdatedAtAsce")
    public String searchSortOfficinalUpdatedAtAsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalUpdatedAtDsce", method = RequestMethod.GET)
    String sortOfficinalUpdatedAtDsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalUpdatedAtDsce")
    public String searchSortOfficinalUpdatedAtDsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalQuantityAsce", method = RequestMethod.GET)
    String sortOfficinalQuantityAsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalQuantityAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalQuantityAsce")
    public String searchSortOfficinalQuantityAsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalQuantityDsce", method = RequestMethod.GET)
    String sortOfficinalQuantityDsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalQuantityDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalQuantityDsce")
    public String searchSortOfficinalQuantityDsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalPriceAsce", method = RequestMethod.GET)
    String sortOfficinalPriceAsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalPriceAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalPriceAsce")
    public String searchSortOfficinalPriceAsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalPriceDsce", method = RequestMethod.GET)
    String sortOfficinalPriceDsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalPriceDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalPriceDsce")
    public String searchSortOfficinalPriceDsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalOrderGoAsce", method = RequestMethod.GET)
    String sortOfficinalOrderGoAsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalOrderGoAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalOrderGoAsce")
    public String searchSortOfficinalOrderGoAsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "sortOfficinalOrderGoDsce", method = RequestMethod.GET)
    String sortOfficinalOrderGoDsce(Model model) {
        List<Order> officinalOrders = service.sortOfficinalOrderGoDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalOrders", officinalOrders);
        return "getAll/officinalOrders-all";
    }

    @PostMapping(value = "sortOfficinalOrderGoDsce")
    public String searchSortOfficinalOrderGoDsce(Model model,
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
        model.addAttribute("officinalOrders", list);
        return "getAll/officinalOrders-all";
    }

    @RequestMapping(value = "officinalCertainPeriod")
    public String sortCertainPeriod(Model model,
                                    @Param("from") String from, @Param("to") String to) {
        List<Order> list;
        LocalDate From= LocalDate.parse(from);
        LocalDate To= LocalDate.parse(to);

        if(From.isAfter(To) || To.isBefore(From)){
            list = new ArrayList<>();
        }
        else {
            list = service.officinalDateRange(From, To);
        }
        model.addAttribute("orders", list);
        return "other/certaint-period-orders-officinal";
    }
    /*******************************************************************/
}
