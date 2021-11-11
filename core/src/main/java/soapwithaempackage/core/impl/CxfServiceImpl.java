package soapwithaempackage.core.impl;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;
import com.webservice.soap.CustomerOrdersWsImplService;

import soapwithaempackage.core.interfaces.CxfService;

public class CxfServiceImpl implements CxfService {

	public static void main(String[] args) throws MalformedURLException {

		// create the object of Impl class from the web service provider App
		// "CustomerOrdersWsImplService"
		// URL value will be the WSDL file URL.
		CustomerOrdersWsImplService service = new CustomerOrdersWsImplService(
				new URL("http://localhost:7070/customerOrdersService/customerOrder?wsdl"));

		// create the object of "CustomerOrdersPortType" using the above service class.
		// this class is called as this class only has two methods.
		CustomerOrdersPortType customerOrdersPortType = service.getCustomerOrdersWsImplPort();

		// testing getOrdersRequest method
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrdersPortType.getOrders(request);
		List<Order> order = response.getOrder();
		for (Order o : order) {
			System.out.println(o.getId() + ": orderID");
			List<Product> product = o.getProduct();
			for (Product p : product) {
				System.out.println(p.getDescription() + ": description");
				System.out.println(p.getQuantity() + ": quantity");
			}

		}

	}

}
