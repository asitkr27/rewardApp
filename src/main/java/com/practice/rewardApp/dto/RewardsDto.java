package com.practice.rewardApp.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
		name = "Customer",
		description = "Schema to hold Customer and Account information"
)
public class RewardsDto {
    @NotEmpty(message = "CustomerId can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "CustomerId must be 10 digits")
    @Schema(
            description = "Customer Id ", example = "3454433243"
    )
    private long customerId;

    @PositiveOrZero(message = "Last 1 months reward point should be equal or greater than zero")
    @Schema(
            description = "Total reward point against a customer for last 1 months ", example = "200"
    )
	private long lastMonthRewardPoints;

    @PositiveOrZero(message = "Last 2 months reward point should be equal or greater than zero")
    @Schema(
            description = "Total reward point against a customer for last 2 months ", example = "400"
    )
    private long lastSecondMonthRewardPoints;

    @PositiveOrZero(message = "Last 3 months  reward point should be equal or greater than zero")
    @Schema(
            description = "Total reward point against a customer for last 3 months ", example = "600"
    )
    private long lastThirdMonthRewardPoints;


    @PositiveOrZero(message = "Total reward point should be equal or greater than zero")
    @Schema(
            description = "Total reward point against a transaction", example = "120"
    )
    private long totalRewards;


}
