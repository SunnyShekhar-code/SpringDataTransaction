package in.strikes.jpaRelationShipDemo.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
public class Account {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id 
    private Long id;
    private String name;
    private BigDecimal balance;

    public void credit(BigDecimal amount){
        if(amount==null || amount.signum()<=0){
            throw new RuntimeException("Invalid Amount");
           
        }
        balance=balance.add(amount);
    }

    public void debit(BigDecimal amount){
        if(amount==null || amount.signum()<=0){
            throw new RuntimeException("Invalid Amount");
        }
        if(balance.compareTo(amount)<0){
            throw new RuntimeException("Insufficient Amount");
        }
        balance=balance.subtract(amount);
    }
    
}
