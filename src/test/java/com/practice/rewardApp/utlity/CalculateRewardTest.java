package com.practice.rewardApp.utlity;

import com.practice.rewardApp.entity.Transaction;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateRewardTest {

    @Test
    void testCalculateRewards() {
        // Setup
        final Transaction t = new Transaction(0L, 0L, Timestamp.valueOf(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)), 0.0);

        // Run the test
        final Long result = CalculateReward.calculateRewards(t);

        // Verify the results
        assertThat(result).isEqualTo(0L);
    }
}
