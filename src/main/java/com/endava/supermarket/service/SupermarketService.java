package com.endava.supermarket.service;

import com.endava.supermarket.dto.SupermarketItemsRequestDto;
import com.endava.supermarket.dto.SupermarketItemsResponseDto;
import com.endava.supermarket.model.Supermarket;

import java.util.Optional;

public interface SupermarketService {

    Supermarket create(Supermarket supermarket);

    SupermarketItemsResponseDto addItemsToSupermarket(SupermarketItemsRequestDto supermarketItemsRequestDto);

    Optional<Supermarket> findById(String id);
}
