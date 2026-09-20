package in.strikes.jpaRelationShipDemo.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import in.strikes.jpaRelationShipDemo.model.Account;
import in.strikes.jpaRelationShipDemo.model.TransferRecord;
import in.strikes.jpaRelationShipDemo.repository.AccountRepository;
import in.strikes.jpaRelationShipDemo.repository.TransferRecordRepository;
import jakarta.transaction.Transactional;

@Service 
public class AccountService {
    private AccountRepository accountRepository;
    private TransferRecordRepository transferRecordRepository;

    public AccountService(AccountRepository accountRepository, TransferRecordRepository transferRecordRepository){
        this.accountRepository=accountRepository;
        this.transferRecordRepository=transferRecordRepository;

    }

    public void createAccount(Account account){
        accountRepository.save(account);
    }


    @Transactional 
    public void transferAmount(Long fromAccId, Long toAccId,BigDecimal amount){

        Account fromAccount= accountRepository.findById(fromAccId).orElseThrow(()->new RuntimeException("invalid account id"));
        Account toAccount= accountRepository.findById(toAccId).orElseThrow(()->new RuntimeException("invalid account id"));

        fromAccount.debit(amount);
        accountRepository.saveAndFlush(fromAccount);
    
        toAccount.credit(amount);
        accountRepository.saveAndFlush(toAccount);


        transferRecordRepository.save(new TransferRecord(fromAccId,toAccId,amount,LocalDate.now()));
        // throw new RuntimeException();

    }

    
}
