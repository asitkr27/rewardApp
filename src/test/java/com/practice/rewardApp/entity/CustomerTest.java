package com.practice.rewardApp.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class CustomerTest {

    private Customer customerUnderTest;

    @BeforeEach
    void setUp() {
        customerUnderTest = new Customer(0L, "customerName");
    }

    @Test
    void testCustomerIdGetterAndSetter() {
        final Long customerId = 0L;
        customerUnderTest.setCustomerId(customerId);
        assertThat(customerUnderTest.getCustomerId()).isEqualTo(customerId);
    }

    @Test
    void testCustomerNameGetterAndSetter() {
        final String customerName = "customerName";
        customerUnderTest.setCustomerName(customerName);
        assertThat(customerUnderTest.getCustomerName()).isEqualTo(customerName);
    }

}
