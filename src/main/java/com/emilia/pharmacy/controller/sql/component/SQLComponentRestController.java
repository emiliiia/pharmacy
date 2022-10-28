package com.emilia.pharmacy.controller.sql.component;
/*
  @author emilia
  @project pharmacy
  @className ComponentRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLComponent;
import com.emilia.pharmacy.service.sql.component.impls.SQLComponentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/components")
public class SQLComponentRestController {

    @Autowired
    SQLComponentServiceImpl service;

    @ApiOperation(value = "Get all components from PostgreSQL", notes = "Output of all objects of the PostgreSQL Components table",
            nickname = "showAllComponents",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLComponent> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one component from PostgreSQL", notes = "Output of certain object of the PostgreSQL Components table",
            nickname = "showOneComponent",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLComponent showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one component in PostgreSQL", notes = "Delete of certain object of the PostgreSQL Components table",
            nickname = "deleteOneComponent",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one component in PostgreSQL", notes = "Create of object of the PostgreSQL Components table",
            nickname = "createOneComponent",
            httpMethod = "POST")
    @PostMapping("/")
    SQLComponent createOne(@RequestBody SQLComponent component) {
        return service.create(component);
    }

    @ApiOperation(value = "Update one component in PostgreSQL", notes = "Update of object of the PostgreSQL Components table",
            nickname = "updateOneComponent",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLComponent updateOne(@RequestBody SQLComponent component) {
        return service.update(component);
    }
}
