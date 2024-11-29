package com.sparta.currency_user.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;




import java.math.BigDecimal;


@Getter
@Setter
public class ExchangeRequestRequestDto {

    @NotNull(message = "유저 아이디가 필요합니다")
    @Positive(message = "유저 아이디는 양수입니다")
    private Long userId;

    @NotNull(message = "통화 아이디가 필요합니다")
    @Positive(message = "양수여야 합니다")
    private Long currencyId;

    @NotNull(message = "한화로 얼마인지 적어야 합니다")
    @Positive(message = "양수여야 합니다")
    private BigDecimal amountInKrw;


}
