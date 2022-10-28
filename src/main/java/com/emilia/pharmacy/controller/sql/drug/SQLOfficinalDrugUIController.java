package com.emilia.pharmacy.controller.sql.drug;

/*
  @author emilia
  @project pharmacy
  @className OfficinalDrugUIController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLDrug;
import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLOfficinalDrugForm;
import com.emilia.pharmacy.repository.sql.IDrugPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.drug.impls.SQLDrugServiceImpl;
import com.emilia.pharmacy.service.sql.manufacturer.impls.SQLManufacturerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/postgreeSQL/officinal/drugs")
public class SQLOfficinalDrugUIController {
    @Autowired
    SQLDrugServiceImpl service;

    @Autowired
    SQLManufacturerServiceImpl manufacturerService;

    @Autowired
    IDrugPostgreSQLRepository sqlRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showOfficinalDrug(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> list = service.search(word, service.sortOfficinal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", list);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/officinal/drugs/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addOfficinalDrug(Model model){
        SQLOfficinalDrugForm officinalDrugForm = new SQLOfficinalDrugForm();
        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> releaseForm = Arrays.asList(ReleaseForm.TABLETS, ReleaseForm.OINTMENT, ReleaseForm.TINCTURE);

        Map<Integer, String> manufacturerMap = manufacturerService.getAll().stream()
                .collect(Collectors.toMap(SQLManufacturer::getId, SQLManufacturer::getManufacturerName));

        List<String> manufacturerList = manufacturerService.getAll().stream()
                .map(SQLManufacturer::getManufacturerName).collect(Collectors.toList());

        model.addAttribute("form", officinalDrugForm);
        model.addAttribute("use", use);
        model.addAttribute("releaseForm", releaseForm);
        model.addAttribute("manufacturerMap", manufacturerMap);
        model.addAttribute("manufacturerList", manufacturerList);
        return "sqlPages/add/add-officinalDrug";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addOfficinalDrug(Model model, @ModelAttribute("form") SQLOfficinalDrugForm form){

        SQLDrug officinalDrug = new SQLDrug();
        officinalDrug.setCreatedAt(LocalDateTime.now());
        officinalDrug.setUpdatedAt(LocalDateTime.now());
        officinalDrug.setDescription("Officinal Drug");

        officinalDrug.setDrugName(form.getDrugName());
        officinalDrug.setVolume(form.getVolume());
        officinalDrug.setUse(form.getUse());
        officinalDrug.setPrescript(form.getPrescript());
        officinalDrug.setReleaseForm(form.getReleaseForm());
        officinalDrug.setOfficinalInStock(form.getOfficinalInStock());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        officinalDrug.setOfficinalExpirationDate(LocalDate.parse(form.getOfficinalExpirationDate(), formatter));

        SQLManufacturer manufacturer = manufacturerService.getAll().stream()
                .filter(technology->technology.getManufacturerName().equals(form.getManufacturerId()))
                .findFirst().orElse(new SQLManufacturer());

        officinalDrug.setManufacturerId(manufacturer);

        officinalDrug.setPrice(form.getPrice());
        service.create(officinalDrug);
        return "redirect:/ui/v1/postgreeSQL/officinal/drugs/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateOfficinalDrug(Model model, @PathVariable("id") Integer id){
        SQLDrug officinalDrug = service.get(id);
        SQLOfficinalDrugForm officinalDrugForm = new SQLOfficinalDrugForm();

        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> releaseForm = Arrays.asList(ReleaseForm.TABLETS, ReleaseForm.OINTMENT, ReleaseForm.TINCTURE);

        Map<Integer, String> manufacturerMap = manufacturerService.getAll().stream()
                .collect(Collectors.toMap(SQLManufacturer::getId, SQLManufacturer::getManufacturerName));

        List<String> manufacturerList = manufacturerService.getAll().stream()
                .map(SQLManufacturer::getManufacturerName).collect(Collectors.toList());


        officinalDrugForm.setDrugName(officinalDrug.getDrugName());
        officinalDrugForm.setVolume(officinalDrug.getVolume());
        officinalDrugForm.setUse(officinalDrug.getUse());
        officinalDrugForm.setPrescript(officinalDrug.getPrescript());
        officinalDrugForm.setReleaseForm(officinalDrug.getReleaseForm());
        officinalDrugForm.setOfficinalInStock(officinalDrug.getOfficinalInStock());
        officinalDrugForm.setOfficinalExpirationDate(officinalDrug.getOfficinalExpirationDate().toString());
        officinalDrugForm.setManufacturerId(officinalDrug.getManufacturerId().getManufacturerName());

        officinalDrugForm.setPrice(officinalDrug.getPrice());

        model.addAttribute("form", officinalDrugForm);
        model.addAttribute("use", use);
        model.addAttribute("releaseForm", releaseForm);
        model.addAttribute("manufacturerMap", manufacturerMap);
        model.addAttribute("manufacturerList", manufacturerList);
        return "sqlPages/edit/edit-officinalDrug";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateOfficinalDrug(@PathVariable("id") String id,
                                      @ModelAttribute("form") SQLOfficinalDrugForm form){
        SQLDrug officinalDrug = service.get(form.getId());

        officinalDrug.setUpdatedAt(LocalDateTime.now());

        officinalDrug.setDrugName(form.getDrugName());
        officinalDrug.setVolume(form.getVolume());
        officinalDrug.setUse(form.getUse());
        officinalDrug.setPrescript(form.getPrescript());
        officinalDrug.setReleaseForm(form.getReleaseForm());
        officinalDrug.setOfficinalInStock(form.getOfficinalInStock());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        officinalDrug.setOfficinalExpirationDate(LocalDate.parse(form.getOfficinalExpirationDate(), formatter));

        SQLManufacturer manufacturer = manufacturerService.getAll().stream()
                .filter(technology->technology.getManufacturerName().equals(form.getManufacturerId()))
                .findFirst().orElse(new SQLManufacturer());

        officinalDrug.setManufacturerId(manufacturer);

        officinalDrug.setPrice(form.getPrice());

        service.update(officinalDrug);
        return "redirect:/ui/v1/postgreeSQL/officinal/drugs/";
    }

    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewOfficinalDrug(Model model, @PathVariable("id") Integer id){
        SQLDrug officinalDrug = service.get(id);
        SQLOfficinalDrugForm officinalDrugForm = new SQLOfficinalDrugForm();

        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> releaseForm = Arrays.asList(ReleaseForm.TABLETS, ReleaseForm.OINTMENT, ReleaseForm.TINCTURE);


        Map<Integer, String> manufacturerMap = manufacturerService.getAll().stream()
                .collect(Collectors.toMap(SQLManufacturer::getId, SQLManufacturer::getManufacturerName));

        List<String> manufacturerList = manufacturerService.getAll().stream()
                .map(SQLManufacturer::getManufacturerName).collect(Collectors.toList());


        officinalDrugForm.setDrugName(officinalDrug.getDrugName());
        officinalDrugForm.setVolume(officinalDrug.getVolume());
        officinalDrugForm.setUse(officinalDrug.getUse());
        officinalDrugForm.setPrescript(officinalDrug.getPrescript());
        officinalDrugForm.setReleaseForm(officinalDrug.getReleaseForm());
        officinalDrugForm.setOfficinalInStock(officinalDrug.getOfficinalInStock());
        officinalDrugForm.setOfficinalExpirationDate(officinalDrug.getOfficinalExpirationDate().toString());
        officinalDrugForm.setManufacturerId(officinalDrug.getManufacturerId().getManufacturerName());

        officinalDrugForm.setPrice(officinalDrug.getPrice());

        officinalDrugForm.setCreatedAt(officinalDrug.getCreatedAt());
        officinalDrugForm.setUpdatedAt(officinalDrug.getUpdatedAt());

        model.addAttribute("form", officinalDrugForm);
        model.addAttribute("use", use);
        model.addAttribute("releaseForm", releaseForm);
        model.addAttribute("manufacturerMap", manufacturerMap);
        model.addAttribute("manufacturerList", manufacturerList);
        return "sqlPages/review/review-officinalDrug";
    }

    @RequestMapping(value = "expireDrugs", method = RequestMethod.GET)
    String expireDrugs(Model model) {
        List<SQLDrug> officinalDrugs = service.expireDrugs(LocalDate.now());
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "expireDrugs")
    public String searchExpireDrugs(Model model,
                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.expireDrugs(LocalDate.now()));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalNameAsce", method = RequestMethod.GET)
    String sortOfficinalNameAsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalNameAsce")
    public String searchSortOfficinalNameAsce(Model model,
                                              @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalNameAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalNameDsce", method = RequestMethod.GET)
    String sortOfficinalNameDsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalNameDsce")
    public String searchSortOfficinalNameDsce(Model model,
                                              @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalNameDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalCreatedAtAsce", method = RequestMethod.GET)
    String sortOfficinalCreatedAtAsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalCreatedAtAsce")
    public String searchSortOfficinalCreatedAtAsce(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalCreatedAtAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalCreatedAtDsce", method = RequestMethod.GET)
    String sortOfficinalCreatedAtDsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalCreatedAtDsce")
    public String searchSortOfficinalCreatedAtDsce(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalCreatedAtDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalUpdatedAtAsce", method = RequestMethod.GET)
    String sortOfficinalUpdatedAtAsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalUpdatedAtAsce")
    public String searchSortOfficinalUpdatedAtAsce(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalUpdatedAtAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalUpdatedAtDsce", method = RequestMethod.GET)
    String sortOfficinalUpdatedAtDsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalUpdatedAtDsce")
    public String searchSortOfficinalUpdatedAtDsce(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalUpdatedAtDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalUseExternal", method = RequestMethod.GET)
    String sortOfficinalUseExternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalUseExternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalUseExternal")
    public String searchSortOfficinalUseExternal(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalUseExternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalUseInternal", method = RequestMethod.GET)
    String sortOfficinalUseInternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalUseInternal")
    public String searchSortOfficinalUseInternal(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalUseInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalUseExInternal", method = RequestMethod.GET)
    String sortOfficinalUseExInternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalUseExInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalUseExInternal")
    public String searchSortOfficinalUseExInternal(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalUseExInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalUseMix", method = RequestMethod.GET)
    String sortOfficinalUseMix(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalUseMix")
    public String searchSortOfficinalUseMix(Model model,
                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalUseMix());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalFormTablets", method = RequestMethod.GET)
    String sortOfficinalFormTablets(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalFormTablets();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalFormTablets")
    public String searchSortOfficinalFormTablets(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalFormTablets());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalFormOintment", method = RequestMethod.GET)
    String sortOfficinalFormOintment(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalFormOintment();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalFormOintment")
    public String searchSortOfficinalFormOintment(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalFormOintment());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @RequestMapping(value = "sortOfficinalFormTincture", method = RequestMethod.GET)
    String sortOfficinalFormTincture(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalFormTincture();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    @PostMapping(value = "sorOfficinalFormTincture")
    public String searchSortOfficinalFormTincture(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalFormTincture());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/getAll/officinalDrugs-all";
    }

    /****************INSTOCK***********************/

    @RequestMapping(value = "sortOfficinalInStockAsce", method = RequestMethod.GET)
    String sortOfficinalInStockAsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce")
    public String searchSortOfficinalInStockAsce(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce", method = RequestMethod.GET)
    String sortOfficinalInStockDsce(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce")
    public String searchSortOfficinalInStockDsce(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/UseInternal", method = RequestMethod.GET)
    String sortOfficinalInStockAsceUseInternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/UseInternal")
    public String searchSortOfficinalInStockAsceUseInternal(Model model,
                                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceUseInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/UseInternal", method = RequestMethod.GET)
    String sortOfficinalInStockDsceUseInternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsceUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/UseInternal")
    public String searchSortOfficinalInStockDsceUseInternal(Model model,
                                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceUseInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/UseExternal", method = RequestMethod.GET)
    String sortOfficinalInStockAsceUseExternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceUseExternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/UseExternal")
    public String searchSortOfficinalInStockAsceUseExternal(Model model,
                                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceUseExternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/UseExternal", method = RequestMethod.GET)
    String sortOfficinalInStockDsceUseExternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsceUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/UseExternal")
    public String searchSortOfficinalInStockDsceUseExternal(Model model,
                                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceUseExternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/UseExternalInternal", method = RequestMethod.GET)
    String sortOfficinalInStockAsceUseExternalInternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceUseExternalInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/UseExternalInternal")
    public String searchSortOfficinalInStockAsceUseExternalInternal(Model model,
                                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceUseExternalInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/UseExternalInternal", method = RequestMethod.GET)
    String sortOfficinalInStockDsceUseExternalInternal(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsceUseExternalInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/UseExternalInternal")
    public String searchSortOfficinalInStockDsceUseExternalInternal(Model model,
                                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceUseExternalInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/UseMix", method = RequestMethod.GET)
    String sortOfficinalInStockAsceUseMix(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/UseMix")
    public String searchSortOfficinalInStockAsceUseMix(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceUseMix());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/UseMix", method = RequestMethod.GET)
    String sortOfficinalInStockDsceUseMix(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/UseMix")
    public String searchSortOfficinalInStockDsceUseMix(Model model,
                                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceUseMix());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/FormTablets", method = RequestMethod.GET)
    String sortOfficinalInStockAsceFormTablets(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceFormTablets();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/FormTablets")
    public String searchSortOfficinalInStockAsceFormTablets(Model model,
                                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceFormTablets());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/FormTablets", method = RequestMethod.GET)
    String sortOfficinalInStockDsceFormTablets(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsceFormTablets();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/FormTablets")
    public String searchSortOfficinalInStockDsceFormTablets(Model model,
                                                            @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceFormTablets());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/FormOintment", method = RequestMethod.GET)
    String sortOfficinalInStockAsceFormOintment(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceFormOintment();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/FormOintment")
    public String searchSortOfficinalInStockAsceFormOintment(Model model,
                                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceFormOintment());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/FormOintment", method = RequestMethod.GET)
    String sortOfficinalInStockDsceFormOintment(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsceFormOintment();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/FormOintment")
    public String searchSortOfficinalInStockDsceFormOintment(Model model,
                                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceFormOintment());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @RequestMapping(value = "sortOfficinalInStockAsce/FormTincture", method = RequestMethod.GET)
    String sortOfficinalInStockAsceFormTincture(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockAsceFormTincture();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @PostMapping(value = "sortOfficinalInStockAsce/FormTincture")
    public String searchSortOfficinalInStockAsceFormTincture(Model model,
                                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockAsceFormTincture());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-asce";
    }

    @RequestMapping(value = "sortOfficinalInStockDsce/FormTincture", method = RequestMethod.GET)
    String sortOfficinalInStockDsceFormTincture(Model model) {
        List<SQLDrug> officinalDrugs = service.sortOfficinalInStockDsceFormTincture();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }

    @PostMapping(value = "sortOfficinalInStockDsce/FormTincture")
    public String searchSortOfficinalInStockDsceFormTincture(Model model,
                                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> officinalDrugs = service.search(word, service.sortOfficinalInStockDsceFormTincture());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("officinalDrugs", officinalDrugs);
        return "sqlPages/other/officinal-minimum-stock-dsce";
    }
}
