package org.tpsmicro.ordersservice.Feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.tpsmicro.productsservice.Product;

/**
 * @author lamaachi
 **/
@FeignClient(name = "PRODUCTS-SERVICE")
public interface ProductClient {
    @GetMapping("/{id}")
    Product getProductById(@PathVariable("id") Integer id);
}
