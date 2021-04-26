package com.endava.supermarket.service;

import com.endava.supermarket.model.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PurchaseService {

    Purchase create(Purchase purchase);

    Page<Purchase> findAll(Pageable pageable);
}
