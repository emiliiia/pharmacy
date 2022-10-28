package com.emilia.pharmacy.controller.sql.technologyBook;

/*
  @author emilia
  @project pharmacy
  @className TechnologyBookRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLTechnologyBook;
import com.emilia.pharmacy.service.sql.technologyBook.impls.SQLTechnologyBookServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/technologyBook")
public class SQLTechnologyBookRestController {
    @Autowired
    SQLTechnologyBookServiceImpl service;

    @ApiOperation(value = "Get all technologies from PostgreSQL", notes = "Output of all objects of the PostgreSQL TechnologyBook table",
            nickname = "showAllTechnologies",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLTechnologyBook> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one technology from PostgreSQL", notes = "Output of certain object of the PostgreSQL TechnologyBook table",
            nickname = "showOneTechnology",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLTechnologyBook showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one technology in PostgreSQL", notes = "Delete of certain object of the PostgreSQL TechnologyBook table",
            nickname = "deleteOneTechnology",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one technology in PostgreSQL", notes = "Create of object of the PostgreSQL TechnologyBook table",
            nickname = "createOneTechnology",
            httpMethod = "POST")
    @PostMapping("/")
    SQLTechnologyBook createOne(@RequestBody SQLTechnologyBook technologyBook) {
        return service.create(technologyBook);
    }

    @ApiOperation(value = "Update one technology in PostgreSQL", notes = "Update of object of the PostgreSQL TechnologyBook table",
            nickname = "updateOneTechnology",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLTechnologyBook updateOne(@RequestBody SQLTechnologyBook technologyBook) {
        return service.update(technologyBook);
    }
}
