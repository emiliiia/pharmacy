package com.emilia.pharmacy.controller.sql.client;

/*
  @author emilia
  @project pharmacy
  @className ClientUIController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLClient;
import com.emilia.pharmacy.entity.sql.SQLOrder;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLClientForm;
import com.emilia.pharmacy.repository.sql.IClientPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.client.impls.SQLClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/postgreeSQL/clients")
public class SQLClientUIController {
    @Autowired
    SQLClientServiceImpl service;

    @Autowired
    IClientPostgreSQLRepository sqlRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<SQLClient> clients = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", list);
        return "sqlPages/getAll/clients-all";
    }


    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/clients/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addClient(Model model){
        SQLClientForm clientForm = new SQLClientForm();

        model.addAttribute("form", clientForm);
        return "sqlPages/add/add-client";
    }


    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("form") SQLClientForm form){
        SQLClient client = new SQLClient();
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        client.setDescription("Client");
        client.setClientName(form.getClientName());
        client.setClientPhNum(form.getClientPhNum());
        client.setClientEmail(form.getClientEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        client.setClientDateBirth(LocalDate.parse(form.getClientDateBirth(), formatter));

        service.create(client);

        return "redirect:/ui/v1/postgreeSQL/clients/";
    }


    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateClient(Model model, @PathVariable("id") Integer id){
        SQLClient client = service.get(id);
        SQLClientForm clientForm = new SQLClientForm();
        clientForm.setClientName(client.getClientName());
        clientForm.setClientPhNum(client.getClientPhNum());
        clientForm.setClientEmail(client.getClientEmail());
        clientForm.setClientDateBirth(client.getClientDateBirth().toString());

        model.addAttribute("form", clientForm);
        return "sqlPages/edit/edit-client";
    }

    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewClient(Model model, @PathVariable("id") Integer id){
        SQLClient client = service.get(id);
        SQLClientForm clientForm = new SQLClientForm();
        clientForm.setClientName(client.getClientName());
        clientForm.setClientPhNum(client.getClientPhNum());
        clientForm.setClientEmail(client.getClientEmail());
        clientForm.setClientDateBirth(client.getClientDateBirth().toString());

        model.addAttribute("form", clientForm);
        return "sqlPages/review/review-client";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateClient(@PathVariable("id") Integer id,
                               @ModelAttribute("form") SQLClientForm form){
        SQLClient client = service.get(form.getId());

        client.setUpdatedAt(LocalDateTime.now());
        client.setClientName(form.getClientName());
        client.setClientPhNum(form.getClientPhNum());
        client.setClientEmail(form.getClientEmail());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        client.setClientDateBirth(LocalDate.parse(form.getClientDateBirth(), formatter));

        service.update(client);
        return "redirect:/ui/v1/postgreeSQL/clients/";
    }


    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<SQLClient> clients = service.sortNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<SQLClient> clients = service.sortNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<SQLClient> clients = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<SQLClient> clients = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<SQLClient> clients = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<SQLClient> clients = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }


    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLClient> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "sqlPages/getAll/clients-all";
    }
}
