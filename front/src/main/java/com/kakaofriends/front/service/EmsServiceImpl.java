package com.kakaofriends.front.service;

import com.kakaofriends.front.repository.EmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Dave on 2017. 4. 27..
 */
@Service
public class EmsServiceImpl implements EmsService {

    @Autowired
    private EmsRepository emsRepository;

    @Override
    public Long getEmsPrice(String countryCode, double weight) {
        return emsRepository.getEmsPrice(countryCode, weight);
    }

    @Override
    public List<Map<String, Object>> getCountryList(String language) {
        return emsRepository.getCountryList(language);
    }

    @Override
    public List<Map<String, Object>> getEmsState() {
        return emsRepository.getEmsState();
    }
}
