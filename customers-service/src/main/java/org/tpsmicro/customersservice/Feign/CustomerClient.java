//package org.tpsmicro.customersservice.Feign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.tpsmicro.customersservice.Customer;
//
///**
// * @author lamaachi
// **/
//@FeignClient(name = "customer-service" ,url = "http://localhost:8081/api/v1/customers")
//public interface CustomerClient {
//    @GetMapping("/{id}")
//    Customer getCustomerById(@PathVariable("id") Integer id);
//}
