package com.emilia.pharmacy.controller.mongo.client;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalClientUIController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Client;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.mongoForms.ClientForm;
import com.emilia.pharmacy.repository.mongo.IClientMongoRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mongoDB/clients")
public class ClientUIController {

    @Autowired
    ClientServiceImpl service;

    @Autowired
    IClientMongoRepository mongoRepository;

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<Client> clients = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }


    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", list);
        return "getAll/clients-all";
    }


    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/clients/";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addClient(Model model){
        ClientForm clientForm = new ClientForm();

        model.addAttribute("form", clientForm);
        return "add/add-client";
    }


    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("form") ClientForm form){
        Client client = new Client();
        client.setCreatedAt(LocalDateTime.now());
        client.setUpdatedAt(LocalDateTime.now());
        client.setDescription("Client");
        client.setClientName(form.getClientName());
        client.setClientPhNum(form.getClientPhNum());
        client.setClientEmail(form.getClientEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        client.setClientDateBirth(LocalDate.parse(form.getClientDateBirth(), formatter));

        service.create(client);

        return "redirect:/ui/v1/mongoDB/clients/";
    }


    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateClient(Model model, @PathVariable("id") String id){
        Client client = service.get(id);
        ClientForm clientForm = new ClientForm();
        clientForm.setClientName(client.getClientName());
        clientForm.setClientPhNum(client.getClientPhNum());
        clientForm.setClientEmail(client.getClientEmail());
        clientForm.setClientDateBirth(client.getClientDateBirth().toString());

        model.addAttribute("form", clientForm);
        return "edit/edit-client";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewClient(Model model, @PathVariable("id") String id){
        Client client = service.get(id);
        ClientForm clientForm = new ClientForm();
        clientForm.setClientName(client.getClientName());
        clientForm.setClientPhNum(client.getClientPhNum());
        clientForm.setClientEmail(client.getClientEmail());
        clientForm.setClientDateBirth(client.getClientDateBirth().toString());

        model.addAttribute("form", clientForm);
        return "review/review-client";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateClient(@PathVariable("id") String id,
                                  @ModelAttribute("form") ClientForm form){
        Client client = service.get(form.getId());

        client.setUpdatedAt(LocalDateTime.now());
        client.setClientName(form.getClientName());
        client.setClientPhNum(form.getClientPhNum());
        client.setClientEmail(form.getClientEmail());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        client.setClientDateBirth(LocalDate.parse(form.getClientDateBirth(), formatter));

        service.update(client);
        return "redirect:/ui/v1/mongoDB/clients/";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<Client> clients = service.sortNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<Client> clients = service.sortNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<Client> clients = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<Client> clients = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<Client> clients = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<Client> clients = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN", "ROLE_USER", "ROLE_OPERATOR"})
    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Client> clients = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("clients", clients);
        return "getAll/clients-all";
    }

}
