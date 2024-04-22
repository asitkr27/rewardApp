package com.practice.rewardApp.repository;

import com.practice.rewardApp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByCustomerId(Long customerId);

    List<Transaction> findAllByCustomerIdAndTransactionDateBetween(Long customerId, Timestamp from, Timestamp to);
}
