package com.endava.supermarket.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static com.endava.supermarket.constants.Errors.VALID_LIST_ITEMS_IDS_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_SUPERMARKET_ID_ERROR_MESSAGE;

@Getter
@Setter
public class SupermarketItemsRequestDto {

    @NotNull(message = VALID_SUPERMARKET_ID_ERROR_MESSAGE)
    private String supermarketId;

    @NotEmpty(message = VALID_LIST_ITEMS_IDS_ERROR_MESSAGE)
    private List<String> itemIds = new ArrayList<>();
}
