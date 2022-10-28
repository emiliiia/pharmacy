package com.emilia.pharmacy.service.sql.order.interfaces;
/*
 * Interface ISQLOrderService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.sql.SQLOrder;

import java.time.LocalDate;
import java.util.List;

public interface ISQLOrderService {
    SQLOrder create(SQLOrder requestComponent);
    SQLOrder get(Integer id);
    List<SQLOrder> getAll();
    SQLOrder update(SQLOrder order);
    void delete(Integer id);

    List<SQLOrder> sortStatusPendingInProgress();

    List<SQLOrder> sortNameAsce();
    List<SQLOrder> sortNameDsce();
    List<SQLOrder> sortCreatedAtAsce();
    List<SQLOrder> sortCreatedAtDsce();
    List<SQLOrder> sortUpdatedAtAsce();
    List<SQLOrder> sortUpdatedAtDsce();
    List<SQLOrder> sortOrderGoAsce();
    List<SQLOrder> sortOrderGoDsce();
    List<SQLOrder> sortStatusInprogress();
    List<SQLOrder> sortStatusGone();
    List<SQLOrder> sortStatusPending();
    List<SQLOrder> sortPriceAsce();
    List<SQLOrder> sortPriceDsce();
    List<SQLOrder> sortQuantityAsce();
    List<SQLOrder> sortQuantityDsce();


    List<SQLOrder> sortExtemporalNameAsce();
    List<SQLOrder> sortExtemporalNameDsce();
    List<SQLOrder> sortExtemporalCreatedAtAsce();
    List<SQLOrder> sortExtemporalCreatedAtDsce();
    List<SQLOrder> sortExtemporalUpdatedAtAsce();
    List<SQLOrder> sortExtemporalUpdatedAtDsce();
    List<SQLOrder> sortExtemporalOrderGoAsce();
    List<SQLOrder> sortExtemporalOrderGoDsce();
    List<SQLOrder> sortExtemporalStatusInprogress();
    List<SQLOrder> sortExtemporalStatusGone();
    List<SQLOrder> sortExtemporalStatusPending();
    List<SQLOrder> sortExtemporalPriceAsce();
    List<SQLOrder> sortExtemporalPriceDsce();
    List<SQLOrder> sortExtemporalQuantityAsce();
    List<SQLOrder> sortExtemporalQuantityDsce();

    List<SQLOrder> sortOfficinalNameAsce();
    List<SQLOrder> sortOfficinalNameDsce();
    List<SQLOrder> sortOfficinalCreatedAtAsce();
    List<SQLOrder> sortOfficinalCreatedAtDsce();
    List<SQLOrder> sortOfficinalUpdatedAtAsce();
    List<SQLOrder> sortOfficinalUpdatedAtDsce();
    List<SQLOrder> sortOfficinalOrderGoAsce();
    List<SQLOrder> sortOfficinalOrderGoDsce();
    List<SQLOrder> sortOfficinalPriceAsce();
    List<SQLOrder> sortOfficinalPriceDsce();
    List<SQLOrder> sortOfficinalQuantityAsce();
    List<SQLOrder> sortOfficinalQuantityDsce();

    List<SQLOrder> sortExtemporal();
    List<SQLOrder> sortOfficinal();

    List<SQLOrder> terminateOrders(LocalDate date);

    List<SQLOrder> sortClientWaitClientNameAsce();
    List<SQLOrder> sortClientWaitClientNameDsce();
    List<SQLOrder> sortClientWaitDrugNameAsce();
    List<SQLOrder> sortClientWaitDrugNameDsce();
    List<SQLOrder> sortClientWaitUseExternal();
    List<SQLOrder> sortClientWaitUseInternal();
    List<SQLOrder> sortClientWaitUseExternalInternal();
    List<SQLOrder> sortClientWaitUseMix();
    List<SQLOrder> sortClientWaitFormTablets();
    List<SQLOrder> sortClientWaitFormOintment();
    List<SQLOrder> sortClientWaitFormPotion();
    List<SQLOrder> sortClientWaitFormAqua();
    List<SQLOrder> sortClientWaitFormFlour();
    List<SQLOrder> sortClientWaitFormTincture();

    List<SQLOrder> sortUseExternal();
    List<SQLOrder> sortUseInternal();
    List<SQLOrder> sortUseExternalInternal();
    List<SQLOrder> sortUseMix();

    List<SQLOrder> sortFormTablets();
    List<SQLOrder> sortFormOintment();
    List<SQLOrder> sortFormPotion();
    List<SQLOrder> sortFormAqua();
    List<SQLOrder> sortFormFlour();
    List<SQLOrder> sortFormTincture();

    List<SQLOrder> dateRange(LocalDate from, LocalDate to);
    List<SQLOrder> extemporalDateRange(LocalDate from, LocalDate to);
    List<SQLOrder> officinalDateRange(LocalDate from, LocalDate to);
}
