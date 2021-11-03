import com.kakaofriends.front.common.configuration.*;
import com.kakaofriends.front.repository.MyPointRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by eunduck on 2017. 11. 6..
 */

@ActiveProfiles("local")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class, SecurityConfig.class, DatabaseConfig.class, SchedulingConfig.class})
@Log

public class PointProcessTest {

    @Autowired
    private MyPointRepository myPointRepository;

    @Test
    public void ordersSheetGetTest() {

        String userId = "425476022";//getFriendsMemberId();
        int usedPoint = 5000;
        String mp_type = "O";
        String mp_code = "K1711091455000001";
        int amount = 290000;

//		List<TbKfoMbsPoint> pointList = myPointRepository.listAvailablePointByUser(userId);
//
//		for(int i = 0 ; i < pointList.size() ; i++ ){
//			int listAmount = pointList.get(i).getMP_AMOUNT();
//			TbKfoMbsPoint mp1 = new TbKfoMbsPoint();
//			mp1.setMP_USRID(pointList.get(i).getMP_USRID());
//
//			if( usedPoint > 0){
//				if( listAmount <= usedPoint ){
//					pointList.get(i).setMP_REST(0);
//				} else {
//					pointList.get(i).setMP_REST(listAmount - usedPoint);
//				}
//				memberRepository.modifyPointByUse(pointList.get(i));
//
//				//(-) 사용 금액
//				mp1.setMP_CODE("k201700000001");
//				mp1.setMP_TITLE("사용");
//				mp1.setMP_AMOUNT(usedPoint);
//				mp1.setMP_TYPE("U");
//				int useResult = myPointRepository.registPointByUser(mp1);
//				usedPoint -= listAmount;
//			}
//		}

        //int usedPoint = mbsPoint.getMP_AMOUNT();
//        List<TbKfoMbsPoint> pointList = myPointRepository.listAddablePointByUser(userId);
//
//        for(TbKfoMbsPoint point : pointList) {
//            //point
//        }
//
//        for(int i = 0 ; i < pointList.size() ; i++ ){
//            int listAmount = pointList.get(i).getMP_AMOUNT() - pointList.get(i).getMP_REST();
//            TbKfoMbsPoint mp1 = new TbKfoMbsPoint();
//            mp1.setMP_USRID(pointList.get(i).getMP_USRID());
//
//            if( usedPoint > 0){
//                if( listAmount <= usedPoint ){
//                    pointList.get(i).setMP_AMOUNT(listAmount);
//                    pointList.get(i).setMP_REST(listAmount);
//                } else {
//                    pointList.get(i).setMP_AMOUNT(usedPoint);
//                    pointList.get(i).setMP_REST(usedPoint);
//                }
//                //memberRepository.modifyPointByUse(pointList.get(i));
//                pointList.get(i).setMP_CODE("k201700000004");
//                pointList.get(i).setMP_TYPE("C");
//                pointList.get(i).setMP_TITLE("재적립");
//                int useResult = myPointRepository.registPointByUser(pointList.get(i));
//                usedPoint -= listAmount;
//            }
//        }


        /*
        포인트 적립 시 결제가의 5% ( 소수점으로 나올 경우 첫번째 자리에서 반올림 )
         */
      //  if(mp_type.equals("O")){
           /* TbKfoMbsPoint registPoint = new TbKfoMbsPoint();
            registPoint.setMP_CODE(mp_code);
            registPoint.setMP_USERID(userId);
            registPoint.setMP_AMOUNT(amount);
            registPoint.setMP_TYPE(mp_type);
           // registPoint.setMP_REST();

            log.info("registPoint.getMP_TYPE() >>> O ");
            System.out.println("MP_CODE >>> "+ registPoint.getMP_CODE());
            System.out.println("MP_USERID >>> "+registPoint.getMP_USERID());
            System.out.println("AMOUNT  "+registPoint.getMP_AMOUNT()+", >>> POINT  "+ (registPoint.getMP_AMOUNT()*0.05));

            int insertPoint = (int)Math.round(registPoint.getMP_AMOUNT()*0.05);
            DateUtil dateUtil = new DateUtil();
            Date edate = dateUtil.getEXPDateyyyyMMddHHmmssAddMonth(dateUtil.getDateyyyyMMdd(), 6);

            registPoint.setMP_TITLE("구매적립");
            registPoint.setMP_AMOUNT(insertPoint);
            registPoint.setMP_REST(insertPoint);
            registPoint.setMP_EDATE(edate);
            int useResult = myPointRepository.registPointByUser(registPoint);

*/
      //  }
    }
}
