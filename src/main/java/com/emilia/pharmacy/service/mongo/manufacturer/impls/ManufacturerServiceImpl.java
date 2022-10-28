package com.emilia.pharmacy.service.mongo.manufacturer.impls;

import com.emilia.pharmacy.entity.mongo.Manufacturer;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.IManufacturerMongoRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.mongo.manufacturer.interfaces.IManufacturerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerServiceImpl
  @version 1.0.0
  @since 09.08.2022
*/
@Service
public class ManufacturerServiceImpl implements IManufacturerService {

    List<Manufacturer> list = new ArrayList<>(
            Arrays.asList(
                    new Manufacturer("1", LocalDateTime.now(), LocalDateTime.now(), "Manufacturer", "Pfizer", "Harpko Anna", "+380606978452", "USA")
            )
    );

    Logger logger = LogManager.getLogger(ClientServiceImpl.class);

    @Autowired
    IManufacturerMongoRepository manufacturerMongoRepository;
/*
    @PostConstruct
    void init(){
        manufacturerMongoRepository.saveAll(list);
    }
*/

    public Manufacturer create(Manufacturer manufacturer) {
        logger.info("Entered create() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return manufacturerMongoRepository.save(manufacturer);
    }


    public Manufacturer get(String id) {
        logger.info("Entered get() manufacturer method from ManufacturerServiceImpl in MongoDB part to find manufacturer with id = " + id);
        return manufacturerMongoRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found manufacturer with id = " + id));
    }

    public Manufacturer update(Manufacturer manufacturer) {
        logger.info("Entered update() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return manufacturerMongoRepository.save(manufacturer);
    }


    public void delete(String id) {
        logger.info("Entered delete() manufacturer method from ManufacturerServiceImpl in MongoDB part to delete manufacturer with id = " + id);
        if (!manufacturerMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found manufacturer with id = " + id);
        }
        manufacturerMongoRepository.deleteById(id);
    }


    public List<Manufacturer> getAll() {
        logger.info("Entered getAll() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return manufacturerMongoRepository.findAll();
    }

    public List<Manufacturer> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return
                manufacturerMongoRepository.sortUpdatedAtAsce();
    }
    public List<Manufacturer> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return
                manufacturerMongoRepository.sortUpdatedAtDsce();
    }
    public List<Manufacturer> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return
                manufacturerMongoRepository.sortCreatedAtAsce();
    }
    public List<Manufacturer> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return
                manufacturerMongoRepository.sortCreatedAtDsce();
    }
    public List<Manufacturer> sortManufacturerDsce() {
        logger.info("Entered sortManufacturerDsce() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return
                manufacturerMongoRepository.sortManufacturerDsce();
    }
    public List<Manufacturer> sortManufacturerAsce() {
        logger.info("Entered sortManufacturerAsce() manufacturer method from ManufacturerServiceImpl in MongoDB part ");
        return
                manufacturerMongoRepository.sortManufacturerAsce();
    }



    public List<Manufacturer> search(String word) {
        logger.info("Entered search() manufacturer method from ManufacturerServiceImpl in MongoDB part to find manufacturer with " + word + " name");
        return this.getAll().stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Manufacturer> searchByCompanyName(String word, List<Manufacturer> list) {
        logger.info("Entered searchByCompanyName() manufacturer method from ManufacturerServiceImpl in MongoDB part to find manufacturer with " + word + " name");
        return list.stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Manufacturer> searchByAgentName(String word, List<Manufacturer> list) {
        logger.info("Entered searchByAgentName() manufacturer method from ManufacturerServiceImpl in MongoDB part to find manufacturer with " + word + " agent");
        return list.stream()
                .filter(manufacturer -> manufacturer.getAgentName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Manufacturer> searchByCountry(String word, List<Manufacturer> list) {
        logger.info("Entered searchByCountry() manufacturer method from ManufacturerServiceImpl in MongoDB part to find manufacturer from " + word + " country");
        return list.stream()
                .filter(manufacturer -> manufacturer.getCountry().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
