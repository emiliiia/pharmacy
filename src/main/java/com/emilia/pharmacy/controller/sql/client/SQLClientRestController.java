package com.emilia.pharmacy.controller.sql.client;

/*
  @author emilia
  @project pharmacy
  @className ClientRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLClient;
import com.emilia.pharmacy.service.sql.client.impls.SQLClientServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/clients")
public class SQLClientRestController {

    @Autowired
    SQLClientServiceImpl service;

    @ApiOperation(value = "Get all clients from PosgreSQL", notes = "Output of all objects of the PosgreSQL Clients table",
            nickname = "showAllClients",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLClient> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one client from PosgreSQL", notes = "Output of certain object of the PosgreSQL Clients table",
            nickname = "showOneClient",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLClient showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one client in PosgreSQL", notes = "Delete of certain object of the PosgreSQL Clients table",
            nickname = "deleteOneClient",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one client in PosgreSQL", notes = "Create of object of the PosgreSQL Clients table",
            nickname = "createOneClient",
            httpMethod = "POST")
    @PostMapping("/")
    SQLClient createOne(@RequestBody SQLClient extemporalClient) {
        return service.create(extemporalClient);
    }

    @ApiOperation(value = "Update one client in PosgreSQL", notes = "Update of object of the PosgreSQL Clients table",
            nickname = "updateOneClient",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLClient updateOne(@RequestBody SQLClient extemporalClient) {
        return service.update(extemporalClient);
    }

    @ApiOperation(value = "Get all clients from PosgreSQL by client name",
            notes = "Output of certain object of the PosgreSQL Clients table by common part in the name",
            nickname = "getByClientName",
            httpMethod = "GET")
    @RequestMapping("/search/{str}")
    List<SQLClient> getByClientName(@PathVariable String str) {
        return service.search(str);
    }

    @ApiOperation(value = "Get all clients from PosgreSQL by client name",
            notes = "Output of certain object of the PosgreSQL Clients table by common part in the name",
            nickname = "getByClientName",
            httpMethod = "GET")
    @RequestMapping("/searchByDB/{str}")
    List<SQLClient> searchByDB(@PathVariable String str) {
        return service.searchByDB(str);
    }


}
