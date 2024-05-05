package com.brodygaudel.accountservice.controller;

import com.brodygaudel.accountservice.dto.AccountDTO;
import com.brodygaudel.accountservice.exception.AccountNotFoundException;
import com.brodygaudel.accountservice.exception.CustomerAlreadyHaveAccountException;
import com.brodygaudel.accountservice.exception.CustomerNotFoundException;
import com.brodygaudel.accountservice.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/accounts")
public class AccountRestController {

	@Autowired
    private  AccountService accountService;
	
	@Autowired
	private RestConsumerInterface rci; // Proxy

	@GetMapping("/hello")
	public String getHello() {
	return rci.getHello();
	}
	
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get/{id}")
    public AccountDTO getById(@PathVariable String id) throws AccountNotFoundException {
        return accountService.getById(id);
    }

    @GetMapping("/find/{customerId}")
    public AccountDTO getByCustomerId(@PathVariable String customerId) throws AccountNotFoundException{
        return accountService.getByCustomerId(customerId);
    }

    @PostMapping("/save")
    public AccountDTO save(@RequestBody AccountDTO accountDTO) throws CustomerNotFoundException, CustomerAlreadyHaveAccountException {
        return accountService.save(accountDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id){
        accountService.deleteById(id);
    }

    @PutMapping("/update")
    public AccountDTO updateStatus(@RequestBody AccountDTO accountDTO) throws AccountNotFoundException{
        return accountService.updateStatus(accountDTO);
    }

}
