package fdayamani.prayertimes.infrastructure;

import fdayamani.prayertimes.application.OutputPrayerTimes;
import org.joda.time.LocalTime;

public class NextTimeRunner {
    public static void main(String[] args) {
        new NextTimeRunner().run();
    }

    private void run() {
        OutputPrayerTimes outputter = new PrayerTimesFactory().make();

        outputter.nextTime();
    }


    class PrayerTimesFactory {
        private OutputPrayerTimes make() {
            InMemoryTimeRetrievalService timeRetrievalService = new InMemoryTimeRetrievalService();
            timeRetrievalService.returns(new LocalTime(12, 45, 00));

            OutputPrayerTimes outputter = new OutputPrayerTimes(timeRetrievalService, new StandardOut());

            return outputter;
        }
    }
}
