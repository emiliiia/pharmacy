package com.emilia.pharmacy.controller.mongo.drug;

/*
  @author emilia
  @project pharmacy
  @className DrugUIController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.entity.mongo.Drug;
import com.emilia.pharmacy.entity.mongo.TechnologyBook;
import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.mongoForms.ExtemporalDrugForm;
import com.emilia.pharmacy.repository.mongo.IDrugMongoRepository;
import com.emilia.pharmacy.service.mongo.component.impls.ComponentServiceImpl;
import com.emilia.pharmacy.service.mongo.drug.impls.DrugServiceImpl;
import com.emilia.pharmacy.service.mongo.technologyBook.impls.TechnologyBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/mongoDB/extemporal/drugs")
public class ExtemporalDrugUIController {
    @Autowired
    DrugServiceImpl service;
    @Autowired
    TechnologyBookServiceImpl technologyBookService;
    @Autowired
    ComponentServiceImpl componentService;

    @Autowired
    IDrugMongoRepository mongoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showExtemporal(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> list = service.search(word, service.sortExtemporal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", list);
        return "getAll/extemporalDrugs-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/extemporal/drugs/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addExtemporalDrug(Model model){
        ExtemporalDrugForm extemporalDrugForm = new ExtemporalDrugForm();
        List<Component> components = new ArrayList<>();
        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> extemporalReleaseForm = Arrays.asList(ReleaseForm.values());

        Map<String, String> technologyBookMap = technologyBookService.getAll().stream()
                .collect(Collectors.toMap(TechnologyBook::getId, TechnologyBook::getType));

        List<String> technologyBookList = technologyBookService.getAll().stream()
                .map(TechnologyBook::getType).collect(Collectors.toList());

        Map<String, String> componentMap = new LinkedHashMap<>();
        componentMap = componentService.getAll().stream()
                .collect(Collectors.toMap(Component::getId, Component::getComponentName));

        Map<Object, Object> componentList = new HashMap<>();
        componentList.put("componentMap", componentMap);

        model.addAttribute("form", extemporalDrugForm);
        model.addAttribute("components", components);
        model.addAttribute("use", use);
        model.addAttribute("extemporalReleaseForm", extemporalReleaseForm);
        model.addAttribute("technologyBookMap", technologyBookMap);
        model.addAttribute("technologyBookList", technologyBookList);
        model.addAttribute("componentMap", componentMap);
        model.addAttribute("componentList", componentList);
        return "add/add-extemporalDrug";
    }


    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addExtemporalDrug(Model model, @ModelAttribute("form") ExtemporalDrugForm form){
        Drug extemporalDrug = new Drug();
        if(form.getComponentList() != null){
            extemporalDrug.setCreatedAt(LocalDateTime.now());
            extemporalDrug.setUpdatedAt(LocalDateTime.now());
            extemporalDrug.setDescription("Extemporal Drug");

            extemporalDrug.setDrugName(form.getExtemporalName());
            extemporalDrug.setVolume(form.getVolume());
            extemporalDrug.setUse(form.getUse());
            extemporalDrug.setPrescript(form.getPrescript());
            extemporalDrug.setReleaseForm(form.getReleaseForm());
            extemporalDrug.setExpirationDate(form.getExpirationDate());

            TechnologyBook technologyBook = technologyBookService.getAll().stream()
                    .filter(technology->technology.getType().equals(form.getTechnologyId()))
                    .findFirst().orElse(new TechnologyBook());

            extemporalDrug.setTechnologyId(technologyBook);
            extemporalDrug.setComponentList(form.getComponentList());

            double drugPrice = 0;
            for (Component component: form.getComponentList()) {
                drugPrice += component.getPrice();
            }

            extemporalDrug.setPrice(drugPrice);
            service.create(extemporalDrug);
            return "redirect:/ui/v1/mongoDB/extemporal/drugs/";
        }
        else{
            return "redirect:/ui/v1/mongoDB/extemporal/drugs/";
        }
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateExtemporalDrug(Model model, @PathVariable("id") String id){
        Drug extemporalDrug = service.get(id);

        ExtemporalDrugForm extemporalDrugForm = new ExtemporalDrugForm();
        extemporalDrugForm.setExtemporalName(extemporalDrug.getDrugName());
        extemporalDrugForm.setVolume(extemporalDrug.getVolume());
        extemporalDrugForm.setUse(extemporalDrug.getUse());
        extemporalDrugForm.setPrescript(extemporalDrug.getPrescript());
        extemporalDrugForm.setReleaseForm(extemporalDrug.getReleaseForm());
        extemporalDrugForm.setExpirationDate(extemporalDrug.getExpirationDate());
        extemporalDrugForm.setPrice(extemporalDrug.getPrice());
        extemporalDrugForm.setTechnologyId(extemporalDrug.getTechnologyId().getType());
        extemporalDrugForm.setComponentList(extemporalDrug.getComponentList());

        List<Component> components = new ArrayList<>();
        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> extemporalReleaseForm = Arrays.asList(ReleaseForm.values());

        Map<String, String> technologyBookMap = technologyBookService.getAll().stream()
                .collect(Collectors.toMap(TechnologyBook::getId, TechnologyBook::getType));

        List<String> technologyBookList = technologyBookService.getAll().stream()
                .map(TechnologyBook::getType).collect(Collectors.toList());

        Map<String, String> componentMap = new LinkedHashMap<>();
        componentMap = extemporalDrug.getComponentList().stream()
                .collect(Collectors.toMap(Component::getId, Component::getComponentName));

        Map<Object, Object> componentList = new HashMap<>();
        componentList.put("componentMap", componentMap);

        model.addAttribute("form", extemporalDrugForm);
        model.addAttribute("components", components);
        model.addAttribute("use", use);
        model.addAttribute("extemporalReleaseForm", extemporalReleaseForm);
        model.addAttribute("technologyBookMap", technologyBookMap);
        model.addAttribute("technologyBookList", technologyBookList);
        model.addAttribute("componentMap", componentMap);
        model.addAttribute("componentList", componentList);

        return "edit/edit-extemporalDrug";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateExtemporalDrug(Model model, @PathVariable("id") String id,
                                         @ModelAttribute("form") ExtemporalDrugForm form){
        Drug extemporalDrug = service.get(form.getId());

        extemporalDrug.setUpdatedAt(LocalDateTime.now());

        extemporalDrug.setDrugName(form.getExtemporalName());
        extemporalDrug.setVolume(form.getVolume());
        extemporalDrug.setUse(form.getUse());
        extemporalDrug.setPrescript(form.getPrescript());
        extemporalDrug.setReleaseForm(form.getReleaseForm());
        extemporalDrug.setExpirationDate(form.getExpirationDate());
        extemporalDrug.setPrice(form.getPrice());

        TechnologyBook technologyBook = technologyBookService.getAll().stream()
                .filter(technology->technology.getType().equals(form.getTechnologyId()))
                .findFirst().orElse(new TechnologyBook());
        extemporalDrug.setTechnologyId(technologyBook);

        service.update(extemporalDrug);
        model.addAttribute("extemporalDrug", service.getAll());
        return "redirect:/ui/v1/mongoDB/extemporal/drugs/";
    }

    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewExtemporalDrug(Model model, @PathVariable("id") String id){
        Drug extemporalDrug = service.get(id);

        ExtemporalDrugForm extemporalDrugForm = new ExtemporalDrugForm();

        extemporalDrugForm.setExtemporalName(extemporalDrug.getDrugName());
        extemporalDrugForm.setVolume(extemporalDrug.getVolume());
        extemporalDrugForm.setUse(extemporalDrug.getUse());
        extemporalDrugForm.setPrescript(extemporalDrug.getPrescript());
        extemporalDrugForm.setReleaseForm(extemporalDrug.getReleaseForm());
        extemporalDrugForm.setExpirationDate(extemporalDrug.getExpirationDate());
        extemporalDrugForm.setPrice(extemporalDrug.getPrice());
        extemporalDrugForm.setTechnologyId(extemporalDrug.getTechnologyId().getType());
        extemporalDrugForm.setComponentList(extemporalDrug.getComponentList());

        extemporalDrugForm.setCreatedAt(extemporalDrug.getCreatedAt());
        extemporalDrugForm.setUpdatedAt(extemporalDrug.getUpdatedAt());

        List<Component> components = extemporalDrug.getComponentList();
        List<Use> use = Arrays.asList(Use.values());
        List<ReleaseForm> extemporalReleaseForm = Arrays.asList(ReleaseForm.values());

        Map<String, String> technologyBookMap = technologyBookService.getAll().stream()
                .collect(Collectors.toMap(TechnologyBook::getId, TechnologyBook::getType));

        List<String> technologyBookList = technologyBookService.getAll().stream()
                .map(TechnologyBook::getType).collect(Collectors.toList());

        Map<String, String> componentMap = new LinkedHashMap<>();
        componentMap = extemporalDrug.getComponentList().stream()
                .collect(Collectors.toMap(Component::getId, Component::getComponentName));

        model.addAttribute("form", extemporalDrugForm);
        model.addAttribute("components", components);
        model.addAttribute("use", use);
        model.addAttribute("extemporalReleaseForm", extemporalReleaseForm);
        model.addAttribute("technologyBookMap", technologyBookMap);
        model.addAttribute("technologyBookList", technologyBookList);
        model.addAttribute("componentMap", componentMap);
        return "review/review-extemporalDrug";
    }

    @RequestMapping(value = "sortExtemporalNameAsce", method = RequestMethod.GET)
    String sortExtemporalNameAsce(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalNameAsce")
    public String searchSortExtemporalNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalNameAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalNameDsce", method = RequestMethod.GET)
    String sortExtemporalNameDsce(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalNameDsce")
    public String searchSortExtemporalNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalNameDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalCreatedAtAsce", method = RequestMethod.GET)
    String sortExtemporalCreatedAtAsce(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalCreatedAtAsce")
    public String searchSortExtemporalCreatedAtAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalCreatedAtAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalCreatedAtDsce", method = RequestMethod.GET)
    String sortExtemporalCreatedAtDsce(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalCreatedAtDsce")
    public String searchSortExtemporalCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalCreatedAtDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUpdatedAtAsce", method = RequestMethod.GET)
    String sortExtemporalUpdatedAtAsce(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUpdatedAtAsce")
    public String searchSortExtemporalUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalUpdatedAtAsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUpdatedAtDsce", method = RequestMethod.GET)
    String sortExtemporalUpdatedAtDsce(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUpdatedAtDsce")
    public String searchSortExtemporalUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalUpdatedAtDsce());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }


    @RequestMapping(value = "sortExtemporalUseExternal", method = RequestMethod.GET)
    String sortExtemporalUseExternal(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalUseExternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseExternal")
    public String searchSortExtemporalUseExternal(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalUseExternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUseInternal", method = RequestMethod.GET)
    String sortExtemporalUseInternal(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseInternal")
    public String searchSortExtemporalUseInternal(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalUseInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUseExInternal", method = RequestMethod.GET)
    String sortExtemporalUseExInternal(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalUseExInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseExInternal")
    public String searchSortExtemporalUseExInternal(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalUseExInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalUseMix", method = RequestMethod.GET)
    String sortExtemporalUseMix(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalUseMix")
    public String searchSortExtemporalUseMix(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalUseMix());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormTablets", method = RequestMethod.GET)
    String sortExtemporalFormTablets(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalFormTablets();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormTablets")
    public String searchSortExtemporalFormTablets(Model model,
                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalFormTablets());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormOintment", method = RequestMethod.GET)
    String sortExtemporalFormOintment(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalFormOintment();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormOintment")
    public String searchSortExtemporalFormOintment(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalFormOintment());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormPotion", method = RequestMethod.GET)
    String sortExtemporalFormPotion(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalFormPotion();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormPotion")
    public String searchSortExtemporalFormPotion(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalFormPotion());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormAQUA", method = RequestMethod.GET)
    String sortExtemporalFormAQUA(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalFormAQUA();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormAQUA")
    public String searchSortExtemporalFormAQUA(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalFormAQUA());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormFlour", method = RequestMethod.GET)
    String sortExtemporalFormFlour(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalFormFlour();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormFlour")
    public String searchSortExtemporalFormFlour(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalFormFlour());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @RequestMapping(value = "sortExtemporalFormTincture", method = RequestMethod.GET)
    String sortExtemporalFormTincture(Model model) {
        List<Drug> extemporalDrugs = service.sortExtemporalFormTincture();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }

    @PostMapping(value = "sortExtemporalFormTincture")
    public String searchSortExtemporalFormTincture(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> extemporalDrugs = service.search(word, service.sortExtemporalFormTincture());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("extemporalDrugs", extemporalDrugs);
        return "getAll/extemporalDrugs-all";
    }
}
