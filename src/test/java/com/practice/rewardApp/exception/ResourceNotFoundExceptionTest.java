package com.practice.rewardApp.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ResourceNotFoundExceptionTest {

    private ResourceNotFoundException resourceNotFoundExceptionUnderTest;

    @BeforeEach
    void setUp() {
        resourceNotFoundExceptionUnderTest = new ResourceNotFoundException("resourceName", "fieldName", "fieldValue");
    }
}
