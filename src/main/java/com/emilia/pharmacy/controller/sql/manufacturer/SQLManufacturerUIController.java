package com.emilia.pharmacy.controller.sql.manufacturer;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerUIController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLManufacturerForm;
import com.emilia.pharmacy.repository.sql.IManufacturerPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.manufacturer.impls.SQLManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/postgreeSQL/manufacturers")
public class SQLManufacturerUIController {
    @Autowired
    SQLManufacturerServiceImpl service;

    @Autowired
    IManufacturerPostgreSQLRepository sqlRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<SQLManufacturer> manufacturers = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.getAll();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.getAll();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/manufacturers/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addManufacturer(Model model){
        SQLManufacturerForm manufacturerForm = new SQLManufacturerForm();

        model.addAttribute("form", manufacturerForm);
        return "sqlPages/add/add-manufacturer";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addManufacturer(@ModelAttribute("form") SQLManufacturerForm form){
        SQLManufacturer manufacturer = new SQLManufacturer();
        manufacturer.setCreatedAt(LocalDateTime.now());
        manufacturer.setUpdatedAt(LocalDateTime.now());
        manufacturer.setDescription("Manufacturer");

        manufacturer.setManufacturerName(form.getManufacturerName());
        manufacturer.setAgentName(form.getAgentName());
        manufacturer.setAgentPhNum(form.getAgentPhNum());
        manufacturer.setCountry(form.getCountry());
        service.create(manufacturer);

        return "redirect:/ui/v1/postgreeSQL/manufacturers/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateManufacturer(Model model, @PathVariable("id") Integer id){
        SQLManufacturer manufacturer = service.get(id);
        SQLManufacturerForm manufacturerForm = new SQLManufacturerForm();
        manufacturerForm.setManufacturerName(manufacturer.getManufacturerName());
        manufacturerForm.setAgentName(manufacturer.getAgentName());
        manufacturerForm.setAgentPhNum(manufacturer.getAgentPhNum());
        manufacturerForm.setCountry(manufacturer.getCountry());

        model.addAttribute("form", manufacturerForm);
        return "sqlPages/edit/edit-manufacturer";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateManufacturer(@PathVariable("id") Integer id,
                                     @ModelAttribute("form") SQLManufacturerForm form){
        SQLManufacturer manufacturer = service.get(form.getId());

        manufacturer.setUpdatedAt(LocalDateTime.now());
        manufacturer.setManufacturerName(form.getManufacturerName());
        manufacturer.setAgentName(form.getAgentName());
        manufacturer.setAgentPhNum(form.getAgentPhNum());
        manufacturer.setCountry(form.getCountry());

        service.update(manufacturer);
        return "redirect:/ui/v1/postgreeSQL/manufacturers/";
    }


    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewManufacturer(Model model, @PathVariable("id") Integer id){
        SQLManufacturer manufacturer = service.get(id);
        SQLManufacturerForm manufacturerForm = new SQLManufacturerForm();
        manufacturerForm.setManufacturerName(manufacturer.getManufacturerName());
        manufacturerForm.setAgentName(manufacturer.getAgentName());
        manufacturerForm.setAgentPhNum(manufacturer.getAgentPhNum());
        manufacturerForm.setCountry(manufacturer.getCountry());

        model.addAttribute("form", manufacturerForm);
        return "sqlPages/review/review-manufacturer";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<SQLManufacturer> manufacturers = service.sortManufacturerAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.sortManufacturerAsce();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<SQLManufacturer> manufacturers = service.sortManufacturerDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.sortManufacturerDsce();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<SQLManufacturer> manufacturers = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.sortCreatedAtAsce();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<SQLManufacturer> manufacturers = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.sortCreatedAtDsce();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<SQLManufacturer> manufacturers = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.sortUpdatedAtAsce();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<SQLManufacturer> manufacturers = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLManufacturer> list = service.sortUpdatedAtDsce();
        List<SQLManufacturer>  manufacturers = service.searchByCompanyName(word, list);
        manufacturers.addAll(service.searchByAgentName(word, list));
        manufacturers.addAll(service.searchByCountry(word, list));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("manufacturers", manufacturers);
        return "sqlPages/getAll/manufacturers-all";
    }
}
