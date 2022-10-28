package com.emilia.pharmacy.repository.sql;

import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.entity.sql.SQLRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKeyPostgreSQLRepository extends JpaRepository<SQLKey, Integer> {
    SQLKey findByUsername(String username);
}
