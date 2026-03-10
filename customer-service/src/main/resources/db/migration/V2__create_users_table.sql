CREATE TABLE Users
(
    id            BIGSERIAL PRIMARY KEY,
    username      VARCHAR(100) NOT NULL UNIQUE,
    email         VARCHAR(256) NOT NULL UNIQUE,
    password_hash VARCHAR(256) NOT NUll,
    role          VARCHAR(50)  NOT NULL DEFAULT 'USER',
    created_at    TIMESTAMP             DEFAULT NOW()
)