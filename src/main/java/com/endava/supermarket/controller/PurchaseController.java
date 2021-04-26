package com.endava.supermarket.controller;

import com.endava.supermarket.dto.PurchaseRequestDto;
import com.endava.supermarket.dto.PurchaseResponseDto;
import com.endava.supermarket.model.Purchase;
import com.endava.supermarket.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private final ModelMapper modelMapper;
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(ModelMapper modelMapper, PurchaseService purchaseService) {
        this.modelMapper = modelMapper;
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDto> create(@Valid @RequestBody PurchaseRequestDto purchaseRequestDto) {
        Purchase purchase = modelMapper.map(purchaseRequestDto, Purchase.class);
        purchase = purchaseService.create(purchase);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(modelMapper.map(purchase, PurchaseResponseDto.class));
    }

    @GetMapping
    public ResponseEntity<Page<PurchaseResponseDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(purchaseService.findAll(pageable)
                .map(purchase -> modelMapper.map(purchase, PurchaseResponseDto.class)));
    }
}
