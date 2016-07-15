package fdayamani.prayertimes.behaviour.steps;

import fdayamani.prayertimes.application.Destination;
import fdayamani.prayertimes.application.OutputPrayerTimes;
import fdayamani.prayertimes.domain.PrayerTimes;
import fdayamani.prayertimes.infrastructure.InMemoryTimeRetrievalService;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.joda.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class PrayerTimesSteps extends Embedder {

    InMemoryTimeRetrievalService timeRetrievalService = new InMemoryTimeRetrievalService();
    DestinationSpy destination = new DestinationSpy();

    OutputPrayerTimes outputPrayerTimes = new OutputPrayerTimes(timeRetrievalService, destination);

    @Given("the next prayer time is $hour:$minute:$second")
    public void theNextPrayerTime(Integer hour, Integer minute, Integer second) {
        LocalTime time = new LocalTime(hour, minute, second);
        timeRetrievalService.returns(time);
    }

    @When("the prayer retrieval service is asked to retrieve the next prayer time")
    public void invokeTimeRetrievalService() {
        outputPrayerTimes.nextTime();
    }

    @Then("time of $hour:$minute:$second is provided")
    public void assertTimeIsAsExpected(Integer hour, Integer minute, Integer second) {
        LocalTime time = new LocalTime(hour, minute, second);
        assertThat(destination.wasGivenTimeOf()).isEqualTo(new PrayerTimes(time));
    }

    class DestinationSpy implements Destination {
        private PrayerTimes prayerTimes;

        public void outputPrayerTimes(PrayerTimes prayerTimes) {
            this.prayerTimes = prayerTimes;
        }

        public PrayerTimes wasGivenTimeOf() {
            return prayerTimes;
        }
    }
}
