package com.emilia.pharmacy.repository.sql;

import com.emilia.pharmacy.entity.sql.SQLClient;
import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.entity.sql.SQLOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IClientPostgreSQLRepository extends JpaRepository<SQLClient, Integer> {
    @Query("SELECT u FROM SQLClient u WHERE u.clientName = ?1")
    List<SQLClient> searchAllByClientName(String name);
}
