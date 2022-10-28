package com.emilia.pharmacy.service.sql.manufacturer.interfaces;

/*
 * Interface IManufacturerService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.sql.SQLManufacturer;

import java.util.List;

public interface ISQLManufacturerService {
    SQLManufacturer create(SQLManufacturer manufacturer);
    SQLManufacturer get(Integer id);
    List<SQLManufacturer> getAll();
    SQLManufacturer update(SQLManufacturer manufacturer);
    void delete(Integer id);

    List<SQLManufacturer> search(String word);

    List<SQLManufacturer> sortManufacturerAsce();
    List<SQLManufacturer> sortManufacturerDsce();
    List<SQLManufacturer> sortCreatedAtAsce();
    List<SQLManufacturer> sortCreatedAtDsce();
    List<SQLManufacturer> sortUpdatedAtAsce();
    List<SQLManufacturer> sortUpdatedAtDsce();

}
