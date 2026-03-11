CREATE TABLE tasks
(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(256),
    description TEXT,
    status VARCHAR (25),
    customer_id BIGINT REFERENCES customers(id),
    user_id BIGINT REFERENCES users(id),
    due_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)