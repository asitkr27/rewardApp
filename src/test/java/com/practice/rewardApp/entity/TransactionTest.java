package com.practice.rewardApp.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
class TransactionTest {

    @Mock
    private Timestamp mockTransactionDate;

    private Transaction transactionUnderTest;

    @BeforeEach
    void setUp() {
        transactionUnderTest = new Transaction(0L, 0L, mockTransactionDate, 0.0);
    }

    @Test
    void testTransactionIdGetterAndSetter() {
        final Long transactionId = 0L;
        transactionUnderTest.setTransactionId(transactionId);
        assertThat(transactionUnderTest.getTransactionId()).isEqualTo(transactionId);
    }

    @Test
    void testCustomerIdGetterAndSetter() {
        final Long customerId = 0L;
        transactionUnderTest.setCustomerId(customerId);
        assertThat(transactionUnderTest.getCustomerId()).isEqualTo(customerId);
    }

    @Test
    void testTransactionDateGetterAndSetter() {
        final Timestamp transactionDate = Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0));
        transactionUnderTest.setTransactionDate(transactionDate);
        assertThat(transactionUnderTest.getTransactionDate()).isEqualTo(transactionDate);
    }

    @Test
    void testTransactionAmountGetterAndSetter() {
        final double transactionAmount = 0.0;
        transactionUnderTest.setTransactionAmount(transactionAmount);
        assertThat(transactionUnderTest.getTransactionAmount()).isEqualTo(transactionAmount, within(0.0001));
    }

}
