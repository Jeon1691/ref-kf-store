import com.google.common.collect.Lists;
import com.kakaofriends.core.common.configuration.persistence.type.BoardReplyType;

import java.util.ArrayList;

/**
 * Created by seott on 2016-10-24.
 */
public class NewArrayList_AsList {
    public static void main(String[] args) {
        ArrayList<BoardReplyType> test = Lists.newArrayList(BoardReplyType.values());
        System.out.println(test);
        test.forEach(e -> System.out.println(e.getCode()));

        test.forEach(e -> System.out.println(e.getName()));
        System.out.println(test.stream().filter(e -> e.getCode().equals("1")).findFirst().get());
    }
}
