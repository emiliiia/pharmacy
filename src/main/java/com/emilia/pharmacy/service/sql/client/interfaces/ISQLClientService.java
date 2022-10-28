package com.emilia.pharmacy.service.sql.client.interfaces;
/*
 * Interface IExtemporalClientService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.sql.SQLClient;

import java.util.List;

public interface ISQLClientService {
    SQLClient create(SQLClient extemporalClient);
    SQLClient get(Integer id);
    List<SQLClient> getAll();
    SQLClient update(SQLClient extemporalClient);
    void delete(Integer id);

    List<SQLClient> sortNameAsce();
    List<SQLClient> sortNameDsce();
    List<SQLClient> sortCreatedAtAsce();
    List<SQLClient> sortCreatedAtDsce();
    List<SQLClient> sortUpdatedAtAsce();
    List<SQLClient> sortUpdatedAtDsce();

    List<SQLClient> search(String word);
}
