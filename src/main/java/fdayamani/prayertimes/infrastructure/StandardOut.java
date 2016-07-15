package fdayamani.prayertimes.infrastructure;

import fdayamani.prayertimes.application.Destination;
import fdayamani.prayertimes.domain.PrayerTimes;

public class StandardOut implements Destination {

    public void outputPrayerTimes(PrayerTimes prayerTimes) {
        System.out.println(prayerTimes.toString());
    }
}
