package com.endava.supermarket.service.impl;

import com.endava.supermarket.model.Item;
import com.endava.supermarket.model.Purchase;
import com.endava.supermarket.model.enums.PaymentType;
import com.endava.supermarket.repository.PurchaseRepository;
import com.endava.supermarket.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase create(Purchase purchase) {
        double total = 0.0;
        for (Item item : purchase.getItems()) {
            total += item.getPrice();
        }
        purchase.setTotalPrice(total);
        if (purchase.getPaymentType() == PaymentType.CASH) {
            purchase.setChangeMoney(purchase.getCashAmount() - total);
        }
        purchase.setExecutedPayment(LocalDate.now());
        return purchaseRepository.save(purchase);
    }

    @Override
    public Page<Purchase> findAll(Pageable pageable) {
        return purchaseRepository.findAll(pageable);
    }
}
