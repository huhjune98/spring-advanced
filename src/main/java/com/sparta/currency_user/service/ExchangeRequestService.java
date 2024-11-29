package com.sparta.currency_user.service;


import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.ExchangeRequest;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.ExchangeRequestRepository;
import com.sparta.currency_user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeRequestService {

    @PersistenceContext
    private EntityManager entityManager;



    @Transactional
    public ExchangeRequest createExchangeRequest( Long userId, Long currencyId, BigDecimal amountInKrw) {

        //유저, 통화 정보 조회
        User user = entityManager.createQuery("SELECT u From User u WHERE u.id = :userId", User.class).setParameter("userId",userId).getSingleResult();
        Currency currency = entityManager.createQuery(("Select c FROM Currency c WHERE c.id = :currencyId"), Currency.class).setParameter("currencyId", currencyId).getSingleResult();

        //환전 후 금액 계산
        BigDecimal exchangeRate = currency.getExchangeRate();
        BigDecimal amountAfterExchange = amountInKrw.divide(exchangeRate, 2, RoundingMode.HALF_UP);

        //ExchangeRequest 생성, 저장
        ExchangeRequest exchangeRequest = new ExchangeRequest();
        exchangeRequest.setUser(user);
        exchangeRequest.setCurrency(currency);
        exchangeRequest.setAmountInKrw(amountInKrw);
        exchangeRequest.setAmountAfterExchange(amountAfterExchange);
        exchangeRequest.setStatus("normal");
        exchangeRequest.setCreatedAt(LocalDateTime.now());
        exchangeRequest.setModifiedAt(LocalDateTime.now());

        entityManager.persist(exchangeRequest);

        return exchangeRequest;

    }

    @Transactional
    public List<ExchangeRequest> getAllExchangeRequestsByUserId(Long userId) {
        String jpql = "SELECT e FROM ExchangeRequest e WHERE e.user.id = :userId";
        return entityManager.createQuery(jpql, ExchangeRequest.class).
                setParameter("userId", userId).
                getResultList();
    }

    @Transactional
    public ExchangeRequest cancelExchangeRequest(Long requestId) {
        ExchangeRequest exchangeRequest = entityManager.createQuery(
                        "SELECT e FROM ExchangeRequest e WHERE e.id = :requestId", ExchangeRequest.class)
                .setParameter("requestId", requestId)
                .getSingleResult();
        exchangeRequest.setStatus("Cancelled");
        exchangeRequest.setModifiedAt(LocalDateTime.now());

        entityManager.persist(exchangeRequest);
        return exchangeRequest;
    }

}
