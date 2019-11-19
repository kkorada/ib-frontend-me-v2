package com.abcbank.ib.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abcbank.ib.config.Constants;
import com.abcbank.ib.service.dto.BankingAccountDTO;
import com.abcbank.ib.service.dto.CustomerDTO;
import com.abcbank.ib.service.dto.TransactionDTO;

@RestController
@RequestMapping("/api")
public class BankingController {
	
	private final Logger log = LoggerFactory.getLogger(AccountResource.class);
	
	@Value("${app.endpoints.customerservice}")
	private String customerServiceHost = "customer-service:8081";
	@Value("${app.endpoints.accountsservice}")
	private String accountServiceHost = "accounts-service:8082";
	@Value("${app.endpoints.transactionsservice}")
	private String transactionServiceHost = "trnx-service:8083";

	@GetMapping("/customers/login/{login:" + Constants.LOGIN_REGEX + "}")
	public ResponseEntity<CustomerDTO> getCustomerByLogin(@PathVariable String login) throws URISyntaxException {
		log.debug("REST request to get customer details by login: " + login);

		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://" + customerServiceHost + "/api/customers/login/" + login;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<CustomerDTO> result = restTemplate.getForEntity(uri, CustomerDTO.class);
		return result;
	}
	
	@GetMapping("/accounts/customer/{customerId}")
	public ResponseEntity<List<BankingAccountDTO>> getAccountsByCustomer(@PathVariable String customerId) throws URISyntaxException {
		log.debug("REST request to get accounts details by customer: " + customerId);

		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://" + accountServiceHost + "/api/banking-accounts/customer/" + customerId;
	    URI uri = new URI(baseUrl);
	 
//	    ResponseEntity<BankingAccountDTO> result = restTemplate.getForEntity(uri, BankingAccountDTO.class);
	    ResponseEntity<List<BankingAccountDTO>> result = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<BankingAccountDTO>>() {
				});
		return result;
	}
	
	@GetMapping("/transactions/account/{accountId}")
	public ResponseEntity<List<TransactionDTO>> getTransactionsByAccount(@PathVariable String accountId) throws URISyntaxException {
		log.debug("REST request to get transactions by account: " + accountId);

		RestTemplate restTemplate = new RestTemplate();
	     
	    final String baseUrl = "http://" + transactionServiceHost + "/api/transactions/account/" + accountId;
	    URI uri = new URI(baseUrl);
	 
	    ResponseEntity<List<TransactionDTO>> result = restTemplate.exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<TransactionDTO>>() {
				});
		return result;
	}
}