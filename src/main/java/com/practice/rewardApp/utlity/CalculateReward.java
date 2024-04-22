package com.practice.rewardApp.utlity;

import com.practice.rewardApp.constants.Constants;
import com.practice.rewardApp.entity.Transaction;

public class CalculateReward {
    public static Long calculateRewards(Transaction t) {
        if (t.getTransactionAmount() > Constants.firstRewardLimit && t.getTransactionAmount() <= Constants.secondRewardLimit) {
            return Math.round(t.getTransactionAmount() - Constants.firstRewardLimit);
        } else if (t.getTransactionAmount() > Constants.secondRewardLimit) {
            return Math.round(t.getTransactionAmount() - Constants.secondRewardLimit) * 2
                    + (Constants.secondRewardLimit - Constants.firstRewardLimit);
        } else
            return 0l;

    }
}
