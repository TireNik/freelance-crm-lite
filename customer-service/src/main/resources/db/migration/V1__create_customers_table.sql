CREATE TABLE customers
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100)        NOT NULL,
    last_name  varchar(100)        NOT NULL,
    email      varchar(256) UNIQUE NOT NULL,
    phone      varchar(34),
    company    varchar(100),
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);
