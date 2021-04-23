package v1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * 
 * @author romai
 *
 * Class to get some app main property from application.properties
 */
@Component
@ConfigurationProperties("app")
public class AppProperties {
	
	public AppProperties() {
		
	}
	
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
