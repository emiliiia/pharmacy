package com.emilia.pharmacy.service.mongo.manufacturer.interfaces;
/*
 * Interface IManufacturerService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.Manufacturer;

import java.util.List;

public interface IManufacturerService {
    Manufacturer create(Manufacturer manufacturer);
    Manufacturer get(String id);
    List<Manufacturer> getAll();
    Manufacturer update(Manufacturer manufacturer);
    void delete(String id);

    List<Manufacturer> search(String word);

    List<Manufacturer> sortUpdatedAtDsce();
    List<Manufacturer> sortUpdatedAtAsce();
    List<Manufacturer> sortCreatedAtDsce();
    List<Manufacturer> sortCreatedAtAsce();
    List<Manufacturer> sortManufacturerDsce();
    List<Manufacturer> sortManufacturerAsce();
}
