package com.emilia.pharmacy.controller;

/*
  @author emilia
  @project pharmacy_2
  @className adminPageUIController
  @version 1.0.0
  @since 18.08.2022
*/

import com.emilia.pharmacy.form.AdminHomeForm;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.mongo.drug.impls.DrugServiceImpl;
import com.emilia.pharmacy.service.mongo.order.impls.OrderServiceImpl;
import com.emilia.pharmacy.service.mongo.requestComponent.impls.RequestComponentServiceImpl;
import com.emilia.pharmacy.service.sql.client.impls.SQLClientServiceImpl;
import com.emilia.pharmacy.service.sql.drug.impls.SQLDrugServiceImpl;
import com.emilia.pharmacy.service.sql.key.impls.SQLKeyServiceImpl;
import com.emilia.pharmacy.service.sql.order.impls.SQLOrderServiceImpl;
import com.emilia.pharmacy.service.sql.requestComponent.impls.SQLRequestComponentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/adminPage")
public class adminPageUIController {

    @Autowired
    SQLKeyServiceImpl service;
    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    DrugServiceImpl drugService;

    @Autowired
    RequestComponentServiceImpl requestService;

    @Autowired
    SQLOrderServiceImpl sqlOrderService;

    @Autowired
    SQLClientServiceImpl sqlClientService;

    @Autowired
    SQLDrugServiceImpl sqlDrugService;

    @Autowired
    SQLRequestComponentServiceImpl sqlRequestComponentService;

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model, Principal principal) {
        List<AdminHomeForm> forms = new ArrayList<>();
        AdminHomeForm form = new AdminHomeForm();
        form.setUsername(principal.getName());
        form.setMongoOrder(orderService.getAll().size());
        form.setMongoClient(clientService.getAll().size());
        form.setMongoDrug(drugService.getAll().size());
        form.setMongoRequest(requestService.getAll().size());
        form.setSqlOrder(sqlOrderService.getAll().size());
        form.setSqlClient(sqlClientService.getAll().size());
        form.setSqlDrug(sqlDrugService.getAll().size());
        form.setSqlRequest(sqlRequestComponentService.getAll().size());

        forms.add(form);
        model.addAttribute("forms", forms);
        return "adminHome";
    }

    @RequestMapping(value = "loadingScript", method = RequestMethod.GET)
    public String loadScriptForm(Model model){
        return "sqlPages/loadingScript";
    }

    @RequestMapping(value = "endLoadingScript")
    public String loadScript(Model model,
                             @Param("script") String script) throws Exception {
        service.loadingScript(script);

        return "redirect:/ui/v1/adminPage/";
    }
}
