package com.emilia.pharmacy.controller.mongo.order;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalOrderRestController
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Order;
import com.emilia.pharmacy.service.mongo.order.impls.OrderServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mongoDB/orders")
public class OrderRestController {
    @Autowired
    OrderServiceImpl service;

    @ApiOperation(value = "Get all orders from Mongo", notes = "Output of all objects of the Mongo Orders table",
            nickname = "showAllOrders",
            httpMethod = "GET")
    @RequestMapping("/")
    List<Order> showAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Get one order from Mongo", notes = "Output of certain object of the Mongo Orders table",
            nickname = "showOneOrder",
            httpMethod = "GET")
    @RequestMapping("/{id}")
    Order showOne(@PathVariable String id) {
        return service.get(id);
    }

    @ApiOperation(value = "Delete one order in Mongo", notes = "Delete of certain object of the Mongo Orders table",
            nickname = "deleteOneOrder",
            httpMethod = "DELETE")
    @DeleteMapping("/{id}")
    void deleteOne(@PathVariable String id) {
        service.delete(id);
    }

    @ApiOperation(value = "Create one order in Mongo", notes = "Create of object of the Mongo Orders table",
            nickname = "createOneOrder",
            httpMethod = "POST")
    @PostMapping("/")
    Order createOne(@RequestBody Order extemporalOrder) {
        return service.create(extemporalOrder);
    }

    @ApiOperation(value = "Update one order in Mongo", notes = "Update of object of the Mongo Orders table",
            nickname = "updateOneOrder",
            httpMethod = "PUT")
    @PutMapping("/")
    Order updateOne(@RequestBody Order extemporalOrder) {
        return service.update(extemporalOrder);
    }

}
