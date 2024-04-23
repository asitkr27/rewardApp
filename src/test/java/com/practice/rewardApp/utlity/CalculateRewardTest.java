package com.practice.rewardApp.utlity;

import com.practice.rewardApp.entity.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CalculateRewardTest {

    @Test
    void testCalculateRewardsMoreThan100() {
        // Setup
        final Transaction t = new Transaction(1L, 1009L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 120.0);
        // Run the test
        final Long result = CalculateReward.calculateRewards(t);
        // Verify the results
        assertThat(result).isEqualTo(90L);
    }

    @Test
    void testCalculateRewardsLessThan100() {
        // Setup
        final Transaction t = new Transaction(1L, 1009L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 120.0);
        // Run the test
        final Long result = CalculateReward.calculateRewards(t);
        // Verify the results
        assertThat(result).isEqualTo(90L);
    }

    @Test
    void testCalculateRewardWithZero() {
        // Setup
        final Transaction t = new Transaction(1L, 1009L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 0L);
        // Run the test
        final Long result = CalculateReward.calculateRewards(t);
        // Verify the results
        assertThat(result).isEqualTo(0L);
    }

    @Test
    void testCalculateRewardWithLessThan50() {
        // Setup
        final Transaction t = new Transaction(1L, 1009L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 40.0);
        // Run the test
        final Long result = CalculateReward.calculateRewards(t);
        // Verify the results
        assertThat(result).isEqualTo(0L);
    }

    @Test
    void testCalculateRewardBetween50To100() {
        // Setup
        final Transaction t = new Transaction(1L, 1009L, Timestamp.valueOf(LocalDateTime.of(2024, 4, 23, 0, 0, 0, 0)), 90.0);
        // Run the test
        final Long result = CalculateReward.calculateRewards(t);
        // Verify the results
        assertThat(result).isEqualTo(40L);
    }
}
