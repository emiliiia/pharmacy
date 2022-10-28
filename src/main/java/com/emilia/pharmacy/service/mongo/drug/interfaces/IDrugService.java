package com.emilia.pharmacy.service.mongo.drug.interfaces;
/*
 * Interface IDrugService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.mongo.Drug;

import java.time.LocalDate;
import java.util.List;

public interface IDrugService {
    Drug create(Drug extemporalDrug);
    Drug get(String id);
    List<Drug> getAll();
    Drug update(Drug extemporalDrug);
    void delete(String id);

    List<Drug> search(String word, List<Drug> list);

    List<Drug> sortExtemporal();
    List<Drug> sortOfficinal();

    List<Drug> sortNameAsce();
    List<Drug> sortNameDsce();
    List<Drug> sortCreatedAtAsce();
    List<Drug> sortCreatedAtDsce();
    List<Drug> sortUpdatedAtAsce();
    List<Drug> sortUpdatedAtDsce();

    List<Drug> sortExtemporalNameAsce();
    List<Drug> sortExtemporalNameDsce();
    List<Drug> sortExtemporalCreatedAtAsce();
    List<Drug> sortExtemporalCreatedAtDsce();
    List<Drug> sortExtemporalUpdatedAtAsce();
    List<Drug> sortExtemporalUpdatedAtDsce();

    List<Drug> sortOfficinalNameAsce();
    List<Drug> sortOfficinalNameDsce();
    List<Drug> sortOfficinalCreatedAtAsce();
    List<Drug> sortOfficinalCreatedAtDsce();
    List<Drug> sortOfficinalUpdatedAtAsce();
    List<Drug> sortOfficinalUpdatedAtDsce();

    List<Drug> sortUseExternal();
    List<Drug> sortUseInternal();
    List<Drug> sortUseExInternal();
    List<Drug> sortUseMix();

    List<Drug> sortExtemporalUseExternal();
    List<Drug> sortExtemporalUseInternal();
    List<Drug> sortExtemporalUseExInternal();
    List<Drug> sortExtemporalUseMix();

    List<Drug> sortOfficinalUseExternal();
    List<Drug> sortOfficinalUseInternal();
    List<Drug> sortOfficinalUseExInternal();
    List<Drug> sortOfficinalUseMix();

    List<Drug> sortFormTablets();
    List<Drug> sortFormOintment();
    List<Drug> sortFormPotion();
    List<Drug> sortFormAQUA();
    List<Drug> sortFormFlour();
    List<Drug> sortFormTincture();

    List<Drug> sortExtemporalFormTablets();
    List<Drug> sortExtemporalFormOintment();
    List<Drug> sortExtemporalFormPotion();
    List<Drug> sortExtemporalFormAQUA();
    List<Drug> sortExtemporalFormFlour();
    List<Drug> sortExtemporalFormTincture();

    List<Drug> sortOfficinalFormTablets();
    List<Drug> sortOfficinalFormOintment();
    List<Drug> sortOfficinalFormTincture();

    List<Drug> sortOfficinalInStockAsce();
    List<Drug> sortOfficinalInStockDsce();

    List<Drug> sortOfficinalInStockAsceUseInternal();
    List<Drug> sortOfficinalInStockAsceUseExternal();
    List<Drug> sortOfficinalInStockAsceUseExternalInternal();
    List<Drug> sortOfficinalInStockAsceUseMix();

    List<Drug> sortOfficinalInStockDsceUseInternal();
    List<Drug> sortOfficinalInStockDsceUseExternal();
    List<Drug> sortOfficinalInStockDsceUseExternalInternal();
    List<Drug> sortOfficinalInStockDsceUseMix();

    List<Drug> sortOfficinalInStockAsceFormTablets();
    List<Drug> sortOfficinalInStockAsceFormOintment();
    List<Drug> sortOfficinalInStockAsceFormTincture();

    List<Drug> sortOfficinalInStockDsceFormTablets();
    List<Drug> sortOfficinalInStockDsceFormOintment();
    List<Drug> sortOfficinalInStockDsceFormTincture();

    List<Drug> expireDrugs(LocalDate date);
}
