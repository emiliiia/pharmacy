package com.emilia.pharmacy.repository.sql;

import com.emilia.pharmacy.entity.sql.SQLRequestComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequestComponentPostgreSQLRepository extends JpaRepository<SQLRequestComponent, Integer> {
    @Query("SELECT u FROM SQLRequestComponent u WHERE u.status = 'INPROGRESS'")
    List<SQLRequestComponent> sortStatusInprogress();

    @Query("SELECT u FROM SQLRequestComponent u WHERE u.status = 'GOTTEN'")
    List<SQLRequestComponent> sortStatusGotten();
}
