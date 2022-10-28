package com.emilia.pharmacy.service.sql.client.impls;

/*
  @author emilia
  @project pharmacy
  @className ClientServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLClient;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IClientPostgreSQLRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.sql.client.interfaces.ISQLClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQLClientServiceImpl implements ISQLClientService {

    List<SQLClient> list = new ArrayList<>(
            Arrays.asList(
                    new SQLClient(1, LocalDateTime.now(), LocalDateTime.now(), "Client", "Lukash Ivanna", "+380505914658", "ivanna@gmail.com", LocalDate.of(2002, Calendar.MARCH, 14)),
                    new SQLClient(2, LocalDateTime.now(), LocalDateTime.now(), "Client", "Okorokova Anastasia", "+380998664578", "nastka@gmail.com", LocalDate.of(2003, Calendar.FEBRUARY, 1)),
                    new SQLClient(3, LocalDateTime.now(), LocalDateTime.now(), "Client", "Borova Olga", "+38066978423", "borolga@gmail.com", LocalDate.of(1996, Calendar.NOVEMBER, 17)),
                    new SQLClient(4, LocalDateTime.now(), LocalDateTime.now(), "Client", "Telman Anton", "+380508794238", "telman79@gmail.com", LocalDate.of(1979, Calendar.SEPTEMBER, 5)),
                    new SQLClient(5, LocalDateTime.now(), LocalDateTime.now(), "Client", "Gavryluk Ostap", "+38077846538", "onyx@gmail.com", LocalDate.of(1980, Calendar.NOVEMBER, 12)),
                    new SQLClient(6, LocalDateTime.now(), LocalDateTime.now(), "Client", "Aksamitovska Vitalina", "+380505978436", "vitaksa@gmail.com", LocalDate.of(1985, Calendar.SEPTEMBER, 9)),
                    new SQLClient(7, LocalDateTime.now(), LocalDateTime.now(), "Client", "Ariychuk Stepan", "+380667223214", "workstep@gmail.com", LocalDate.of(1996, Calendar.APRIL, 11)),
                    new SQLClient(8, LocalDateTime.now(), LocalDateTime.now(), "Client", "Bodnaruk Oleksiy", "+380998112456", "humolex@gmail.com", LocalDate.of(1990, Calendar.MAY, 15)),
                    new SQLClient(9, LocalDateTime.now(), LocalDateTime.now(), "Client", "Viznuk Vadym", "+38085769988", "viznuk@gmail.com", LocalDate.of(1976, Calendar.JULY, 5)),
                    new SQLClient(10, LocalDateTime.now(), LocalDateTime.now(), "Client", "Sych Danyil", "+38099372133", "sych@gmail.com", LocalDate.of(1988, Calendar.DECEMBER, 21)),
                    new SQLClient(11, LocalDateTime.now(), LocalDateTime.now(), "Client", "Romanchuk Petro", "+38066785498", "romanchpetr@gmail.com", LocalDate.of(1976, Calendar.JUNE, 28)),
                    new SQLClient(12, LocalDateTime.now(), LocalDateTime.now(), "Client", "Maksymuk Oleg", "+380505879812", "olegmax@gmail.com", LocalDate.of(1992, Calendar.FEBRUARY, 25)),
                    new SQLClient(13, LocalDateTime.now(), LocalDateTime.now(), "Client", "Romanuk Roman", "+38066032123", "roman8719@gmail.com", LocalDate.of(1987, Calendar.AUGUST, 16)),
                    new SQLClient(14, LocalDateTime.now(), LocalDateTime.now(), "Client", "Lachen Orest", "+380660213023", "nastka@gmail.com", LocalDate.of(1978, Calendar.FEBRUARY, 8)),
                    new SQLClient(15, LocalDateTime.now(), LocalDateTime.now(), "Client", "Dron Olena", "+3808808785455", "olena@gmail.com", LocalDate.of(1986, Calendar.APRIL, 2)),
                    new SQLClient(16, LocalDateTime.now(), LocalDateTime.now(), "Client", "Yavorska Ludmyla", "+380996336632", "ludmyla@gmail.com", LocalDate.of(1983, Calendar.DECEMBER, 22)),
                    new SQLClient(17, LocalDateTime.now(), LocalDateTime.now(), "Client", "Kyrylenkro Petro", "+380505212322", "petro@gmail.com", LocalDate.of(1979, Calendar.JUNE, 30)),
                    new SQLClient(18, LocalDateTime.now(), LocalDateTime.now(), "Client", "Yaremynko Oksana", "+380665489758", "oxana@gmail.com", LocalDate.of(1986, Calendar.NOVEMBER, 28)),
                    new SQLClient(19, LocalDateTime.now(), LocalDateTime.now(), "Client", "Osatsa Andriy", "+380505458754", "osatsa@gmail.com", LocalDate.of(1994, Calendar.JUNE, 17)),
                    new SQLClient(20, LocalDateTime.now(), LocalDateTime.now(), "Client", "Ratushnyak Inna", "+380325478961", "iinka@gmail.com", LocalDate.of(1987, Calendar.FEBRUARY, 31))
            )
    );

    Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Autowired
    IClientPostgreSQLRepository clientPostgreSQLRepository;
/*
    @PostConstruct
    void init(){
        clientPostgreSQLRepository.saveAll(list);
    }
*/

    public SQLClient create(SQLClient client) {
        logger.info("Entered create() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.save(client);
    }


    public SQLClient get(Integer id) {
        logger.info("Entered get() client method from SQLClientServiceImpl in PostgreSQL part to find client with id = " + id);
        return clientPostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found client with id = " + id));
    }


    public SQLClient update(SQLClient client) {
        logger.info("Entered update() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.save(client);
    }


    public void delete(Integer id){
        logger.info("Entered delete() client method from SQLClientServiceImpl in PostgreSQL part to delete client with id = " + id);
        if (!clientPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found client with id = " + id);
        }
        clientPostgreSQLRepository.deleteById(id);
    }


    public List<SQLClient> getAll() {
        logger.info("Entered getAll() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll();
    }
    public List<SQLClient> sortNameAsce() {
        logger.info("Entered sortNameAsce() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "clientName"));
    }

    public List<SQLClient> sortNameDsce() {
        logger.info("Entered sortNameDsce() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "clientName"));
    }

    public List<SQLClient> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public List<SQLClient> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<SQLClient> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }

    public List<SQLClient> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() client method from SQLClientServiceImpl in PostgreSQL part ");
        return clientPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }

    public List<SQLClient> searchByDB(String word) {
        logger.info("Entered searchByDB() client method from SQLClientServiceImpl in PostgreSQL part to find client with " + word + " name");
        return clientPostgreSQLRepository.searchAllByClientName(word);
    }

    public List<SQLClient> search(String word) {
        logger.info("Entered search() client method from SQLClientServiceImpl in PostgreSQL part to find client with " + word + " name");
        return this.getAll().stream()
                .filter(client -> client.getClientName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
