package com.brodygaudel.accountservice.controller;


import com.brodygaudel.accountservice.dto.CustomerDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@FeignClient(url = "http://customer-svc:9090", value="customer-service")
public interface CustomerRestClient {

    /**
     * Retrieves customer details by their unique ID.
     *
     * @param id The unique identifier of the customer.
     * @return The {@code CustomerDTO} containing customer details.
     */
	 @GetMapping("/bank/v2/customers/get/{id}")
	 CustomerDTO getById(@PathVariable String id);
}
