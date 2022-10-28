package com.emilia.pharmacy.controller.mongo.component;

/*
  @author emilia
  @project pharmacy
  @className ComponentUIController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.mongoForms.ComponentForm;
import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.repository.mongo.IComponentMongoRepository;
import com.emilia.pharmacy.service.mongo.component.impls.ComponentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/ui/v1/mongoDB/components")
public class ComponentUIController {
    @Autowired
    ComponentServiceImpl service;

    @Autowired
    IComponentMongoRepository mongoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<Component> components = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", list);
        return "getAll/components-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/components/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addComponent(Model model){
        ComponentForm componentForm = new ComponentForm();

        model.addAttribute("form", componentForm);
        return "add/add-component";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addComponent(@ModelAttribute("form") ComponentForm form){
            Component component = new Component();
            component.setCreatedAt(LocalDateTime.now());
            component.setUpdatedAt(LocalDateTime.now());
            component.setDescription("Component");
            component.setPrice(form.getPrice());
            component.setComponentName(form.getComponentName());
            component.setMeasure(form.getMeasure());
            component.setCriticalNorm(form.getCriticalNorm());
            component.setInStock(form.getInStock());
            service.create(component);

            return "redirect:/ui/v1/mongoDB/components/";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateComponent(Model model, @PathVariable("id") String id){
        Component component = service.get(id);
        ComponentForm componentForm = new ComponentForm();
        componentForm.setComponentName(component.getComponentName());
        componentForm.setMeasure(component.getMeasure());
        componentForm.setCriticalNorm(component.getCriticalNorm());
        componentForm.setInStock(component.getInStock());
        componentForm.setPrice(component.getPrice());

        model.addAttribute("form", componentForm);
        return "edit/edit-component";
    }

    @RequestMapping(value = "editInStockForm/{id}", method = RequestMethod.GET)
    public String updateInStockComponent(Model model, @PathVariable("id") String id){
        Component component = service.get(id);
        ComponentForm componentForm = new ComponentForm();
        componentForm.setComponentName(component.getComponentName());
        componentForm.setMeasure(component.getMeasure());
        componentForm.setCriticalNorm(component.getCriticalNorm());
        componentForm.setInStock(component.getInStock());
        componentForm.setPrice(component.getPrice());

        model.addAttribute("form", componentForm);
        return "edit/editInStock-component";
    }

    @RequestMapping(value = "editPriceForm/{id}", method = RequestMethod.GET)
    public String updatePriceComponent(Model model, @PathVariable("id") String id){
        Component component = service.get(id);
        ComponentForm componentForm = new ComponentForm();
        componentForm.setComponentName(component.getComponentName());
        componentForm.setMeasure(component.getMeasure());
        componentForm.setCriticalNorm(component.getCriticalNorm());
        componentForm.setInStock(component.getInStock());
        componentForm.setPrice(component.getPrice());

        model.addAttribute("form", componentForm);
        return "edit/editPrice-component";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateComponent(@PathVariable("id") String id,
                               @ModelAttribute("form") ComponentForm form){
        Component component = service.get(form.getId());

        component.setUpdatedAt(LocalDateTime.now());
        component.setComponentName(form.getComponentName());
        component.setMeasure(form.getMeasure());
        component.setCriticalNorm(form.getCriticalNorm());
        component.setInStock(form.getInStock());
        component.setPrice(form.getPrice());

        service.update(component);
        return "redirect:/ui/v1/mongoDB/components/";
    }

    @RequestMapping(value = "editInStockForm/{id}", method = RequestMethod.POST)
    public String updateInStockComponent(@PathVariable("id") String id,
                                  @ModelAttribute("form") ComponentForm form){
        Component component = service.get(form.getId());

        component.setUpdatedAt(LocalDateTime.now());
        component.setComponentName(form.getComponentName());
        component.setMeasure(form.getMeasure());
        component.setCriticalNorm(form.getCriticalNorm());
        component.setInStock(form.getInStock());
        component.setPrice(form.getPrice());

        service.update(component);
        return "redirect:/ui/v1/mongoDB/components/";
    }

    @RequestMapping(value = "editPriceForm/{id}", method = RequestMethod.POST)
    public String updatePriceComponent(@PathVariable("id") String id,
                                         @ModelAttribute("form") ComponentForm form){
        Component component = service.get(form.getId());

        component.setUpdatedAt(LocalDateTime.now());
        component.setComponentName(form.getComponentName());
        component.setMeasure(form.getMeasure());
        component.setCriticalNorm(form.getCriticalNorm());
        component.setInStock(form.getInStock());
        component.setPrice(form.getPrice());

        service.update(component);
        return "redirect:/ui/v1/mongoDB/components/";
    }

    @RequestMapping(value = "review/{id}", method = RequestMethod.GET)
    public String reviewComponent(Model model, @PathVariable("id") String id){
        Component component = service.get(id);
        ComponentForm componentForm = new ComponentForm();
        componentForm.setComponentName(component.getComponentName());
        componentForm.setMeasure(component.getMeasure());
        componentForm.setCriticalNorm(component.getCriticalNorm());
        componentForm.setInStock(component.getInStock());
        componentForm.setCreatedAt(component.getCreatedAt());
        componentForm.setUpdatedAt(component.getUpdatedAt());
        componentForm.setPrice(component.getPrice());

        model.addAttribute("form", componentForm);
        return "review/review-component";
    }

    @RequestMapping(value = "needComponent", method = RequestMethod.GET)
    String needComponent(Model model) {
        List<Component> components = service.needComponent();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "needComponent")
    public String searchNeedComponent(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<Component> components = service.sortNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<Component> components = service.sortNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<Component> components = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<Component> components = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<Component> components = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<Component> components = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortMeasureKg", method = RequestMethod.GET)
    String sortMeasureKg(Model model) {
        List<Component> components = service.sortMeasureKg();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortMeasureKg")
    public String searchSortMeasureKg(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortMeasureL", method = RequestMethod.GET)
    String sortMeasureL(Model model) {
        List<Component> components = service.sortMeasureL();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortMeasureL")
    public String searchSortMeasureL(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortMeasureG", method = RequestMethod.GET)
    String sortMeasureG(Model model) {
        List<Component> components = service.sortMeasureG();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortMeasureG")
    public String searchSortMeasureG(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortMeasureMG", method = RequestMethod.GET)
    String sortMeasureMG(Model model) {
        List<Component> components = service.sortMeasureMG();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortMeasureMG")
    public String searchSortMeasureMG(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @RequestMapping(value = "sortMeasureML", method = RequestMethod.GET)
    String sortMeasureML(Model model) {
        List<Component> components = service.sortMeasureML();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

    @PostMapping(value = "sortMeasureML")
    public String searchSortMeasureML(Model model,
                                      @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Component> components = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("components", components);
        return "getAll/components-all";
    }

}
