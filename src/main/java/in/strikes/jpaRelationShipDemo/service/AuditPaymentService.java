package in.strikes.jpaRelationShipDemo.service;
import in.strikes.jpaRelationShipDemo.model.AuditPayment;
import in.strikes.jpaRelationShipDemo.repository.AuditPaymentRepository;



public class AuditPaymentService {
    private AuditPaymentRepository auditPaymentRepository;
    public AuditPaymentService(AuditPaymentRepository auditPaymentRepository){
        this.auditPaymentRepository=auditPaymentRepository;
    }

    public void audit(AuditPayment auditPayment){
        auditPaymentRepository.save(auditPayment);

    }
    
}
