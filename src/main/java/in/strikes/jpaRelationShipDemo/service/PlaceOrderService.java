package in.strikes.jpaRelationShipDemo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import in.strikes.jpaRelationShipDemo.model.AuditPayment;
import in.strikes.jpaRelationShipDemo.model.OrderProduct;
import in.strikes.jpaRelationShipDemo.repository.OrderRepository;
import jakarta.transaction.Transactional;



@Service 
public class PlaceOrderService {
    private OrderRepository orderRepository;
    private AuditPaymentService auditPaymentService;

    public PlaceOrderService(OrderRepository orderRepository,AuditPaymentService auditPaymentService){
        this.orderRepository = orderRepository;
        this.auditPaymentService=auditPaymentService;
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
    public void placeOrder(String product, int price){

        OrderProduct req=new OrderProduct();
        req.setPrice(price);
        req.setProduct(product);
        orderRepository.save(req);
        AuditPayment auditorrder= new AuditPayment();
        auditorrder.setPrice(price);
        auditorrder.setProduct_id(req.getId());
        auditorrder.setSuccess(true);
        auditPaymentService.audit(auditorrder);



        
    }
    

    
}
