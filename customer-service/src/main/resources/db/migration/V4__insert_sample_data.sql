-- Добавляем пользователей
INSERT INTO users (username, email, password_hash, role, created_at) VALUES
('admin', 'admin@crm.com', '$2a$12$iuKwqAeH7g6Z9y6L03si.eDkOxOzSvW5I8BZ6YJfX3/', 'ADMIN', NOW()),
('manager1', 'manager1@crm.com', '$2a$12$iuKwqAeH7g6Z9y6L03si.eDkOxOzSvW5I8BZ6YJfX3/', 'USER', NOW()),
('manager2', 'manager2@crm.com', '$2a$12$iuKwqAeH7g6Z9y6L03si.eDkOxOzSvW5I8BZ6YJfX3/', 'USER', NOW()),
('sales', 'sales@crm.com', '$2a$12$iuKwqAeH7g6Z9y6L03si.eDkOxOzSvW5I8BZ6YJfX3/', 'USER', NOW());

-- Добавляем клиентов
INSERT INTO customers (first_name, last_name, email, phone, company, user_id) VALUES
('Иван', 'Иванов', 'ivan@example.com', '+79123456789', 'ТехноЛаб', 1),
('Мария', 'Петрова', 'maria@example.com', '+79223456789', 'Стартап Х', 2),
('Алексей', 'Сидоров', 'alex@example.com', '+79323456789', 'Газпром Торг', 1),
('Елена', 'Кузнецова', 'elena@example.com', '+79423456789', 'МедИнновации', 3);