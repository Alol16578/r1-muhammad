package com.restapi.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer>{
    Account findByNumber(Integer number);
    void deleteByNumber(Integer number);
    
    @Query("SELECT a FROM Account a WHERE a.state = true")
    List<Account> findAllActive();
}
