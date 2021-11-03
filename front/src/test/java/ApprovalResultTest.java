import org.apache.commons.collections.map.HashedMap;

import java.util.Map;
import java.util.StringTokenizer;

public class ApprovalResultTest {



	public static void main(String[] args) {
		String result = "P_STATUS=00&P_AUTH_DT=20161014183540&P_AUTH_NO=43137559&P_RMESG1=성공적으로 처리 하였습니다.&P_RMESG2=00&P_TID=INIMX_CARDkfrientest20161014183540410736&P_FN_CD1=14&P_AMT=23500&P_TYPE=CARD&P_UNAME=최성조&P_MID=kfrientest&P_OID=K20161014183430799&P_NOTI=770262|59B648E27E25DE2CCAD1DE32E3564923|K20161014183430799&P_NEXT_URL=http://genius.front-store.kakaofriends.com/kr/order/inimobile/pnexturl&P_MNAME=카카오프렌즈 온라인 스토어[개발]&P_NOTEURL=&P_CARD_MEMBER_NUM=&P_CARD_NUM=356297452959&P_CARD_ISSUER_CODE=26&P_CARD_PURCHASE_CODE=14&P_CARD_PRTC_CODE=1&P_CARD_INTEREST=0&P_CARD_CHECKFLAG=0&P_CARD_ISSUER_NAME=&P_CARD_PURCHASE_NAME=&P_FN_NM=신한카드&P_MERCHANT_RESERVED=dXNlcG9pbnQ9MCY%3D&P_CARD_APPLPRICE=23500&P_CARD_USEPOINT=000000000000";
		StringTokenizer st = new StringTokenizer(result);
		Map<String, String> map = new HashedMap();
		while (st.hasMoreTokens()) {
			String s = st.nextToken("&");
			String[] ss = s.split("\\=");
			System.out.println(ss.length);
			map.put(ss[0], ss.length > 1 ? ss[1] : "");
		}
		System.out.println(map);

		String R_STATUS = "";
		String R_TID = "";
		String R_OID = "";
		String R_TYPE = "";
		String R_RMESG1 = "";
		String R_CARD_NUM = "";
		String R_CARD_ISSUER_CODE = "";
		String R_CARD_PRTC_CODE = "";
		String R_FN_CD1 = "";
		String R_AUTH_NO = "";
		String R_HPP_NUM = "";
	}
}
