package com.emilia.pharmacy.repository.sql;

import com.emilia.pharmacy.entity.sql.SQLTechnologyBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITechnologyBookPostgreSQLRepository  extends JpaRepository<SQLTechnologyBook, Integer> {
    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'DISSOLVING'")
    List<SQLTechnologyBook> sortMethodDISSOLVING();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'SWELLING'")
    List<SQLTechnologyBook> sortMethodSWELLING();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'HEATING'")
    List<SQLTechnologyBook> sortMethodHEATING();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'DILUTION'")
    List<SQLTechnologyBook> sortMethodDILUTION();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'FILTERING'")
    List<SQLTechnologyBook> sortMethodFILTERING();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'EMULSIFYING'")
    List<SQLTechnologyBook> sortMethodEMULSIFYING();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'DISPERSING'")
    List<SQLTechnologyBook> sortMethodDISPERSING();

    @Query("SELECT u FROM SQLTechnologyBook u WHERE u.method = 'MIXING'")
    List<SQLTechnologyBook> sortMethodMIXING();
}
