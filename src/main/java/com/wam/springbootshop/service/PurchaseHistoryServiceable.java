package com.wam.springbootshop.service;

import java.util.List;

import com.wam.springbootshop.model.PurchaseHistory;
import com.wam.springbootshop.repository.projection.PurchaseItem;

/**
 * @author Wyllian
 */

public interface PurchaseHistoryServiceable {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);
    List<PurchaseItem> findUserPurchasedProducts(Long id);
}
