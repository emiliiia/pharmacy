package com.emilia.pharmacy.service.sql.technologyBook.impls;

/*
  @author emilia
  @project pharmacy
  @className TechnologyBookServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLTechnologyBook;
import com.emilia.pharmacy.enums.ExtemporalMethod;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.ITechnologyBookPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.technologyBook.interfaces.ISQLTechnologyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQLTechnologyBookServiceImpl implements ISQLTechnologyBookService {

    @Autowired
    ITechnologyBookPostgreSQLRepository technologyBookPostgreSQLRepository;

   List<SQLTechnologyBook> list = new ArrayList<>(
            Arrays.asList(
                    new SQLTechnologyBook(1, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Bovtanka from acne", ExtemporalMethod.DILUTION, "14 days"),
                    new SQLTechnologyBook(2, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Antifungal solution", ExtemporalMethod.DILUTION, "1 days"),
                    new SQLTechnologyBook(3, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Vidal milk", ExtemporalMethod.DISPERSING, "5 days"),
                    new SQLTechnologyBook(4, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Castellani liquid", ExtemporalMethod.EMULSIFYING, "2 days"),
                    new SQLTechnologyBook(5, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Deflagyl ointment", ExtemporalMethod.FILTERING, "4 days"),
                    new SQLTechnologyBook(6, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Dill water", ExtemporalMethod.HEATING, "6 days"),
                    new SQLTechnologyBook(7, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Ethacridine lactate", ExtemporalMethod.MIXING, "1 days"),
                    new SQLTechnologyBook(8, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Potassium iodide eye drops", ExtemporalMethod.SWELLING, "3 days"),
                    new SQLTechnologyBook(9, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Xeroform powder", ExtemporalMethod.DISSOLVING, "2 days"),
                    new SQLTechnologyBook(10, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Kolargol solution", ExtemporalMethod.DILUTION, "5 days"),
                    new SQLTechnologyBook(11, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Methylene blue", ExtemporalMethod.DISPERSING, "2 days"),
                    new SQLTechnologyBook(12, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Ointment from hemorrhoids", ExtemporalMethod.EMULSIFYING, "4 days"),
                    new SQLTechnologyBook(13, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Soothing balm AMA", ExtemporalMethod.FILTERING, "6 days"),
                    new SQLTechnologyBook(14, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Ointment from calluses No. 2", ExtemporalMethod.HEATING, "3 days"),
                    new SQLTechnologyBook(15, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Anti-inflammatory gel", ExtemporalMethod.MIXING, "4 days"),
                    new SQLTechnologyBook(16, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Bryonia ointment", ExtemporalMethod.SWELLING, "6 days"),
                    new SQLTechnologyBook(17, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Anti-acne lotion", ExtemporalMethod.SWELLING, "2 days"),
                    new SQLTechnologyBook(18, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Homeopathic allergy ointment", ExtemporalMethod.MIXING, "4 days"),
                    new SQLTechnologyBook(19, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Universal homeopathic ointment", ExtemporalMethod.FILTERING, "5 days"),
                    new SQLTechnologyBook(20, LocalDateTime.now(), LocalDateTime.now(), "Technology Book", "Sabadilla AMA", ExtemporalMethod.EMULSIFYING, "2 days")
            )
    );


/*
    @PostConstruct
    void init(){
        technologyBookPostgreSQLRepository.saveAll(list);
    }
*/
    public SQLTechnologyBook create(SQLTechnologyBook technologyBook) {
        return technologyBookPostgreSQLRepository.save(technologyBook);
    }

    public SQLTechnologyBook get(Integer id) {
        return technologyBookPostgreSQLRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("Not found technology with id = " + id));
    }


    public SQLTechnologyBook update(SQLTechnologyBook technologyBook) {
        return technologyBookPostgreSQLRepository.save(technologyBook);
    }

    public void delete(Integer id) {
        if (!technologyBookPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found technology with id = " + id);
        }
        technologyBookPostgreSQLRepository.deleteById(id);
    }

    public List<SQLTechnologyBook> getAll() {
        return
                technologyBookPostgreSQLRepository.findAll();
    }




    public List<SQLTechnologyBook> sortNameAsce() {
        return technologyBookPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "type"));
    }

    public List<SQLTechnologyBook> sortNameDsce() {
        return technologyBookPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "type"));
    }


    public List<SQLTechnologyBook> sortCreatedAtAsce() {
        return technologyBookPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public List<SQLTechnologyBook> sortCreatedAtDsce() {
        return technologyBookPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<SQLTechnologyBook> sortUpdatedAtAsce() {
        return technologyBookPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }

    public List<SQLTechnologyBook> sortUpdatedAtDsce() {
        return technologyBookPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }
    public List<SQLTechnologyBook> sortMethodDISSOLVING() {
        return technologyBookPostgreSQLRepository.sortMethodDISSOLVING();
    }
    public List<SQLTechnologyBook> sortMethodSWELLING() {
        return technologyBookPostgreSQLRepository.sortMethodSWELLING();
    }
    public List<SQLTechnologyBook> sortMethodHEATING() {
        return technologyBookPostgreSQLRepository.sortMethodHEATING();
    }

    public List<SQLTechnologyBook> sortMethodDILUTION() {
        return technologyBookPostgreSQLRepository.sortMethodDILUTION();
    }

    public List<SQLTechnologyBook> sortMethodFILTERING() {
        return technologyBookPostgreSQLRepository.sortMethodFILTERING();
    }

    public List<SQLTechnologyBook> sortMethodEMULSIFYING() {
        return technologyBookPostgreSQLRepository.sortMethodEMULSIFYING();
    }
    public List<SQLTechnologyBook> sortMethodDISPERSING() {
        return technologyBookPostgreSQLRepository.sortMethodDISPERSING();
    }

    public List<SQLTechnologyBook> sortMethodMIXING() {
        return technologyBookPostgreSQLRepository.sortMethodMIXING();
    }

    public List<SQLTechnologyBook> search(String word) {
        return this.getAll().stream()
                .filter(technologyBook -> technologyBook.getType().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }


}
