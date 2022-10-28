package com.emilia.pharmacy.controller.mongo.drug;

/*
  @author emilia
  @project pharmacy
  @className DrugUIController
  @version 1.0.0
  @since 10.08.2022
*/

import com.emilia.pharmacy.entity.mongo.Drug;
import com.emilia.pharmacy.entity.mongo.Order;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.repository.mongo.IDrugMongoRepository;
import com.emilia.pharmacy.service.mongo.component.impls.ComponentServiceImpl;
import com.emilia.pharmacy.service.mongo.drug.impls.DrugServiceImpl;
import com.emilia.pharmacy.service.mongo.technologyBook.impls.TechnologyBookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/v1/mongoDB/drugs")
public class DrugUIController {

    @Autowired
    DrugServiceImpl service;
    @Autowired
    TechnologyBookServiceImpl technologyBookService;
    @Autowired
    ComponentServiceImpl componentService;

    @Autowired
    IDrugMongoRepository mongoRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<Drug> drugs = service.getAll();
        SearchForm searchForm = new SearchForm();

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());

        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);

        return "getAll/drugs-all";
    }

    @RequestMapping(value = "/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> list = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", list);
        return "getAll/drugs-all";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/v1/mongoDB/drugs/";
    }

    @RequestMapping(value = "sortNameAsce", method = RequestMethod.GET)
    String sortNameAsce(Model model) {
        List<Drug> drugs = service.sortNameAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortNameAsce")
    public String searchSortNameAsce(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortNameDsce", method = RequestMethod.GET)
    String sortNameDsce(Model model) {
        List<Drug> drugs = service.sortNameDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortNameDsce")
    public String searchSortNameDsce(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortCreatedAtAsce", method = RequestMethod.GET)
    String sortCreatedAtAsce(Model model) {
        List<Drug> drugs = service.sortCreatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortCreatedAtAsce")
    public String searchSortCreatedAtAsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortCreatedAtDsce", method = RequestMethod.GET)
    String sortCreatedAtDsce(Model model) {
        List<Drug> drugs = service.sortCreatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortCreatedAtDsce")
    public String searchSortCreatedAtDsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortUpdatedAtAsce", method = RequestMethod.GET)
    String sortUpdatedAtAsce(Model model) {
        List<Drug> drugs = service.sortUpdatedAtAsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortUpdatedAtAsce")
    public String searchSortUpdatedAtAsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortUpdatedAtDsce", method = RequestMethod.GET)
    String sortUpdatedAtDsce(Model model) {
        List<Drug> drugs = service.sortUpdatedAtDsce();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortUpdatedAtDsce")
    public String searchSortUpdatedAtDsce(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.getAll());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortUseExternal", method = RequestMethod.GET)
    String sortUseExternal(Model model) {
        List<Drug> drugs = service.sortUseExternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortUseExternal")
    public String searchSortUseExternal(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortUseExternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortUseInternal", method = RequestMethod.GET)
    String sortUseInternal(Model model) {
        List<Drug> drugs = service.sortUseInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortUseInternal")
    public String searchSortUseInternal(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortUseInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortUseExInternal", method = RequestMethod.GET)
    String sortUseExInternal(Model model) {
        List<Drug> drugs = service.sortUseExInternal();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortUseExInternal")
    public String searchSortUseExInternal(Model model,
                                                    @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortUseExInternal());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortUseMix", method = RequestMethod.GET)
    String sortUseMix(Model model) {
        List<Drug> drugs = service.sortUseMix();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortUseMix")
    public String searchSortUseMix(Model model,
                                             @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortUseMix());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortFormTablets", method = RequestMethod.GET)
    String sortFormTablets(Model model) {
        List<Drug> drugs = service.sortFormTablets();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortFormTablets")
    public String searchSortFormTablets(Model model,
                                                  @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortFormTablets());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortFormOintment", method = RequestMethod.GET)
    String sortFormOintment(Model model) {
        List<Drug> drugs = service.sortFormOintment();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortFormOintment")
    public String searchSortFormOintment(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortFormOintment());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortFormPotion", method = RequestMethod.GET)
    String sortFormPotion(Model model) {
        List<Drug> drugs = service.sortFormPotion();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortFormPotion")
    public String searchSortFormPotion(Model model,
                                                 @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortFormPotion());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortFormAQUA", method = RequestMethod.GET)
    String sortFormAQUA(Model model) {
        List<Drug> drugs = service.sortFormAQUA();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortFormAQUA")
    public String searchSortFormAQUA(Model model,
                                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortFormAQUA());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortFormFlour", method = RequestMethod.GET)
    String sortFormFlour(Model model) {
        List<Drug> drugs = service.sortFormFlour();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortFormFlour")
    public String searchSortFormFlour(Model model,
                                                @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortFormFlour());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @RequestMapping(value = "sortFormTincture", method = RequestMethod.GET)
    String sortFormTincture(Model model) {
        List<Drug> drugs = service.sortFormTincture();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }

    @PostMapping(value = "sortFormTincture")
    public String searchSortFormTincture(Model model,
                                                   @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Drug> drugs = service.search(word, service.sortFormTincture());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("drugs", drugs);
        return "getAll/drugs-all";
    }


}
