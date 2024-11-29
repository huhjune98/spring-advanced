CREATE TABLE User (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 고객 고유 식별자
                      email VARCHAR(30) NOT NULL,          -- 고객 이메일
                      name VARCHAR(30) NOT NULL,           -- 고객 이름
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일자
                      modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 수정일자
);
CREATE TABLE Currency (
                          currency_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 통화 고유 식별자
                          exchange_rate DECIMAL(10, 4) NOT NULL,         -- 환율
                          currency_name VARCHAR(20) NOT NULL,           -- 통화 이름
                          symbol VARCHAR(10),                            -- 표시
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일자
                          modified_at DATE DEFAULT CURRENT_DATE           -- 수정일자
);
CREATE TABLE ExchangeRequest (
                                 id BIGINT AUTO_INCREMENT PRIMARY KEY,           -- 환전 요청 고유 식별자
                                 user_id BIGINT NOT NULL,                        -- 고객 고유 식별자 (Foreign Key)
                                 to_currency_id BIGINT NOT NULL,                -- 환전 대상 통화 식별자 (Foreign Key)
                                 amount_in_krw DECIMAL(15, 2) NOT NULL,          -- 환전 전 금액 (원화 기준)
                                 amount_after_exchange DECIMAL(15, 2) NOT NULL,  -- 환전 후 금액
                                 status VARCHAR(10) DEFAULT 'normal',            -- 상태
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 생성일자
                                 modified_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정일자
                                 CONSTRAINT fk_exchange_user FOREIGN KEY (user_id) REFERENCES User (id) ON DELETE CASCADE,
                                 CONSTRAINT fk_exchange_currency FOREIGN KEY (to_currency_id) REFERENCES Currency (currency_id)
);
