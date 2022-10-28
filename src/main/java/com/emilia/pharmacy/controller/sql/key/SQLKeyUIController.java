package com.emilia.pharmacy.controller.sql.key;

/*
  @author emilia
  @project pharmacy
  @className SQLKeyUIController
  @version 1.0.0
  @since 16.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLComponent;
import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.form.SearchForm;
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
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/ui/v1/postgreeSQL/key")
public class SQLKeyUIController {
    @Autowired
    SQLKeyServiceImpl service;

    @Autowired
    SQLRoleServiceImpl roleService;

    @Autowired
    IKeyPostgreSQLRepository sqlRepository;

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "/", method = RequestMethod.GET)
    String showAll(Model model) {
        List<SQLKey> keys = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("keys", keys);
        return "sqlPages/keys/keys-all";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @PostMapping(value = "/")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<SQLKey> keys = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("keys", keys);
        return "sqlPages/keys/keys-all";
    }

    @Secured({"ROLE_OWNER"})
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        service.delete(id);
        return "redirect:/ui/v1/postgreeSQL/key/";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "createOwnerForm", method = RequestMethod.GET)
    public String addOwner(Model model){
        SQLKeyForm keyForm = new SQLKeyForm();

        model.addAttribute("form", keyForm);
        return "sqlPages/keys/add-ownerKey";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "endCreateOwnerForm", method = RequestMethod.POST)
    public String addOwner(@ModelAttribute("form") SQLKeyForm form){
        SQLKey key = new SQLKey();

        key.setUsername(form.getUsername());
        key.setPassword(form.getPassword());
        key.setRole(roleService.get(1));

        service.create(key);
        return "redirect:/ui/v1/postgreeSQL/key/";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "createAdminForm", method = RequestMethod.GET)
    public String addAdmin(Model model){
        SQLKeyForm keyForm = new SQLKeyForm();
        List<SQLRole> roles = roleService.getAll();

        model.addAttribute("form", keyForm);
        model.addAttribute("roles", roles);
        return "sqlPages/keys/add-adminKey";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "endCreateAdminForm", method = RequestMethod.POST)
    public String addAdmin(@ModelAttribute("form") SQLKeyForm form){
        SQLKey key = new SQLKey();

        key.setUsername(form.getUsername());
        key.setPassword(form.getPassword());
        key.setRole(roleService.get(2));

        service.create(key);
        return "redirect:/ui/v1/postgreeSQL/key/";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "createOperatorForm", method = RequestMethod.GET)
    public String addOperator(Model model){
        SQLKeyForm keyForm = new SQLKeyForm();
        List<SQLRole> roles = roleService.getAll();

        model.addAttribute("form", keyForm);
        model.addAttribute("roles", roles);
        return "sqlPages/keys/add-operatorKey";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "endCreateOperatorForm", method = RequestMethod.POST)
    public String addOperator(@ModelAttribute("form") SQLKeyForm form){
        SQLKey key = new SQLKey();

        key.setUsername(form.getUsername());
        key.setPassword(form.getPassword());
        key.setRole(roleService.get(3));

        service.create(key);
        return "redirect:/ui/v1/postgreeSQL/key/";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "createUserForm", method = RequestMethod.GET)
    public String addUser(Model model){
        SQLKeyForm keyForm = new SQLKeyForm();
        List<SQLRole> roles = roleService.getAll();

        model.addAttribute("form", keyForm);
        model.addAttribute("roles", roles);
        return "sqlPages/keys/add-userKey";
    }

    @Secured({"ROLE_OWNER", "ROLE_ADMIN"})
    @RequestMapping(value = "endCreateUserForm", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("form") SQLKeyForm form){
        SQLKey key = new SQLKey();

        key.setUsername(form.getUsername());
        key.setPassword(form.getPassword());
        key.setRole(roleService.get(4));

        service.create(key);
        return "redirect:/ui/v1/postgreeSQL/key/";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "editForm/{id}", method = RequestMethod.GET)
    public String updateKey(Model model, @PathVariable("id") Integer id){
        SQLKey key = service.get(id);
        Map<Integer, String> roleMap = roleService.getAll().stream()
                .collect(Collectors.toMap(SQLRole::getId, SQLRole::getRolename));

        List<String> roleList = roleService.getAll().stream()
                .map(SQLRole::getRolename).collect(Collectors.toList());
        SQLKeyForm keyForm = new SQLKeyForm();
        keyForm.setUsername(key.getUsername());
        keyForm.setPassword(key.getPassword());
        keyForm.setRole(key.getRole().toString());

        model.addAttribute("form", keyForm);
        model.addAttribute("roleMap", roleMap);
        model.addAttribute("roles", roleList);
        return "sqlPages/keys/edit-key";
    }

    @Secured({"ROLE_OWNER"})
    @RequestMapping(value = "editForm/{id}", method = RequestMethod.POST)
    public String updateKey(@PathVariable("id") Integer id,
                                   @ModelAttribute("form") SQLKeyForm form){
        SQLKey key = service.get(form.getId());

            key.setUsername(form.getUsername());
            key.setPassword(form.getPassword());
            SQLRole role = roleService.getAll().stream()
                .filter(role1->role1.getRolename().equals(form.getRole()))
                .findFirst().orElse(new SQLRole());
            key.setRole(role);
            service.update(key);
            return "redirect:/ui/v1/postgreeSQL/key/";

    }
}
