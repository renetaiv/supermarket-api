package com.endava.supermarket.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

import static com.endava.supermarket.constants.Errors.VALID_ADDRESS_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_NAME_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_PHONE_NUMBER_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_WORKING_HOURS_ERROR_MESSAGE;
import static com.endava.supermarket.constants.RegexConstants.PHONE_NUMBER;
import static com.endava.supermarket.constants.RegexConstants.WORKING_HOURS;

@Getter
@Setter
public class SupermarketDto {

    @NotBlank(message = VALID_NAME_ERROR_MESSAGE)
    @Column(unique = true)
    @Length(max = 64)
    private String name;

    @Valid
    @NotNull(message = VALID_ADDRESS_ERROR_MESSAGE)
    private AddressDto address;

    @Pattern(regexp = PHONE_NUMBER, message = VALID_PHONE_NUMBER_ERROR_MESSAGE)
    private String phoneNumber;

    @Pattern(regexp = WORKING_HOURS, message = VALID_WORKING_HOURS_ERROR_MESSAGE)
    private String workingHours;

    private List<ItemResponseDtoWithId> items = new ArrayList<>();
}
