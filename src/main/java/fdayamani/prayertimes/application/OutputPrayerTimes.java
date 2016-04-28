package fdayamani.prayertimes.application;

import fdayamani.prayertimes.domain.GivenDate;
import fdayamani.prayertimes.domain.TimeRetrievalService;

public class OutputPrayerTimes {

    private final TimeRetrievalService timeRetrievalService;
    private final Destination destination;

    public OutputPrayerTimes(TimeRetrievalService timeRetrievalService, Destination destination) {

        this.timeRetrievalService = timeRetrievalService;
        this.destination = destination;
    }

    public void outputTimesForDate(GivenDate date) {
        timeRetrievalService.retrieveTimesFor(date);
    }
}
