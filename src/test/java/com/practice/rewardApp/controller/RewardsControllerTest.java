package com.practice.rewardApp.controller;

import com.practice.rewardApp.repository.CustomerRepository;
import com.practice.rewardApp.service.RewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RewardsControllerTest {

    @Mock
    private RewardsService mockRewardsService;
    @Mock
    private CustomerRepository mockCustomerRepository;

    private RewardsController rewardsControllerUnderTest;

    @BeforeEach
    void setUp() {
        rewardsControllerUnderTest = new RewardsController(mockRewardsService, mockCustomerRepository);
    }


    @Test
    void testGetRewardsByCustomerId_CustomerRepositoryReturnsAbsent() {
        // Setup
        when(mockCustomerRepository.findByCustomerId(0L)).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> rewardsControllerUnderTest.getRewardsByCustomerId(0L))
                .isInstanceOf(RuntimeException.class);
    }
}
