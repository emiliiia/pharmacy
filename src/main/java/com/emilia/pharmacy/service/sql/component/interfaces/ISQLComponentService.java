package com.emilia.pharmacy.service.sql.component.interfaces;
/*
 * Interface IComponentService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.sql.SQLComponent;

import java.util.List;

public interface ISQLComponentService {
    SQLComponent create(SQLComponent component);
    SQLComponent get(Integer id);
    List<SQLComponent> getAll();
    SQLComponent update(SQLComponent component);
    void delete(Integer id);


    List<SQLComponent> search(String word);
    List<SQLComponent> needComponent();
    List<SQLComponent> sortNameAsce();
    List<SQLComponent> sortNameDsce();
    List<SQLComponent> sortCreatedAtAsce();
    List<SQLComponent> sortCreatedAtDsce();
    List<SQLComponent> sortUpdatedAtAsce();
    List<SQLComponent> sortUpdatedAtDsce();
    List<SQLComponent> sortMeasureKg();
    List<SQLComponent> sortMeasureL();
    List<SQLComponent> sortMeasureMG();
    List<SQLComponent> sortMeasureML();
    List<SQLComponent> sortMeasureG();
}
