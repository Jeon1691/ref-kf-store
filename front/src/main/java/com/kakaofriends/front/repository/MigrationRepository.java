package com.kakaofriends.front.repository;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.Migration;
import org.springframework.stereotype.Repository;

/**
 * Created by breeze.hwi@kakaocorp.com on 2017. 11. 10.
 */
@PrimaryMapper
@Repository
public interface MigrationRepository {
    int isMigration(Migration migration);

    int beforeMigration(Migration migration);

    int migrationAddress(Migration migration);

    int migrationBasket(Migration migration);

    int migrationWishList(Migration migration);

    int migrationWishListMoId(Migration migration);

    int migrationWishListInId(Migration migration);

    int migrationBoardArticle(Migration migration);

    int migrationMemberLogin(Migration migration);

    int migrationOrderAddDeli(Migration migration);

    int migrationOrderAddDeliMoId(Migration migration);

    int migrationOrderAddDeliInId(Migration migration);

    int migrationOrderAddressMoId(Migration migration);

    int migrationOrderAddressInId(Migration migration);

    int migrationAddressMobileTempMoId(Migration migration);

    int migrationAddressMobileTempInId(Migration migration);

    int migrationOrderMain(Migration migration);

    int migrationOrderMainMobileTemp(Migration migration);

    int migrationOrderMainMobileTempMoId(Migration migration);

    int migrationOrderMainMobileTempInId(Migration migration);

    int migrationOrderSub(Migration migration);

    int migrationOrderSubMoId(Migration migration);

    int migrationOrderSubInId(Migration migration);

    int migrationOrderSub2(Migration migration);

    int migrationOrderSub2MoId(Migration migration);

    int migrationOrderSub2InId(Migration migration);

    int migrationOrderSubHistoryMoId(Migration migration);

    int migrationOrderSubHistoryInId(Migration migration);

    int migrationOrderSubMobileTemp(Migration migration);

    int migrationOrderSubMobileTempMoId(Migration migration);

    int migrationOrderSubMobileTempInid(Migration migration);

    int migrationSales(Migration migration);

    int migrationKakaoPayConfirmInId(Migration migration);

    int complete(Migration migration);
}
