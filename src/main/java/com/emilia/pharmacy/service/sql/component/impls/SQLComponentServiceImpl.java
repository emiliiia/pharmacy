package com.emilia.pharmacy.service.sql.component.impls;

/*
  @author emilia
  @project pharmacy
  @className ComponentServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLComponent;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IComponentPostgreSQLRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.sql.component.interfaces.ISQLComponentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQLComponentServiceImpl implements ISQLComponentService {


    List<SQLComponent> list = new ArrayList<>(
            Arrays.asList(
                    new SQLComponent(1, LocalDateTime.now(), LocalDateTime.now(), "Component", "Eucalyptus leaves", "g", 0.5, 1, 100),
                    new SQLComponent(2, LocalDateTime.now(), LocalDateTime.now(), "Component", "Xylometazoline", "ml", 0.25, 1, 110),
                    new SQLComponent(3, LocalDateTime.now(), LocalDateTime.now(), "Component", "Mometasone", "g", 0.5, 1, 100),
                    new SQLComponent(4, LocalDateTime.now(), LocalDateTime.now(), "Component", "Fluticasone propionate", "g", 0.1, 1, 50),
                    new SQLComponent(5, LocalDateTime.now(), LocalDateTime.now(), "Component", "Estradiol valerate", "g", 0.25, 1, 250),
                    new SQLComponent(6, LocalDateTime.now(), LocalDateTime.now(), "Component", "Dienogest", "g", 0.75, 1, 500),
                    new SQLComponent(7, LocalDateTime.now(), LocalDateTime.now(), "Component", "Levonorgestrel", "ml", 1, 1, 340),
                    new SQLComponent(8, LocalDateTime.now(), LocalDateTime.now(), "Component", "Ethinyl estradiol", "ml", 5, 1, 13),
                    new SQLComponent(9, LocalDateTime.now(), LocalDateTime.now(), "Component", "Drospirenone", "g", 0.5, 1, 24),
                    new SQLComponent(10, LocalDateTime.now(), LocalDateTime.now(), "Component", "Vitamin C", "g", 0.75, 1, 45),
                    new SQLComponent(11, LocalDateTime.now(), LocalDateTime.now(), "Component", "Liquid aloe extract", "ml", 0.2, 1, 13),
                    new SQLComponent(12, LocalDateTime.now(), LocalDateTime.now(), "Component", "Rhodiola rosea", "ml", 0.5, 1, 466),
                    new SQLComponent(13, LocalDateTime.now(), LocalDateTime.now(), "Component", "Doxycycline", "g", 0.1, 1, 674),
                    new SQLComponent(14, LocalDateTime.now(), LocalDateTime.now(), "Component", "Ceftriaxone", "ml", 1, 1, 253),
                    new SQLComponent(15, LocalDateTime.now(), LocalDateTime.now(), "Component", "Levofloxacin", "g", 1.5, 1, 1234),
                    new SQLComponent(16, LocalDateTime.now(), LocalDateTime.now(), "Component", "Ampicillin", "g", 2, 1, 456),
                    new SQLComponent(17, LocalDateTime.now(), LocalDateTime.now(), "Component", "Cefpodoxime", "g", 3, 1, 23),
                    new SQLComponent(18, LocalDateTime.now(), LocalDateTime.now(), "Component", "Paracetamol", "g", 5, 1, 64),
                    new SQLComponent(19, LocalDateTime.now(), LocalDateTime.now(), "Component", "Ibuprofen", "g", 2, 1, 624),
                    new SQLComponent(20, LocalDateTime.now(), LocalDateTime.now(), "Component", "Caffeine", "g", 0.75, 1, 13)
            )
    );

    Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Autowired
    IComponentPostgreSQLRepository componentPostgreSQLRepository;
/*
    @PostConstruct
    void init(){
        componentPostgreSQLRepository.saveAll(list);
    }
*/
    public SQLComponent create(SQLComponent component) {
        logger.info("Entered create() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.save(component);
    }


    public SQLComponent get(Integer id) {
        logger.info("Entered get() component method from SQLComponentServiceImpl in PostgreSQL part to get component with id = " + id);
        return componentPostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found component with id = " + id));
    }

    public SQLComponent update(SQLComponent component) {
        logger.info("Entered update() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.save(component);
    }


    public void delete(Integer id) {
        logger.info("Entered delete() component method from SQLComponentServiceImpl in PostgreSQL part to delete component with id = " + id);
        if (!componentPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found component with id = " + id);
        }
        componentPostgreSQLRepository.deleteById(id);
    }


    public List<SQLComponent> getAll() {
        logger.info("Entered getAll() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll();
    }

    public List<SQLComponent> sortNameAsce() {
        logger.info("Entered sortNameAsce() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "componentName"));
    }

    public List<SQLComponent> sortNameDsce() {
        logger.info("Entered sortNameDsce() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "componentName"));
    }

    public List<SQLComponent> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));}

    public List<SQLComponent> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<SQLComponent> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }

    public List<SQLComponent> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }

    public List<SQLComponent> sortMeasureKg() {
        logger.info("Entered sortMeasureKg() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.sortMeasureKg();
    }

    public List<SQLComponent> sortMeasureL() {
        logger.info("Entered sortMeasureL() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.sortMeasureL();
    }

    public List<SQLComponent> sortMeasureG() {
        logger.info("Entered sortMeasureG() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.sortMeasureG();
    }

    public List<SQLComponent> sortMeasureML() {
        logger.info("Entered sortMeasureML() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.sortMeasureML();
    }
    public List<SQLComponent> sortMeasureMG() {
        logger.info("Entered sortMeasureMG() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.sortMeasureMG();
    }

    public List<SQLComponent> search(String word) {
        logger.info("Entered search() component method from SQLComponentServiceImpl in PostgreSQL part to find component with " + word + " name");
        return this.getAll().stream()
                .filter(component -> component.getComponentName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLComponent> needComponent() {
        logger.info("Entered needComponent() component method from SQLComponentServiceImpl in PostgreSQL part ");
        return componentPostgreSQLRepository.needComponent();
    }
}
