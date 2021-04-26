package com.endava.supermarket.dto;

import com.endava.supermarket.model.enums.ItemType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.endava.supermarket.constants.Errors.VALID_ITEM_TYPE_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_NAME_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_PRICE_ERROR_MESSAGE;

@Getter
@Setter
public class ItemDto {

    @NotBlank(message = VALID_NAME_ERROR_MESSAGE)
    @Length(max = 64)
    private String name;

    @NotNull(message = VALID_PRICE_ERROR_MESSAGE)
    private double price;

    @NotNull(message = VALID_ITEM_TYPE_ERROR_MESSAGE)
    private ItemType itemType;
}
