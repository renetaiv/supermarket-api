package com.endava.supermarket.model;

import com.endava.supermarket.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import static com.endava.supermarket.constants.Errors.VALID_CITY_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_STREET_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_STREET_NUMBER_ERROR_MESSAGE;

@Entity
@Getter
@Setter
public class Address extends BaseEntity {

    @NotBlank(message = VALID_CITY_ERROR_MESSAGE)
    private String city;

    @NotBlank(message = VALID_STREET_ERROR_MESSAGE)
    private String street;

    @NotBlank(message = VALID_STREET_NUMBER_ERROR_MESSAGE)
    private String streetNumber;
}