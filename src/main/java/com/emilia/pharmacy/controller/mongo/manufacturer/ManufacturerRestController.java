package com.emilia.pharmacy.controller.mongo.manufacturer;

import com.emilia.pharmacy.entity.mongo.Manufacturer;
import com.emilia.pharmacy.service.mongo.manufacturer.impls.ManufacturerServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerRestController
  @version 1.0.0
  @since 09.08.2022
*/
@RestController
@RequestMapping("/api/v1/mongoDB/manufacturers")
public class ManufacturerRestController {
    @Autowired
    ManufacturerServiceImpl service;

    @ApiOperation(value = "Get all manufacturers from Mongo", notes = "Output of all objects of the Mongo Manufacturers table",
            nickname = "showAllManufacturers",
            httpMethod = "GET")
    @RequestMapping("/")
    List<Manufacturer> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one manufacturer from Mongo", notes = "Output of certain object of the Mongo Manufacturers table",
            nickname = "showOneManufacturer",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    Manufacturer showOne(@PathVariable String id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one manufacturer in Mongo", notes = "Delete of certain object of the Mongo Manufacturers table",
            nickname = "deleteOneManufacturer",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one manufacturer in Mongo", notes = "Create of object of the Mongo Manufacturers table",
            nickname = "createOneManufacturer",
            httpMethod = "POST")
    @PostMapping("/")
    Manufacturer createOne(@RequestBody Manufacturer manufacturer) {
        return service.create(manufacturer);
    }

    @ApiOperation(value = "Update one manufacturer in Mongo", notes = "Update of object of the Mongo Manufacturers table",
            nickname = "updateOneManufacturer",
            httpMethod = "PUT")
    @PutMapping("/")
    Manufacturer updateOne(@RequestBody Manufacturer manufacturer) {
        return service.update(manufacturer);
    }


}
