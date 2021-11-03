import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dave on 2017. 7. 2..
 */
public class OrderResultDtoToOrderInfoTest {

    public static void main(String[] args){

        String orderResultDtoLog = "oid=K20170701132814621, uid=, payMethodType=PAYPAL, paymethod=, bsSeqList=2057594,2057583,2057663,2057614,2057718,2057660,2057610,2057672,2057585, accesstype=5, osDeliType=6, osDeliPayType=2, osDeliMoenyUse=Y, osDeliInOutType=DOMESTIC, giftCardNumber=---, giftCardAmount=0, deliveryCharge=22900, prCodes=[8809509761762, FRPBAPNBP0004, FRPBAPSEM0003, FRPBAPTBP0001, FRPBAPTPL0391, FRPBRNCK0458, FRPBRNLNT0004, FRPBRYMBT238, FRPBRYNBP0003], parentPrCodes=null, bsCtSeqs=[55, 30, 70, 53, 53, 30, 53, 69, 30], bsEas=[1, 1, 1, 1, 1, 1, 1, 1, 1], bsEtc5s=[, , , , , , , , ], isDiscountPeriods=[false, false, false, true, true, true, false, false, false], osOptionNames=null, osOriginalMoneys=null, osSaleMoneys=null, osTotOriginalMoneys=null, totOnePrMoneys=null, prSaveMoneys=null, oaName=Yuki Lau, oaPhone=852-6298-7386-7386, oaEmail=yukilau_hk@yahoo.com.hk, oaZoneCode=852, oaAddr1=Rm 12, 23/F, Luen Wai Apartment, oaAddr2=Hong Kong, oaAddr3=136-142 Belcher's Street, Kennedy Town, osDeliMemo=, payType=paypal, buyername=, encrypted=, cardcode=, sessionkey=, goodname=Smart Grip Tok-Ryan and others (8), Amt=122700, paymentAmount=122700, GoodsCnt=9, GoodsName=Smart Grip Tok-Ryan and others (8), currency=WON, odOmNum=null, odOsSeq=null, P_STATUS=null, P_RMESG1=null, P_TID=null, P_MID=, P_REQ_URL=null, P_NOTI=, EdiDate=20170701132814, SPU=, SPU_SIGN_TOKEN=, MPAY_PUB=, NON_REP_TOKEN=, oaCountryCode=null, oaCountryName=Hong Kong, payaplSaleId=57657190TE0495525, paypalPaymentId=PAY-85615743X7474644SLFLSJXY, paypalPayerId=yukilau_hk@yahoo.com.hk, paypalPayerEmail=SKFR6BAF29E2Q, paypalCreateTime=2017-07-01T04:29:06Z, exchangeRate=0.0";

        String [] split1 = orderResultDtoLog.split("=");

        List<String> orderResultDtoDatas = new ArrayList<>();

        for(int i=0; i<split1.length; i++){
            if(split1[i].contains("[")){
                split1[i] = split1[i].replace(", ", ",");
                split1[i] = split1[i].replace("],", "], ");
            }

            if(split1[i].contains("oaAddr")){
                String [] split2 = split1[i].split(", oaAddr");
                System.out.println(split2[0]);
                orderResultDtoDatas.add(split2[0]);

                String addr = "oaAddr" + split2[1];
                System.out.println(addr);
                orderResultDtoDatas.add(addr);
            }else if(split1[i].contains("osDeliMemo")){
                String [] split2 = split1[i].split(", osDeli");
                System.out.println(split2[0]);
                orderResultDtoDatas.add(split2[0]);

                String addr = "osDeli" + split2[1];
                System.out.println(addr);
                orderResultDtoDatas.add(addr);
            }else{
                String [] split2 = split1[i].split(", ");
                for(String str2 : split2){
                    System.out.println(str2);
                    orderResultDtoDatas.add(str2);
                }
            }

        }

        Map<String, String> orderResultDtoDatsMap = new HashMap<>();

        for(int i=0; i < orderResultDtoDatas.size(); i += 2){
            orderResultDtoDatsMap.put(orderResultDtoDatas.get(i), orderResultDtoDatas.get(i+1));
            System.out.println("key: " + orderResultDtoDatas.get(i) + " value: " + orderResultDtoDatas.get(i+1));
        }
    }
}
