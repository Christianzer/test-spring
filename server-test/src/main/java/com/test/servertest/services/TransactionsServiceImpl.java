package com.test.servertest.services;

import com.test.servertest.models.Transactions;
import com.test.servertest.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public Transactions saveTransactions(final Transactions transactions){
        return transactionsRepository.save(transactions);
    }

    @Override
    public Long nombreTransactions(){
        return transactionsRepository.count();
    }

    @Override
    public List<Transactions> findAll(){
        return transactionsRepository.findAll();
    }
}
