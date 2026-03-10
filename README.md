# Customer Service

Сервис управления клиентами с поддержкой кэширования через Redis и хранением данных в PostgreSQL.

## Запуск через Docker Compose

1. Убедитесь, что у вас установлены:
   - Docker
   - Docker Compose

2. Выполните команду: bash docker-compose up --build
3. Сервис будет доступен по адресу: http://localhost:8081
4. Swagger UI: http://localhost:8081/swagger-ui.html
### Особенности
- Автоматическое создание таблиц через Flyway
- Кэширование списка клиентов в Redis (`GET /api/customers`)
- При создании клиента кэш сбрасывается
- H2 консоль отключена в профиле `docker`
   
   
   # freelance-crm-lite