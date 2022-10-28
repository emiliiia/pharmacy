package com.emilia.pharmacy.controller.sql.manufacturer;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import com.emilia.pharmacy.service.sql.manufacturer.impls.SQLManufacturerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/manufacturers")
public class SQLManufacturerRestController {
    @Autowired
    SQLManufacturerServiceImpl service;

    @ApiOperation(value = "Get all manufacturers from PosgreSQL", notes = "Output of all objects of the PosgreSQL Manufacturers table",
            nickname = "showAllManufacturers",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLManufacturer> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one manufacturer from PosgreSQL", notes = "Output of certain object of the PosgreSQL Manufacturers table",
            nickname = "showOneManufacturer",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLManufacturer showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one manufacturer in PosgreSQL", notes = "Delete of certain object of the PosgreSQL Manufacturers table",
            nickname = "deleteOneManufacturer",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one manufacturer in PosgreSQL", notes = "Create of object of the PosgreSQL Manufacturers table",
            nickname = "createOneManufacturer",
            httpMethod = "POST")
    @PostMapping("/")
    SQLManufacturer createOne(@RequestBody SQLManufacturer manufacturer) {
        return service.create(manufacturer);
    }

    @ApiOperation(value = "Update one manufacturer in PosgreSQL", notes = "Update of object of the PosgreSQL Manufacturers table",
            nickname = "updateOneManufacturer",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLManufacturer updateOne(@RequestBody SQLManufacturer manufacturer) {
        return service.update(manufacturer);
    }
}
