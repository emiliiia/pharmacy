package com.emilia.pharmacy.service.mongo.component.impls;
/*
  @author emilia
  @project pharmacy
  @className ComponentServiceImp
  @version 1.0.0
  @since 29.06.2022
*/

import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.IComponentMongoRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.mongo.component.interfaces.IComponentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ComponentServiceImpl implements IComponentService {

    List<Component> list = new ArrayList<>(
            Arrays.asList(
                    new Component("1", LocalDateTime.now(), LocalDateTime.now(), "Component", "Eucalyptus leaves", "g", 0.5, 1, 100),
                    new Component("2", LocalDateTime.now(), LocalDateTime.now(), "Component", "Xylometazoline", "ml", 0.25, 1, 110),
                    new Component("3", LocalDateTime.now(), LocalDateTime.now(), "Component", "Mometasone", "g", 0.5, 1, 100),
                    new Component("4", LocalDateTime.now(), LocalDateTime.now(), "Component", "Fluticasone propionate", "g", 0.1, 1, 50),
                    new Component("5", LocalDateTime.now(), LocalDateTime.now(), "Component", "Estradiol valerate", "g", 0.25, 1, 250),
                    new Component("6", LocalDateTime.now(), LocalDateTime.now(), "Component", "Dienogest", "g", 0.75, 1, 500),
                    new Component("7", LocalDateTime.now(), LocalDateTime.now(), "Component", "Levonorgestrel", "ml", 1, 1, 340),
                    new Component("8", LocalDateTime.now(), LocalDateTime.now(), "Component", "Ethinyl estradiol", "ml", 5, 1, 13),
                    new Component("9", LocalDateTime.now(), LocalDateTime.now(), "Component", "Drospirenone", "g", 0.5, 1, 24),
                    new Component("10", LocalDateTime.now(), LocalDateTime.now(), "Component", "Vitamin C", "g", 0.75, 1, 45),
                    new Component("11", LocalDateTime.now(), LocalDateTime.now(), "Component", "Liquid aloe extract", "ml", 0.2, 1, 13),
                    new Component("12", LocalDateTime.now(), LocalDateTime.now(), "Component", "Rhodiola rosea", "ml", 0.5, 1, 466),
                    new Component("13", LocalDateTime.now(), LocalDateTime.now(), "Component", "Doxycycline", "g", 0.1, 1, 674),
                    new Component("14", LocalDateTime.now(), LocalDateTime.now(), "Component", "Ceftriaxone", "ml", 1, 1, 253),
                    new Component("15", LocalDateTime.now(), LocalDateTime.now(), "Component", "Levofloxacin", "g", 1.5, 1, 1234),
                    new Component("16", LocalDateTime.now(), LocalDateTime.now(), "Component", "Ampicillin", "g", 2, 1, 456),
                    new Component("17", LocalDateTime.now(), LocalDateTime.now(), "Component", "Cefpodoxime", "g", 3, 1, 23),
                    new Component("18", LocalDateTime.now(), LocalDateTime.now(), "Component", "Paracetamol", "g", 5, 1, 64),
                    new Component("19", LocalDateTime.now(), LocalDateTime.now(), "Component", "Ibuprofen", "g", 2, 1, 624),
                    new Component("20", LocalDateTime.now(), LocalDateTime.now(), "Component", "Caffeine", "g", 0.75, 1, 13)
            )
    );

    Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Autowired
    IComponentMongoRepository componentMongoRepository;
/*
    @PostConstruct
    void init(){
        componentMongoRepository.saveAll(list);
    }
*/
    public Component create(Component component) {
        logger.info("Entered create() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.save(component);
    }


    public Component get(String id) {
        logger.info("Entered get() component method from ComponentServiceImpl in MongoDB part to find component with id = " + id);
        return componentMongoRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found component with id = " + id));
    }

    public Component update(Component component) {
        logger.info("Entered update() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.save(component);
    }


    public void delete(String id) {
        logger.info("Entered delete() component method from ComponentServiceImpl in MongoDB part to delete component with id = " + id);
        if (!componentMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found component with id = " + id);
        }
        componentMongoRepository.deleteById(id);
    }


    public List<Component> getAll() {
        logger.info("Entered getAll() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.findAll();
    }

    public List<Component> sortNameAsce() {
        logger.info("Entered sortNameAsce() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortNameAsce();
    }

    public List<Component> sortNameDsce() {
        logger.info("Entered sortNameDsce() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortNameDsce();
    }

    public List<Component> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortCreatedAtAsce();
    }

    public List<Component> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortCreatedAtDsce();
    }

    public List<Component> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortUpdatedAtAsce();
    }

    public List<Component> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortUpdatedAtDsce();
    }

    public List<Component> sortMeasureKg() {
        logger.info("Entered sortMeasureKg() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortMeasureKg();
    }

    public List<Component> sortMeasureL() {
        logger.info("Entered sortMeasureL() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortMeasureL();
    }

    public List<Component> sortMeasureG() {
        logger.info("Entered sortMeasureG() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortMeasureG();
    }

    public List<Component> sortMeasureML() {
        logger.info("Entered sortMeasureML() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortMeasureML();
    }
    public List<Component> sortMeasureMG() {
        logger.info("Entered sortMeasureMG() component method from ComponentServiceImpl in MongoDB part ");
        return componentMongoRepository.sortMeasureMG();
    }

    public List<Component> search(String word) {
        logger.info("Entered search() component method from ComponentServiceImpl in MongoDB part to find component with " + word + " name");
        return this.getAll().stream()
                .filter(component -> component.getComponentName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Component> needComponent() {
        logger.info("Entered needComponent() component method from ComponentServiceImpl in MongoDB part ");
        return this.getAll().stream()
                .filter(component -> component.getCriticalNorm()>component.getInStock())
                .collect(Collectors.toList());
    }
}
