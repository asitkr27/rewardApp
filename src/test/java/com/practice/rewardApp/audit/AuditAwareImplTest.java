package com.practice.rewardApp.audit;

import org.junit.jupiter.api.BeforeEach;

class AuditAwareImplTest {

    private AuditAwareImpl auditAwareImplUnderTest;

    @BeforeEach
    void setUp() {
        auditAwareImplUnderTest = new AuditAwareImpl();
    }

}
