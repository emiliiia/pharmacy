package com.emilia.pharmacy.repository.sql;
/*
 * Interface IComponentMongoRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.sql.SQLComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IComponentPostgreSQLRepository  extends JpaRepository<SQLComponent, Integer> {
    @Query("SELECT u FROM SQLComponent u WHERE u.measure = 'kg'")
    List<SQLComponent> sortMeasureKg();

    @Query("SELECT u FROM SQLComponent u WHERE u.measure = 'l'")
    List<SQLComponent> sortMeasureL();

    @Query("SELECT u FROM SQLComponent u WHERE u.measure = 'g'")
    List<SQLComponent> sortMeasureG();

    @Query("SELECT u FROM SQLComponent u WHERE u.measure = 'ml'")
    List<SQLComponent> sortMeasureML();

    @Query("SELECT u FROM SQLComponent u WHERE u.measure = 'mg'")
    List<SQLComponent> sortMeasureMG();

    @Query("SELECT u FROM SQLComponent u WHERE u.criticalNorm > u.inStock")
    List<SQLComponent> needComponent();
}
