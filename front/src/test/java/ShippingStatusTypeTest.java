import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.ShippingStatusType;

/**
 * Created by seott on 2016-10-25.
 */
public class ShippingStatusTypeTest {
    public static void main(String[] args) {
        System.out.println(Lists.newArrayList(ShippingStatusType.values()).stream().filter(e -> e.getOrderStatusTypeCodes().contains(300000)).findFirst().get().getName());
    }
}
