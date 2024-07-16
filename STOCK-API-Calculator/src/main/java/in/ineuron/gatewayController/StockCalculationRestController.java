package in.ineuron.gatewayController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.fiegnClient;

@RestController
@RequestMapping("/calc")
public class StockCalculationRestController 
{
	@Autowired
	private fiegnClient client;
	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> getCompanyValue(@PathVariable String companyName,@PathVariable String quantity)
	{
		ResponseEntity<?> responseEntity=null;
		Double totalPrice=null;
		System.out.println(companyName);
		System.out.println(quantity);
		responseEntity = client.getStockPrice(companyName);
		System.out.println(responseEntity);

		//int statusCode = responseEntity.getStatusCode().value();
		
			Double companyStockPrice = (Double) responseEntity.getBody();
			totalPrice = Double.parseDouble(quantity) * companyStockPrice;
			String response = "Total cost :: " + totalPrice;
			responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
	
		return responseEntity;
	}
}
