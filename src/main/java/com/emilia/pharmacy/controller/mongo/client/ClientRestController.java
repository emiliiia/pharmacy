package com.emilia.pharmacy.controller.mongo.client;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalClientRestController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Client;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mongoDB/clients")
public class ClientRestController {

    @Autowired
    ClientServiceImpl service;

    @ApiOperation(value = "Get all clients from Mongo", notes = "Output of all objects of the Mongo Clients table",
            nickname = "showAllClients",
            httpMethod = "GET")
    @RequestMapping("/")
    List<Client> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one client from Mongo", notes = "Output of certain object of the Mongo Clients table",
            nickname = "showOneClient",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    Client showOne(@PathVariable String id) {
        return service.get(id);
    }


    @ApiOperation(value = "Delete one client in Mongo", notes = "Delete of certain object of the Mongo Clients table",
            nickname = "deleteOneClient",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }


    @ApiOperation(value = "Create one client in Mongo", notes = "Create of object of the Mongo Clients table",
            nickname = "createOneClient",
            httpMethod = "POST")
    @PostMapping("/")
    Client createOne(@RequestBody Client extemporalClient) {
        return service.create(extemporalClient);
    }


    @ApiOperation(value = "Update one client in Mongo", notes = "Update of object of the Mongo Clients table",
            nickname = "updateOneClient",
            httpMethod = "PUT")
    @PutMapping("/")
    Client updateOne(@RequestBody Client extemporalClient) {
        return service.update(extemporalClient);
    }
}
