package com.emilia.pharmacy.service.mongo.technologyBook.impls;

import com.emilia.pharmacy.enums.ExtemporalMethod;
import com.emilia.pharmacy.entity.mongo.TechnologyBook;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.ITechnologyBookMongoRepository;
import com.emilia.pharmacy.service.mongo.technologyBook.interfaces.ITechnologyBookService;
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
  @className TechnologyBookServiceImp
  @version 1.0.0
  @since 29.06.2022
*/
@Service
public class TechnologyBookServiceImpl implements ITechnologyBookService {

    List<TechnologyBook> list = new ArrayList<>(
            Arrays.asList(
                    new TechnologyBook("1", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Bovtanka from acne", ExtemporalMethod.DISSOLVING, "14 days"),
                    new TechnologyBook("2", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Antifungal solution", ExtemporalMethod.DILUTION, "1 days"),
                    new TechnologyBook("3", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Vidal milk", ExtemporalMethod.DISPERSING, "5 days"),
                    new TechnologyBook("4", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Castellani liquid", ExtemporalMethod.EMULSIFYING, "2 days"),
                    new TechnologyBook("5", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Deflagyl ointment", ExtemporalMethod.FILTERING, "4 days"),
                    new TechnologyBook("6", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Dill water", ExtemporalMethod.HEATING, "6 days"),
                    new TechnologyBook("7", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Ethacridine lactate", ExtemporalMethod.MIXING, "1 days"),
                    new TechnologyBook("8", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Potassium iodide eye drops", ExtemporalMethod.SWELLING, "3 days"),
                    new TechnologyBook("9", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Xeroform powder", ExtemporalMethod.DISSOLVING, "2 days"),
                    new TechnologyBook("10", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Kolargol solution", ExtemporalMethod.DILUTION, "5 days"),
                    new TechnologyBook("11", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Methylene blue", ExtemporalMethod.DISPERSING, "2 days"),
                    new TechnologyBook("12", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Ointment from hemorrhoids is complex", ExtemporalMethod.EMULSIFYING, "4 days"),
                    new TechnologyBook("13", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Soothing balm AMA", ExtemporalMethod.FILTERING, "6 days"),
                    new TechnologyBook("14", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Ointment from calluses No. 2", ExtemporalMethod.HEATING, "3 days"),
                    new TechnologyBook("15", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Anti-inflammatory gel", ExtemporalMethod.MIXING, "4 days"),
                    new TechnologyBook("16", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Bryonia ointment", ExtemporalMethod.SWELLING, "6 days"),
                    new TechnologyBook("17", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Anti-acne lotion", ExtemporalMethod.SWELLING, "2 days"),
                    new TechnologyBook("18", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Homeopathic allergy ointment", ExtemporalMethod.MIXING, "4 days"),
                    new TechnologyBook("19", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Universal homeopathic ointment", ExtemporalMethod.FILTERING, "5 days"),
                    new TechnologyBook("20", LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Sabadilla AMA", ExtemporalMethod.EMULSIFYING, "2 days")
            )
    );

    @Autowired
    ITechnologyBookMongoRepository technologyBookMongoRepository;
/*
    @PostConstruct
    void init(){
        technologyBookMongoRepository.saveAll(list);
    }
*/
    public TechnologyBook create(TechnologyBook technologyBook) {
        return technologyBookMongoRepository.save(technologyBook);
    }

    public TechnologyBook get(String id) {
        return technologyBookMongoRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("Not found technology with id = " + id));
    }


    public TechnologyBook update(TechnologyBook technologyBook) {
        return technologyBookMongoRepository.save(technologyBook);
    }

    public void delete(String id) {
        if (!technologyBookMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found technology with id = " + id);
        }
        technologyBookMongoRepository.deleteById(id);
    }

    public List<TechnologyBook> getAll() {
        return
                technologyBookMongoRepository.findAll();
    }



    public List<TechnologyBook> sortNameAsce() {
        return technologyBookMongoRepository.sortNameAsce();
    }

    public List<TechnologyBook> sortNameDsce() {
        return technologyBookMongoRepository.sortNameDsce();
    }

    public List<TechnologyBook> sortCreatedAtAsce() {
        return technologyBookMongoRepository.sortCreatedAtAsce();
    }

    public List<TechnologyBook> sortCreatedAtDsce() {
        return technologyBookMongoRepository.sortCreatedAtDsce();
    }

    public List<TechnologyBook> sortUpdatedAtAsce() {
        return technologyBookMongoRepository.sortUpdatedAtAsce();
    }

    public List<TechnologyBook> sortUpdatedAtDsce() {
        return technologyBookMongoRepository.sortUpdatedAtDsce();
    }
    public List<TechnologyBook> sortMethodDISSOLVING() {
        return technologyBookMongoRepository.sortMethodDISSOLVING();
    }
    public List<TechnologyBook> sortMethodSWELLING() {
        return technologyBookMongoRepository.sortMethodSWELLING();
    }
    public List<TechnologyBook> sortMethodHEATING() {
        return technologyBookMongoRepository.sortMethodHEATING();
    }

    public List<TechnologyBook> sortMethodDILUTION() {
        return technologyBookMongoRepository.sortMethodDILUTION();
    }

    public List<TechnologyBook> sortMethodFILTERING() {
        return technologyBookMongoRepository.sortMethodFILTERING();
    }

    public List<TechnologyBook> sortMethodEMULSIFYING() {
        return technologyBookMongoRepository.sortMethodEMULSIFYING();
    }
    public List<TechnologyBook> sortMethodDISPERSING() {
        return technologyBookMongoRepository.sortMethodDISPERSING();
    }

    public List<TechnologyBook> sortMethodMIXING() {
        return technologyBookMongoRepository.sortMethodMIXING();
    }

    public List<TechnologyBook> search(String word) {
        return this.getAll().stream()
                .filter(technologyBook -> technologyBook.getType().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

}
