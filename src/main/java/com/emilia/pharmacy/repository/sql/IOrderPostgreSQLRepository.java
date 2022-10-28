package com.emilia.pharmacy.repository.sql;
/*
 * Interface IOrderPostgreSQLRepository
 * Author Emiliia Drahomyretska
 * PZKS, Department CS
 * Copyright notice
 */

import com.emilia.pharmacy.entity.sql.SQLOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IOrderPostgreSQLRepository extends JpaRepository<SQLOrder, Integer> {
    @Query("SELECT u FROM SQLOrder u WHERE u.orderStatus = 'INPROGRESS'")
    List<SQLOrder> sortStatusInprogress();

    @Query("SELECT u FROM SQLOrder u WHERE u.orderStatus = 'GONE'")
    List<SQLOrder> sortStatusGone();

    @Query("SELECT u FROM SQLOrder u WHERE u.orderStatus = 'PENDING'")
    List<SQLOrder> sortStatusPending();

    @Query("SELECT u FROM SQLOrder u WHERE u.orderStatus = 'INPROGRESS' AND u.orderStatus = 'PENDING'")
    List<SQLOrder> sortStatusPendingInProgress();

    /***********************/
    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order'")
    List<SQLOrder> sortOfficinal();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order'")
    List<SQLOrder> sortExtemporal();

    /*************************************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.drugId.drugName ASC")
    List<SQLOrder> sortExtemporalNameAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.drugId.drugName DESC")
    List<SQLOrder> sortExtemporalNameDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.drugId.drugName ASC")
    List<SQLOrder> sortOfficinalNameAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.drugId.drugName DESC")
    List<SQLOrder> sortOfficinalNameDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.createdAt ASC")
    List<SQLOrder> sortExtemporalCreatedAtAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.createdAt DESC")
    List<SQLOrder> sortExtemporalCreatedAtDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.createdAt ASC")
    List<SQLOrder> sortOfficinalCreatedAtAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.createdAt DESC")
    List<SQLOrder> sortOfficinalCreatedAtDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.updatedAt ASC")
    List<SQLOrder> sortExtemporalUpdatedAtAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.updatedAt DESC")
    List<SQLOrder> sortExtemporalUpdatedAtDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.updatedAt ASC")
    List<SQLOrder> sortOfficinalUpdatedAtAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.updatedAt DESC")
    List<SQLOrder> sortOfficinalUpdatedAtDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.orderGo ASC")
    List<SQLOrder> sortExtemporalOrderGoAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.orderGo DESC")
    List<SQLOrder> sortExtemporalOrderGoDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.orderGo ASC")
    List<SQLOrder> sortOfficinalOrderGoAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.orderGo DESC")
    List<SQLOrder> sortOfficinalOrderGoDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'INPROGRESS'")
    List<SQLOrder> sortExtemporalStatusInprogress();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'GONE'")
    List<SQLOrder> sortExtemporalStatusGone();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING'")
    List<SQLOrder> sortExtemporalStatusPending();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING'")
    List<SQLOrder> sortExtemporalStatusPendingInProgress();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.price ASC")
    List<SQLOrder> sortExtemporalPriceAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.price DESC")
    List<SQLOrder> sortExtemporalPriceDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.price ASC")
    List<SQLOrder> sortOfficinalPriceAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.price DESC")
    List<SQLOrder> sortOfficinalPriceDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.drugQuantity ASC")
    List<SQLOrder> sortExtemporalQuantityAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' ORDER BY u.drugQuantity DESC")
    List<SQLOrder> sortExtemporalQuantityDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.drugQuantity ASC")
    List<SQLOrder> sortOfficinalQuantityAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Officinal Order' ORDER BY u.drugQuantity DESC")
    List<SQLOrder> sortOfficinalQuantityDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'INPROGRESS' AND u.orderGo < ?1")
    List<SQLOrder> terminateOrders(LocalDate date);

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING'" +
            "ORDER BY u.clientId.clientName ASC")
    List<SQLOrder> sortClientWaitClientNameAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING'" +
            "ORDER BY u.clientId.clientName DESC")
    List<SQLOrder> sortClientWaitClientNameDsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING'" +
            "ORDER BY u.drugId.drugName ASC")
    List<SQLOrder> sortClientWaitDrugNameAsce();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING'" +
            "ORDER BY u.drugId.drugName DESC")
    List<SQLOrder> sortClientWaitDrugNameDsce();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.use = 'EXTERNAL'")
    List<SQLOrder> sortClientWaitUseExternal();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.use = 'INTERNAL'")
    List<SQLOrder> sortClientWaitUseInternal();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.use = 'INTERNALEXTERNAL'")
    List<SQLOrder> sortClientWaitUseExternalInternal();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.use = 'MIX'")
    List<SQLOrder> sortClientWaitUseMix();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.releaseForm = 'TABLETS'")
    List<SQLOrder> sortClientWaitFormTablets();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.releaseForm = 'OINTMENT'")
    List<SQLOrder> sortClientWaitFormOintment();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.releaseForm = 'POTION'")
    List<SQLOrder> sortClientWaitFormPotion();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.releaseForm = 'AQUA'")
    List<SQLOrder> sortClientWaitFormAqua();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.releaseForm = 'FLOUR'")
    List<SQLOrder> sortClientWaitFormFlour();

    @Query("SELECT u FROM SQLOrder u WHERE u.description = 'Extemporal Order' AND u.orderStatus = 'PENDING' AND u.drugId.releaseForm = 'TINCTURES'")
    List<SQLOrder> sortClientWaitFormTincture();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.use = 'EXTERNAL' ")
    List<SQLOrder> sortUseExternal();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.use = 'INTERNAL' ")
    List<SQLOrder> sortUseInternal();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.use = 'INTERNALEXTERNAL' ")
    List<SQLOrder> sortUseExternalInternal();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.use = 'MIX' ")
    List<SQLOrder> sortUseMix();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.releaseForm = 'TABLETS' ")
    List<SQLOrder> sortFormTablets();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.releaseForm = 'OINTMENT' ")
    List<SQLOrder> sortFormOintment();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.releaseForm = 'POTION' ")
    List<SQLOrder> sortFormPotion();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.releaseForm = 'AQUA' ")
    List<SQLOrder> sortFormAqua();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.releaseForm = 'FLOUR' ")
    List<SQLOrder> sortFormFlour();

    @Query("SELECT u FROM SQLOrder u WHERE u.drugId.releaseForm = 'TINCTURE' ")
    List<SQLOrder> sortFormTincture();

    /***********************/

    @Query("SELECT u FROM SQLOrder u WHERE u.orderGo > ?1 AND u.orderGo < ?2")
    List<SQLOrder> dateRange(LocalDate from, LocalDate to);

    @Query("SELECT u FROM SQLOrder u WHERE u.orderGo > ?1 AND u.orderGo < ?2 AND u.description = 'Extemporal Order'")
    List<SQLOrder> extemporalDateRange(LocalDate from, LocalDate to);

    @Query("SELECT u FROM SQLOrder u WHERE u.orderGo > ?1 AND u.orderGo < ?2 AND u.description = 'Officinal Order'")
    List<SQLOrder> officinalDateRange(LocalDate from, LocalDate to);

}
