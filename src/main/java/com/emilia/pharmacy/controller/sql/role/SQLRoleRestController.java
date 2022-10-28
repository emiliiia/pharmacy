package com.emilia.pharmacy.controller.sql.role;

/*
  @author emilia
  @project pharmacy_2
  @className SQLRoleRestController
  @version 1.0.0
  @since 18.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.service.sql.key.impls.SQLKeyServiceImpl;
import com.emilia.pharmacy.service.sql.role.impls.SQLRoleServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/role")
public class SQLRoleRestController {
    @Autowired
    SQLRoleServiceImpl service;

    @ApiOperation(value = "Get all roles from PostgreSQL", notes = "Output of all objects of the PostgreSQL Roles table",
            nickname = "showAllRoles",
            httpMethod = "GET")
    @Secured({"ROLE_OWNER"})
    @RequestMapping("/")
    List<SQLRole> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one role from PostgreSQL", notes = "Output of certain object of the PostgreSQL Roles table",
            nickname = "showOneRole",
            httpMethod = "GET")
    @Secured({"ROLE_OWNER"})
    @RequestMapping("/{id}")
    SQLRole showOne(@PathVariable int id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one role in PostgreSQL", notes = "Delete of certain object of the PostgreSQL Roles table",
            nickname = "deleteOneRole",
            httpMethod = "DELETE")
    @Secured({"ROLE_OWNER"})
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable int id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one role in PostgreSQL", notes = "Create of object of the PostgreSQL Roles table",
            nickname = "createOneRole",
            httpMethod = "POST")
    @Secured({"ROLE_OWNER"})
    @PostMapping("/")
    SQLRole createOne(@RequestBody SQLRole role) {
        return service.create(role);
    }

    @ApiOperation(value = "Update one role in PostgreSQL", notes = "Update of object of the PostgreSQL Roles table",
            nickname = "updateOneRole",
            httpMethod = "PUT")
    @Secured({"ROLE_OWNER"})
    @PutMapping("/")
    SQLRole updateOne(@RequestBody SQLRole role) {
        return service.update(role);
    }
}
