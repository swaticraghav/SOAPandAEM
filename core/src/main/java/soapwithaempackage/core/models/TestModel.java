package soapwithaempackage.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestModel {

	private String message;

	@PostConstruct
	public void init() {
		message = "Initial Test!";
	}

	public String getMessage() {
		return message;
	}
}
