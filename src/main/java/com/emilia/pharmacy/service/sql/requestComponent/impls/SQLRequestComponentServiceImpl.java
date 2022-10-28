package com.emilia.pharmacy.service.sql.requestComponent.impls;
/*
  @author emilia
  @project pharmacy
  @className RequestComponentServiceImpl
  @version 1.0.0
  @since 12.08.2022
*/

import com.emilia.pharmacy.entity.sql.SQLRequestComponent;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.sql.IRequestComponentPostgreSQLRepository;
import com.emilia.pharmacy.service.sql.requestComponent.interfaces.ISQLRequestComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SQLRequestComponentServiceImpl implements ISQLRequestComponentService {
    @Autowired
    IRequestComponentPostgreSQLRepository requestComponentPostgreSQLRepository;

    public SQLRequestComponent create(SQLRequestComponent requestComponent) {
        return requestComponentPostgreSQLRepository.save(requestComponent);
    }


    public SQLRequestComponent get(Integer id) {
        return requestComponentPostgreSQLRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("Not found request forComponent with id = " + id));
    }

    public SQLRequestComponent update(SQLRequestComponent requestComponent) {
        return requestComponentPostgreSQLRepository.save(requestComponent);
    }


    public void delete(Integer id) {
        if (!requestComponentPostgreSQLRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found request for Component with id = " + id);
        }
        requestComponentPostgreSQLRepository.deleteById(id);
    }


    public List<SQLRequestComponent> getAll() {
        return
                requestComponentPostgreSQLRepository.findAll();
    }

    public List<SQLRequestComponent> search(String word) {
        return this.getAll().stream()
                .filter(requestComponent -> requestComponent.getComponentName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<SQLRequestComponent> sortByNameAsce() {
        return this.getAll().stream().sorted(Comparator.comparing(SQLRequestComponent::getComponentName))
                .collect(Collectors.toList());
    }

    public List<SQLRequestComponent> sortByNameDsce() {
        return this.getAll().stream().sorted(Comparator.comparing(SQLRequestComponent::getComponentName).reversed())
                .collect(Collectors.toList());
    }

    public List<SQLRequestComponent> sortCreatedAtAsce() {
        return requestComponentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "createdAt"));
    }

    public List<SQLRequestComponent> sortCreatedAtDsce() {
        return requestComponentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public List<SQLRequestComponent> sortUpdatedAtAsce() {
        return requestComponentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.ASC, "updatedAt"));
    }

    public List<SQLRequestComponent> sortUpdatedAtDsce() {
        return requestComponentPostgreSQLRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt"));
    }

    public List<SQLRequestComponent> sortStatusInprogress() {
        return requestComponentPostgreSQLRepository.sortStatusInprogress();
    }

    public List<SQLRequestComponent> sortStatusGotten() {
        return requestComponentPostgreSQLRepository.sortStatusGotten();
    }
}
