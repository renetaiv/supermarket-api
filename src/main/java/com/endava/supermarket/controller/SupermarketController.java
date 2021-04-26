package com.endava.supermarket.controller;

import com.endava.supermarket.constants.Errors;
import com.endava.supermarket.dto.SupermarketDto;
import com.endava.supermarket.dto.SupermarketItemsRequestDto;
import com.endava.supermarket.dto.SupermarketItemsResponseDto;
import com.endava.supermarket.exceptions.SupermarketNotFoundException;
import com.endava.supermarket.model.Supermarket;
import com.endava.supermarket.service.SupermarketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static java.lang.String.format;

@RestController
@RequestMapping("/supermarkets")
public class SupermarketController {

    private final SupermarketService supermarketService;
    private final ModelMapper modelMapper;

    @Autowired
    public SupermarketController(SupermarketService supermarketService, ModelMapper modelMapper) {
        this.supermarketService = supermarketService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<SupermarketDto> create(@Valid @RequestBody SupermarketDto supermarketDto) {
        Supermarket supermarket = modelMapper.map(supermarketDto, Supermarket.class);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(supermarketService.create(supermarket), SupermarketDto.class));
    }

    @PostMapping("/add-items")
    public ResponseEntity<SupermarketItemsResponseDto> addItemsToSupermarket(@Valid @RequestBody SupermarketItemsRequestDto supermarketItemsRequestDto) {
        return ResponseEntity.ok(supermarketService.addItemsToSupermarket(supermarketItemsRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupermarketDto> findById(@PathVariable(name = "id") String id) {
        SupermarketDto supermarketDto = modelMapper.map(supermarketService.findById(id)
                .orElseThrow(() -> new SupermarketNotFoundException(format(Errors.SUPERMARKET_NOT_FOUND_ERROR_MESSAGE, id))), SupermarketDto.class);
        return ResponseEntity.ok(supermarketDto);
    }
}
