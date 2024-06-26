package com.practice.rewardApp.controller;


import com.practice.rewardApp.dto.ErrorResponseDto;
import com.practice.rewardApp.dto.RewardsDto;
import com.practice.rewardApp.entity.Customer;
import com.practice.rewardApp.repository.CustomerRepository;
import com.practice.rewardApp.service.RewardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * @author Asit Bhakat
 */

@Tag(
        name = "CRUD REST APIs for to calculate rewards of a customer",
        description = "CRUD REST APIs to FETCH rewards points details of the customer"
)
@RestController
@RequestMapping(path = "/api/v1/customers", produces = (MediaType.APPLICATION_JSON_VALUE))
@Validated
@AllArgsConstructor
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @Autowired
    private CustomerRepository customerRepository;


    @Operation(
            summary = "Fetch Reward Details REST API",
            description = "REST API to fetch reward details based on a customer number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping(value = "/{customerId}/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RewardsDto> getRewardsByCustomerId(@PathVariable("customerId") Long customerId) {
        Optional<Customer> customer = customerRepository.findByCustomerId(customerId);
        if (customer.isEmpty()) {
            throw new RuntimeException("Invalid / Missing customer Id ");
        }
        RewardsDto customerRewards = rewardsService.getRewardsByCustomerId(customerId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerRewards);
    }

}
