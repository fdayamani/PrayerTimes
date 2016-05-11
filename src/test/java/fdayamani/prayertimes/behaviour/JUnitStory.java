package fdayamani.prayertimes.behaviour;

import org.jbehave.core.configuration.Configuration;

import static fdayamani.prayertimes.behaviour.JBehaveConfiguration.aConfigurationFor;

public class JUnitStory extends org.jbehave.core.junit.JUnitStory {
    public JUnitStory() {
        configuredEmbedder().embedderControls()
                .doIgnoreFailureInStories(false)
                .doIgnoreFailureInView(true)
                .doVerboseFailures(true);
    }

    @Override
    public Configuration configuration() {
        return aConfigurationFor(this.getClass());
    }
}
