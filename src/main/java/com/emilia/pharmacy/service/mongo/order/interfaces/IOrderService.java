package com.emilia.pharmacy.service.mongo.order.interfaces;
/*
 * Interface IExtemporalOrderService
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */
import com.emilia.pharmacy.entity.mongo.Order;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {
    Order create(Order requestComponent);
    Order get(String id);
    List<Order> getAll();
    Order update(Order extemporalOrder);
    void delete(String id);

    List<Order> sortStatusPendingInProgress();

    List<Order> sortNameAsce();
    List<Order> sortNameDsce();
    List<Order> sortCreatedAtAsce();
    List<Order> sortCreatedAtDsce();
    List<Order> sortUpdatedAtAsce();
    List<Order> sortUpdatedAtDsce();
    List<Order> sortOrderGoAsce();
    List<Order> sortOrderGoDsce();
    List<Order> sortStatusInprogress();
    List<Order> sortStatusGone();
    List<Order> sortStatusPending();
    List<Order> sortPriceAsce();
    List<Order> sortPriceDsce();
    List<Order> sortQuantityAsce();
    List<Order> sortQuantityDsce();


    List<Order> sortExtemporalNameAsce();
    List<Order> sortExtemporalNameDsce();
    List<Order> sortExtemporalCreatedAtAsce();
    List<Order> sortExtemporalCreatedAtDsce();
    List<Order> sortExtemporalUpdatedAtAsce();
    List<Order> sortExtemporalUpdatedAtDsce();
    List<Order> sortExtemporalOrderGoAsce();
    List<Order> sortExtemporalOrderGoDsce();
    List<Order> sortExtemporalStatusInprogress();
    List<Order> sortExtemporalStatusGone();
    List<Order> sortExtemporalStatusPending();
    List<Order> sortExtemporalPriceAsce();
    List<Order> sortExtemporalPriceDsce();
    List<Order> sortExtemporalQuantityAsce();
    List<Order> sortExtemporalQuantityDsce();

    List<Order> sortOfficinalNameAsce();
    List<Order> sortOfficinalNameDsce();
    List<Order> sortOfficinalCreatedAtAsce();
    List<Order> sortOfficinalCreatedAtDsce();
    List<Order> sortOfficinalUpdatedAtAsce();
    List<Order> sortOfficinalUpdatedAtDsce();
    List<Order> sortOfficinalOrderGoAsce();
    List<Order> sortOfficinalOrderGoDsce();
    List<Order> sortOfficinalPriceAsce();
    List<Order> sortOfficinalPriceDsce();
    List<Order> sortOfficinalQuantityAsce();
    List<Order> sortOfficinalQuantityDsce();

    List<Order> sortExtemporal();
    List<Order> sortOfficinal();

    List<Order> terminateOrders(LocalDate date);

    List<Order> sortClientWaitClientNameAsce();
    List<Order> sortClientWaitClientNameDsce();
    List<Order> sortClientWaitDrugNameAsce();
    List<Order> sortClientWaitDrugNameDsce();
    List<Order> sortClientWaitUseExternal();
    List<Order> sortClientWaitUseInternal();
    List<Order> sortClientWaitUseExternalInternal();
    List<Order> sortClientWaitUseMix();
    List<Order> sortClientWaitFormTablets();
    List<Order> sortClientWaitFormOintment();
    List<Order> sortClientWaitFormPotion();
    List<Order> sortClientWaitFormAqua();
    List<Order> sortClientWaitFormFlour();
    List<Order> sortClientWaitFormTincture();

    List<Order> sortUseExternal();
    List<Order> sortUseInternal();
    List<Order> sortUseExternalInternal();
    List<Order> sortUseMix();

    List<Order> sortFormTablets();
    List<Order> sortFormOintment();
    List<Order> sortFormPotion();
    List<Order> sortFormAqua();
    List<Order> sortFormFlour();
    List<Order> sortFormTincture();

    List<Order> dateRange(LocalDate from, LocalDate to);
    List<Order> extemporalDateRange(LocalDate from, LocalDate to);
    List<Order> officinalDateRange(LocalDate from, LocalDate to);
}
