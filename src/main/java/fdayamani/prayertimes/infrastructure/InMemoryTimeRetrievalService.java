package fdayamani.prayertimes.infrastructure;

import fdayamani.prayertimes.domain.PrayerTimes;
import fdayamani.prayertimes.domain.TimeRetrievalService;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class InMemoryTimeRetrievalService implements TimeRetrievalService {
    private PrayerTimes prayerTimes;

    public void returns(LocalTime nextTime) {
        this.prayerTimes = new PrayerTimes(nextTime);
    }

    public PrayerTimes retrieveTimesFor(LocalDate date) {
        return null;
    }

    public PrayerTimes retrieveNextTime() {
        return prayerTimes;
    }
}
