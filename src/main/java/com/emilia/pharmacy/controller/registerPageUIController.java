package com.emilia.pharmacy.controller;

/*
  @author emilia
  @project pharmacy_2
  @className registerPageUIController
  @version 1.0.0
  @since 20.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.form.sqlForms.SQLKeyForm;
import com.emilia.pharmacy.repository.sql.IKeyPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.key.impls.SQLKeyServiceImpl;
import com.emilia.pharmacy.service.sql.role.impls.SQLRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class registerPageUIController {

    @Autowired
    SQLKeyServiceImpl service;

    @Autowired
    SQLRoleServiceImpl roleService;

    @Autowired
    IKeyPostgreSQLRepository sqlRepository;

    @GetMapping(value = "/registration")
    public String addUser(Model model){
        SQLKeyForm keyForm = new SQLKeyForm();

        model.addAttribute("form", keyForm);
        return "register";
    }

    @PostMapping(value = "/registration")
    public String addUser(Model model, @ModelAttribute("form") SQLKeyForm form){
        SQLKey key = new SQLKey();
        key.setUsername(form.getUsername());
        key.setPassword(form.getPassword());
        key.setRole(roleService.get(4));

        if(form.getPassword().equals(form.getConfirmPassword())){
            service.create(key);
            return "redirect:/login";
        }
        else {
            return "redirect:/registration";
        }
    }
}
