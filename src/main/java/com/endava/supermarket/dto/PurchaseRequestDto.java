package com.endava.supermarket.dto;

import com.endava.supermarket.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import static com.endava.supermarket.constants.Errors.VALID_PAYMENT_TYPE_ERROR_MESSAGE;

@Getter
@Setter
public class PurchaseRequestDto extends SupermarketItemsRequestDto {

    @NotNull(message = VALID_PAYMENT_TYPE_ERROR_MESSAGE)
    private PaymentType paymentType;

    private double cashAmount;
}
