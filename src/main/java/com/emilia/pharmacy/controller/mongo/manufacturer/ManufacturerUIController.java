package com.emilia.pharmacy.controller.mongo.manufacturer;

import com.emilia.pharmacy.entity.mongo.Manufacturer;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.mongoForms.ManufacturerForm;
import com.emilia.pharmacy.repository.mongo.IManufacturerMongoRepository;
import com.emilia.pharmacy.service.mongo.manufacturer.impls.ManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerUIController
  @version 1.0.0
  @since 09.08.2022
*/
@Controller
@RequestMapping("/ui/v1/mongoDB/manufacturers")
public class ManufacturerUIController {

    @Autowired
    ManufacturerServiceImpl service;

    @Autowired
    IManufacturerMongoRepository mongoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<Manufacturer> manufacturers = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.getAll();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
            manufacturers.addAll(service.searchByAgentName(word, list));
            manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.getAll();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/manufacturers/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addManufacturer(Model model){
        ManufacturerForm manufacturerForm = new ManufacturerForm();

        model.addAttribute("form", manufacturerForm);
        return "add/add-manufacturer";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addManufacturer(@ModelAttribute("form") ManufacturerForm form){
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreatedAt(LocalDateTime.now());
        manufacturer.setUpdatedAt(LocalDateTime.now());
        manufacturer.setDescription("Manufacturer");

        manufacturer.setManufacturerName(form.getManufacturerName());
        manufacturer.setAgentName(form.getAgentName());
        manufacturer.setAgentPhNum(form.getAgentPhNum());
        manufacturer.setCountry(form.getCountry());
        service.create(manufacturer);

        return "redirect:/ui/v1/mongoDB/manufacturers/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateManufacturer(Model model, @PathVariable("id") String id){
        Manufacturer manufacturer = service.get(id);
        ManufacturerForm manufacturerForm = new ManufacturerForm();
        manufacturerForm.setManufacturerName(manufacturer.getManufacturerName());
        manufacturerForm.setAgentName(manufacturer.getAgentName());
        manufacturerForm.setAgentPhNum(manufacturer.getAgentPhNum());
        manufacturerForm.setCountry(manufacturer.getCountry());

        model.addAttribute("form", manufacturerForm);
        return "edit/edit-manufacturer";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateManufacturer(@PathVariable("id") String id,
                                  @ModelAttribute("form") ManufacturerForm form){
        Manufacturer manufacturer = service.get(form.getId());

        manufacturer.setUpdatedAt(LocalDateTime.now());
        manufacturer.setManufacturerName(form.getManufacturerName());
        manufacturer.setAgentName(form.getAgentName());
        manufacturer.setAgentPhNum(form.getAgentPhNum());
        manufacturer.setCountry(form.getCountry());

        service.update(manufacturer);
        return "redirect:/ui/v1/mongoDB/manufacturers/";
    }


    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewManufacturer(Model model, @PathVariable("id") String id){
        Manufacturer manufacturer = service.get(id);
        ManufacturerForm manufacturerForm = new ManufacturerForm();
        manufacturerForm.setManufacturerName(manufacturer.getManufacturerName());
        manufacturerForm.setAgentName(manufacturer.getAgentName());
        manufacturerForm.setAgentPhNum(manufacturer.getAgentPhNum());
        manufacturerForm.setCountry(manufacturer.getCountry());

        model.addAttribute("form", manufacturerForm);
        return "review/review-manufacturer";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<Manufacturer> manufacturers = service.sortManufacturerAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.sortManufacturerAsce();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<Manufacturer> manufacturers = service.sortManufacturerDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.sortManufacturerDsce();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<Manufacturer> manufacturers = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.sortCreatedAtAsce();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<Manufacturer> manufacturers = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.sortCreatedAtDsce();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<Manufacturer> manufacturers = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.sortUpdatedAtAsce();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<Manufacturer> manufacturers = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Manufacturer> list = service.sortUpdatedAtDsce();
        List<Manufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "getAll/manufacturers-all";
    }

}
