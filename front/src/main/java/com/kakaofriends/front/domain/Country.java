package com.kakaofriends.front.domain;

/**
 * Created by Dave on 2017. 4. 27..
 */

public enum  Country {
    Nederland("네덜란드", "Nederland", "NL"),
    Norway("노르웨이", "Norway", "NO"),
    NewZealand("뉴질랜드", "New Zealand", "NZ"),
    Taiwan("대만", "Taiwan", "TW"),
    Germany("독일", "Germany", "DE"),
    Russia("러시아", "Russia", "RU"),
    Macau("마카오", "Macau", "MO"),
    Malaysia("말레이시아", "Malaysia", "MY"),
    Mexico("멕시코", "Mexico", "MX"),
    UnitedStates("미국", "United States", "US"),
    Vietnam("베트남", "Vietnam", "VN"),
    Brazil("브라질", "Brazil", "BR"),
    SaudiArabia("사우디아라비아", "Saudi Arabia", "SA"),
    Sweden("스웨덴", "Sweden", "SE"),
    Spain("스페인", "Spain", "ES"),
    Singapore("싱가포르", "Singapore", "SG"),
    UAE("아랍에미리트", "UAE", "AE"),
    UnitedKingdom("영국", "United Kingdom", "GB"),
    Italy("이탈리아", "Italy", "IT"),
    Indonesia("인도네시아", "Indonesia", "ID"),
    Japan("일본", "Japan", "JP"),
    China("중국", "China", "CN"),
    Canada("캐나다", "Canada", "CA"),
    Thailand("태국", "Thailand", "TH"),
    Turkey("터키", "Turkey", "TR"),
    Poland("폴란드", "Poland", "PL"),
//    France("프랑스", "France", "FR"),
    Philippines("필리핀", "Philippines", "PH"),
    Australia("호주", "Australia", "AU"),
    HongKong("홍콩", "Hong Kong", "HK"),
    Korea("한국", "Korea", "KR"),
    India("인도", "India", "IN"),
    Czech("체코", "Czech", "CZ"),
    Slovakia("슬로바키아", "Slovakia", "SK"),
    Finland("핀란드", "Finland", "FI"),
    Portugal("포르투갈", "Portugal", "PT"),
    Argentina("아르헨티나", "Argentina", "AR"),
    Qatar("카타르", "Qatar", "QA"),
    Austria("오스트리아", "Austria", "AT"),
    Romania("루마니아", "Romania", "RO"),
    Switzerland("스위스", "Switzerland", "CH"),
    Denmark("덴마크", "Denmark", "DK"),
    Chile("칠레", "Chile", "CL"),
    Peru("페루", "Peru", "PE"),
    Laos("라오스", "Laos", "LA"),
    Croatia("크로아티아", "Croatia", "HR"),
    Belgium("벨기에", "Belgium", "BE"),
    Israel("이스라엘", "Israel", "IL"),
    Ireland("아일랜드", "Ireland", "IE"),
    Uzbekistan("우즈베키스탄", "Uzbekistan", "UZ"),
    Morocco("모로코", "Morocco", "MA"),
    Brunei("브루나이", "Brunei", "BN"),
    Myanmar("미얀마", "Myanmar", "MM"),
    Kenya("케냐", "Kenya", "KE");


    final private String name;
    final private String nameEn;
    final private String code;


    Country(String name, String nameEn, String code) {
        this.name = name;
        this.nameEn = nameEn;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getNameEn() {
        return nameEn;
    }

    public static String getCountryCodeByName(String name){
        if(name == null){
            return null;
        }

        for(Country country : Country.values()){
            if(country.getName().equals(name)){
                return country.getCode();
            }
        }

        for(Country country : Country.values()){
            if(country.getNameEn().toLowerCase().equals(name.toLowerCase())){
                return country.getCode();
            }
        }

        return null;
    }

    public static String getCountryNameByCode(String code, String language){
        if(language.equals("kr")){
            for(Country country : Country.values()){
                if(country.getCode().equals(code)){
                    return country.getName();
                }
            }
        }
        else{
            for(Country country : Country.values()){
                if(country.getCode().equals(code)){
                    return country.getNameEn();
                }
            }
        }
        return null;
    }

    /**
     * 국가코드를 받아 국가 enum 을 반환한다.
     *
     * @param code 국가 코드 ex) KR, US ...
     * @return 해당 국가 값
     */
    public static Country getCountry(String code) {
        for (Country country : Country.values()) {
            if (country.getCode().equals(code)) {
                return country;
            }
        }
        return null;
    }

    /**
     * 국내 국가인지 확인한다.
     *
     * @return 국내일 경우 true / 해외일 경우 false
     */
    public boolean isDomestic() {
        return this.equals(Country.Korea);
    }

    /**
     * 국가명을 반환한다.
     * - 한국의 경우 한국어 국가명을 반환한다.
     * - 한국 이외의 국가의 경우 영어 국가명을 반환한다.
     *
     * @return 국가명
     */
    public String getCountryName() {
        if (this.equals(Country.Korea)) {
            return this.getName();
        }
        return this.getNameEn();
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 3. 16.
     *
     * domestic return
     *
     * @return domestic type
     */
    public static boolean isDomestic(Country country) {
        boolean domestic = false;
        if (country != null && country.equals(Country.Korea)) {
            domestic = true;
        }
        return domestic;
    }

    /**
     * 작성자 : layla
     * 날짜 : 2018. 3. 16.
     *
     * domestic return
     *
     * @return domestic type
     */
    public static boolean isDomestic(String countryCode) {
        boolean domestic = false;
        if (countryCode != null && countryCode.equals(Country.Korea.getCode())) {
            domestic = true;
        }
        return domestic;
    }
}
