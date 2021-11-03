package com.kakaofriends.front.domain.stat;

import lombok.Data;

/**
 * StatInflow
 * <p>
 * Author  layla
 * Date    2018. 5. 16.
 */
@Data
public class StatInflowData {
    String site;    //인입경로
    String indate;  //인입날짜
    String intime;  //인입시간
}
