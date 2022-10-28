package com.emilia.pharmacy.controller.mongo.component;
/*
  @author emilia
  @project pharmacy
  @className ComponentRestController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.service.mongo.component.impls.ComponentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:8082")
@RequestMapping("/api/v1/mongoDB/components")
public class ComponentRestController {

    @Autowired
    ComponentServiceImpl service;

    @ApiOperation(value = "Get all components from Mongo", notes = "Output of all objects of the Mongo Components table",
            nickname = "showAllComponents",
            httpMethod = "GET")
    @RequestMapping("/")
    List<Component> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one component from Mongo", notes = "Output of certain object of the Mongo Components table",
            nickname = "showOneComponent",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    Component showOne(@PathVariable String id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one component in Mongo", notes = "Delete of certain object of the Mongo Components table",
            nickname = "deleteOneComponent",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one component in Mongo", notes = "Create of object of the Mongo Components table",
            nickname = "createOneComponent",
            httpMethod = "POST")
    @PostMapping("/")
    Component createOne(@RequestBody Component component) {
        return service.create(component);
    }

    @ApiOperation(value = "Update one component in Mongo", notes = "Update of object of the Mongo Components table",
            nickname = "updateOneComponent",
            httpMethod = "PUT")
    @PutMapping("/")
    Component updateOne(@RequestBody Component component) {
        return service.update(component);
    }
}
