import java.util.*;
import java.util.function.Function;

public class BitOperationTest {

	private static Map<Integer, String> map = new HashMap<>();

	public static void main(String[] args) {

		int read = 1 << 0;
		int write = 1 << 1;
		int create = 1 << 2;
		int delete = 1 << 3;

		map.put(read, "read");
		map.put(write, "write");
		map.put(create, "create");
		map.put(delete, "delete");

		int permission = 4;

		for (int i = 0; i < 32; i++) {
			int permissionToCheck = 1 << i;
			if ((permission & permissionToCheck) == permissionToCheck) {
				System.out.println(map.get(permissionToCheck));
				Integer.valueOf(permissionToCheck);
			}
		}

		Arrays.asList("1", "3").forEach(System.out::println);

		final Function<Long, String> function = i -> i.toString();
		final List<Long> list = Arrays.asList(1L, 2L);
		final List<String> mappedList = map(list, function);
		System.out.println(mappedList);
	}

	private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		final List<R> result = new ArrayList<>();
		for (final T t : list) {
			result.add(mapper.apply(t));
		}
		return result;
	}
}