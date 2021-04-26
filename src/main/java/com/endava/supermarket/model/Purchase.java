package com.endava.supermarket.model;

import com.endava.supermarket.model.base.BaseEntity;
import com.endava.supermarket.model.enums.PaymentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.endava.supermarket.constants.Errors.VALID_PAYMENT_TYPE_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_SUPERMARKET_ID_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_TOTAL_PRICE_ERROR_MESSAGE;

@Entity
@Getter
@Setter
public class Purchase extends BaseEntity {

    @NotBlank(message = VALID_SUPERMARKET_ID_ERROR_MESSAGE)
    private String supermarketId;

    @NotNull(message = VALID_PAYMENT_TYPE_ERROR_MESSAGE)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @NotNull(message = VALID_TOTAL_PRICE_ERROR_MESSAGE)
    private double totalPrice;

    private double cashAmount;

    private double changeMoney;

    private LocalDate executedPayment;

    @ManyToMany
    @JoinTable(
            name = "purchase_items",
            joinColumns = @JoinColumn(name = "purchase_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();
}
