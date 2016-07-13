package fdayamani.prayertimes.application;

import fdayamani.prayertimes.domain.PrayerTimes;
import fdayamani.prayertimes.domain.TimeRetrievalService;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class OutputPrayerTimesTest {
    private static final LocalDate SAMPLE_DATE = new LocalDate();
    public static final PrayerTimes PRAYER_TIMES = new PrayerTimes(new LocalTime());

    private TimeRetrievalServiceStub timeRetrievalService;
    private DestinationSpy destination;
    private OutputPrayerTimes outputter;

    @Before
    public void setUp() {
        timeRetrievalService = new TimeRetrievalServiceStub();
        destination = new DestinationSpy();
        outputter = new OutputPrayerTimes(timeRetrievalService, destination);
    }

    @Test
    public void invokesTimeRetrievalServiceWithAGivenDate() {
        outputter.forDate(SAMPLE_DATE);

        assertThat(timeRetrievalService.invokedWith()).isEqualTo(SAMPLE_DATE);
    }


    @Test
    public void invokesDestinationWithCorrectPrayerTimes() {
        timeRetrievalService.returns(PRAYER_TIMES).whenInvokedWith(SAMPLE_DATE);

        outputter.forDate(SAMPLE_DATE);

        assertThat(destination.invokedWith()).isEqualTo(PRAYER_TIMES);
    }

    private class TimeRetrievalServiceStub implements TimeRetrievalService {

        private LocalDate date;
        private PrayerTimes prayerTimes;
        private LocalDate expectedDate;

        public PrayerTimes retrieveTimesFor(LocalDate date) {
            this.date = date;
            if (date != null && date.equals(expectedDate)) {
                return prayerTimes;
            }
            return null;
        }

        public PrayerTimes retrieveNextTime() {
            return null;
        }

        public LocalDate invokedWith() {
            return date;
        }

        public TimeRetrievalServiceStub returns(PrayerTimes prayerTimes) {
            this.prayerTimes = prayerTimes;
            return this;
        }

        public void whenInvokedWith(LocalDate expectedDate) {

            this.expectedDate = expectedDate;
        }
    }

    private class DestinationSpy implements Destination {

        private PrayerTimes prayerTimes;

        public void outputPrayerTimes(PrayerTimes prayerTimes) {
            this.prayerTimes = prayerTimes;
        }

        public PrayerTimes invokedWith() {
            return prayerTimes;
        }
    }
}
