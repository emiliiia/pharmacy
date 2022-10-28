package com.emilia.pharmacy.controller.sql.drug;

/*
  @author emilia
  @project pharmacy
  @className DrugRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLDrug;
import com.emilia.pharmacy.service.sql.drug.impls.SQLDrugServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/drugs")
public class SQLDrugRestController {
    @Autowired
    SQLDrugServiceImpl service;

    @ApiOperation(value = "Get all drugs from PosgreSQL", notes = "Output of all objects of the PosgreSQL Drugs table",
            nickname = "showAllDrugs",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLDrug> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one drug from PosgreSQL", notes = "Output of certain object of the PosgreSQL Drugs table",
            nickname = "showOneDrug",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLDrug showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one drug in PosgreSQL", notes = "Delete of certain object of the PosgreSQL Drugs table",
            nickname = "deleteOneDrug",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one drug in PosgreSQL", notes = "Create of object of the PosgreSQL Drugs table",
            nickname = "createOneDrug",
            httpMethod = "POST")
    @PostMapping("/")
    SQLDrug createOne(@RequestBody SQLDrug drug) {
        return service.create(drug);
    }

    @ApiOperation(value = "Update one drug in PosgreSQL", notes = "Update of object of the PosgreSQL Drugs table",
            nickname = "updateOneDrug",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLDrug updateOne(@RequestBody SQLDrug drug) {
        return service.update(drug);
    }

}
