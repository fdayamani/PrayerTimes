package fdayamani.prayertimes.domain;

public interface TimeRetrievalService {
    PrayerTimes retrieveTimesFor(GivenDate date);

}
