import org.junit.Test;

/**
 * Created by Genius on 2016-09-11.
 */

public class AntPath {
    @Test
    public void splitOaPhone() {
       // String noStr = "33-786100593";
        String noStr = "33-786100593";
        if(noStr != null) {
            String[] phones = noStr.split("-");

            String arr1 = phones[0];
            String arr2 = phones[1].substring(0, 3);
            String arr3 = phones[1].substring(3, 7);
            String arr4 = phones[1].substring(7, phones[1].length());
            System.out.println(arr1 + " " + arr2 + " " + arr3 + " " + arr4);
            noStr =arr1 + "-" + arr2 + "-" + arr3 + "-" + arr4;
            System.out.println(noStr);
        }
    }
}
