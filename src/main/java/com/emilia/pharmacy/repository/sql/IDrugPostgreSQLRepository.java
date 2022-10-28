package com.emilia.pharmacy.repository.sql;

import com.emilia.pharmacy.entity.sql.SQLDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDrugPostgreSQLRepository extends JpaRepository<SQLDrug, Integer> {
    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug'")
    List<SQLDrug> sortExtemporal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug'")
    List<SQLDrug> sortOfficinal();

    /*************************************/

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.drugName ASC")
    List<SQLDrug> sortExtemporalNameAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.drugName DESC")
    List<SQLDrug> sortExtemporalNameDsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' ORDER BY u.drugName ASC")
    List<SQLDrug> sortOfficinalNameAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' ORDER BY u.drugName DESC")
    List<SQLDrug> sortOfficinalNameDsce();

    /*************************************/

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.createdAt ASC")
    List<SQLDrug> sortExtemporalCreatedAtAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.createdAt DESC")
    List<SQLDrug> sortExtemporalCreatedAtDsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.updatedAt ASC")
    List<SQLDrug> sortExtemporalUpdatedAtAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.updatedAt DESC")
    List<SQLDrug> sortExtemporalUpdatedAtDsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' ORDER BY u.createdAt ASC")
    List<SQLDrug> sortOfficinalCreatedAtAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' ORDER BY u.createdAt DESC")
    List<SQLDrug> sortOfficinalCreatedAtDsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.updatedAt ASC")
    List<SQLDrug> sortOfficinalUpdatedAtAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' ORDER BY u.updatedAt DESC")
    List<SQLDrug> sortOfficinalUpdatedAtDsce();

    /*************************************/
    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.use = 'EXTERNAL'")
    List<SQLDrug> sortExtemporalUseExternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.use = 'INTERNAL'")
    List<SQLDrug> sortExtemporalUseInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.use = 'INTERNALEXTERNAL'")
    List<SQLDrug> sortExtemporalUseExInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.use = 'MIX'")
    List<SQLDrug> sortExtemporalUseMix();

    /*************************************/
    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'EXTERNAL'")
    List<SQLDrug> sortOfficinalUseExternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'INTERNAL'")
    List<SQLDrug> sortOfficinalUseInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'INTERNALEXTERNAL'")
    List<SQLDrug> sortOfficinalUseExInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'MIX'")
    List<SQLDrug> sortOfficinalUseMix();

    /*************************************/
    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.releaseForm = 'TABLETS'")
    List<SQLDrug> sortExtemporalFormTablets();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.releaseForm = 'OINTMENT'")
    List<SQLDrug> sortExtemporalFormOintment();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.releaseForm = 'POTION'")
    List<SQLDrug> sortExtemporalFormPotion();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.releaseForm = 'AQUA'")
    List<SQLDrug> sortExtemporalFormAQUA();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.releaseForm = 'FLOUR'")
    List<SQLDrug> sortExtemporalFormFlour();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Extemporal Drug' AND u.releaseForm = 'TINCTURE'")
    List<SQLDrug> sortExtemporalFormTincture();

    /*************************************/

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'TABLETS'")
    List<SQLDrug> sortOfficinalFormTablets();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'OINTMENT'")
    List<SQLDrug> sortOfficinalFormOintment();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'TINCTURE'")
    List<SQLDrug> sortOfficinalFormTincture();

    /*************************************/

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'INTERNAL' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceUseInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'EXTERNAL' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceUseExternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'INTERNALEXTERNAL' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceUseExternalInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'MIX' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceUseMix();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'TABLETS' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceFormTablets();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'OINTMENT' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceFormOintment();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'TINCTURE' ORDER BY u.officinalInStock ASC")
    List<SQLDrug> sortOfficinalInStockAsceFormTincture();

    /*********************************************/
    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsce();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'INTERNAL' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceUseInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'EXTERNAL' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceUseExternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'INTERNALEXTERNAL' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceUseExternalInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.use = 'MIX' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceUseMix();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'TABLETS' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceFormTablets();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'OINTMENT' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceFormOintment();

    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.releaseForm = 'TINCTURE' ORDER BY u.officinalInStock DESC")
    List<SQLDrug> sortOfficinalInStockDsceFormTincture();

    /*********************************************/

    @Query("SELECT u FROM SQLDrug u WHERE u.releaseForm = 'TABLETS'")
    List<SQLDrug> sortFormTablets();

    @Query("SELECT u FROM SQLDrug u WHERE u.releaseForm = 'OINTMENT'")
    List<SQLDrug> sortFormOintment();

    @Query("SELECT u FROM SQLDrug u WHERE u.releaseForm = 'POTION'")
    List<SQLDrug> sortFormPotion();

    @Query("SELECT u FROM SQLDrug u WHERE u.releaseForm = 'AQUA'")
    List<SQLDrug> sortFormAQUA();

    @Query("SELECT u FROM SQLDrug u WHERE u.releaseForm = 'FLOUR'")
    List<SQLDrug> sortFormFlour();

    @Query("SELECT u FROM SQLDrug u WHERE u.releaseForm = 'TINCTURE'")
    List<SQLDrug> sortFormTincture();

    /*********************************************/

    @Query("SELECT u FROM SQLDrug u WHERE u.use = 'EXTERNAL'")
    List<SQLDrug> sortUseExternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.use = 'INTERNAL'")
    List<SQLDrug> sortUseInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.use = 'INTERNALEXTERNAL'")
    List<SQLDrug> sortUseExInternal();

    @Query("SELECT u FROM SQLDrug u WHERE u.use = 'MIX'")
    List<SQLDrug> sortUseMix();

    /*********************************************/
    @Query("SELECT u FROM SQLDrug u WHERE u.description = 'Officinal Drug' AND u.officinalExpirationDate < ?1")
    List<SQLDrug> expireDrugs(LocalDate date);

}
