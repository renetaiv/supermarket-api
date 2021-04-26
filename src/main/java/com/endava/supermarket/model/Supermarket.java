package com.endava.supermarket.model;

import com.endava.supermarket.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

import static com.endava.supermarket.constants.Errors.VALID_NAME_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_PHONE_NUMBER_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.VALID_WORKING_HOURS_ERROR_MESSAGE;
import static com.endava.supermarket.constants.RegexConstants.PHONE_NUMBER;
import static com.endava.supermarket.constants.RegexConstants.WORKING_HOURS;

@Entity
@Getter
@Setter
public class Supermarket extends BaseEntity {

    @NotBlank(message = VALID_NAME_ERROR_MESSAGE)
    @Column(unique = true)
    @Length(max = 64)
    private String name;

    @Pattern(regexp = PHONE_NUMBER, message = VALID_PHONE_NUMBER_ERROR_MESSAGE)
    private String phoneNumber;

    @Pattern(regexp = WORKING_HOURS, message = VALID_WORKING_HOURS_ERROR_MESSAGE)
    private String workingHours;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "supermarket_items",
            joinColumns = @JoinColumn(name = "supermarket_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();
}
