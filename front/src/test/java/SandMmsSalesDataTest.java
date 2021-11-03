import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Dave on 2017. 7. 5..
 */
public class SandMmsSalesDataTest {

    public static void main(String [] args){
//        String localhost = null;
//
//        try {
//            localhost = InetAddress.getLocalHost().toString();
//        } catch (UnknownHostException var9) {
//            var9.printStackTrace();
//        }
//
//        if(localhost == null || !"localhost".equals(localhost))
//            return;


        SimpleDateFormat format = new SimpleDateFormat("HH");
        long time = Long.parseLong(format.format(new Date()));

        StringBuilder date = new StringBuilder();
        Calendar calendar = new GregorianCalendar();
        if(time == 0){
            calendar.add(Calendar.DATE, -1);
            date.append(calendar.get(Calendar.YEAR)).append("-").append(calendar.get(Calendar.MONTH) + 1).append("-").append(calendar.get(Calendar.DAY_OF_MONTH));
        }else{
            date.append(calendar.get(Calendar.YEAR)).append("-").append((calendar.get(Calendar.MONTH) +1 )).append("-").append(calendar.get(Calendar.DAY_OF_MONTH));
        }

        System.out.println(date.toString());


        BigDecimal bigDecimal = BigDecimal.valueOf(1000000000);
        DecimalFormat df = new DecimalFormat("#,###");
        df.format(bigDecimal);

        System.out.println(df.format(bigDecimal));


    }
}
