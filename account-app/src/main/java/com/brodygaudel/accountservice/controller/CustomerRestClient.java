package com.brodygaudel.accountservice.controller;


import com.brodygaudel.accountservice.dto.CustomerDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v2/accounts")
public class CustomerRestClient {

    /**
     * Retrieves customer details by their unique ID.
     *
     * @param id The unique identifier of the customer.
     * @return The {@code CustomerDTO} containing customer details.
     */
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    private DiscoveryClient client;
	
    public CustomerDTO getById(String id) {
    	List<ServiceInstance> siList = client.getInstances("customer-service");
    	ServiceInstance si = siList.get(0);
    	CustomerDTO foo = restTemplate
  			  .getForObject(si.getUri() +"/v2/customers/get/"+id, CustomerDTO.class);
		return foo;
     }
    
    @GetMapping("/customers/get/{id}")
    CustomerDTO getCustomerById(@PathVariable String id) {
    	List<ServiceInstance> siList = client.getInstances("customer-service");
    	ServiceInstance si = siList.get(0);
    	CustomerDTO foo = restTemplate
  			  .getForObject(si.getUri() +"/v2/customers/get/"+id, CustomerDTO.class);
		return foo;
    }
}
