package artifact.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import vrmsConnectionServices.wsdl.AvailableCriteria;
import vrmsConnectionServices.wsdl.Credentials;
import vrmsConnectionServices.wsdl.IsAvailableRQ;
import vrmsConnectionServices.wsdl.IsAvailableRS;

public class SOAPClient  extends WebServiceGatewaySupport{

	public SOAPClient() {
		// TODO Auto-generated constructor stub
	}
	
	public IsAvailableRS isAvailable(){
		
		IsAvailableRS response = null;
		IsAvailableRQ request = new IsAvailableRQ();
		
		Credentials credentials = new Credentials();
		credentials.setLanguage("ca_CA");
		credentials.setPassword("pass");
		credentials.setUserName("pmanent");
		request.setCredentials(credentials);
		
		AvailableCriteria criteria = new AvailableCriteria();
		
		request.setCriteria(criteria);
		
		response = (IsAvailableRS)this.getWebServiceTemplate().marshalSendAndReceive("http://ws.avantio.com/soap/vrmsConnectionServices.php?wsdl",
				request,
				new SoapActionCallback("http://ws.avantio.com/soap/vrmsConnectionServices.php/IsAvailable"));
		
		return response;
	}

}