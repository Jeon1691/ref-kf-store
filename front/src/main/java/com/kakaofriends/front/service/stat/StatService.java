package com.kakaofriends.front.service.stat;

/**
 * StatService
 * <p>
 * Author  layla
 * Date    2018. 5. 16.
 */
public interface StatService {

    /**
     * 유입횟수를 기록한다.
     *
     * @param site 유입경로
     * @return 등록된 데이터의 수
     */
    int insert(String site);
}
