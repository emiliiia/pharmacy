package com.emilia.pharmacy.service.sql.drug.impls;

import com.emilia.pharmacy.entity.sql.SQLDrug;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IDrugPostgreSQLRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.sql.drug.interfaces.ISQLDrugService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/*
  @author emilia
  @project pharmacy
  @className DrugServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/
@Service
public class SQLDrugServiceImpl implements ISQLDrugService {
    Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Autowired
    IDrugPostgreSQLRepository drugPostgreSQLRepository;

    public SQLDrug create(SQLDrug drug) {
        logger.info("Entered create() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.save(drug);
    }

    public SQLDrug get(Integer id) {
        logger.info("Entered get() drug method from SQLDrugServiceImpl in PostgreSQL part to find drug with id = "+ id);
        return drugPostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found drug with id = " + id));
    }


    public SQLDrug update(SQLDrug drug) {
        logger.info("Entered update() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.save(drug);
    }

    public void delete(Integer id) {
        logger.info("Entered delete() drug method from SQLDrugServiceImpl in PostgreSQL part to delete drug with id = " + id);
        if (!drugPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found drug with id = " + id);
        }
        drugPostgreSQLRepository.deleteById(id);
    }


    public List<SQLDrug> getAll() {
        logger.info("Entered getAll() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll();
    }


    public List<SQLDrug> sortExtemporal() {
        logger.info("Entered sortExtemporal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporal();
    }

    public List<SQLDrug> sortOfficinal() {
        logger.info("Entered sortOfficinal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinal();
    }



    public List<SQLDrug> sortNameAsce() {
        logger.info("Entered sortNameAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "drugName"));
    }

    public List<SQLDrug> sortNameDsce() {
        logger.info("Entered sortNameDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "drugName"));
    }

    public List<SQLDrug> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public List<SQLDrug> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<SQLDrug> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }

    public List<SQLDrug> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }


    public List<SQLDrug> sortExtemporalNameAsce() {
        logger.info("Entered sortExtemporalNameAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalNameAsce();
    }

    public List<SQLDrug> sortExtemporalNameDsce() {
        logger.info("Entered sortExtemporalNameDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalNameDsce();
    }

    public List<SQLDrug> sortExtemporalCreatedAtAsce() {
        logger.info("Entered sortExtemporalCreatedAtAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalCreatedAtAsce();
    }

    public List<SQLDrug> sortExtemporalCreatedAtDsce() {
        logger.info("Entered sortExtemporalCreatedAtDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalCreatedAtDsce();
    }

    public List<SQLDrug> sortExtemporalUpdatedAtAsce() {
        logger.info("Entered sortExtemporalUpdatedAtAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalUpdatedAtAsce();
    }

    public List<SQLDrug> sortExtemporalUpdatedAtDsce() {
        logger.info("Entered sortExtemporalUpdatedAtDsc() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalUpdatedAtDsce();
    }




    public List<SQLDrug> sortOfficinalNameAsce() {
        logger.info("Entered sortOfficinalNameAsc() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalNameAsce();
    }

    public List<SQLDrug> sortOfficinalNameDsce() {
        logger.info("Entered sortOfficinalNameDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalNameDsce();
    }

    public List<SQLDrug> sortOfficinalCreatedAtAsce() {
        logger.info("Entered sortOfficinalCreatedAtAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalCreatedAtAsce();
    }

    public List<SQLDrug> sortOfficinalCreatedAtDsce() {
        logger.info("Entered sortOfficinalCreatedAtDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalCreatedAtDsce();
    }

    public List<SQLDrug> sortOfficinalUpdatedAtAsce() {
        logger.info("Entered sortOfficinalUpdatedAtAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalUpdatedAtAsce();
    }

    public List<SQLDrug> sortOfficinalUpdatedAtDsce() {
        logger.info("Entered sortOfficinalUpdatedAtDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalUpdatedAtDsce();
    }


    public List<SQLDrug> sortUseExternal() {
        logger.info("Entered sortUseExterna() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortUseExternal();
    }
    public List<SQLDrug> sortUseInternal() {
        logger.info("Entered sortUseInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortUseInternal();
    }
    public List<SQLDrug> sortUseExInternal() {
        logger.info("Entered sortUseExInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortUseExInternal();
    }
    public List<SQLDrug> sortUseMix() {
        logger.info("Entered sortUseMix() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortUseMix();
    }



    public List<SQLDrug> sortExtemporalUseExternal() {
        logger.info("Entered sortExtemporalUseExternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalUseExternal();
    }
    public List<SQLDrug> sortExtemporalUseInternal() {
        logger.info("Entered sortExtemporalUseInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalUseInternal();
    }
    public List<SQLDrug> sortExtemporalUseExInternal() {
        logger.info("Entered sortExtemporalUseExInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalUseExInternal();
    }
    public List<SQLDrug> sortExtemporalUseMix() {
        logger.info("Entered sortExtemporalUseMix() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalUseMix();
    }


    public List<SQLDrug> sortOfficinalUseExternal() {
        logger.info("Entered sortOfficinalUseExternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalUseExternal();
    }
    public List<SQLDrug> sortOfficinalUseInternal() {
        logger.info("Entered sortOfficinalUseInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalUseInternal();
    }
    public List<SQLDrug> sortOfficinalUseExInternal() {
        logger.info("Entered sortOfficinalUseExInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalUseExInternal();
    }
    public List<SQLDrug> sortOfficinalUseMix() {
        logger.info("Entered sortOfficinalUseMix() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalUseMix();
    }


    public List<SQLDrug> sortFormTablets() {
        logger.info("Entered sortFormTablets() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortFormTablets();
    }
    public List<SQLDrug> sortFormOintment() {
        logger.info("Entered sortFormOintment() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortFormOintment();
    }
    public List<SQLDrug> sortFormPotion() {
        logger.info("Entered sortFormPotion() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortFormPotion();
    }
    public List<SQLDrug> sortFormAQUA() {
        logger.info("Entered sortFormAQUA() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortFormAQUA();
    }
    public List<SQLDrug> sortFormFlour() {
        logger.info("Entered sortFormFlour() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortFormFlour();
    }
    public List<SQLDrug> sortFormTincture() {
        logger.info("Entered sortFormTincture() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortFormTincture();
    }



    public List<SQLDrug> sortExtemporalFormTablets() {
        logger.info("Entered sortExtemporalFormTablets() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalFormTablets();
    }
    public List<SQLDrug> sortExtemporalFormOintment() {
        logger.info("Entered sortExtemporalFormOintment() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalFormOintment();
    }
    public List<SQLDrug> sortExtemporalFormPotion() {
        logger.info("Entered sortExtemporalFormPotio() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalFormPotion();
    }
    public List<SQLDrug> sortExtemporalFormAQUA() {
        logger.info("Entered sortExtemporalFormAQUA() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalFormAQUA();
    }
    public List<SQLDrug> sortExtemporalFormFlour() {
        logger.info("Entered sortExtemporalFormFlour() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalFormFlour();
    }
    public List<SQLDrug> sortExtemporalFormTincture() {
        logger.info("Entered sortExtemporalFormTincture() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortExtemporalFormTincture();
    }


    public List<SQLDrug> sortOfficinalFormTablets() {
        logger.info("Entered sortOfficinalFormTablets() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalFormTablets();
    }
    public List<SQLDrug> sortOfficinalFormOintment() {
        logger.info("Entered sortOfficinalFormOintment() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalFormOintment();
    }
    public List<SQLDrug> sortOfficinalFormTincture() {
        logger.info("Entered sortOfficinalFormTincture() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalFormTincture();
    }


    public List<SQLDrug> sortOfficinalInStockAsce() {
        logger.info("Entered sortOfficinalInStockAsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsce();
    }
    public List<SQLDrug> sortOfficinalInStockDsce() {
        logger.info("Entered sortOfficinalInStockDsce() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsce();
    }


    public List<SQLDrug> sortOfficinalInStockAsceUseInternal() {
        logger.info("Entered sortOfficinalInStockAsceUseInterna() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceUseInternal();
    }
    public List<SQLDrug> sortOfficinalInStockDsceUseInternal() {
        logger.info("Entered sortOfficinalInStockDsceUseInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceUseInternal();
    }

    public List<SQLDrug> sortOfficinalInStockAsceUseExternal() {
        logger.info("Entered sortOfficinalInStockAsceUseExternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceUseExternal();
    }
    public List<SQLDrug> sortOfficinalInStockDsceUseExternal() {
        logger.info("Entered sortOfficinalInStockDsceUseExternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceUseExternal();
    }

    public List<SQLDrug> sortOfficinalInStockAsceUseExternalInternal() {
        logger.info("Entered sortOfficinalInStockAsceUseExternalInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceUseExternalInternal();
    }
    public List<SQLDrug> sortOfficinalInStockDsceUseExternalInternal() {
        logger.info("Entered sortOfficinalInStockDsceUseExternalInternal() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceUseExternalInternal();
    }
    public List<SQLDrug> sortOfficinalInStockAsceUseMix() {
        logger.info("Entered sortOfficinalInStockAsceUseMix() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceUseMix();
    }
    public List<SQLDrug> sortOfficinalInStockDsceUseMix() {
        logger.info("Entered sortOfficinalInStockDsceUseMix() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceUseMix();
    }
    public List<SQLDrug> sortOfficinalInStockAsceFormTablets() {
        logger.info("Entered sortOfficinalInStockAsceFormTablets() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceFormTablets();
    }
    public List<SQLDrug> sortOfficinalInStockDsceFormTablets() {
        logger.info("Entered sortOfficinalInStockDsceFormTablets() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceFormTablets();
    }
    public List<SQLDrug> sortOfficinalInStockAsceFormOintment() {
        logger.info("Entered sortOfficinalInStockAsceFormOintment() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceFormOintment();
    }
    public List<SQLDrug> sortOfficinalInStockDsceFormOintment() {
        logger.info("Entered sortOfficinalInStockDsceFormOintment() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceFormOintment();
    }

    public List<SQLDrug> sortOfficinalInStockAsceFormTincture() {
        logger.info("Entered sortOfficinalInStockAsceFormTincture() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockAsceFormTincture();
    }
    public List<SQLDrug> sortOfficinalInStockDsceFormTincture() {
        logger.info("Entered sortOfficinalInStockDsceFormTincture() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.sortOfficinalInStockDsceFormTincture();
    }

    public List<SQLDrug> expireDrugs(LocalDate date) {
        logger.info("Entered expireDrugs() drug method from SQLDrugServiceImpl in PostgreSQL part ");
        return drugPostgreSQLRepository.expireDrugs(date);
    }


    public List<SQLDrug> search(String word, List<SQLDrug> list) {
        logger.info("Entered search() drug method from SQLDrugServiceImpl in PostgreSQL part to find drug with " + word + " name");
        return list.stream()
                .filter(drug -> drug.getDrugName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

}
