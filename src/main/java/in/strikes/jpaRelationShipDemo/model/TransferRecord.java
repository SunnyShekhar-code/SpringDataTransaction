package in.strikes.jpaRelationShipDemo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

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
public class TransferRecord {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private Long fromAccId;
    private Long toAccId;
    private LocalDate date;
    private BigDecimal amount;

    public TransferRecord(Long fromAccId,Long toAccId, BigDecimal amount,LocalDate date){
        this.fromAccId=fromAccId;
        this.toAccId=toAccId;
        this.amount=amount;
        this.date=date;
    }
    
}
