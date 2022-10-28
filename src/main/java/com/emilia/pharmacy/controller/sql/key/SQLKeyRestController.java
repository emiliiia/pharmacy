package com.emilia.pharmacy.controller.sql.key;

import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.service.sql.key.impls.SQLKeyServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author emilia
  @project pharmacy
  @className SQLKeyRestController
  @version 1.0.0
  @since 16.08.2022
*/
@RestController
@RequestMapping("/api/v1/postgreeSQL/key")
public class SQLKeyRestController {
    @Autowired
    SQLKeyServiceImpl service;

    @ApiOperation(value = "Get all keys from PosgreSQL", notes = "Output of all objects of the PosgreSQL Keys table",
            nickname = "showAllKeys",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLKey> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one key from PosgreSQL", notes = "Output of certain object of the PosgreSQL Keys table",
            nickname = "showOneKey",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLKey showOne(@PathVariable int id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one key in PosgreSQL", notes = "Delete of certain object of the PosgreSQL Keys table",
            nickname = "deleteOneKey",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable int id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one key in PosgreSQL", notes = "Create of object of the PosgreSQL Keys table",
            nickname = "createOneKey",
            httpMethod = "POST")
    @PostMapping("/")
    SQLKey createOne(@RequestBody SQLKey user) {
        return service.create(user);
    }

    @ApiOperation(value = "Update one key in PosgreSQL", notes = "Update of object of the PosgreSQL Keys table",
            nickname = "updateOneKey",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLKey updateOne(@RequestBody SQLKey user) {
        return service.update(user);
    }
}
