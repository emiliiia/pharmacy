package com.emilia.pharmacy.service.mongo.client.interfaces;
/*
 * Interface IExtemporalClientService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.mongo.Client;

import java.util.List;

public interface IClientService {
    Client create(Client extemporalClient);
    Client get(String id);
    List<Client> getAll();
    Client update(Client extemporalClient);
    void delete(String id);

    List<Client> sortNameAsce();
    List<Client> sortNameDsce();
    List<Client> sortCreatedAtAsce();
    List<Client> sortCreatedAtDsce();
    List<Client> sortUpdatedAtAsce();
    List<Client> sortUpdatedAtDsce();

    List<Client> search(String word);
}
