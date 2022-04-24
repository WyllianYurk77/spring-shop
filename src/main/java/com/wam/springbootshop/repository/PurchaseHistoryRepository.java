package com.wam.springbootshop.repository;

/**
 * @author Wyllian
 */

import java.util.List;

import com.wam.springbootshop.model.PurchaseHistory;
import com.wam.springbootshop.repository.projection.PurchaseItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {
    
    @Query(" SELECT DISTINCT " +
            " b.title AS title, ph.productPrice AS price, ph.purchaseTime AS purchaseDate " + 
            " FROM PurchaseHistory ph " +
            " LEFT JOIN Book b ON b.id = ph.productId " +
            " WHERE ph.userId = :userId ")
    List<PurchaseItem> findAllUserPurchases(@Param("userId") Long userId);
}
