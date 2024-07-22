# Рассуждения

* Развертывание экземпляра PostgreSQL в Docker-контейнере и
  минимальная конфигурация, включающая создание базы данных (БД)

```shell
docker run --name dwh -p 5555:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dwh -d postgres:11-alpine
```

* создание учетной записи с надлежащими правами доступа,

1. Вариант [подключиться к бд из контейнера ручками]
    * docker exec -it [id container] bash
    * psql --username=write_user --dbname=postgres
    * \l
    * CREATE USER write_user WITH PASSWORD 'pass' VALID UNTIL '2025-12-31';
    * CREATE ROLE read_user WITH LOGIN PASSWORD 'pass' VALID UNTIL '2025-12-31'; //только для чтения
    * \du
2. Вариант [docker-compose c инит файлом]
    * Пользователей создаем в init.sql

3. Вариант [спринг через инит файлы shema.sql и data.sql] ветка - spring
 

* настройку сетевого доступа для обращения к БД при помощи современных UI-
  инструментов (например, DBeaver или аналогичных сред) - **как это ?**
- _Скачал DBeaver и через него подключился к БД. Выполнено ?_

```shell
curl -O https://cloclo58.cloud.mail.ru/public/M87gXAw89WHWyoBB8H5/g/no/L1xB/nvgHGYJz5
```

 