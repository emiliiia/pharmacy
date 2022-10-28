package com.emilia.pharmacy.service.sql.technologyBook.interfaces;
/*
 * Interface ITechnologyBookService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.sql.SQLTechnologyBook;

import java.util.List;

public interface ISQLTechnologyBookService {
    SQLTechnologyBook create(SQLTechnologyBook technologyBook);
    SQLTechnologyBook get(Integer id);
    List<SQLTechnologyBook> getAll();
    SQLTechnologyBook update(SQLTechnologyBook technologyBook);
    void delete(Integer id);

    List<SQLTechnologyBook> search(String word);
    List<SQLTechnologyBook> sortMethodDISSOLVING();
    List<SQLTechnologyBook> sortMethodSWELLING();
    List<SQLTechnologyBook> sortMethodHEATING();
    List<SQLTechnologyBook> sortMethodDILUTION();
    List<SQLTechnologyBook> sortMethodFILTERING();
    List<SQLTechnologyBook> sortMethodEMULSIFYING();
    List<SQLTechnologyBook> sortMethodDISPERSING();
    List<SQLTechnologyBook> sortMethodMIXING();
    List<SQLTechnologyBook> sortCreatedAtAsce();
    List<SQLTechnologyBook> sortCreatedAtDsce();
    List<SQLTechnologyBook> sortUpdatedAtAsce();
    List<SQLTechnologyBook> sortUpdatedAtDsce();
}
