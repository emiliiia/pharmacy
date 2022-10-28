package com.emilia.pharmacy.controller.sql.drug;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalDrugUIController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLComponent;
import com.emilia.pharmacy.entity.sql.SQLDrug;
import com.emilia.pharmacy.entity.sql.SQLTechnologyBook;
import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLExtemporalDrugForm;
import com.emilia.pharmacy.repository.sql.IDrugPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.component.impls.SQLComponentServiceImpl;
import com.emilia.pharmacy.service.sql.drug.impls.SQLDrugServiceImpl;
import com.emilia.pharmacy.service.sql.technologyBook.impls.SQLTechnologyBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/postgreeSQL/extemporal/drugs")
public class SQLExtemporalDrugUIController {
    @Autowired
    SQLDrugServiceImpl service;
    @Autowired
    SQLTechnologyBookServiceImpl technologyBookService;
    @Autowired
    SQLComponentServiceImpl componentService;

    @Autowired
    IDrugPostgreSQLRepository sqlRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showExtemporal(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> list = service.search(word, service.sortExtemporal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", list);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/extemporal/drugs/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addExtemporalDrug(Model model){
        SQLExtemporalDrugForm extemporalDrugForm = new SQLExtemporalDrugForm();
        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> extemporalReleaseForm = Arrays.asList(ReleaseForm.values());

        Map<Integer, String> technologyBookMap = technologyBookService.getAll().stream()
                .collect(Collectors.toMap(SQLTechnologyBook::getId, SQLTechnologyBook::getType));

        List<String> technologyBookList = technologyBookService.getAll().stream()
                .map(SQLTechnologyBook::getType).collect(Collectors.toList());

        Map<Integer, String> componentMap = componentService.getAll().stream()
                .collect(Collectors.toMap(SQLComponent::getId, SQLComponent::getComponentName));

        List<String> componentList = componentService.getAll().stream()
                .map(SQLComponent::getComponentName).collect(Collectors.toList());

        model.addAttribute("form", extemporalDrugForm);
        model.addAttribute("use", use);
        model.addAttribute("extemporalReleaseForm", extemporalReleaseForm);
        model.addAttribute("technologyBookMap", technologyBookMap);
        model.addAttribute("technologyBookList", technologyBookList);
        model.addAttribute("componentMap", componentMap);
        model.addAttribute("componentList", componentList);
        return "sqlPages/add/add-extemporalDrug";
    }


    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addExtemporalDrug(Model model, @ModelAttribute("form") SQLExtemporalDrugForm form){
        SQLDrug extemporalDrug = new SQLDrug();
        extemporalDrug.setCreatedAt(LocalDateTime.now());
        extemporalDrug.setUpdatedAt(LocalDateTime.now());
        extemporalDrug.setDescription("Extemporal Drug");

        extemporalDrug.setDrugName(form.getExtemporalName());
        extemporalDrug.setVolume(form.getVolume());
        extemporalDrug.setUse(form.getUse());
        extemporalDrug.setPrescript(form.getPrescript());
        extemporalDrug.setReleaseForm(form.getReleaseForm());
        extemporalDrug.setExpirationDate(form.getExpirationDate());
        extemporalDrug.setOfficinalInStock(0);
        SQLTechnologyBook technologyBook = technologyBookService.getAll().stream()
                .filter(technology->technology.getType().equals(form.getTechnologyId()))
                .findFirst().orElse(new SQLTechnologyBook());

        extemporalDrug.setTechnologyId(technologyBook);

        SQLComponent component = componentService.getAll().stream()
                .filter(comp->comp.getComponentName().equals(form.getComponentId()))
                .findFirst().orElse(new SQLComponent());

        extemporalDrug.setComponentId(component);

        double drugPrice = component.getPrice() + ((component.getPrice() * 20) / 100);
        extemporalDrug.setPrice(drugPrice);
        service.create(extemporalDrug);
        return "redirect:/ui/v1/postgreeSQL/extemporal/drugs/";

    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateExtemporalDrug(Model model, @PathVariable("id") Integer id){
        SQLDrug extemporalDrug = service.get(id);

        SQLExtemporalDrugForm extemporalDrugForm = new SQLExtemporalDrugForm();
        extemporalDrugForm.setExtemporalName(extemporalDrug.getDrugName());
        extemporalDrugForm.setVolume(extemporalDrug.getVolume());
        extemporalDrugForm.setUse(extemporalDrug.getUse());
        extemporalDrugForm.setPrescript(extemporalDrug.getPrescript());
        extemporalDrugForm.setReleaseForm(extemporalDrug.getReleaseForm());
        extemporalDrugForm.setExpirationDate(extemporalDrug.getExpirationDate());
        extemporalDrugForm.setPrice(extemporalDrug.getPrice());
        extemporalDrugForm.setTechnologyId(extemporalDrug.getTechnologyId().getType());
        extemporalDrugForm.setComponentId(extemporalDrug.getComponentId().getComponentName());

        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> extemporalReleaseForm = Arrays.asList(ReleaseForm.values());

        Map<Integer, String> technologyBookMap = technologyBookService.getAll().stream()
                .collect(Collectors.toMap(SQLTechnologyBook::getId, SQLTechnologyBook::getType));

        List<String> technologyBookList = technologyBookService.getAll().stream()
                .map(SQLTechnologyBook::getType).collect(Collectors.toList());

        Map<Integer, String> componentMap = componentService.getAll().stream()
                .collect(Collectors.toMap(SQLComponent::getId, SQLComponent::getComponentName));

        List<String> componentList = componentService.getAll().stream()
                .map(SQLComponent::getComponentName).collect(Collectors.toList());

        model.addAttribute("form", extemporalDrugForm);
        model.addAttribute("use", use);
        model.addAttribute("extemporalReleaseForm", extemporalReleaseForm);
        model.addAttribute("technologyBookMap", technologyBookMap);
        model.addAttribute("technologyBookList", technologyBookList);
        model.addAttribute("componentMap", componentMap);
        model.addAttribute("componentList", componentList);

        return "sqlPages/edit/edit-extemporalDrug";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateExtemporalDrug(Model model, @PathVariable("id") Integer id,
                                       @ModelAttribute("form") SQLExtemporalDrugForm form){
        SQLDrug extemporalDrug = service.get(form.getId());

        extemporalDrug.setUpdatedAt(LocalDateTime.now());

        extemporalDrug.setDrugName(form.getExtemporalName());
        extemporalDrug.setVolume(form.getVolume());
        extemporalDrug.setUse(form.getUse());
        extemporalDrug.setPrescript(form.getPrescript());
        extemporalDrug.setReleaseForm(form.getReleaseForm());
        extemporalDrug.setExpirationDate(form.getExpirationDate());

        SQLTechnologyBook technologyBook = technologyBookService.getAll().stream()
                .filter(technology->technology.getType().equals(form.getTechnologyId()))
                .findFirst().orElse(new SQLTechnologyBook());
        extemporalDrug.setTechnologyId(technologyBook);

        SQLComponent component = componentService.getAll().stream()
                .filter(comp->comp.getComponentName().equals(form.getComponentId()))
                .findFirst().orElse(new SQLComponent());

        extemporalDrug.setComponentId(component);

        double drugPrice = component.getPrice() + ((component.getPrice() * 20) / 100);
        extemporalDrug.setPrice(drugPrice);

        service.update(extemporalDrug);
        model.addAttribute("extemporalDrug", service.getAll());
        return "redirect:/ui/v1/postgreeSQL/extemporal/drugs/";
    }

    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewExtemporalDrug(Model model, @PathVariable("id") Integer id){
        SQLDrug extemporalDrug = service.get(id);

        SQLExtemporalDrugForm extemporalDrugForm = new SQLExtemporalDrugForm();

        extemporalDrugForm.setExtemporalName(extemporalDrug.getDrugName());
        extemporalDrugForm.setVolume(extemporalDrug.getVolume());
        extemporalDrugForm.setUse(extemporalDrug.getUse());
        extemporalDrugForm.setPrescript(extemporalDrug.getPrescript());
        extemporalDrugForm.setReleaseForm(extemporalDrug.getReleaseForm());
        extemporalDrugForm.setExpirationDate(extemporalDrug.getExpirationDate());
        extemporalDrugForm.setPrice(extemporalDrug.getPrice());
        extemporalDrugForm.setTechnologyId(extemporalDrug.getTechnologyId().getType());
        extemporalDrugForm.setComponentId(extemporalDrug.getComponentId().getComponentName());


        extemporalDrugForm.setCreatedAt(extemporalDrug.getCreatedAt());
        extemporalDrugForm.setUpdatedAt(extemporalDrug.getUpdatedAt());

        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> extemporalReleaseForm = Arrays.asList(ReleaseForm.values());

        Map<Integer, String> technologyBookMap = technologyBookService.getAll().stream()
                .collect(Collectors.toMap(SQLTechnologyBook::getId, SQLTechnologyBook::getType));

        Map<Integer, String> componentMap = componentService.getAll().stream()
                .collect(Collectors.toMap(SQLComponent::getId, SQLComponent::getComponentName));

        model.addAttribute("form", extemporalDrugForm);
        model.addAttribute("use", use);
        model.addAttribute("extemporalReleaseForm", extemporalReleaseForm);
        model.addAttribute("technologyBookMap", technologyBookMap);
        model.addAttribute("componentMap", componentMap);
        return "sqlPages/review/review-extemporalDrug";
    }

    @RequestMapping(value = "sortExtemporalNameAsce", method = RequestMethod.GET)
    String sortExtemporalNameAsce(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalNameAsce")
    public String searchSortExtemporalNameAsce(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalNameAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalNameDsce", method = RequestMethod.GET)
    String sortExtemporalNameDsce(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalNameDsce")
    public String searchSortExtemporalNameDsce(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalNameDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalCreatedAtAsce", method = RequestMethod.GET)
    String sortExtemporalCreatedAtAsce(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalCreatedAtAsce")
    public String searchSortExtemporalCreatedAtAsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalCreatedAtAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalCreatedAtDsce", method = RequestMethod.GET)
    String sortExtemporalCreatedAtDsce(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalCreatedAtDsce")
    public String searchSortExtemporalCreatedAtDsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalCreatedAtDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUpdatedAtAsce", method = RequestMethod.GET)
    String sortExtemporalUpdatedAtAsce(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUpdatedAtAsce")
    public String searchSortExtemporalUpdatedAtAsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalUpdatedAtAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUpdatedAtDsce", method = RequestMethod.GET)
    String sortExtemporalUpdatedAtDsce(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUpdatedAtDsce")
    public String searchSortExtemporalUpdatedAtDsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalUpdatedAtDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }


    @RequestMapping(value = "sortExtemporalUseExternal", method = RequestMethod.GET)
    String sortExtemporalUseExternal(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalUseExternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseExternal")
    public String searchSortExtemporalUseExternal(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalUseExternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUseInternal", method = RequestMethod.GET)
    String sortExtemporalUseInternal(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseInternal")
    public String searchSortExtemporalUseInternal(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalUseInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUseExInternal", method = RequestMethod.GET)
    String sortExtemporalUseExInternal(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalUseExInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseExInternal")
    public String searchSortExtemporalUseExInternal(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalUseExInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUseMix", method = RequestMethod.GET)
    String sortExtemporalUseMix(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseMix")
    public String searchSortExtemporalUseMix(Model model,
                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalUseMix());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormTablets", method = RequestMethod.GET)
    String sortExtemporalFormTablets(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalFormTablets();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormTablets")
    public String searchSortExtemporalFormTablets(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalFormTablets());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormOintment", method = RequestMethod.GET)
    String sortExtemporalFormOintment(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalFormOintment();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormOintment")
    public String searchSortExtemporalFormOintment(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalFormOintment());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormPotion", method = RequestMethod.GET)
    String sortExtemporalFormPotion(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalFormPotion();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormPotion")
    public String searchSortExtemporalFormPotion(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalFormPotion());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormAQUA", method = RequestMethod.GET)
    String sortExtemporalFormAQUA(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalFormAQUA();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormAQUA")
    public String searchSortExtemporalFormAQUA(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalFormAQUA());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormFlour", method = RequestMethod.GET)
    String sortExtemporalFormFlour(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalFormFlour();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormFlour")
    public String searchSortExtemporalFormFlour(Model model,
                                                @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalFormFlour());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormTincture", method = RequestMethod.GET)
    String sortExtemporalFormTincture(Model model) {
        List<SQLDrug> extemporalDrugs = service.sortExtemporalFormTincture();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormTincture")
    public String searchSortExtemporalFormTincture(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLDrug> extemporalDrugs = service.search(word, service.sortExtemporalFormTincture());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "sqlPages/getAll/extemporalDrugs-all";
    }
}
