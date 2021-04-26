package com.endava.supermarket.service.impl;

import com.endava.supermarket.model.Item;
import com.endava.supermarket.repository.ItemRepository;
import com.endava.supermarket.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }
}
