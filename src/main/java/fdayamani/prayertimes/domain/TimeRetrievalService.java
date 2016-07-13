package fdayamani.prayertimes.domain;

import org.joda.time.LocalDate;

public interface TimeRetrievalService {
    PrayerTimes retrieveTimesFor(LocalDate date);

    PrayerTimes retrieveNextTime();
}
