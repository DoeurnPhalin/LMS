import java.text.SimpleDateFormat;
import java.util.Date;
public class DateCal {

	
	
	
 public static int daycal(String date) {
	String dateStart = date;
//	String dateStop =;
	int result=0;
	//HH converts hour in 24 hours format (0-23), day calculation
			SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
			
			Date d1 = null;
			Date d2 = new Date();

			try {
				d1 = format.parse(dateStart);
//				d2 = format.parse(dateStop);

				//in milliseconds
				long diff = d2.compareTo(d1) ;

//				long diffSeconds = diff / 1000 % 60;
//				long diffMinutes = diff / (60 * 1000) % 60;
//				long diffHours = diff / (60 * 60 * 1000) % 24;
//				long diffDays = diff / (24 * 60 * 60 * 1000);

				System.out.print(diff + " days, ");
//				System.out.print(diffHours + " hours, ");
//				System.out.print(diffMinutes + " minutes, ");
//				System.out.print(diffSeconds + " seconds.");
				result=(int) diff;

			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
	
}
}
