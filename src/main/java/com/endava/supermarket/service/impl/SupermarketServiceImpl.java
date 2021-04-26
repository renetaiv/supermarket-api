package com.endava.supermarket.service.impl;

import com.endava.supermarket.dto.SupermarketItemsRequestDto;
import com.endava.supermarket.dto.SupermarketItemsResponseDto;
import com.endava.supermarket.exceptions.ItemNotFoundException;
import com.endava.supermarket.exceptions.SupermarketNotFoundException;
import com.endava.supermarket.model.Item;
import com.endava.supermarket.model.Supermarket;
import com.endava.supermarket.repository.ItemRepository;
import com.endava.supermarket.repository.SupermarketRepository;
import com.endava.supermarket.service.SupermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.endava.supermarket.constants.Errors.ITEM_NOT_FOUND_ERROR_MESSAGE;
import static com.endava.supermarket.constants.Errors.SUPERMARKET_NOT_FOUND_ERROR_MESSAGE;
import static java.lang.String.format;

@Service
public class SupermarketServiceImpl implements SupermarketService {

    private final SupermarketRepository supermarketRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public SupermarketServiceImpl(SupermarketRepository supermarketRepository, ItemRepository itemRepository) {
        this.supermarketRepository = supermarketRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public Supermarket create(Supermarket supermarket) {
        return supermarketRepository.save(supermarket);
    }

    @Override
    public SupermarketItemsResponseDto addItemsToSupermarket(SupermarketItemsRequestDto supermarketItemsRequestDto) {
        List<Item> itemList = new ArrayList<>();
        for (String itemId : supermarketItemsRequestDto.getItemIds()) {
            itemList.add(itemRepository.findById(itemId)
                    .orElseThrow(() -> new ItemNotFoundException(format(ITEM_NOT_FOUND_ERROR_MESSAGE, itemId))));
        }

        Supermarket supermarket = supermarketRepository.findById(supermarketItemsRequestDto.getSupermarketId())
                .orElseThrow(() -> new SupermarketNotFoundException(format(SUPERMARKET_NOT_FOUND_ERROR_MESSAGE, supermarketItemsRequestDto.getSupermarketId())));
        supermarket.setItems(itemList);
        supermarketRepository.save(supermarket);

        SupermarketItemsResponseDto supermarketItemsResponseDto = new SupermarketItemsResponseDto();
        supermarketItemsResponseDto.setSupermarketId(supermarketItemsRequestDto.getSupermarketId());

        List<String> itemsNames = new ArrayList<>();
        for (Item item : itemList) {
            itemsNames.add(item.getName());
        }
        supermarketItemsResponseDto.setItemNames(itemsNames);

        return supermarketItemsResponseDto;
    }

    @Override
    public Optional<Supermarket> findById(String id) {
        return supermarketRepository.findById(id);
    }
}
