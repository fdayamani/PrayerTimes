package fdayamani.prayertimes.domain;

public class GivenDate {

    private final int day;
    private final int month;
    private final int year;

    public GivenDate(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GivenDate givenDate = (GivenDate) o;

        if (day != givenDate.day) return false;
        if (month != givenDate.month) return false;
        return year == givenDate.year;

    }

    @Override
    public int hashCode() {
        int result = day;
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "GivenDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
