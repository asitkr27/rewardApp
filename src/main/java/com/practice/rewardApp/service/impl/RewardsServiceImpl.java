package com.practice.rewardApp.service.impl;

import com.practice.rewardApp.constants.Constants;
import com.practice.rewardApp.dto.RewardsDto;
import com.practice.rewardApp.entity.Transaction;
import com.practice.rewardApp.repository.TransactionRepository;
import com.practice.rewardApp.service.RewardsService;
import com.practice.rewardApp.utlity.CalculateReward;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class RewardsServiceImpl implements RewardsService {


    @Autowired
    private TransactionRepository transactionRepository;

    public RewardsDto getRewardsByCustomerId(Long customerId) {

        Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(Constants.daysInMonths);
        Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * Constants.daysInMonths);
        Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * Constants.daysInMonths);

        List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
                customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
        List<Transaction> lastSecondMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
        List<Transaction> lastThirdMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
                        lastSecondMonthTimestamp);

        Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
        Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
        Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

        RewardsDto rewardsDto = new RewardsDto();
        rewardsDto.setCustomerId(customerId);
        rewardsDto.setLastMonthRewardPoints(lastMonthRewardPoints);
        rewardsDto.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        rewardsDto.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        rewardsDto.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return rewardsDto;

    }

    private Long getRewardsPerMonth(List<Transaction> transactions) {
        return transactions.stream().map(CalculateReward::calculateRewards).mapToLong(r -> r).sum();
    }


    public Timestamp getDateBasedOnOffSetDays(int days) {
        return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
    }

}
