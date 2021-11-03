package com.kakaofriends.front.service;

import com.kakaofriends.front.domain.Migration;
import com.kakaofriends.front.repository.MigrationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 10.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class MigrationServiceImpl implements MigrationService{
    private MigrationRepository migrationRepository;

    @Transactional
    public void migration(Migration migration){
        if(migrationRepository.isMigration(migration) > 0){
            int result = 0;
            String columnName = "";
            LocalDateTime startTime = LocalDateTime.now();

            log.info("MIGRATION START : " + migration.getTargetId() + " >>> " + migration.getId());
            migrationRepository.beforeMigration(migration);

            // migration address ad_ownerid
            migration.setCount(migrationRepository.migrationAddress(migration));
            migration.setTableName("address");
            migration.setColumnName("ad_ownerid");
            migrationRepository.complete(migration);

            // migration basket  bs_ownerid
            migration.setCount(migrationRepository.migrationBasket(migration));
            migration.setTableName("basket");
            migration.setColumnName("bs_ownerid");
            migrationRepository.complete(migration);

            // migration wishlist ws_ownerid
            migration.setCount(migrationRepository.migrationWishList(migration));
            migration.setTableName("wishlist");
            migration.setColumnName("ws_ownerid");
            migrationRepository.complete(migration);

            // migration wishlist ws_moid
            migration.setCount(migrationRepository.migrationWishListMoId(migration));
            migration.setTableName("wishlist");
            migration.setColumnName("ws_moid");
            migrationRepository.complete(migration);

            // migration wishlist ws_inid
            migration.setCount(migrationRepository.migrationWishListInId(migration));
            migration.setTableName("wishlist");
            migration.setColumnName("ws_inid");
            migrationRepository.complete(migration);

            // migration boardarticle  bda_ownerid
            migration.setCount(migrationRepository.migrationBoardArticle(migration));
            migration.setTableName("boardarticle");
            migration.setColumnName("bda_ownerid");
            migrationRepository.complete(migration);

            // migration memberlogin mbl_mbid
            migration.setCount(migrationRepository.migrationMemberLogin(migration));
            migration.setTableName("memberlogin");
            migration.setColumnName("mbl_mbid");
            migrationRepository.complete(migration);

            // migration orderadddeli od_ownerid
            migration.setCount(migrationRepository.migrationOrderAddDeli(migration));
            migration.setTableName("orderadddeli");
            migration.setColumnName("od_ownerid");
            migrationRepository.complete(migration);

            // migration migrationOrderAddDeli od_moid
            migration.setCount(migrationRepository.migrationOrderAddDeliMoId(migration));
            migration.setTableName("orderadddeli");
            migration.setColumnName("od_moid");
            migrationRepository.complete(migration);

            // migration migrationOrderAddDeli od_inid
            migration.setCount(migrationRepository.migrationOrderAddDeliInId(migration));
            migration.setTableName("orderadddeli");
            migration.setColumnName("od_inid");
            migrationRepository.complete(migration);

            // migration orderaddress oa_moid
            migration.setCount(migrationRepository.migrationOrderAddressMoId(migration));
            migration.setTableName("orderaddress");
            migration.setColumnName("oa_moid");
            migrationRepository.complete(migration);

            // migration orderaddress oa_inid
            migration.setCount(migrationRepository.migrationOrderAddressInId(migration));
            migration.setTableName("orderaddress");
            migration.setColumnName("oa_inid");
            migrationRepository.complete(migration);

            // migration orderaddressmobiletemp oamt_moid
            migration.setCount(migrationRepository.migrationAddressMobileTempMoId(migration));
            migration.setTableName("orderaddressmobiletemp");
            migration.setColumnName("oamt_moid");
            migrationRepository.complete(migration);

            // migration migrationAddressMobileTemp oamt_inid
            migration.setCount(migrationRepository.migrationAddressMobileTempInId(migration));
            migration.setTableName("orderaddressmobiletemp");
            migration.setColumnName("oamt_inid");
            migrationRepository.complete(migration);

            // migration ordermain om_ownerid
            migration.setCount(migrationRepository.migrationOrderMain(migration));
            migration.setTableName("ordermain");
            migration.setColumnName("om_ownerid");
            migrationRepository.complete(migration);

            // migration ordermainmobiletemp ommt_ownerid
            migration.setCount(migrationRepository.migrationOrderMainMobileTemp(migration));
            migration.setTableName("ordermainmobiletemp");
            migration.setColumnName("ommt_ownerid");
            migrationRepository.complete(migration);

            // migration ordermainmobiletemp ommt_moid
            migration.setCount(migrationRepository.migrationOrderMainMobileTempMoId(migration));
            migration.setTableName("ordermainmobiletemp");
            migration.setColumnName("ommt_moid");
            migrationRepository.complete(migration);

            // migration ordermainmobiletemp ommt_inid
            migration.setCount(migrationRepository.migrationOrderMainMobileTempInId(migration));
            migration.setTableName("ordermainmobiletemp");
            migration.setColumnName("ommt_inid");
            migrationRepository.complete(migration);

            // migration ordersub os_ownerid
            migration.setCount(migrationRepository.migrationOrderSub(migration));
            migration.setTableName("ordersub");
            migration.setColumnName("os_ownerid");
            migrationRepository.complete(migration);

            // migration ordersub os_moid
            migration.setCount(migrationRepository.migrationOrderSubMoId(migration));
            migration.setTableName("ordersub");
            migration.setColumnName("os_moid");
            migrationRepository.complete(migration);

            // migration ordersub os_inid
            migration.setCount(migrationRepository.migrationOrderSubInId(migration));
            migration.setTableName("ordersub");
            migration.setColumnName("os_inid");
            migrationRepository.complete(migration);

            // migration ordersub2 os_ownerid
            migration.setCount(migrationRepository.migrationOrderSub2(migration));
            migration.setTableName("ordersub2");
            migration.setColumnName("os_ownerid");
            migrationRepository.complete(migration);

            // migration ordersub2 os_moid
            migration.setCount(migrationRepository.migrationOrderSub2MoId(migration));
            migration.setTableName("ordersub2");
            migration.setColumnName("os_moid");
            migrationRepository.complete(migration);

            // migration ordersub2 os_inid
            migration.setCount(migrationRepository.migrationOrderSub2InId(migration));
            migration.setTableName("ordersub2");
            migration.setColumnName("os_inid");
            migrationRepository.complete(migration);

            // migration ordersubhistory osh_moid
            migration.setCount(migrationRepository.migrationOrderSubHistoryMoId(migration));
            migration.setTableName("ordersubhistory");
            migration.setColumnName("osh_moid");
            migrationRepository.complete(migration);

            // migration ordersubhistory osh_inid
            migration.setCount(migrationRepository.migrationOrderSubHistoryInId(migration));
            migration.setTableName("ordersubhistory");
            migration.setColumnName("osh_inid");
            migrationRepository.complete(migration);

            // migration ordersubmobiletemp osmt_ownerid
            migration.setCount(migrationRepository.migrationOrderSubMobileTemp(migration));
            migration.setTableName("ordersubmobiletemp");
            migration.setColumnName("osmt_ownerid");
            migrationRepository.complete(migration);

            // migration ordersubmobiletemp osmt_moid
            migration.setCount(migrationRepository.migrationOrderSubMobileTempMoId(migration));
            migration.setTableName("ordersubmobiletemp");
            migration.setColumnName("osmt_moid");
            migrationRepository.complete(migration);

            // migration ordersubmobiletemp osmt_inid
            migration.setCount(migrationRepository.migrationOrderSubMobileTempInid(migration));
            migration.setTableName("ordersubmobiletemp");
            migration.setColumnName("osmt_inid");
            migrationRepository.complete(migration);

            // migration sales ss_mbid
            migration.setCount(migrationRepository.migrationSales(migration));
            migration.setTableName("sales");
            migration.setColumnName("ss_mbid");
            migrationRepository.complete(migration);

            // migration kakaopayconfirm kpc_inid
            migration.setCount(migrationRepository.migrationKakaoPayConfirmInId(migration));
            migration.setTableName("kakaopayconfirm");
            migration.setColumnName("kpc_inid");
            migrationRepository.complete(migration);

            LocalDateTime endTime = LocalDateTime.now();
            log.info("MIGRATION END : " + migration.getTargetId() + " >>> " + migration.getId() + " >>>>> " + Duration.between(endTime, startTime));
        }
    }
}
