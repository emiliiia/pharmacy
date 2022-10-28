package com.emilia.pharmacy.service.mongo.component.interfaces;
/*
 * Interface IComponentService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.Component;

import java.util.List;

public interface IComponentService {
    Component create(Component component);
    Component get(String id);
    List<Component> getAll();
    Component update(Component component);
    void delete(String id);


    List<Component> search(String word);
    List<Component> needComponent();
    List<Component> sortNameAsce();
    List<Component> sortNameDsce();
    List<Component> sortCreatedAtAsce();
    List<Component> sortCreatedAtDsce();
    List<Component> sortUpdatedAtAsce();
    List<Component> sortUpdatedAtDsce();
    List<Component> sortMeasureKg();
    List<Component> sortMeasureL();
    List<Component> sortMeasureMG();
    List<Component> sortMeasureML();
    List<Component> sortMeasureG();
}
