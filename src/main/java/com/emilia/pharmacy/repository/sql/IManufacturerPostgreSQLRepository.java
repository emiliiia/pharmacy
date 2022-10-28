package com.emilia.pharmacy.repository.sql;


import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManufacturerPostgreSQLRepository extends JpaRepository<SQLManufacturer, Integer> {
}
