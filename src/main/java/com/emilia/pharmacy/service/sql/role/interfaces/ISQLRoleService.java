package com.emilia.pharmacy.service.sql.role.interfaces;

import com.emilia.pharmacy.entity.sql.SQLRole;

import java.util.List;

public interface ISQLRoleService {
    SQLRole create(SQLRole role);
    SQLRole get(int id);
    SQLRole update(SQLRole role);
    void delete(int id);
    List<SQLRole> getAll();
    List<SQLRole> search(String word);
}
