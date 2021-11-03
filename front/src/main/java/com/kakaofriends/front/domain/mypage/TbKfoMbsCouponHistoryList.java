package com.kakaofriends.front.domain.mypage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbKfoMbsCouponHistoryList{
    private List<TbKfoMbsCouponHistory> CouponHistoryList;
}
