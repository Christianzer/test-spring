package com.test.servertest.services;

import com.test.servertest.models.Transactions;

import java.util.List;

public interface TransactionsService {
    Transactions saveTransactions(Transactions transactions);

    Long nombreTransactions();

    List<Transactions> findAll();
}
