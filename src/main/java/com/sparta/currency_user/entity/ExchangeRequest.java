package com.sparta.currency_user.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class ExchangeRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", unique = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "currency_id", unique = false)
    private Currency currency;

    @Column(nullable = false)
    private BigDecimal amountInKrw;

    @Column(nullable = false)
    private BigDecimal amountAfterExchange;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime modifiedAt;

    public ExchangeRequest() {}

    public void initializedDate(){
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.modifiedAt = now;
    }

    public void updatedDate(){
        this.modifiedAt = LocalDateTime.now();
    }

}
