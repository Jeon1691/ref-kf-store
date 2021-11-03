package com.kakaofriends.front.service;

import java.util.List;
import java.util.Map;

/**
 * Created by Dave on 2017. 4. 27..
 */

public interface EmsService {
    Long getEmsPrice(String countryCodeByName, double weight);

    List<Map<String, Object>> getCountryList(String language);

    List<Map<String, Object>> getEmsState();
}
