# Прочие документы

* Развертывание экземпляра PostgreSQL в Docker-контейнере и
  минимальная конфигурация, включающая создание базы данных (БД)

```shell
docker run --name dwh -p 5555:5432 -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dwh -d postgres:11-alpine
```

* создание учетной записи с надлежащими правами доступа,

1. Вариант [подключиться к бд из контейнера ручками]
    * docker exec -it [id container] bash
    * psql --username=postgres --dbname=postgres
    * \l
    * CREATE USER write_user WITH PASSWORD 'pass' VALID UNTIL '2025-12-31';
    * CREATE ROLE read_user WITH LOGIN PASSWORD 'pass' VALID UNTIL '2025-12-31'; //только для чтения
    * \du
2. Вариант [docker-compose c инит файлом]
    * Пользователей создаем в init.sql

3. Вариант [спринг через инит файлы shema.sql и data.sql] ветка - spring

```shell
curl -i -X GET https://itsm365.com/documents_rus/web/Content/Resources/doc/import_ou_csv.csv
```
* настройку сетевого доступа для обращения к БД при помощи современных UI-
  инструментов (например, DBeaver или аналогичных сред) - **как это ?**
- _Скачал DBeaver и через него подключился к БД. Выполнено ?_

```shell
curl -O https://cloclo62.datacloudmail.ru/public/get/c4DtW24Hc7mMUQUUQjYHownVv41kDZNvDgQ6StAsXXznd57e9ueLYzwjrH2RFTg5DE6JZ8S8LnxUfKJXkEVqMUpK6kaLzw7LCA6PpgeUgLfUQz7d8CDWNxzwZyAG1Bdi1LNu6VSgsi5JTXb2ooP9X4jktjD5rFi8ivbqHxumMPdAQPvgJd5DwBFb8R9TsfgT8rRAvCv6sVMiJAj4T8H4iYBfM1eLS3uoc41CcU6iTNEQsYvDEq1s1MJYQycUc149tznzstMMzRWEMRatRz9yikGdGrJFd3VyzwwjHXdyjsQyiGcty4xJJBBmQA7AiLxFKJT7riRwzxTn9uACWCQABVjNnKi3wSXgty5UVPZ5LuXyNX989mHabP4TK98FNwNrpLttZSJyAb5o1Bx/no/IMOEX_230101_240601.csv
```

 