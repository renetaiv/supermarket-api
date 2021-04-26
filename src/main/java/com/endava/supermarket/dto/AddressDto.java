package com.endava.supermarket.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

import static com.endava.supermarket.constants.Errors.VALID_CITY_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_STREET_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_STREET_NUMBER_ERROR_MESSAGE;

@Getter
@Setter
public class AddressDto {

    @NotBlank(message = VALID_CITY_ERROR_MESSAGE)
    private String city;

    @NotBlank(message = VALID_STREET_ERROR_MESSAGE)
    private String street;

    @NotBlank(message = VALID_STREET_NUMBER_ERROR_MESSAGE)
    private String streetNumber;
}