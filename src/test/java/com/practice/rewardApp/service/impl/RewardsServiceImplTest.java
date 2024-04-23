package com.practice.rewardApp.service.impl;

import com.practice.rewardApp.dto.RewardsDto;
import com.practice.rewardApp.entity.Transaction;
import com.practice.rewardApp.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RewardsServiceImplTest {

    @InjectMocks
    private RewardsServiceImpl rewardsServiceImpl;
    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {

        final Transaction t1 = new Transaction(1L, 1001L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 120.0);
        final Transaction t2 = new Transaction(2L, 1001L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 40.0);
        final Transaction t3 = new Transaction(3L, 1002L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 120.0);
        final Transaction t4 = new Transaction(4L, 1002L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 400.0);
        final Transaction t5 = new Transaction(4L, 1003L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 600.0);

    }

    @Test
    public void getRewardsByCustomerId() {
        Long customerId = 123L;
        final RewardsDto expected = new RewardsDto();
        expected.setCustomerId(123);
        RewardsDto actual = rewardsServiceImpl.getRewardsByCustomerId(customerId);

        assertEquals(expected, actual);
    }


}
