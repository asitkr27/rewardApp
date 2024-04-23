package com.practice.rewardApp.audit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuditAwareImplTest {

    private AuditAwareImpl auditAwareImplUnderTest;

    @BeforeEach
    void setUp() {
        auditAwareImplUnderTest = new AuditAwareImpl();
    }

}
