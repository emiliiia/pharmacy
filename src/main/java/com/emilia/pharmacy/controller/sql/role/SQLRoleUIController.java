package com.emilia.pharmacy.controller.sql.role;

import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.form.SearchForm;
import com.emilia.pharmacy.form.sqlForms.SQLRoleForm;
import com.emilia.pharmacy.repository.sql.IRolePostgreSQLRepository;
import com.emilia.pharmacy.service.sql.role.impls.SQLRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author emilia
  @project pharmacy_2
  @className SQLRoleUIController
  @version 1.0.0
  @since 18.08.2022
*/

@Controller
@RequestMapping("/ui/v1/postgreeSQL/role")
public class SQLRoleUIController {
    @Autowired
    SQLRoleServiceImpl service;

    @Autowired
    IRolePostgreSQLRepository sqlRepository;

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<SQLRole> roles = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("roles", roles);
        return "sqlPages/roles/roles-all";
    }

    @Secured({"ROLE_OWNER"})
    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLRole> roles = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("roles", roles);
        return "sqlPages/roles/roles-all";
    }

    @Secured({"ROLE_OWNER"})
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/role/";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "createForm", method = RequestMethod.GET)
    public String addKey(Model model){
        SQLRoleForm roleForm = new SQLRoleForm();

        model.addAttribute("form", roleForm);
        return "sqlPages/roles/add-role";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "endCreateForm", method = RequestMethod.POST)
    public String addKey(@ModelAttribute("form") SQLRoleForm form){
        SQLRole role = new SQLRole();

        role.setRolename(form.getRolename());

        service.create(role);
        return "redirect:/ui/v1/postgreeSQL/role/";


    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateKey(Model model, @PathVariable("id") int id){
        SQLRole role = service.get(id);
        SQLRoleForm roleForm = new SQLRoleForm();
        roleForm.setRolename(role.getRolename());

        model.addAttribute("form", roleForm);
        return "sqlPages/roles/edit-role";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateKey(@PathVariable("id") int id,
                            @ModelAttribute("form") SQLRoleForm form){
        SQLRole role = service.get(form.getId());

        role.setRolename(form.getRolename());
        service.update(role);
        return "redirect:/ui/v1/postgreeSQL/role/";

    }
}
