package com.practice.rewardApp.exception;

import org.junit.jupiter.api.BeforeEach;

class ResourceNotFoundExceptionTest {

    private ResourceNotFoundException resourceNotFoundExceptionUnderTest;

    @BeforeEach
    void setUp() {
        resourceNotFoundExceptionUnderTest = new ResourceNotFoundException("resourceName", "fieldName", "fieldValue");
    }
}
