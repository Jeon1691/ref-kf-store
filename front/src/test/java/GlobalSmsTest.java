import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class GlobalSmsTest {
    @Test
    public void globalSmsTest() {
        String phoneNumber = "82-010-8181-1891";
        String countryCode = "82";
        String[] phoneNumArr = null;

        //01011112222
        //010-1111-2222
        //82-10-2222-3333
        //82-010-2222-3333
        //61-1111-2222-15

        if(StringUtils.isNotEmpty(phoneNumber)) {
            phoneNumArr = phoneNumber.split("-");
            // 해외 및 국내 문자 발송 ex:) 82-10-1111-2222 , 61-1111-2222-15
            if (phoneNumArr != null && phoneNumArr.length > 3) {
                phoneNumber = "";
                countryCode = phoneNumArr[0];
                for (int i = 1; i < phoneNumArr.length; i++) {
                    phoneNumber += phoneNumArr[i];
                }
            } else if (!phoneNumber.startsWith("0")) {    // 기존 국내 문자 발송 소스
                phoneNumber = "0" + phoneNumber.substring(phoneNumber.indexOf("-") + 1);
            }
        }

        System.out.println(countryCode + "       !!!!!!!!!         " + phoneNumber);

//        String countryCode = "kwr";
//
//        Locale currentLocale = LocaleContextHolder.getLocale();
//
//        if(org.apache.commons.lang.StringUtils.isNotEmpty(countryCode) && !countryCode.equalsIgnoreCase("KR")) {
//            currentLocale = Locale.forLanguageTag("en-US");
//        }
//
//        System.out.println(currentLocale);
//        System.out.println();
    }

}
