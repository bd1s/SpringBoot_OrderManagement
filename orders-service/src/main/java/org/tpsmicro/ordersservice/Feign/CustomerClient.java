package org.tpsmicro.ordersservice.Feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.tpsmicro.customersservice.Customer;

@FeignClient(name = "CUSTOMERS-SERVICE")
public interface CustomerClient {
    @GetMapping("/{id}")
    @CircuitBreaker(name="customersService",fallbackMethod = "getDefaultCustomer")
    Customer getCustomerById(@PathVariable("id") Integer id);

    default Customer  getDefaultCustomer(Integer id){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Vailable");
        customer.setLastName("Not Vailable");
        customer.setEmail("Not Vailable");
        return  customer;
    }

}
