package fdayamani.prayertimes.application;

import fdayamani.prayertimes.domain.GivenDate;
import fdayamani.prayertimes.domain.PrayerTimes;
import fdayamani.prayertimes.domain.TimeRetrievalService;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OutputPrayerTimesTest {
    TimeRetrievalServiceStub timeRetrievalService;
    Destination destination;
    OutputPrayerTimes outputter;

    @Before
    public void setUp() {
        timeRetrievalService = new TimeRetrievalServiceStub();
        outputter = new OutputPrayerTimes(timeRetrievalService, destination);
    }

    @Test
    public void invokesTimeRetrievalServiceWithAGivenDate() {
        GivenDate date = new GivenDate(28, 04, 2016);

        outputter.outputTimesForDate(date);

        assertThat(timeRetrievalService.invokedWith()).isEqualTo(date);
    }

    private class TimeRetrievalServiceStub implements TimeRetrievalService {

        private GivenDate date;

        public PrayerTimes retrieveTimesFor(GivenDate date) {
            this.date = date;
            return null;
        }

        public GivenDate invokedWith() {
            return date;
        }
    }
}
