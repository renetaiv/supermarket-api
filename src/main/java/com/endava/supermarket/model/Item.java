package com.endava.supermarket.model;

import com.endava.supermarket.model.base.BaseEntity;
import com.endava.supermarket.model.enums.ItemType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

import static com.endava.supermarket.constants.Errors.VALID_ITEM_TYPE_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_NAME_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_PRICE_ERROR_MESSAGE;

@Entity
@Getter
@Setter
public class Item extends BaseEntity {

    @NotBlank(message = VALID_NAME_ERROR_MESSAGE)
    @Length(max = 64)
    private String name;

    @NotNull(message = VALID_PRICE_ERROR_MESSAGE)
    private double price;

    @NotNull(message = VALID_ITEM_TYPE_ERROR_MESSAGE)
    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToMany(mappedBy = "items")
    private List<Purchase> purchases = new ArrayList<>();

    @ManyToMany(mappedBy = "items")
    private List<Supermarket> supermarkets = new ArrayList<>();
}
