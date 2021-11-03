package com.kakaofriends.front.domain.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * CountryVO
 *
 * Author  layla
 * Date    2018. 01. 10.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountryVO implements Serializable {
    private String countryCode;
    private List<Map<String, Object>> countryList;
    private List<Map<String, Object>> usStateList;
}
