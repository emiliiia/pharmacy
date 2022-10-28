package com.emilia.pharmacy.service.mongo.drug.impls;

import com.emilia.pharmacy.entity.mongo.*;
import com.emilia.pharmacy.enums.ReleaseForm;
import com.emilia.pharmacy.enums.Use;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.IDrugMongoRepository;
import com.emilia.pharmacy.service.mongo.client.impls.ClientServiceImpl;
import com.emilia.pharmacy.service.mongo.drug.interfaces.IDrugService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/*
  @author emilia
  @project pharmacy
  @className ExtemporalDrugServiceImp
  @version 1.0.0
  @since 29.06.2022
*/
@Service
public class DrugServiceImpl implements IDrugService {

    List<Drug> list = new ArrayList<>(
            Arrays.asList(
                    new Drug("1", LocalDateTime.now(), LocalDateTime.now(), "Extemporal Drug",
                            "Aluminum lotion", 0.1, Use.EXTERNAL, "Treatment of oily seborrhea, acne, rosacea, etc.", ReleaseForm.AQUA, "1 year",
                            136, new TechnologyBook("10"), "10 days", new ArrayList<>(Arrays.asList(new Component("1"), new Component("5")))),

                    new Drug("2", LocalDateTime.now(), LocalDateTime.now(), "Extemporal Drug",
                            "Enterosorbent", 1, Use.INTERNALEXTERNAL, "In dermatovenereology: allergic dermatitis, toxicoderma, acne, rosacea, pyoderma, eczema and the like. In gastroenterology: food poisoning, dysbacteriosis, gastritis, enteritis, cholangitis and the like.", ReleaseForm.AQUA, "1 month",
                            316, new TechnologyBook("5"), "11 days", new ArrayList<>(Arrays.asList(new Component("3"), new Component("8"), new Component("13")))),

                    new Drug("3", LocalDateTime.now(), LocalDateTime.now(), "Officinal Drug",
                            "Panckreatyt", 0.5, Use.INTERNAL, "In dermatovenereology: allergic dermatitis, toxicoderma, acne, rosacea, pyoderma, eczema and the like. In gastroenterology: food poisoning, dysbacteriosis, gastritis, enteritis, cholangitis and the like.", ReleaseForm.TABLETS,  143.5, new Manufacturer("1"), LocalDate.of(2002, Calendar.MARCH, 14), 100)

            )
    );
    Logger logger = LogManager.getLogger(ClientServiceImpl.class);
    @Autowired
    IDrugMongoRepository drugMongoRepository;
/*
    @PostConstruct
    void init(){
        drugMongoRepository.saveAll(list);
    }
*/
    public Drug create(Drug drug) {
        logger.info("Entered create() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.save(drug);
    }

    public Drug get(String id) {
        logger.info("Entered get() drug method from DrugServiceImpl in MongoDB part to find drug with id = " + id);
        return drugMongoRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found drug with id = " + id));
    }

    public Drug update(Drug drug) {
        logger.info("Entered update() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.save(drug);
    }


    public void delete(String id) {
        logger.info("Entered delete() drug method from DrugServiceImpl in MongoDB part ");
        if (!drugMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found drug with id = " + id);
        }
        drugMongoRepository.deleteById(id);
    }


    public List<Drug> getAll() {
        logger.info("Entered getAll() drug method from DrugServiceImpl in MongoDB part ");
        return
                drugMongoRepository.findAll();
    }

    public List<Drug> sortExtemporal() {
        logger.info("Entered sortExtemporal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporal();
    }

    public List<Drug> sortOfficinal() {
        logger.info("Entered sortOfficinal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinal();
    }



    public List<Drug> sortNameAsce() {
        logger.info("Entered sortNameAsc() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortNameAsce();
    }

    public List<Drug> sortNameDsce() {
        logger.info("Entered sortNameDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortNameDsce();
    }

    public List<Drug> sortCreatedAtAsce() {
        logger.info("Entered sortCreatedAtAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortCreatedAtAsce();
    }

    public List<Drug> sortCreatedAtDsce() {
        logger.info("Entered sortCreatedAtDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortCreatedAtDsce();
    }

    public List<Drug> sortUpdatedAtAsce() {
        logger.info("Entered sortUpdatedAtAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortUpdatedAtAsce();
    }

    public List<Drug> sortUpdatedAtDsce() {
        logger.info("Entered sortUpdatedAtDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortUpdatedAtDsce();
    }



    public List<Drug> sortExtemporalNameAsce() {
        logger.info("Entered sortExtemporalNameAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalNameAsce();
    }

    public List<Drug> sortExtemporalNameDsce() {
        logger.info("Entered sortExtemporalNameDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalNameDsce();
    }

    public List<Drug> sortExtemporalCreatedAtAsce() {
        logger.info("Entered sortExtemporalCreatedAtAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalCreatedAtAsce();
    }

    public List<Drug> sortExtemporalCreatedAtDsce() {
        logger.info("Entered sortExtemporalCreatedAtDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalCreatedAtDsce();
    }

    public List<Drug> sortExtemporalUpdatedAtAsce() {
        logger.info("Entered sortExtemporalUpdatedAtAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalUpdatedAtAsce();
    }

    public List<Drug> sortExtemporalUpdatedAtDsce() {
        logger.info("Entered sortExtemporalUpdatedAtDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalUpdatedAtDsce();
    }


    public List<Drug> sortOfficinalNameAsce() {
        logger.info("Entered sortOfficinalNameAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalNameAsce();
    }

    public List<Drug> sortOfficinalNameDsce() {
        logger.info("Entered sortOfficinalNameDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalNameDsce();
    }

    public List<Drug> sortOfficinalCreatedAtAsce() {
        logger.info("Entered sortOfficinalCreatedAtAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalCreatedAtAsce();
    }

    public List<Drug> sortOfficinalCreatedAtDsce() {
        logger.info("Entered sortOfficinalCreatedAtDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalCreatedAtDsce();
    }

    public List<Drug> sortOfficinalUpdatedAtAsce() {
        logger.info("Entered sortOfficinalUpdatedAtAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalUpdatedAtAsce();
    }

    public List<Drug> sortOfficinalUpdatedAtDsce() {
        logger.info("Entered sortOfficinalUpdatedAtDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalUpdatedAtDsce();
    }


    public List<Drug> sortUseExternal() {
        logger.info("Entered sortUseExternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortUseExternal();
    }
    public List<Drug> sortUseInternal() {
        logger.info("Entered sortUseInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortUseInternal();
    }
    public List<Drug> sortUseExInternal() {
        logger.info("Entered sortUseExInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortUseExInternal();
    }
    public List<Drug> sortUseMix() {
        logger.info("Entered sortUseMix() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortUseMix();
    }


    public List<Drug> sortExtemporalUseExternal() {
        logger.info("Entered sortExtemporalUseExternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalUseExternal();
    }
    public List<Drug> sortExtemporalUseInternal() {
        logger.info("Entered sortExtemporalUseInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalUseInternal();
    }
    public List<Drug> sortExtemporalUseExInternal() {
        logger.info("Entered sortExtemporalUseExInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalUseExInternal();
    }
    public List<Drug> sortExtemporalUseMix() {
        logger.info("Entered sortExtemporalUseMix() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalUseMix();
    }


    public List<Drug> sortOfficinalUseExternal() {
        logger.info("Entered sortOfficinalUseExternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalUseExternal();
    }
    public List<Drug> sortOfficinalUseInternal() {
        logger.info("Entered sortOfficinalUseInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalUseInternal();
    }
    public List<Drug> sortOfficinalUseExInternal() {
        logger.info("Entered sortOfficinalUseExInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalUseExInternal();
    }
    public List<Drug> sortOfficinalUseMix() {
        logger.info("Entered sortOfficinalUseMix() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalUseMix();
    }



    public List<Drug> sortFormTablets() {
        logger.info("Entered sortFormTablets() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortFormTablets();
    }
    public List<Drug> sortFormOintment() {
        logger.info("Entered sortFormOintment() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortFormOintment();
    }
    public List<Drug> sortFormPotion() {
        logger.info("Entered sortFormPotion() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortFormPotion();
    }
    public List<Drug> sortFormAQUA() {
        logger.info("Entered sortFormAQUA() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortFormAQUA();
    }
    public List<Drug> sortFormFlour() {
        logger.info("Entered sortFormFlour() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortFormFlour();
    }
    public List<Drug> sortFormTincture() {
        logger.info("Entered sortFormTincture() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortFormTincture();
    }



    public List<Drug> sortExtemporalFormTablets() {
        logger.info("Entered sortExtemporalFormTablets() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalFormTablets();
    }
    public List<Drug> sortExtemporalFormOintment() {
        logger.info("Entered sortExtemporalFormOintment() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalFormOintment();
    }
    public List<Drug> sortExtemporalFormPotion() {
        logger.info("Entered sortExtemporalFormPotion() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalFormPotion();
    }
    public List<Drug> sortExtemporalFormAQUA() {
        logger.info("Entered sortExtemporalFormAQUA() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalFormAQUA();
    }
    public List<Drug> sortExtemporalFormFlour() {
        logger.info("Entered sortExtemporalFormFlou() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalFormFlour();
    }
    public List<Drug> sortExtemporalFormTincture() {
        logger.info("Entered sortExtemporalFormTincture() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortExtemporalFormTincture();
    }


    public List<Drug> sortOfficinalFormTablets() {
        logger.info("Entered sortOfficinalFormTablets() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalFormTablets();
    }
    public List<Drug> sortOfficinalFormOintment() {
        logger.info("Entered sortOfficinalFormOintment() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalFormOintment();
    }
    public List<Drug> sortOfficinalFormTincture() {
        logger.info("Entered sortOfficinalFormTincture() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalFormTincture();
    }


    public List<Drug> sortOfficinalInStockAsce() {
        logger.info("Entered sortOfficinalInStockAsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsce();
    }
    public List<Drug> sortOfficinalInStockDsce() {
        logger.info("Entered sortOfficinalInStockDsce() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsce();
    }


    public List<Drug> sortOfficinalInStockAsceUseInternal() {
        logger.info("Entered sortOfficinalInStockAsceUseInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceUseInternal();
    }
    public List<Drug> sortOfficinalInStockDsceUseInternal() {
        logger.info("Entered sortOfficinalInStockDsceUseInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceUseInternal();
    }

    public List<Drug> sortOfficinalInStockAsceUseExternal() {
        logger.info("Entered sortOfficinalInStockAsceUseExternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceUseExternal();
    }
    public List<Drug> sortOfficinalInStockDsceUseExternal() {
        logger.info("Entered sortOfficinalInStockDsceUseExternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceUseExternal();
    }

    public List<Drug> sortOfficinalInStockAsceUseExternalInternal() {
        logger.info("Entered sortOfficinalInStockAsceUseExternalInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceUseExternalInternal();
    }
    public List<Drug> sortOfficinalInStockDsceUseExternalInternal() {
        logger.info("Entered sortOfficinalInStockDsceUseExternalInternal() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceUseExternalInternal();
    }
    public List<Drug> sortOfficinalInStockAsceUseMix() {
        logger.info("Entered sortOfficinalInStockAsceUseMix() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceUseMix();
    }
    public List<Drug> sortOfficinalInStockDsceUseMix() {
        logger.info("Entered sortOfficinalInStockDsceUseMix() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceUseMix();
    }
    public List<Drug> sortOfficinalInStockAsceFormTablets() {
        logger.info("Entered sortOfficinalInStockAsceFormTablets() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceFormTablets();
    }
    public List<Drug> sortOfficinalInStockDsceFormTablets() {
        logger.info("Entered sortOfficinalInStockDsceFormTablets() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceFormTablets();
    }
    public List<Drug> sortOfficinalInStockAsceFormOintment() {
        logger.info("Entered sortOfficinalInStockAsceFormOintment() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceFormOintment();
    }
    public List<Drug> sortOfficinalInStockDsceFormOintment() {
        logger.info("Entered sortOfficinalInStockDsceFormOintment() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceFormOintment();
    }

    public List<Drug> sortOfficinalInStockAsceFormTincture() {
        logger.info("Entered sortOfficinalInStockAsceFormTincture() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockAsceFormTincture();
    }
    public List<Drug> sortOfficinalInStockDsceFormTincture() {
        logger.info("Entered sortOfficinalInStockDsceFormTincture() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.sortOfficinalInStockDsceFormTincture();
    }

    public List<Drug> expireDrugs(LocalDate date) {
        logger.info("Entered expireDrugs() drug method from DrugServiceImpl in MongoDB part ");
        return drugMongoRepository.expireDrugs(date);
    }


    public List<Drug> search(String word, List<Drug> list) {
        logger.info("Entered search() drug method from DrugServiceImpl in MongoDB part to find drug with " + word + " name");
        return list.stream()
                .filter(drug -> drug.getDrugName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
