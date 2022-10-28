package com.emilia.pharmacy.controller.mongo.order;

import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.entity.mongo.Order;
import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
import com.emilia.pharmacy.form.SearchForm;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
  @author emilia
  @project pharmacy
  @className OrderUIController
  @version 1.0.0
  @since 10.08.2022
*/
@Controller
@RequestMapping("/ui/v1/mongoDB/orders")
public class OrderUIController {

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
        List<Order> orders = service.getAll();
        SearchForm searchForm = new SearchForm();

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();

        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
           orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);

        return "getAll/orders-all";
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/orders/";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<Order> orders = service.sortNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<Order> orders = service.sortNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortPriceAsce", method = RequestMethod.GET)
    String sortPriceAsce(Model model) {
        List<Order> orders = service.sortPriceAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortPriceAsce")
    public String searchSortPriceAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortPriceDsce", method = RequestMethod.GET)
    String sortPriceDsce(Model model) {
        List<Order> orders = service.sortPriceDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortPriceDsce")
    public String searchSortPriceDsce(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortQuantityAsce", method = RequestMethod.GET)
    String sortQuantityAsce(Model model) {
        List<Order> orders = service.sortQuantityAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortQuantityAsce")
    public String searchSortQuantityAsce(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortQuantityDsce", method = RequestMethod.GET)
    String sortQuantityDsce(Model model) {
        List<Order> orders = service.sortQuantityDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortQuantityDsce")
    public String searchSortQuantityDsce(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortOrderGoAsce", method = RequestMethod.GET)
    String sortOrderGoAsce(Model model) {
        List<Order> orders = service.sortQuantityDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortOrderGoAsce")
    public String searchSortOrderGoAsce(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortOrderGoDsce", method = RequestMethod.GET)
    String sortOrderGoDsce(Model model) {
        List<Order> orders = service.sortQuantityDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortOrderGoDsce")
    public String searchSortOrderGoDsce(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<Order> orders = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<Order> orders = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<Order> orders = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<Order> orders = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortStatusInprogress", method = RequestMethod.GET)
    String sortStatusInprogress(Model model) {
        List<Order> orders = service.sortStatusInprogress();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortStatusInprogress")
    public String searchSortStatusInprogress(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortStatusGone", method = RequestMethod.GET)
    String sortStatusGone(Model model) {
        List<Order> orders = service.sortStatusGone();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortStatusGone")
    public String searchSortStatusGone(Model model,
                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @RequestMapping(value = "sortStatusPending", method = RequestMethod.GET)
    String sortStatusPending(Model model) {
        List<Order> orders = service.sortStatusPending();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    @PostMapping(value = "sortStatusPending")
    public String searchSortStatusPending(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> orders = service.getAll();
        if(service.searchByDrug(word, orders) != null && !service.searchByDrug(word, orders).isEmpty()){
            orders = service.searchByDrug(word, orders);
        }
        else {
            orders = service.searchByClient(word, orders);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", orders);
        return "getAll/orders-all";
    }

    /**********************************/

    @RequestMapping(value = "sortTopTenDrugs", method = RequestMethod.GET)
    String sortTopTenDrugs(Model model) {
        List<Order> list = service.getAll();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size()-1; j++) {
                if(list.get(i).getDrugId().getDrugName().equals(list.get(j).getDrugId().getDrugName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs")
    public String searchSortTopTenDrugs(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/extemporal", method = RequestMethod.GET)
    String sortTopTenDrugsExtemporal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Extemporal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/extemporal")
    public String searchSortTopTenDrugsExtemporal(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Extemporal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/officinal", method = RequestMethod.GET)
    String sortTopTenDrugsOfficinal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Officinal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/officinal")
    public String searchSortTopTenDrugsOfficinal(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Officinal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortUseExternal", method = RequestMethod.GET)
    String sortTopTenDrugsSortUseExternal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.EXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortUseExternal")
    public String searchSortTopTenDrugsSortUseExternal(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.EXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortUseInternal", method = RequestMethod.GET)
    String sortTopTenDrugsSortUseInternal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortUseInternal")
    public String searchSortTopTenDrugsSortUseInternal(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortUseExternalInternal", method = RequestMethod.GET)
    String sortTopTenDrugsSortUseExternalInternal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNALEXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortUseExternalInternal")
    public String searchSortTopTenDrugsSortUseExternalInternal(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNALEXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortUseMix", method = RequestMethod.GET)
    String sortTopTenDrugsSortUseMix(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.MIX))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortUseMix")
    public String searchSortTopTenDrugsSortUseMix(Model model,
                                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.MIX))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortFormTablets", method = RequestMethod.GET)
    String sortTopTenDrugsSortFormTablets(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TABLETS))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortFormTablets")
    public String searchSortTopTenDrugsSortFormTablets(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TABLETS))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortFormOintment", method = RequestMethod.GET)
    String sortTopTenDrugsSortFormOintment(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.OINTMENT))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortFormOintment")
    public String searchSortTopTenDrugsSortFormOintment(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.OINTMENT))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortFormPotion", method = RequestMethod.GET)
    String sortTopTenDrugsSortFormPotion(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.POTION))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortFormPotion")
    public String searchSortTopTenDrugsSortFormPotion(Model model,
                                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.POTION))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortFormAqua", method = RequestMethod.GET)
    String sortTopTenDrugsSortFormAqua(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.AQUA))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortFormAqua")
    public String searchSortTopTenDrugsSortFormAqua(Model model,
                                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.AQUA))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortFormFlour", method = RequestMethod.GET)
    String sortTopTenDrugsSortFormFlour(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.FLOUR))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortFormFlour")
    public String searchSortTopTenDrugsSortFormFlour(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.FLOUR))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "sortTopTenDrugs/sortFormTincture", method = RequestMethod.GET)
    String sortTopTenDrugsSortFormTincture(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TINCTURE))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getDrugQuantity).reversed()).limit(10)
                .collect(Collectors.toList());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @PostMapping(value = "sortTopTenDrugs/sortFormTincture")
    public String searchSortTopTenDrugsSortFormTincture(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TINCTURE))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getDrugId().equals(list.get(j).getDrugId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.remove(j);
                }
            }
        }

        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }


        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-most-popular-drugs";
    }

    @RequestMapping(value = "CertainPeriod")
    public String sortCertainPeriod(Model model,
                                          @Param("from") String from, @Param("to") String to) {
    List<Order> list = service.getAll();
    LocalDate From= LocalDate.parse(from);
    LocalDate To= LocalDate.parse(to);

        if(From.isAfter(To) || To.isBefore(From)){
            list = new ArrayList<>();
        }
        else {
            list = service.dateRange(From, To);
        }
        model.addAttribute("orders", list);
        return "other/certaint-period-orders";
    }


    /*********/
    @RequestMapping(value = "sortTopTenClients", method = RequestMethod.GET)
    String sortTopTenClients(Model model) {
        List<Order> list = service.getAll();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients")
    public String searchSortTopTenClients(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortUseExternal", method = RequestMethod.GET)
    String sortTopTenClientsSortUseExternal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.EXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortUseExternal")
    public String searchSortTopTenClientsSortUseExternal(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.EXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortUseInternal", method = RequestMethod.GET)
    String sortTopTenClientsSortUseInternal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortUseInternal")
    public String searchSortTopTenClientsSortUseInternal(Model model,
                                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortUseExternalInternal", method = RequestMethod.GET)
    String sortTopTenClientsSortUseExternalInternal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNALEXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortUseExternalInternal")
    public String searchSortTopTenClientsSortUseExternalInternal(Model model,
                                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.INTERNALEXTERNAL))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortUseMix", method = RequestMethod.GET)
    String sortTopTenClientsSortUseMix(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.MIX))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortUseMix")
    public String searchSortTopTenClientsSortUseMix(Model model,
                                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getUse().equals(Use.MIX))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortFormTablets", method = RequestMethod.GET)
    String sortTopTenClientsSortFormTablets(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TABLETS))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortFormTablets")
    public String searchSortTopTenClientsSortFormTablets(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TABLETS))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }


    @RequestMapping(value = "sortTopTenClients/sortFormOintment", method = RequestMethod.GET)
    String sortTopTenClientsSortFormOintment(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.OINTMENT))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortFormOintment")
    public String searchSortTopTenClientsSortFormOintment(Model model,
                                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.OINTMENT))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortFormPotion", method = RequestMethod.GET)
    String sortTopTenClientsSortFormPotion(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.POTION))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortFormPotion")
    public String searchSortTopTenClientsSortFormPotion(Model model,
                                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.POTION))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortFormAqua", method = RequestMethod.GET)
    String sortTopTenClientsSortFormAqua(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.AQUA))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortFormAqua")
    public String searchSortTopTenClientsSortFormAqua(Model model,
                                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.AQUA))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortFormFlour", method = RequestMethod.GET)
    String sortTopTenClientsSortFormFlour(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.FLOUR))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortFormFlour")
    public String searchSortTopTenClientsSortFormFlour(Model model,
                                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.FLOUR))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortFormTincture", method = RequestMethod.GET)
    String sortTopTenClientsSortFormTincture(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TINCTURE))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortFormTincture")
    public String searchSortTopTenClientsSortFormTincture(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDrugId().getReleaseForm().equals(ReleaseForm.TINCTURE))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortExtemporal", method = RequestMethod.GET)
    String sortTopTenClientsSortExtemporal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Extemporal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortExtemporal")
    public String searchSortTopTenClientsSortExtemporal(Model model,
                                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Extemporal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().getClientName().equals(list.get(j).getClientId().getClientName())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @RequestMapping(value = "sortTopTenClients/sortOfficinal", method = RequestMethod.GET)
    String sortTopTenClientsSortOfficinal(Model model) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Officinal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());

        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }

    @PostMapping(value = "sortTopTenClients/sortOfficinal")
    public String searchSortTopTenClientsSortOfficinal(Model model,
                                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        List<Order> list = service.getAll().stream()
                .filter(order -> order.getDescription().equals("Officinal Order"))
                .collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getClientId().equals(list.get(j).getClientId())){
                    list.get(i).plustDrugQuantity(list.get(j).getDrugQuantity());
                    list.get(i).plustDrugPrice(list.get(j).getPrice());
                    list.remove(j);
                }
            }
        }

        list = list.stream().sorted(Comparator.comparing(Order::getPrice).reversed()).limit(10)
                .collect(Collectors.toList());
        String word = searchForm.getString();
        if(service.searchByDrug(word, list) != null && !service.searchByDrug(word, list).isEmpty()){
            list = service.searchByDrug(word, list);
        }
        else {
            list = service.searchByClient(word, list);
        }
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("orders", list);
        return "other/ten-top-clients";
    }
}
