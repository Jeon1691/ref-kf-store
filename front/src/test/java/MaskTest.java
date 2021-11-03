import java.util.Arrays;
import java.util.stream.Collectors;

import static com.kakaofriends.core.utils.KakaoFriendsUtil.maskPhone;
import static com.kakaofriends.core.utils.KakaoFriendsUtil.maskMail;

public class MaskTest {

	public static void main(String[] args) {
		System.out.println(maskPhone(""));
		System.out.println(maskMail(""));


		String[] aa = "FRPBRNFK0446".split(",");
		System.out.println(Arrays.asList(aa).stream().collect(Collectors.joining(",")));
	}
}
