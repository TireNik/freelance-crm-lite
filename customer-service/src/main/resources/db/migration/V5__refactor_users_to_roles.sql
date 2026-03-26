CREATE TABLE master_profile
(
    user_id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(100),
    phone VARCHAR(50),
    city VARCHAR(50),
    profession VARCHAR(100),
    hourly_rate VARCHAR(100),
    rating DECIMAL,
    "description" VARCHAR(255),

    CONSTRAINT fk_users_id FOREIGN KEY (user_id) REFERENCES users (id)
)

CREATE TABLE client_profiles
(
    user_id BIGSERIAL PRIMARY KEY,
    full_name VARCHAR(100),
    phone VARCHAR(50),
    addres VARCHAR(255),

    CONSTRAINT fk_users_id FOREIGN KEY (user_id) REFERENCES users (id)
)