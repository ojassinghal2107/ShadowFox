package com.example.bap;


import com.example.bap.Transaction;
import com.example.bap.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findByAccountId(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
