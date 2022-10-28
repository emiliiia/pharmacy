package com.emilia.pharmacy.service.sql.manufacturer.impls;

/*
  @author emilia
  @project pharmacy
  @className ManufacturerServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLManufacturer;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IManufacturerPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.manufacturer.interfaces.ISQLManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SQLManufacturerServiceImpl implements ISQLManufacturerService {

    List<SQLManufacturer> list = new ArrayList<>(
            Arrays.asList(
                    new SQLManufacturer(1, LocalDateTime.now(), LocalDateTime.now(), "Manufacturer", "Pfizer", "Harpko Anna", "+380606978452", "USA")
            )
    );

    @Autowired
    IManufacturerPostgreSQLRepository manufacturerPostgreSQLRepository;
/*
    @PostConstruct
    void init(){
        manufacturerPostgreSQLRepository.saveAll(list);
    }
*/

    public SQLManufacturer create(SQLManufacturer manufacturer) {
        return manufacturerPostgreSQLRepository.save(manufacturer);
    }


    public SQLManufacturer get(Integer id) {
        return manufacturerPostgreSQLRepository.findById(id).orElseThrow( () -> new ApiRequestException("Not found manufacturer with id = " + id));
    }

    public SQLManufacturer update(SQLManufacturer manufacturer) {
        return manufacturerPostgreSQLRepository.save(manufacturer);
    }


    public void delete(Integer id) {
        if (!manufacturerPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found manufacturer with id = " + id);
        }
        manufacturerPostgreSQLRepository.deleteById(id);
    }


    public List<SQLManufacturer> getAll() {
        return
                manufacturerPostgreSQLRepository.findAll();
    }



    public List<SQLManufacturer> sortManufacturerDsce() {
        return
                manufacturerPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "manufacturerName"));
    }
    public List<SQLManufacturer> sortManufacturerAsce() {
        return
                manufacturerPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "manufacturerName"));
    }

    public List<SQLManufacturer> sortCreatedAtAsce() {
        return
                manufacturerPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }
    public List<SQLManufacturer> sortCreatedAtDsce() {
        return
                manufacturerPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }
    public List<SQLManufacturer> sortUpdatedAtAsce() {
        return
                manufacturerPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }
    public List<SQLManufacturer> sortUpdatedAtDsce() {
        return
                manufacturerPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }



    public List<SQLManufacturer> search(String word) {
        return this.getAll().stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLManufacturer> searchByCompanyName(String word, List<SQLManufacturer> list) {
        return list.stream()
                .filter(manufacturer -> manufacturer.getManufacturerName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLManufacturer> searchByAgentName(String word, List<SQLManufacturer> list) {
        return list.stream()
                .filter(manufacturer -> manufacturer.getAgentName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLManufacturer> searchByCountry(String word, List<SQLManufacturer> list) {
        return list.stream()
                .filter(manufacturer -> manufacturer.getCountry().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
