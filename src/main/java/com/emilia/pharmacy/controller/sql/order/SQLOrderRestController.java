package com.emilia.pharmacy.controller.sql.order;

/*
  @author emilia
  @project pharmacy
  @className OrderRestController
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLOrder;
import com.emilia.pharmacy.service.sql.order.impls.SQLOrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/postgreeSQL/orders")
public class SQLOrderRestController {
    @Autowired
    SQLOrderServiceImpl service;

    @ApiOperation(value = "Get all orders from PostgreSQL", notes = "Output of all objects of the PostgreSQL Orders table",
            nickname = "showAllOrders",
            httpMethod = "GET")
    @RequestMapping("/")
    List<SQLOrder> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one order from PostgreSQL", notes = "Output of certain object of the PostgreSQL Orders table",
            nickname = "showOneOrder",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    SQLOrder showOne(@PathVariable Integer id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one order in PostgreSQL", notes = "Delete of certain object of the PostgreSQL Orders table",
            nickname = "deleteOneOrder",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable Integer id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one order in PostgreSQL", notes = "Create of object of the PostgreSQL Orders table",
            nickname = "createOneOrder",
            httpMethod = "POST")
    @PostMapping("/")
    SQLOrder createOne(@RequestBody SQLOrder order) {
        return service.create(order);
    }

    @ApiOperation(value = "Update one order in PostgreSQL", notes = "Update of object of the PostgreSQL Orders table",
            nickname = "updateOneOrder",
            httpMethod = "PUT")
    @PutMapping("/")
    SQLOrder updateOne(@RequestBody SQLOrder order) {
        return service.update(order);
    }

}
