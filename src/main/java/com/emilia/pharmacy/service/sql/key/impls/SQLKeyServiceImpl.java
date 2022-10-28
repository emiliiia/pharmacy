package com.emilia.pharmacy.service.sql.key.impls;

/*
  @author emilia
  @project pharmacy
  @className SQLKeyServiceImpl
  @version 1.0.0
  @since 16.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLKey;
import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import com.emilia.pharmacy.entity.sql.SQLRole;
import com.emilia.pharmacy.entity.sql.SQLTechnologyBook;
import com.emilia.pharmacy.enums.Role;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IKeyPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.key.KeyDetailsPrincipal;
import com.emilia.pharmacy.service.sql.key.interfaces.ISQLKeyService;
import com.emilia.pharmacy.service.sql.role.impls.SQLRoleServiceImpl;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQLKeyServiceImpl implements UserDetailsService, ISQLKeyService {
    @Autowired
    IKeyPostgreSQLRepository keyPostgreSQLRepository;
    @Autowired
    SQLRoleServiceImpl roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SQLKey key = keyPostgreSQLRepository.findByUsername(username);
        KeyDetailsPrincipal keyDetailsPrincipal = new KeyDetailsPrincipal(key);
        return keyDetailsPrincipal;
    }

    public SQLKey create(SQLKey key) {
        //key.setPassword(new BCryptPasswordEncoder().encode(key.getPassword()).toString());
        return keyPostgreSQLRepository.save(key);
    }


    public SQLKey get(int id) {
        return keyPostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found key with id = " + id));
    }

    public SQLKey update(SQLKey key) {
        //key.setPassword(new BCryptPasswordEncoder().encode(key.getPassword()).toString());
        return keyPostgreSQLRepository.save(key);
    }


    public void delete(int id) {
        if (!keyPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found key with id = " + id);
        }
        keyPostgreSQLRepository.deleteById(id);
    }


    public List<SQLKey> getAll() {
        return
                keyPostgreSQLRepository.findAll();
    }

    public void loadingScript(String path) throws Exception{
        DriverManager.registerDriver(new org.postgresql.Driver());
        //Getting the connection
        String url = "jdbc:postgresql://localhost:5432/pharmacy";
        Connection con = DriverManager.getConnection(url, "postgres", "55fm74rml");
        System.out.println("Connection established......");
        //Initialize the script runner
        ScriptRunner sr = new ScriptRunner(con);
        //Creating a reader object
        Reader reader = new BufferedReader(new FileReader(path));
        //Running the script
        sr.runScript(reader);
    }

    public List<SQLKey> search(String word) {
        return this.getAll().stream()
                .filter(key -> key.getUsername().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public SQLKey searchOne(String word) {
        List<SQLKey> keys = this.getAll().stream()
                .filter(key1 -> key1.getUsername().equals(word))
                .collect(Collectors.toList());
        if (keys.isEmpty()){
            SQLKey k = new SQLKey();
            k.setUsername("no matches");
            k.setPassword("no matches");
            k.setRole(roleService.get(4));
            keys.add(k);
            return keys.get(0);
        }
        else {
            return keys.get(0);
        }
    }
}
