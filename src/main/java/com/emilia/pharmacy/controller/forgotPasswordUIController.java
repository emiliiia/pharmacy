package com.emilia.pharmacy.controller;

/*
  @author emilia
  @project pharmacy_2
  @className forgotPasswordUIController
  @version 1.0.0
  @since 20.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLKeyForm;
import com.emilia.pharmacy.repository.sql.IKeyPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.key.impls.SQLKeyServiceImpl;
import com.emilia.pharmacy.service.sql.role.impls.SQLRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class forgotPasswordUIController {

    @Autowired
    SQLKeyServiceImpl service;

    @Autowired
    SQLRoleServiceImpl roleService;

    @Autowired
    IKeyPostgreSQLRepository sqlRepository;

    @GetMapping(value = "/forgotPassword")
    public String show(Model model){
        List<SQLKey> keys = new ArrayList<>();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("keys", keys);
        return "forgotPassword";
    }

    @PostMapping(value = "/forgotPassword")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLKey> keys = new ArrayList<>();
        keys.add(service.searchOne(word));
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("keys", keys);
        return "forgotPassword";

    }
}
