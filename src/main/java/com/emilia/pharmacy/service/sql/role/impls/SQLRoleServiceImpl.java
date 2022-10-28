package com.emilia.pharmacy.service.sql.role.impls;

/*
  @author emilia
  @project pharmacy_2
  @className SQLRoleServiceImpl
  @version 1.0.0
  @since 18.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IRolePostgreSQLRepository;
import com.emilia.pharmacy.service.sql.role.interfaces.ISQLRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQLRoleServiceImpl implements ISQLRoleService {

    @Autowired
    IRolePostgreSQLRepository rolePostgreSQLRepository;


    public SQLRole create(SQLRole role) {
        return rolePostgreSQLRepository.save(role);
    }


    public SQLRole get(int id) {
        return rolePostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found role with id = " + id));
    }

    public SQLRole update(SQLRole role) {
        return rolePostgreSQLRepository.save(role);
    }


    public void delete(int id) {
        if (!rolePostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found role with id = " + id);
        }
        rolePostgreSQLRepository.deleteById(id);
    }


    public List<SQLRole> getAll() {
        return
                rolePostgreSQLRepository.findAll();
    }

    public List<SQLRole> search(String word) {
        return this.getAll().stream()
                .filter(role -> role.getRolename().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
