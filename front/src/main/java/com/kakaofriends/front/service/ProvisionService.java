package com.kakaofriends.front.service;

        import com.kakaofriends.front.domain.Provision;
        import org.springframework.dao.DataAccessException;

        import java.util.List;

public interface ProvisionService {
    // 약관 조회. 2017.10.30 Breeze
    Provision get(Provision provision) throws DataAccessException;

    // 최종 버전 약관 전부 가져오기. 2017.10.30 Breeze
    List<Provision> getLatestProvision(Provision provision) throws DataAccessException;
}
