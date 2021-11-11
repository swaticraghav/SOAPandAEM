package soapwithaempackage.core.models;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.models.annotations.Model;
import org.apache.xml.resolver.apps.resolver;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;
import com.webservice.soap.CustomerOrdersWsImplService;

@Model(adaptables = resolver.class)
public class SoapModel {

	private String message;
	private String soapResponse;

	@PostConstruct
	public void init() throws MalformedURLException {
		message = "Hey, Soap Here!";
		soapResponse = getSoapMessage();

	}

	String getSoapMessage() throws MalformedURLException {

		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:7070/customerOrdersService/customerOrder?wsdl"));
		CustomerOrdersPortType customerOrdersPortType = service.getCustomerOrdersWsImplPort();
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrdersPortType.getOrders(request);
		List<Order> order = response.getOrder();
		String soapResp = "Product Description is ";
		for (Order o : order) {
			List<Product> product = o.getProduct();
			for (Product p : product) {
				soapResp += p.getDescription() + ". Product Quantity is " + p.getQuantity();
			}

		}

		return soapResp;
	}

	public String getSoapResponse() {
		return soapResponse;
	}

	public String getMessage() {
		return message;
	}
}
