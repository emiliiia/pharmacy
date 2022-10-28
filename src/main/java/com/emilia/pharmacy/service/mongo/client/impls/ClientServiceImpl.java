package com.emilia.pharmacy.service.mongo.client.impls;


import com.emilia.pharmacy.annotation.CustomAnnotation;
import com.emilia.pharmacy.entity.mongo.Client;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.IClientMongoRepository;
import com.emilia.pharmacy.service.mongo.client.interfaces.IClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalClientServiceImp
  @version 1.0.0
  @since 29.06.2022
*/
@Service
public class ClientServiceImpl implements IClientService {

    List<Client> list = new ArrayList<>(
            Arrays.asList(
                    new Client("1", LocalDateTime.now(), LocalDateTime.now(), "Client", "Lukash Ivanna", "+380505914658", "ivanna@gmail.com", LocalDate.of(2002, Calendar.MARCH, 14)),
                    new Client("2", LocalDateTime.now(), LocalDateTime.now(), "Client", "Okorokova Anastasia", "+380998664578", "nastka@gmail.com", LocalDate.of(2003, Calendar.FEBRUARY, 1)),
                    new Client("3", LocalDateTime.now(), LocalDateTime.now(), "Client", "Borova Olga", "+38066978423", "borolga@gmail.com", LocalDate.of(1996, Calendar.NOVEMBER, 17)),
                    new Client("4", LocalDateTime.now(), LocalDateTime.now(), "Client", "Telman Anton", "+380508794238", "telman79@gmail.com", LocalDate.of(1979, Calendar.SEPTEMBER, 5)),
                    new Client("5", LocalDateTime.now(), LocalDateTime.now(), "Client", "Gavryluk Ostap", "+38077846538", "onyx@gmail.com", LocalDate.of(1980, Calendar.NOVEMBER, 12)),
                    new Client("6", LocalDateTime.now(), LocalDateTime.now(), "Client", "Aksamitovska Vitalina", "+380505978436", "vitaksa@gmail.com", LocalDate.of(1985, Calendar.SEPTEMBER, 9)),
                    new Client("7", LocalDateTime.now(), LocalDateTime.now(), "Client", "Ariychuk Stepan", "+380667223214", "workstep@gmail.com", LocalDate.of(1996, Calendar.APRIL, 11)),
                    new Client("8", LocalDateTime.now(), LocalDateTime.now(), "Client", "Bodnaruk Oleksiy", "+380998112456", "humolex@gmail.com", LocalDate.of(1990, Calendar.MAY, 15)),
                    new Client("9", LocalDateTime.now(), LocalDateTime.now(), "Client", "Viznuk Vadym", "+38085769988", "viznuk@gmail.com", LocalDate.of(1976, Calendar.JULY, 5)),
                    new Client("10", LocalDateTime.now(), LocalDateTime.now(), "Client", "Sych Danyil", "+38099372133", "sych@gmail.com", LocalDate.of(1988, Calendar.DECEMBER, 21)),
                    new Client("11", LocalDateTime.now(), LocalDateTime.now(), "Client", "Romanchuk Petro", "+38066785498", "romanchpetr@gmail.com", LocalDate.of(1976, Calendar.JUNE, 28)),
                    new Client("12", LocalDateTime.now(), LocalDateTime.now(), "Client", "Maksymuk Oleg", "+380505879812", "olegmax@gmail.com", LocalDate.of(1992, Calendar.FEBRUARY, 25)),
                    new Client("13", LocalDateTime.now(), LocalDateTime.now(), "Client", "Romanuk Roman", "+38066032123", "roman8719@gmail.com", LocalDate.of(1987, Calendar.AUGUST, 16)),
                    new Client("14", LocalDateTime.now(), LocalDateTime.now(), "Client", "Lachen Orest", "+380660213023", "nastka@gmail.com", LocalDate.of(1978, Calendar.FEBRUARY, 8)),
                    new Client("15", LocalDateTime.now(), LocalDateTime.now(), "Client", "Dron Olena", "+3808808785455", "olena@gmail.com", LocalDate.of(1986, Calendar.APRIL, 2)),
                    new Client("16", LocalDateTime.now(), LocalDateTime.now(), "Client", "Yavorska Ludmyla", "+380996336632", "ludmyla@gmail.com", LocalDate.of(1983, Calendar.DECEMBER, 22)),
                    new Client("17", LocalDateTime.now(), LocalDateTime.now(), "Client", "Kyrylenkro Petro", "+380505212322", "petro@gmail.com", LocalDate.of(1979, Calendar.JUNE, 30)),
                    new Client("18", LocalDateTime.now(), LocalDateTime.now(), "Client", "Yaremynko Oksana", "+380665489758", "oxana@gmail.com", LocalDate.of(1986, Calendar.NOVEMBER, 28)),
                    new Client("19", LocalDateTime.now(), LocalDateTime.now(), "Client", "Osatsa Andriy", "+380505458754", "osatsa@gmail.com", LocalDate.of(1994, Calendar.JUNE, 17)),
                    new Client("20", LocalDateTime.now(), LocalDateTime.now(), "Client", "Ratushnyak Inna", "+380325478961", "iinka@gmail.com", LocalDate.of(1987, Calendar.FEBRUARY, 31))
            )
    );

    Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    IClientMongoRepository clientMongoRepository;
/*
    @PostConstruct
    void init(){
        extemporalClientMongoRepository.saveAll(list);
    }
*/

    @CustomAnnotation
    public Client create(Client client) {
        logger.info("Entered create() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.save(client);
    }

    @CustomAnnotation
    public Client get(String id) {
        logger.info("Entered get() client method from ClientServiceImpl in MongoDB part to find client with id = " + id);
        return clientMongoRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found client with id = " + id));
    }

    @CustomAnnotation
    public Client update(Client client) {
        logger.info("Entered update() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.save(client);
    }

    @CustomAnnotation
    public void delete(String id) {
        logger.info("Entered delete() client method from ClientServiceImpl in MongoDB part to delete client with id = " + id);
        if (!clientMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found client with id = " + id);
        }
        clientMongoRepository.deleteById(id);
    }

    @CustomAnnotation
    public List<Client> getAll() {
        logger.info("Entered getAll() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.findAll();
    }

    @CustomAnnotation
    public List<Client> sortNameAsce() {
        logger.info("Entered sortNameAsce() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.sortNameAsce();
    }

    @CustomAnnotation
    public List<Client> sortNameDsce() {
        logger.info("Entered sortNameDsce() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.sortNameDsce();
    }

    @CustomAnnotation
    public List<Client> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.sortCreatedAtAsce();
    }

    @CustomAnnotation
    public List<Client> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.sortCreatedAtDsce();
    }

    @CustomAnnotation
    public List<Client> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.sortUpdatedAtAsce();
    }

    @CustomAnnotation
    public List<Client> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() client method from ClientServiceImpl in MongoDB part ");
        return clientMongoRepository.sortUpdatedAtDsce();
    }

    public List<Client> search(String word) {
        logger.info("Entered search() client method from ClientServiceImpl in MongoDB part to find client with " + word + " name");
        return this.getAll().stream()
                .filter(c -> c.getClientName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
