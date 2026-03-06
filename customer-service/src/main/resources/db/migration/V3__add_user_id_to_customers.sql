ALTER TABLE customers
    ADD COLUMN user_id BIGINT NULL;

ALTER TABLE customers
    ADD CONSTRAINT fk_customers_user
        FOREIGN KEY (user_id) REFERENCES users (id)
            ON UPDATE CASCADE
            ON DELETE SET NUll;