package in.strikes.jpaRelationShipDemo.controller;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.strikes.jpaRelationShipDemo.model.Account;
import in.strikes.jpaRelationShipDemo.model.TransferRecord;
import in.strikes.jpaRelationShipDemo.service.AccountService;

@RestController 
@RequestMapping ("/api")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService){
        this.accountService= accountService;

    }

    @PostMapping("/account")
    public ResponseEntity<String> createAccount(@RequestBody Account account){
        accountService.createAccount(account);

        return ResponseEntity.ok("Account Created Successfully");

    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferAmount(@RequestBody TransferRecord record){
        accountService.transferAmount(record.getFromAccId(),record.getToAccId(),record.getAmount());
        return ResponseEntity.ok("Amount Transfered Successfully");
    }
    
    
}
