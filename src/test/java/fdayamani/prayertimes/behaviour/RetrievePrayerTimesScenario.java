package fdayamani.prayertimes.behaviour;

import fdayamani.prayertimes.behaviour.steps.PrayerTimesSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

public class RetrievePrayerTimesScenario extends JUnitStory {
    public RetrievePrayerTimesScenario() {
        useStepsFactory(new InstanceStepsFactory(configuration(), new PrayerTimesSteps()));
    }
}
