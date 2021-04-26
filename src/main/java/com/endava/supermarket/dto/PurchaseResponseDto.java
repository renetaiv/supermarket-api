package com.endava.supermarket.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.endava.supermarket.constants.Errors.VALID_TOTAL_PRICE_ERROR_MESSAGE;

@Getter
@Setter
public class PurchaseResponseDto extends PurchaseRequestDto {

    @NotNull(message = VALID_TOTAL_PRICE_ERROR_MESSAGE)
    private double totalPrice;

    private double changeMoney;

    private LocalDate executedPayment;
}
