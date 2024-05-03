package com.brodygaudel.accountservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://customer-svc:9090", value="customer-service")
public interface RestConsumerInterface {
	@RequestMapping(method = RequestMethod.GET, value="/v2/customers/hello")
	public String getHello();

}
