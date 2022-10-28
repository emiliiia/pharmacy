package com.emilia.pharmacy.service.sql.drug.interfaces;
/*
 * Interface IDrugService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.sql.SQLDrug;

import java.time.LocalDate;
import java.util.List;

public interface ISQLDrugService {
    SQLDrug create(SQLDrug extemporalDrug);
    SQLDrug get(Integer id);
    List<SQLDrug> getAll();
    SQLDrug update(SQLDrug extemporalDrug);
    void delete(Integer id);

    List<SQLDrug> search(String word, List<SQLDrug> list);

    List<SQLDrug> sortExtemporal();
    List<SQLDrug> sortOfficinal();

    List<SQLDrug> sortNameAsce();
    List<SQLDrug> sortNameDsce();
    List<SQLDrug> sortCreatedAtAsce();
    List<SQLDrug> sortCreatedAtDsce();
    List<SQLDrug> sortUpdatedAtAsce();
    List<SQLDrug> sortUpdatedAtDsce();

    List<SQLDrug> sortExtemporalNameAsce();
    List<SQLDrug> sortExtemporalNameDsce();
    List<SQLDrug> sortExtemporalCreatedAtAsce();
    List<SQLDrug> sortExtemporalCreatedAtDsce();
    List<SQLDrug> sortExtemporalUpdatedAtAsce();
    List<SQLDrug> sortExtemporalUpdatedAtDsce();

    List<SQLDrug> sortOfficinalNameAsce();
    List<SQLDrug> sortOfficinalNameDsce();
    List<SQLDrug> sortOfficinalCreatedAtAsce();
    List<SQLDrug> sortOfficinalCreatedAtDsce();
    List<SQLDrug> sortOfficinalUpdatedAtAsce();
    List<SQLDrug> sortOfficinalUpdatedAtDsce();

    List<SQLDrug> sortUseExternal();
    List<SQLDrug> sortUseInternal();
    List<SQLDrug> sortUseExInternal();
    List<SQLDrug> sortUseMix();

    List<SQLDrug> sortExtemporalUseExternal();
    List<SQLDrug> sortExtemporalUseInternal();
    List<SQLDrug> sortExtemporalUseExInternal();
    List<SQLDrug> sortExtemporalUseMix();

    List<SQLDrug> sortOfficinalUseExternal();
    List<SQLDrug> sortOfficinalUseInternal();
    List<SQLDrug> sortOfficinalUseExInternal();
    List<SQLDrug> sortOfficinalUseMix();

    List<SQLDrug> sortFormTablets();
    List<SQLDrug> sortFormOintment();
    List<SQLDrug> sortFormPotion();
    List<SQLDrug> sortFormAQUA();
    List<SQLDrug> sortFormFlour();
    List<SQLDrug> sortFormTincture();

    List<SQLDrug> sortExtemporalFormTablets();
    List<SQLDrug> sortExtemporalFormOintment();
    List<SQLDrug> sortExtemporalFormPotion();
    List<SQLDrug> sortExtemporalFormAQUA();
    List<SQLDrug> sortExtemporalFormFlour();
    List<SQLDrug> sortExtemporalFormTincture();

    List<SQLDrug> sortOfficinalFormTablets();
    List<SQLDrug> sortOfficinalFormOintment();
    List<SQLDrug> sortOfficinalFormTincture();

    List<SQLDrug> sortOfficinalInStockAsce();
    List<SQLDrug> sortOfficinalInStockDsce();

    List<SQLDrug> sortOfficinalInStockAsceUseInternal();
    List<SQLDrug> sortOfficinalInStockAsceUseExternal();
    List<SQLDrug> sortOfficinalInStockAsceUseExternalInternal();
    List<SQLDrug> sortOfficinalInStockAsceUseMix();

    List<SQLDrug> sortOfficinalInStockDsceUseInternal();
    List<SQLDrug> sortOfficinalInStockDsceUseExternal();
    List<SQLDrug> sortOfficinalInStockDsceUseExternalInternal();
    List<SQLDrug> sortOfficinalInStockDsceUseMix();

    List<SQLDrug> sortOfficinalInStockAsceFormTablets();
    List<SQLDrug> sortOfficinalInStockAsceFormOintment();
    List<SQLDrug> sortOfficinalInStockAsceFormTincture();

    List<SQLDrug> sortOfficinalInStockDsceFormTablets();
    List<SQLDrug> sortOfficinalInStockDsceFormOintment();
    List<SQLDrug> sortOfficinalInStockDsceFormTincture();

    List<SQLDrug> expireDrugs(LocalDate date);
}
