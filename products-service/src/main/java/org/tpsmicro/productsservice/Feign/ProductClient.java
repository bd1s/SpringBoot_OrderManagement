//package org.tpsmicro.productsservice.Feign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.tpsmicro.productsservice.Product;
//
///**
// * @author lamaachi
// **/
//@FeignClient(name = "products-service" ,url = "")
//public interface ProductClient {
//    @GetMapping("/{id}")
//    Product getProductById(@PathVariable("id") Integer id);
//}
//