package big.open.utility;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utility 
{
	//private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //  01/05/2022 00:00:00
	public static String asJsonString(final Object obj) 
	{
	    try 
	    {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) 
	    {
	        throw new RuntimeException(e);
	    }
	}  
	public static String getRandomString(Integer lengthString) 
	{
		 
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(lengthString);
	    for (int i = 0; i < lengthString; i++) 
	    {
	        int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
	          
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();

	    return generatedString;
	}
	public static Integer getRandomNumber(Integer lengthNumber) 
	{
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 57; // letter 'z'
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(lengthNumber)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return Integer.parseInt( generatedString);
	}
	public static boolean isEmpty(String str)
	{
		return (str == null || str.isEmpty() || str == "" );
	}
	public static LocalDateTime convert(String source,int h,int m,int s) 
	{
	    // parse to LocalDateTime 
	    LocalDateTime dt = stringToLocalDateTime(source);
	    dt = LocalDateTime.of(dt.getYear(),dt.getMonth(), dt.getDayOfMonth(),h,m,s);
	    return dt;
	}
	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) 
	{
	    Set<Object> seen = ConcurrentHashMap.newKeySet();
	    return t -> seen.add(keyExtractor.apply(t));
	}
	public static LocalDateTime stringToLocalDateTime(String date)
	{
	    return LocalDateTime.parse(date.substring(0, 19));
	}
	public static String leftTrim(String str) 
	{
        return str.replaceAll("^\\s+", "");
    }
 
    public static String rightTrim(String str) 
    {
        return str.replaceAll("\\s+$", "");
    }
}
