package com.emilia.pharmacy.controller.mongo.technologyBook;

/*
  @author emilia
  @project pharmacy
  @className TechnologyBookUIController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.mongoForms.TechnologyBookForm;
import com.emilia.pharmacy.enums.ExtemporalMethod;
import com.emilia.pharmacy.entity.mongo.TechnologyBook;
import com.emilia.pharmacy.repository.mongo.ITechnologyBookMongoRepository;
import com.emilia.pharmacy.service.mongo.technologyBook.impls.TechnologyBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mongoDB/technologyBook")
public class TechnologyBookUIController {
    @Autowired
    TechnologyBookServiceImpl service;

    @Autowired
    ITechnologyBookMongoRepository mongoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<TechnologyBook> technology = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", list);
        return "getAll/technology-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/technologyBook/";
    }


    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addTechnology(Model model){
        TechnologyBookForm technologyBookForm = new TechnologyBookForm();
        List<ExtemporalMethod> methods = Arrays.asList(ExtemporalMethod.values());

        model.addAttribute("form", technologyBookForm);
        model.addAttribute("methods", methods);
        return "add/add-technology";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addTechnology(@ModelAttribute("form") TechnologyBookForm form){
        TechnologyBook technology = new TechnologyBook();
        technology.setCreatedAt(LocalDateTime.now());
        technology.setUpdatedAt(LocalDateTime.now());
        technology.setDescription("Technology Book");
        technology.setType(form.getType());
        technology.setMethod(form.getMethod());
        technology.setTimeReady(form.getTimeReady());
        service.create(technology);

        return "redirect:/ui/v1/mongoDB/technologyBook/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateTechnology(Model model, @PathVariable("id") String id){
        TechnologyBook technology = service.get(id);
        List<ExtemporalMethod> methods = Arrays.asList(ExtemporalMethod.values());
        TechnologyBookForm technologyForm = new TechnologyBookForm();
        technologyForm.setType(technology.getType());
        technologyForm.setMethod(technology.getMethod());
        technologyForm.setTimeReady(technology.getTimeReady());

        model.addAttribute("form", technologyForm);
        model.addAttribute("methods", methods);
        return "edit/edit-technology";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateTechnology(@PathVariable("id") String id,
                                  @ModelAttribute("form") TechnologyBookForm form){
        TechnologyBook technology = service.get(form.getId());

        technology.setUpdatedAt(LocalDateTime.now());
        technology.setType(form.getType());
        technology.setMethod(form.getMethod());
        technology.setTimeReady(form.getTimeReady());

        service.update(technology);
        return "redirect:/ui/v1/mongoDB/technologyBook/";
    }

    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewTechnology(Model model, @PathVariable("id") String id){
        TechnologyBook technology = service.get(id);
        List<ExtemporalMethod> methods = Arrays.asList(ExtemporalMethod.values());
        TechnologyBookForm technologyForm = new TechnologyBookForm();
        technologyForm.setType(technology.getType());
        technologyForm.setMethod(technology.getMethod());
        technologyForm.setTimeReady(technology.getTimeReady());

        model.addAttribute("form", technologyForm);
        model.addAttribute("methods", methods);
        return "review/review-technology";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<TechnologyBook> technology = service.sortNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<TechnologyBook> technology = service.sortNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }


    @RequestMapping(value = "sortMethodDISSOLVING", method = RequestMethod.GET)
    String sortMethodDISSOLVING(Model model) {
        List<TechnologyBook> technology = service.sortMethodDISSOLVING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodDISSOLVING")
    public String searchMethodDISSOLVING(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodSWELLING", method = RequestMethod.GET)
    String sortMethodSWELLING(Model model) {
        List<TechnologyBook> technology = service.sortMethodSWELLING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodSWELLING")
    public String searchMethodSWELLING(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodHEATING", method = RequestMethod.GET)
    String sortMethodHEATING(Model model) {
        List<TechnologyBook> technology = service.sortMethodHEATING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodHEATING")
    public String searchMethodHEATING(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodDILUTION", method = RequestMethod.GET)
    String sortMethodDILUTION(Model model) {
        List<TechnologyBook> technology = service.sortMethodDILUTION();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodDILUTION")
    public String searchMethodDILUTION(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodFILTERING", method = RequestMethod.GET)
    String sortMethodFILTERING(Model model) {
        List<TechnologyBook> technology = service.sortMethodFILTERING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodFILTERING")
    public String searchMethodFILTERING(Model model,
                                       @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodEMULSIFYING", method = RequestMethod.GET)
    String sortMethodEMULSIFYING(Model model) {
        List<TechnologyBook> technology = service.sortMethodEMULSIFYING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodEMULSIFYING")
    public String searchMethodEMULSIFYING(Model model,
                                        @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodDISPERSING", method = RequestMethod.GET)
    String sortMethodDISPERSING(Model model) {
        List<TechnologyBook> technology = service.sortMethodDISPERSING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodDISPERSING")
    public String searchMethodDISPERSING(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortMethodMIXING", method = RequestMethod.GET)
    String sortMethodMIXING(Model model) {
        List<TechnologyBook> technology = service.sortMethodMIXING();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortMethodMIXING")
    public String searchMethodMIXING(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<TechnologyBook> technology = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<TechnologyBook> technology = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<TechnologyBook> technology = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<TechnologyBook> technology = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnologyBook> technology = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technologyBook", technology);
        return "getAll/technology-all";
    }

}
