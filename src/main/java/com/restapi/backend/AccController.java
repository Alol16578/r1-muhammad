package com.restapi.backend;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;





// REST CONTROLLER RETURNS IN JSON
@RestController
@RequestMapping("/api/v1")
public class AccController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        // Envia listado de cuentas activas
        return accountRepository.findAllActive();
    }
    
    @GetMapping("/accounts/{id}")
    public Account getSpecificAccount(@PathVariable(value="id") Integer id) {
        // Envia información específica de una cuenta de acuerdo
        //  al id en la URL. Tambien lista cuentas desactivadas
        return accountRepository.findByNumber(id);
    }

    @PostMapping("/accounts")
    public void postMethodName(@RequestParam String name,
                                  @RequestParam Double balance,
                                  @RequestParam Boolean state) {
        // Creación de nueva cuenta
        // TODO: Registro debe viajar en el /body/ en formato JSON
        Account account = new Account();
        account.setName(name);
        account.setBalance(balance);
        account.setState(state);
        accountRepository.save(account);
        return;
    }
    
    @PutMapping("/accounts/{id}")
    public Boolean putMethodName(@PathVariable Integer id,
                                 @RequestParam Optional<String> name,
                                 @RequestParam Optional<Double> balance,
                                 @RequestParam Optional<Boolean> state) {
        // Modificar SALDO de cuenta

        if ((!accountRepository.findByNumber(id).equals(Optional.empty())) 
            && (name.isPresent() || balance.isPresent() || state.isPresent())){
            // Check if account exists & if a parameter was passed
            Account account = accountRepository.findByNumber(id);
            if (!name.isEmpty()) 
                account.setName(name.get());

            if (!balance.isEmpty())
                account.setBalance(balance.get());
            
            if (!state.isEmpty())
                account.setState(state.get());

            accountRepository.save(account);
            return true;
        }
        
        return false;
    }

    @DeleteMapping("/accounts/{id}")
    public Boolean deleteMethodName(@PathVariable Integer id) {
        // ELIMINAR = DESACTIVAR CUENTA

        if (!accountRepository.findByNumber(id).equals(Optional.empty())){
            Account account = accountRepository.findByNumber(id);
            account.setState(false);
            accountRepository.save(account);
            return true;
        }
        return false;
    }
}
