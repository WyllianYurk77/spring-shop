package com.wam.springbootshop.model;

import java.time.LocalDateTime;

import javax.persistence.Column;

/**
 * @author Wyllian
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "purchase_history")
@Data
public class PurchaseHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_price", nullable = false)
    private Double productPrice;

    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;
}
