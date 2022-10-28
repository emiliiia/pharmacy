package com.emilia.pharmacy.service.mongo.requestComponent.interfaces;
/*
 * Interface IRequestComponentService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.RequestComponent;

import java.util.List;

public interface IRequestComponentService {
    RequestComponent create(RequestComponent requestComponent);
    RequestComponent get(String id);
    List<RequestComponent> getAll();
    RequestComponent update(RequestComponent requestComponent);
    void delete(String id);

    List<RequestComponent> sortCreatedAtAsce();
    List<RequestComponent> sortCreatedAtDsce();
    List<RequestComponent> sortUpdatedAtAsce();
    List<RequestComponent> sortUpdatedAtDsce();
    List<RequestComponent> sortStatusInprogress();
    List<RequestComponent> sortStatusGotten();
}
