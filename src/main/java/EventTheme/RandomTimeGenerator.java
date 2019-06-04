package EventTheme;

import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

import static Common.Utils.timeReportPeriod3;

public class RandomTimeGenerator {

    public static long timegen() {
        long timestamp = Calendar.getInstance().getTimeInMillis();
        int randomNum = ThreadLocalRandom.current().nextInt(0, timeReportPeriod3 );
        long randomtime = timestamp - randomNum;
        return randomtime;
    }
}


