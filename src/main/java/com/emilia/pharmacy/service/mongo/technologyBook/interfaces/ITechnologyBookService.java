package com.emilia.pharmacy.service.mongo.technologyBook.interfaces;
/*
 * Interface ITechnologyBookService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.mongo.TechnologyBook;

import java.util.List;

public interface ITechnologyBookService {
    TechnologyBook create(TechnologyBook technologyBook);
    TechnologyBook get(String id);
    List<TechnologyBook> getAll();
    TechnologyBook update(TechnologyBook technologyBook);
    void delete(String id);

    List<TechnologyBook> search(String word);
    List<TechnologyBook> sortMethodDISSOLVING();
    List<TechnologyBook> sortMethodSWELLING();
    List<TechnologyBook> sortMethodHEATING();
    List<TechnologyBook> sortMethodDILUTION();
    List<TechnologyBook> sortMethodFILTERING();
    List<TechnologyBook> sortMethodEMULSIFYING();
    List<TechnologyBook> sortMethodDISPERSING();
    List<TechnologyBook> sortMethodMIXING();
    List<TechnologyBook> sortCreatedAtAsce();
    List<TechnologyBook> sortCreatedAtDsce();
    List<TechnologyBook> sortUpdatedAtAsce();
    List<TechnologyBook> sortUpdatedAtDsce();
}
