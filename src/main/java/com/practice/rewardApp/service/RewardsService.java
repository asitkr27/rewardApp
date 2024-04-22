package com.practice.rewardApp.service;

import com.practice.rewardApp.dto.RewardsDto;


public interface RewardsService {
    RewardsDto getRewardsByCustomerId(Long customerId);
}
