package com.kakaofriends.front.common.cache;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class FriendsCacheKeyBuilder {

	public String getTimeUnitWithTimestamp(Instant instant, String prefix, TimeUnit timeUnit, long duration) {
		long epochSecond = instant.getEpochSecond();
		long align = timeUnit.toSeconds(duration);
		Instant adjustedInstant = Instant.ofEpochSecond(epochSecond / align * align);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		return prefix + "_" + formatter.format(LocalDateTime.ofInstant(adjustedInstant, ZoneId.systemDefault()));
	}
}