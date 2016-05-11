package fdayamani.prayertimes.behaviour;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;

import java.util.Properties;


public class JBehaveConfiguration {
    public static Configuration aConfigurationFor(Class<? extends Embeddable> embeddableClass) {
        Properties viewResources = new Properties();
        viewResources.put("decorateNonHtml", "true");

        return new MostUsefulConfiguration();
    }
}
