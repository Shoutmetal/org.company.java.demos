package datetime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		//datetime_example_instant();
		//datetime_example_localdate();
		//datetime_example_format();
		datetime_example_time_zone_offsets();

	}
	
	@SuppressWarnings("unused")
	private static void datetime_example_instant() throws InterruptedException
	{
		Instant start = Instant.now();
		System.out.println(start);
		
		Thread.sleep(1000);
		
		Instant end = Instant.now();
		System.out.println(end);
		
		Duration elapsed = Duration.between(start, end);
		
		System.out.println(elapsed.toMillis() + " Milliseconds");
	}
	
	@SuppressWarnings("unused")
	private static void datetime_example_localdate(){
		
		LocalDate currentDate = LocalDate.now(); 
		System.out.println(currentDate);
		
		LocalDate specificDate = LocalDate.of(2000, 1, 16); 
		System.out.println(specificDate);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println(currentTime);
		
		LocalTime specificTime = LocalTime.of(14, 0, 45);
		System.out.println(specificTime);
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime);
		System.out.println(specificDateTime);
	}
	
	@SuppressWarnings("unused")
	private static void datetime_example_format()
	{
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
		System.out.println(df.format(currentDate)); 
		
		LocalTime currentTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_TIME;
		System.out.println(timeFormatter.format(currentTime)); 
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;
		System.out.println(dateTimeFormatter.format(currentDateTime)); 
	
		
		DateTimeFormatter f_long = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(f_long.format(currentDateTime)); 
		
		DateTimeFormatter f_short = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(f_short.format(currentDateTime)); 
		
		String fr_short = f_short.withLocale(Locale.FRENCH).format(currentDateTime);
		String fr_long = f_long.withLocale(Locale.FRENCH).format(currentDateTime);
		System.out.println(fr_short);
		System.out.println(fr_long);
		
		DateTimeFormatterBuilder b = new DateTimeFormatterBuilder();
		b.appendValue(ChronoField.MONTH_OF_YEAR);
		b.appendLiteral("||");
		b.appendValue(ChronoField.DAY_OF_MONTH);
		b.appendLiteral("||");
		b.appendValue(ChronoField.YEAR);
		
		
		DateTimeFormatter f = b.toFormatter();
		System.out.println(f.format(currentDateTime));
	}
	
	private static void datetime_example_time_zone_offsets()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dtf.format(dt));
		 
		ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT+0"));
		System.out.println(dtf.format(gmt));
		
		ZonedDateTime ny = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println(dtf.format(ny));
		
		Predicate<String> condition = str -> str.contains("London");
		
		Set<String> zones = ZoneId.getAvailableZoneIds();
		

		
		@SuppressWarnings("unused")
		List<String> filteredZones = zones
		.stream()
		.filter(condition)
		.collect(Collectors.toList());
		
		String zone = zones
				.stream()
				.filter(condition)
				.findFirst().orElse("GMT+0");

		ZonedDateTime london = ZonedDateTime.now(ZoneId.of(zone));
		System.out.println("London: " + dtf.format(london));
	}

}
