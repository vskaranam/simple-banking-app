package com.brodygaudel.accountservice.controller;


import com.brodygaudel.accountservice.dto.CustomerDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://customer-svc:9090", value="customer-service")
public interface CustomerRestClient {

    /**
     * Retrieves customer details by their unique ID.
     *
     * @param id The unique identifier of the customer.
     * @return The {@code CustomerDTO} containing customer details.
     */
	 @GetMapping("/v2/customers/get/{id}")
	 CustomerDTO getById(@PathVariable String id);
	 
	 @RequestMapping(method = RequestMethod.GET, value="/v2/customers/hello")
		public String getHello();
}
