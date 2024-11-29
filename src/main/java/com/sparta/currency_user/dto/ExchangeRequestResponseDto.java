package com.sparta.currency_user.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
public class ExchangeRequestResponseDto {

    private Long requestId;
    private Long userId;
    private Long currencyId;
    private BigDecimal amountInKrw;
    private BigDecimal amountAfterExchange;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public ExchangeRequestResponseDto(Long id, Long userId, Long currencyId, BigDecimal amountInKrw, BigDecimal amountAfterExchange, String status, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.requestId = id;
        this.userId = userId;
        this.currencyId = currencyId;
        this.amountInKrw = amountInKrw;
        this.amountAfterExchange = amountAfterExchange;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
