package com.brodygaudel.customerservice.util;

import com.brodygaudel.customerservice.dto.CustomerDTO;
import com.brodygaudel.customerservice.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code Mappers} class implements methods for mapping between {@link Customer} and {@link CustomerDTO} objects.
 * Implementing classes should provide concrete implementations for these methods to facilitate the conversion process.
 * <p>
 * The typical usage involves transforming a {@code Customer} instance to a {@code CustomerDTO} instance and vice versa.
 * </p>
 *
 * @implSpec
 * Implementing classes should adhere to the contract defined by these methods and ensure proper conversion between
 * {@code Customer} and {@code CustomerDTO} objects.
 *
 * @author Brody Gaudel MOUNANGA BOUKA
 *
 * @see Customer
 * @see CustomerDTO
 */
@Service
public class MappersImpl implements Mappers {
    /**
     * Converts a {@link Customer} object to its corresponding {@link CustomerDTO} representation.
     *
     * @param customer The {@code Customer} object to be converted.
     * @return The corresponding {@code CustomerDTO} representation of the input {@code customer}.
     */
    @Override
    public CustomerDTO fromCustomer(Customer customer){
        return new CustomerDTO(
                customer.getId(), customer.getFirstname(), customer.getName(),
                customer.getPlaceOfBirth(), customer.getDateOfBirth(),
                customer.getNationality(), customer.getSex(), customer.getCin(),
                customer.getEmail(), customer.getPhone(), customer.getCreation(),
                customer.getLastUpdate()
        );
    }

    /**
     * Converts a {@link CustomerDTO} object to its corresponding {@link Customer} representation.
     *
     * @param customerDTO The {@code CustomerDTO} object to be converted.
     * @return The corresponding {@code Customer} representation of the input {@code customerDTO}.
     */
    @Override
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
    	Customer customer = new Customer();
    	customer.setFirstname(customerDTO.firstname());
    	customer.setName(customerDTO.name());
    	customer.setDateOfBirth(customerDTO.dateOfBirth());
    	customer.setEmail(customerDTO.email());
    	customer.setNationality(customerDTO.nationality());
    	customer.setPhone(customerDTO.phone());
    	customer.setPlaceOfBirth(customerDTO.placeOfBirth());
    	customer.setCin(customerDTO.cin());
    	customer.setSex(customerDTO.sex());
    	
        return customer;
    }


    /**
     * Converts a list of {@link Customer} objects to a list of {@link CustomerDTO} objects using the {@link Mappers#fromCustomer} method.
     *
     * @param customers The list of {@link Customer} objects to be converted.
     * @return A new {@link List} containing the converted {@link CustomerDTO} objects.
     * @throws NullPointerException if the input {@code customers} list is {@code null}.
     */
    @Override
    public List<CustomerDTO> fromListOfCustomers(List<Customer> customers){
        return customers.stream().map(this::fromCustomer).toList();
    }

    public MappersImpl(){
        super();
    }
}
