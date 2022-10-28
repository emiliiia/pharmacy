package com.emilia.pharmacy.controller.mongo.drug;

/*
  @author emilia
  @project pharmacy
  @className DrugRestController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Drug;
import com.emilia.pharmacy.service.mongo.drug.impls.DrugServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mongoDB/drugs")
public class DrugRestController {

    @Autowired
    DrugServiceImpl service;

    @ApiOperation(value = "Get all drugs from Mongo", notes = "Output of all objects of the Mongo Drugs table",
            nickname = "showAllDrugs",
            httpMethod = "GET")
    @RequestMapping("/")
    List<Drug> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one drug from Mongo", notes = "Output of certain object of the Mongo Drugs table",
            nickname = "showOneDrug",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    Drug showOne(@PathVariable String id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one drug in Mongo", notes = "Delete of certain object of the Mongo Drugs table",
            nickname = "deleteOneDrug",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one drug in Mongo", notes = "Create of object of the Mongo Drugs table",
            nickname = "createOneDrug",
            httpMethod = "POST")
    @PostMapping("/")
    Drug createOne(@RequestBody Drug drug) {
        return service.create(drug);
    }

    @ApiOperation(value = "Update one drug in Mongo", notes = "Update of object of the Mongo Drugs table",
            nickname = "updateOneDrug",
            httpMethod = "PUT")
    @PutMapping("/")
    Drug updateOne(@RequestBody Drug drug) {
        return service.update(drug);
    }

}
