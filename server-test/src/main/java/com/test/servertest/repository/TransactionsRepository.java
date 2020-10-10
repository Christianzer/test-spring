package com.test.servertest.repository;

import com.test.servertest.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long> {
}
