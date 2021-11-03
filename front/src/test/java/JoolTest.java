import com.google.common.collect.Lists;
import com.kakaofriends.core.domain.Basket;
import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class JoolTest {

	public static void main(String[] args) {
		List<Long> numbers = Lists.newArrayList(1L, 2L, 3L, 4L, 5L);
		List<String> strings = Lists.newArrayList("A", "B", "C", "D", "E");

		Map<String, Long> maps = Seq.zip(strings, numbers).stream().collect(toMap(Tuple2::v1, Tuple2::v2));
		System.out.println(maps);

		Function<Tuple2<String, Long>, Basket> tuple2BasketFunction = e -> Basket.builder().bsPrCode(e.v1).bsEa(e.v2).build();
		List<Basket> baskets = Seq.zip(strings, numbers).stream().map(tuple2BasketFunction).collect(toList());
		System.out.println(baskets);

		//System.out.println(getOrderDate("O20160126233704248"));

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate date = LocalDate.parse("20160126", dateTimeFormatter);
		System.out.println(date);

		Long a = null;
		Long b = 1L;
		Long c = 10L;
		Long d;
		if(Lists.newArrayList(a, b, c).stream().filter(e -> e != null && e > 0).count() == 1) {
			d = Lists.newArrayList(a, b, c).stream().filter(e -> e != null && e > 0).findAny().get();
			System.out.println(d + " !!");
		}
	}
}
