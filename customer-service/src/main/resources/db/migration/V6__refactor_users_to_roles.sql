ALTER TABLE users ADD COLUMN IF NOT EXISTS role VARCHAR(50) NOT NULL DEFAULT 'CLIENT';

CREATE TABLE IF NOT EXISTS master_profiles (
    user_id BIGINT PRIMARY KEY,
    full_name VARCHAR(100),
    phone VARCHAR(50),
    city VARCHAR(50),
    profession VARCHAR(100),
    hourly_rate VARCHAR(50),
    rating DECIMAL,
    description TEXT,

    CONSTRAINT fk_master_profile_user_id
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS client_profiles (
    user_id BIGINT PRIMARY KEY,
    full_name VARCHAR(100),
    phone VARCHAR(50),
    address VARCHAR(255),

    CONSTRAINT fk_client_profile_user_id
        FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
);