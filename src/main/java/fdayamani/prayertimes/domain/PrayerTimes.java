package fdayamani.prayertimes.domain;

import org.joda.time.LocalTime;

public class PrayerTimes {

    private LocalTime nextTime;

    public PrayerTimes(LocalTime nextTime) {
        this.nextTime = nextTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrayerTimes that = (PrayerTimes) o;

        return nextTime != null ? nextTime.equals(that.nextTime) : that.nextTime == null;

    }

    @Override
    public int hashCode() {
        return nextTime != null ? nextTime.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PrayerTimes{" +
                "nextTime=" + nextTime +
                '}';
    }
}
