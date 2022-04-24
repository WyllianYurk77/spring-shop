package com.wam.springbootshop.service;

import java.time.LocalDateTime;
import java.util.List;

import com.wam.springbootshop.model.PurchaseHistory;
import com.wam.springbootshop.repository.PurchaseHistoryRepository;
import com.wam.springbootshop.repository.projection.PurchaseItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wyllian
 */

@Service
public class PurchaseHistoryService implements PurchaseHistoryServiceable {
    
    @Autowired
    private PurchaseHistoryRepository pHistoryRepository;

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return pHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseItem> findUserPurchasedProducts(Long id) {
        return pHistoryRepository.findAllUserPurchases(id);
    }
}
