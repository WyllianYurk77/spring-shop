package com.wam.springbootshop.repository.projection;

/**
 * @author Wyllian
 */

import java.time.LocalDateTime;

public interface PurchaseItem {
    String getProduct();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
