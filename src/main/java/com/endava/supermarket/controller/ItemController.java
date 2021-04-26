package com.endava.supermarket.controller;

import com.endava.supermarket.dto.ItemDto;
import com.endava.supermarket.model.Item;
import com.endava.supermarket.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    @Autowired
    public ItemController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<ItemDto> create(@Valid @RequestBody ItemDto itemDto) {
        Item item = modelMapper.map(itemDto, Item.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(itemService.create(item), ItemDto.class));
    }
}
