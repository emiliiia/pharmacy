package com.emilia.pharmacy.controller.mongo.technologyBook;

/*
  @author emilia
  @project pharmacy
  @className TechnologyBookRestController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.TechnologyBook;
import com.emilia.pharmacy.service.mongo.technologyBook.impls.TechnologyBookServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mongoDB/technologyBook")
public class TechnologyBookRestController {

    @Autowired
    TechnologyBookServiceImpl service;

    @ApiOperation(value = "Get all technologies from Mongo", notes = "Output of all objects of the Mongo TechnologyBook table",
            nickname = "showAllTechnologies",
            httpMethod = "GET")
    @RequestMapping("/")
    List<TechnologyBook> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one technology from Mongo", notes = "Output of certain object of the Mongo TechnologyBook table",
            nickname = "showOneTechnology",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    TechnologyBook showOne(@PathVariable String id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one technology in Mongo", notes = "Delete of certain object of the Mongo TechnologyBook table",
            nickname = "deleteOneTechnology",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one technology in Mongo", notes = "Create of object of the Mongo TechnologyBook table",
            nickname = "createOneTechnology",
            httpMethod = "POST")
    @PostMapping("/")
    TechnologyBook createOne(@RequestBody TechnologyBook technologyBook) {
        return service.create(technologyBook);
    }

    @ApiOperation(value = "Update one technology in Mongo", notes = "Update of object of the Mongo TechnologyBook table",
            nickname = "updateOneTechnology",
            httpMethod = "PUT")
    @PutMapping("/")
    TechnologyBook updateOne(@RequestBody TechnologyBook technologyBook) {
        return service.update(technologyBook);
    }
}
