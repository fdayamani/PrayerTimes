package fdayamani.prayertimes.application;

import fdayamani.prayertimes.domain.PrayerTimes;
import fdayamani.prayertimes.domain.TimeRetrievalService;
import org.joda.time.LocalDate;

public class OutputPrayerTimes {

    private final TimeRetrievalService timeRetrievalService;
    private final Destination destination;

    public OutputPrayerTimes(TimeRetrievalService timeRetrievalService, Destination destination) {
        this.timeRetrievalService = timeRetrievalService;
        this.destination = destination;
    }

    public void forDate(LocalDate date) {
        PrayerTimes prayerTimes = timeRetrievalService.retrieveTimesFor(date);
        destination.outputPrayerTimes(prayerTimes);
    }

    public void nextTime() {
        PrayerTimes nextTime = timeRetrievalService.retrieveNextTime();
        destination.outputPrayerTimes(nextTime);
    }
}
