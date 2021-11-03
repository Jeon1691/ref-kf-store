package com.kakaofriends.front.service.stat;

import com.kakaofriends.front.domain.stat.StatInflowData;
import com.kakaofriends.front.repository.stat.StatRepository;
import com.kakaofriends.front.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StatServiceImpl
 * <p>
 * Author  layla
 * Date    2018. 5. 16.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
public class StatServiceImpl implements StatService {
    private StatRepository statRepository;

    @Override
    public int insert(String site) {
        return statRepository.insert(makeStatInflowData(site));
    }

    /* make statInflowData */
    private StatInflowData makeStatInflowData(String site) {
        DateUtil dateUtil = new DateUtil();

        StatInflowData data = new StatInflowData();
        data.setSite(site);
        data.setIndate(dateUtil.getDateyyyyMMdd());
        data.setIntime(dateUtil.getDateHH());
        return data;
    }
}
