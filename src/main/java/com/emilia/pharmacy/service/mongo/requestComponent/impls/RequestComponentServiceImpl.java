package com.emilia.pharmacy.service.mongo.requestComponent.impls;

import com.emilia.pharmacy.entity.mongo.Component;
import com.emilia.pharmacy.entity.mongo.RequestComponent;
import com.emilia.pharmacy.enums.Status;
import com.emilia.pharmacy.exception.ApiRequestException;
import com.emilia.pharmacy.repository.mongo.IRequestComponentMongoRepository;
import com.emilia.pharmacy.service.mongo.requestComponent.interfaces.IRequestComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
  @author emilia
  @project pharmacy
  @className RequestComponentServiceImp
  @version 1.0.0
  @since 29.06.2022
*/

@Service
public class RequestComponentServiceImpl implements IRequestComponentService {

    List<RequestComponent> list = new ArrayList<>(
            Arrays.asList(
                    new RequestComponent("1", LocalDateTime.now(), LocalDateTime.now(), "Request Component", new Component("8"), 10, Status.INPROGRESS),
                    new RequestComponent("2", LocalDateTime.now(), LocalDateTime.now(), "Request Component", new Component("15"), 10, Status.INPROGRESS),
                    new RequestComponent("3", LocalDateTime.now(), LocalDateTime.now(), "Request Component", new Component("16"), 10, Status.INPROGRESS),
                    new RequestComponent("4", LocalDateTime.now(), LocalDateTime.now(), "Request Component", new Component("17"), 10, Status.INPROGRESS),
                    new RequestComponent("5", LocalDateTime.now(), LocalDateTime.now(), "Request Component", new Component("18"), 10, Status.INPROGRESS),
                    new RequestComponent("5", LocalDateTime.now(), LocalDateTime.now(), "Request Component", new Component("19"), 10, Status.INPROGRESS)
            )
    );
    @Autowired
    IRequestComponentMongoRepository requestComponentMongoRepository;
/*
    @PostConstruct
    void init(){
        requestComponentMongoRepository.saveAll(list);
    }
*/
    public RequestComponent create(RequestComponent requestComponent) {
        return requestComponentMongoRepository.save(requestComponent);
    }


    public RequestComponent get(String id) {
        return requestComponentMongoRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("Not found request forComponent with id = " + id));
    }

    public RequestComponent update(RequestComponent requestComponent) {
        return requestComponentMongoRepository.save(requestComponent);
    }


    public void delete(String id) {
        if (!requestComponentMongoRepository.existsById(id)) {
            throw new ApiRequestException("CANT DELETE! Not found request for Component with id = " + id);
        }
        requestComponentMongoRepository.deleteById(id);
    }


    public List<RequestComponent> getAll() {
        return
                requestComponentMongoRepository.findAll();
    }

    public List<RequestComponent> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<RequestComponent> pagedResult = requestComponentMongoRepository.findAll(paging);

        return pagedResult.toList();
    }

    public List<RequestComponent> search(String word) {
        return this.getAll().stream()
                .filter(requestComponent -> requestComponent.getComponentName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<RequestComponent> sortByNameAsce() {
        return this.getAll().stream().sorted(Comparator.comparing(RequestComponent::getComponentName))
                .collect(Collectors.toList());
    }

    public List<RequestComponent> sortByNameDsce() {
        return this.getAll().stream().sorted(Comparator.comparing(RequestComponent::getComponentName).reversed())
                .collect(Collectors.toList());
    }

    public List<RequestComponent> sortCreatedAtAsce() {
        return requestComponentMongoRepository.sortCreatedAtAsce();
    }

    public List<RequestComponent> sortCreatedAtDsce() {
        return requestComponentMongoRepository.sortCreatedAtDsce();
    }

    public List<RequestComponent> sortUpdatedAtAsce() {
        return requestComponentMongoRepository.sortUpdatedAtAsce();
    }

    public List<RequestComponent> sortUpdatedAtDsce() {
        return requestComponentMongoRepository.sortUpdatedAtDsce();
    }

    public List<RequestComponent> sortStatusInprogress() {
        return requestComponentMongoRepository.sortStatusInprogress();
    }

    public List<RequestComponent> sortStatusGotten() {
        return requestComponentMongoRepository.sortStatusGotten();
    }



}
