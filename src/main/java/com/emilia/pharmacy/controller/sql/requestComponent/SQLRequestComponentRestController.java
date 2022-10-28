package com.emilia.pharmacy.controller.sql.requestComponent;

/*
  @author emilia
  @project pharmacy
  @className RequestComponentRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLRequestComponent;
import com.emilia.pharmacy.service.sql.requestComponent.impls.SQLRequestComponentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/requestComponents")
public class SQLRequestComponentRestController {

    @Autowired
    SQLRequestComponentServiceImpl service;

    @ApiOperation(value = "Get all requestComponents from PostgreSQL", notes = "Output of all objects of the PostgreSQL RequestComponents table",
            nickname = "showAllRequestComponents",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLRequestComponent> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one requestComponent from PostgreSQL", notes = "Output of certain object of the PostgreSQL RequestComponents table",
            nickname = "showOneRequestComponent",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLRequestComponent showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one requestComponent in PostgreSQL", notes = "Delete of certain object of the PostgreSQL RequestComponents table",
            nickname = "deleteOneRequestComponent",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one requestComponent in PostgreSQL", notes = "Create of object of the PostgreSQL RequestComponents table",
            nickname = "createOneRequestComponent",
            httpMethod = "POST")
    @PostMapping("/")
    SQLRequestComponent createOne(@RequestBody SQLRequestComponent requestComponent) {
        return service.create(requestComponent);
    }

    @ApiOperation(value = "Update one requestComponent in PostgreSQL", notes = "Update of object of the PostgreSQL RequestComponents table",
            nickname = "updateOneRequestComponent",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLRequestComponent updateOne(@RequestBody SQLRequestComponent requestComponent) {
        return service.update(requestComponent);
    }
}
