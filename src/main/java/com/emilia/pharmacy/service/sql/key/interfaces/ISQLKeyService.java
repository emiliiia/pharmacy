package com.emilia.pharmacy.service.sql.key.interfaces;

import com.emilia.pharmacy.entity.sql.SQLKey;

import java.util.List;

public interface ISQLKeyService {
    SQLKey create(SQLKey user);
    SQLKey get(int id);
    List<SQLKey> getAll();
    SQLKey update(SQLKey user);
    void delete(int id);

    List<SQLKey> search(String word);
}
