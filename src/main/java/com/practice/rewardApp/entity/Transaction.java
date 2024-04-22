package com.practice.rewardApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "transaction_date")
    private Timestamp transactionDate;

    @Column(name = "transaction_amount")
    private double transactionAmount;


}
