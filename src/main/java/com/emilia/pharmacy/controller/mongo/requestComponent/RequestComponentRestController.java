package com.emilia.pharmacy.controller.mongo.requestComponent;

import com.emilia.pharmacy.entity.mongo.RequestComponent;
import com.emilia.pharmacy.service.mongo.requestComponent.impls.RequestComponentServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
  @author emilia
  @project pharmacy
  @className RequestComponentRestController
  @version 1.0.0
  @since 29.06.2022
*/


@RestController
@RequestMapping("/api/v1/mongoDB/requestComponents")
public class RequestComponentRestController {
    @Autowired
    RequestComponentServiceImpl service;

    @ApiOperation(value = "Get all requestComponents from Mongo", notes = "Output of all objects of the Mongo RequestComponents table",
            nickname = "showAllRequestComponents",
            httpMethod = "GET")
    @RequestMapping("/")
    List<RequestComponent> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one requestComponent from Mongo", notes = "Output of certain object of the Mongo RequestComponents table",
            nickname = "showOneRequestComponent",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    RequestComponent showOne(@PathVariable String id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one requestComponent in Mongo", notes = "Delete of certain object of the Mongo RequestComponents table",
            nickname = "deleteOneRequestComponent",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one requestComponent in Mongo", notes = "Create of object of the Mongo RequestComponents table",
            nickname = "createOneRequestComponent",
            httpMethod = "POST")
    @PostMapping("/")
    RequestComponent createOne(@RequestBody RequestComponent requestComponent) {
        return service.create(requestComponent);
    }

    @ApiOperation(value = "Update one requestComponent in Mongo", notes = "Update of object of the Mongo RequestComponents table",
            nickname = "updateOneRequestComponent",
            httpMethod = "PUT")
    @PutMapping("/")
    RequestComponent updateOne(@RequestBody RequestComponent requestComponent) {
        return service.update(requestComponent);
    }
}
