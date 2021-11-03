import com.kakaofriends.front.common.cache.FriendsCacheKeyBuilder;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class InstantTest {

	public static void main(String[] args) {
		FriendsCacheKeyBuilder friendsCacheKeyBuilder = new FriendsCacheKeyBuilder();
		System.out.println(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(Instant.now(), "Test", TimeUnit.MINUTES, 10));
		System.out.println(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(Instant.now().plus(10, ChronoUnit.MINUTES), "Test", TimeUnit.MINUTES, 10));
		System.out.println(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(Instant.now(), "Test", TimeUnit.HOURS, 1));
		System.out.println(friendsCacheKeyBuilder.getTimeUnitWithTimestamp(Instant.now().plus(1, ChronoUnit.HOURS), "Test", TimeUnit.HOURS, 1));
	}
}
