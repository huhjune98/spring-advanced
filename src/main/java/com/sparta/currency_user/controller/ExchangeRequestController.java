package com.sparta.currency_user.controller;


import com.sparta.currency_user.entity.ExchangeRequest;
import com.sparta.currency_user.service.ExchangeRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/exchange_requests")
public class ExchangeRequestController {

    private final ExchangeRequestService exchangeRequestService;

    public ExchangeRequestController(ExchangeRequestService exchangeRequestService) {
        this.exchangeRequestService = exchangeRequestService;
    }

    // C:환전 요청 수행
    @PostMapping
    public ResponseEntity<ExchangeRequest> createExchangeRequest(@RequestParam Long userId, @RequestParam Long currencyId, @RequestParam BigDecimal amountInKrw) {
        ExchangeRequest exchangeRequest = exchangeRequestService.createExchangeRequest(userId, currencyId, amountInKrw);
        return ResponseEntity.ok(exchangeRequest);
    }


    // R: 고객 고유 식별자를 기반으로 특정 고객이 수행한 환전 요청 조회
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ExchangeRequest>> getExchangeRequests(@PathVariable Long userId) {
        List<ExchangeRequest> exchangeRequests = exchangeRequestService.getAllExchangeRequestsByUserId(userId);
        return ResponseEntity.ok(exchangeRequests);
    }


    // U: 특정 환전 요청 상태를 취소로 변경
    @PutMapping("/{requestId}/cancel")
    public ResponseEntity<ExchangeRequest> cancelExchangeRequest(@PathVariable Long requestId) {
        ExchangeRequest exchangeRequest = exchangeRequestService.cancelExchangeRequest(requestId);
        return ResponseEntity.ok(exchangeRequest);
    }
}
