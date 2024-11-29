package com.sparta.currency_user.repository;

import com.sparta.currency_user.entity.ExchangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRequestRepository extends JpaRepository<ExchangeRequest, Long> {
}
