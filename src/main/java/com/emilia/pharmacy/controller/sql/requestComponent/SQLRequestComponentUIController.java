package com.emilia.pharmacy.controller.sql.requestComponent;

/*
  @author emilia
  @project pharmacy
  @className RequestComponentUIController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLComponent;
import com.emilia.pharmacy.entity.sql.SQLRequestComponent;
import com.emilia.pharmacy.enums.Status;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLRequestComponentForm;
import com.emilia.pharmacy.repository.sql.IComponentPostgreSQLRepository;
import com.emilia.pharmacy.repository.sql.IRequestComponentPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.component.impls.SQLComponentServiceImpl;
import com.emilia.pharmacy.service.sql.requestComponent.impls.SQLRequestComponentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/postgreeSQL/requestComponents")
public class SQLRequestComponentUIController {

    @Autowired
    SQLRequestComponentServiceImpl service;

    @Autowired
    IRequestComponentPostgreSQLRepository sqlRepository;

    @Autowired
    IComponentPostgreSQLRepository componentPostgreSQLRepository;

    @Autowired
    SQLComponentServiceImpl componentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<SQLRequestComponent> requestComponents = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents",requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }


    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", list);
        return "sqlPages/getAll/requestComponents-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Integer id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/requestComponents/";
    }

    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addRequestComponent(Model model){
        SQLRequestComponentForm requestComponentForm = new SQLRequestComponentForm();
        List<Status> status = Arrays.asList(Status.values());
        Map<Integer, String> componentMap = componentService.getAll().stream()
                .collect(Collectors.toMap(SQLComponent::getId, SQLComponent::getComponentName));

        List<String> componentList = componentService.getAll().stream()
                .map(SQLComponent::getComponentName).collect(Collectors.toList());
        model.addAttribute("form", requestComponentForm);
        model.addAttribute("status", status);
        model.addAttribute("componentMap", componentMap);
        model.addAttribute("componentList", componentList);
        return "sqlPages/add/add-requestComponent";
    }

    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addRequestComponent(Model model, @ModelAttribute("form") SQLRequestComponentForm form){
        SQLRequestComponent requestComponent = new SQLRequestComponent();

        requestComponent.setCreatedAt(LocalDateTime.now());
        requestComponent.setUpdatedAt(LocalDateTime.now());
        requestComponent.setDescription("Request Component");

        SQLComponent component = componentService.getAll().stream()
                .filter(compon->compon.getComponentName().equals(form.getComponentId()))
                .findFirst().orElse(new SQLComponent());
        requestComponent.setComponentId(component);

        requestComponent.setRequestQuantity(form.getRequestQuantity());
        requestComponent.setStatus(Status.INPROGRESS);
        service.create(requestComponent);
        model.addAttribute("requestComponent", service.getAll());
        return "redirect:/ui/v1/postgreeSQL/requestComponents/";
    }


    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateRequestComponent(Model model, @PathVariable("id") Integer id){
        SQLRequestComponent requestComponent = service.get(id);
        List<Status> status = Arrays.asList(Status.values());

        List<String> componentList = componentService.getAll().stream()
                .map(SQLComponent::getComponentName).collect(Collectors.toList());

        SQLRequestComponentForm requestComponentForm = new SQLRequestComponentForm();
        requestComponentForm.setComponentId(requestComponent.getComponentId().getComponentName());
        requestComponentForm.setStatus(requestComponent.getStatus());
        requestComponentForm.setRequestQuantity(requestComponent.getRequestQuantity());

        model.addAttribute("form", requestComponentForm);
        model.addAttribute("componentList", componentList);
        model.addAttribute("status", status);
        return "sqlPages/edit/edit-requestComponent";
    }

    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateRequestComponent(Model model, @PathVariable("id") Integer id,
                                         @ModelAttribute("form") SQLRequestComponentForm form){
        SQLRequestComponent requestComponent = service.get(form.getId());

        SQLComponent component = componentService.getAll().stream()
                .filter(compon->compon.getComponentName().equals(form.getComponentId()))
                .findFirst().orElse(new SQLComponent());
        requestComponent.setComponentId(component);
        requestComponent.setUpdatedAt(LocalDateTime.now());
        requestComponent.setStatus(form.getStatus());
        requestComponent.setRequestQuantity(form.getRequestQuantity());

        service.update(requestComponent);
        model.addAttribute("requestComponent", service.getAll());
        return "redirect:/ui/v1/postgreeSQL/requestComponents/";
    }

    @RequestMapping(value = "editStatusForm/{id}", method = RequestMethod.GET)
    public String updateStatusRequestComponent(Model model, @PathVariable("id") Integer id){
        SQLRequestComponent requestComponent = service.get(id);
        List<Status> status = Arrays.asList(Status.values());

        List<String> componentList = componentService.getAll().stream()
                .map(SQLComponent::getComponentName).collect(Collectors.toList());

        SQLRequestComponentForm requestComponentForm = new SQLRequestComponentForm();
        requestComponentForm.setComponentId(requestComponent.getComponentId().getComponentName());
        requestComponentForm.setStatus(requestComponent.getStatus());
        requestComponentForm.setRequestQuantity(requestComponent.getRequestQuantity());

        model.addAttribute("form", requestComponentForm);
        model.addAttribute("componentList", componentList);
        model.addAttribute("status", status);
        return "sqlPages/edit/edit-statusRequestComponent";
    }

    @RequestMapping(value = "editStatusForm/{id}", method = RequestMethod.POST)
    public String updateStatusRequestComponent(Model model, @PathVariable("id") Integer id,
                                         @ModelAttribute("form") SQLRequestComponentForm form){
        SQLRequestComponent requestComponent = service.get(form.getId());

        SQLComponent component = componentService.getAll().stream()
                .filter(compon->compon.getComponentName().equals(form.getComponentId()))
                .findFirst().orElse(new SQLComponent());
        requestComponent.setComponentId(component);
        requestComponent.setUpdatedAt(LocalDateTime.now());
        requestComponent.setStatus(form.getStatus());
        requestComponent.setRequestQuantity(form.getRequestQuantity());

        service.update(requestComponent);
        model.addAttribute("requestComponent", service.getAll());
        return "redirect:/ui/v1/postgreeSQL/requestComponents/";
    }


    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model){
        List<SQLRequestComponent> list = service.sortByNameAsce();
        model.addAttribute("requestComponents", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.POST)
    public String searchSortNameAsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", list);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model){
        List<SQLRequestComponent> list = service.sortByNameDsce();
        model.addAttribute("requestComponents", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.POST)
    public String searchSortNameDsce(Model model,
                                     @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", list);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<SQLRequestComponent> requestComponents = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<SQLRequestComponent> requestComponents = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }


    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<SQLRequestComponent> requestComponents = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<SQLRequestComponent> requestComponents = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                          @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }


    @RequestMapping(value = "sortStatusInprogress", method = RequestMethod.GET)
    String sortStatusInprogress(Model model) {
        List<SQLRequestComponent> requestComponents = service.sortStatusInprogress();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "sortMeasureKg")
    public String searchSortStatusInprogress(Model model,
                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @RequestMapping(value = "sortStatusGotten", method = RequestMethod.GET)
    String sortStatusGotten(Model model) {
        List<SQLRequestComponent> requestComponents = service.sortStatusGotten();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }

    @PostMapping(value = "sortStatusGotten")
    public String searchSortStatusGotten(Model model,
                                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRequestComponent> requestComponents = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("requestComponents", requestComponents);
        return "sqlPages/getAll/requestComponents-all";
    }
}
