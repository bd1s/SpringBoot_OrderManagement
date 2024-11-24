package org.tpsmicro.ordersservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.tpsmicro.customersservice.Customer;
import org.tpsmicro.ordersservice.Feign.CustomerClient;
import org.tpsmicro.ordersservice.Feign.ProductClient;
import org.tpsmicro.productsservice.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;


    // Create a new order
    public Order createOrder(OrderRequest orderRequest) {
        // Étape 1 : Récupérer les détails du client en utilisant Feign
        Customer customer = customerClient.getCustomerById(orderRequest.getCustomerId());
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        // Étape 2 : Créer la commande
        Order order = new Order();
        order.setCustomerId(customer.getId());


        // Étape 3 : Créer les OrderItems et les définir dans la commande
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItemRequest itemRequest : orderRequest.getOrderItems()) {
            // Récupérer les détails du produit en utilisant Feign
            Product product = productClient.getProductById(itemRequest.getProductId());

            if (product == null) {
                throw new RuntimeException("Product not found");
            }

            // Créer un nouvel OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getId());
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setOrder(order); // Lier l'OrderItem à la commande
            orderItems.add(orderItem);
        }

        // Étape 4 : Définir les items de commande dans la commande
        order.setOrderItems(orderItems);

        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get a specific order by ID
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // Update an existing order
    public Optional<Order> updateOrder(Integer id, OrderRequest orderRequest) {
        return orderRepository.findById(id).map(order -> {
            // Update orderItems
            List<OrderItem> orderItems = orderRequest.getOrderItems().stream().map(orderItemRequest ->
                    OrderItem.builder()
                            .order(order)
                            .productId(orderItemRequest.getProductId())
                            .quantity(orderItemRequest.getQuantity())
                            .build()
            ).collect(Collectors.toList());
            order.setOrderItems(orderItems);
            order.setCustomerId(orderRequest.getCustomerId());
            return orderRepository.save(order);
        });
    }

    // Delete an order
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
