package com.kakaofriends.front.repository.giftcard;

import com.kakaofriends.front.common.annotation.PrimaryMapper;
import com.kakaofriends.front.domain.giftcard.GiftCardMasterData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * GiftCardMasterRepository
 *
 * Author  april
 * Date    2018. 1. 22.
 */
@PrimaryMapper
@Repository
public interface GiftCardMasterRepository {
    GiftCardMasterData select(@Param("giftCardMasterCode") String giftCardMasterCode);
}
