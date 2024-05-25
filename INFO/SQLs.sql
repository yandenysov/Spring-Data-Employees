
-- БАЗА ДАНИХ
-- Можливість створення БД з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Можемо створити БД через візуальний інструмент, наприклад,
-- MySQL Workbench.
CREATE DATABASE demo_db;

-- ТАБЛИЦІ
-- Можливість створення таблиць БД, з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Попередньо, необхідно спроектувати таблиці та їх зв'язки,
-- на основі сутностей реального світу.
-- Можемо створити таблиці БД через візуальний інструмент, наприклад,
-- MySQL Workbench.

CREATE TABLE IF NOT EXISTS employees
( id INTEGER NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  position VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

GET
http://localhost:8080/api/v1/employees

POST
http://localhost:8080/api/v1/employees

{
	"firstName": "Alice",
	"lastName": "Jackson",
	"position": "Manager"
	"phone": "258 956-1293"
}

{
	"firstName": "Bob",
	"lastName": "Roberts",
	"position": "Manager"
	"phone": "931 381-0765"
}

{
	"firstName": "The",
	"lastName": "Boss",
	"position": "CEO"
	"phone": "777 777-7777"
}

GET
Отримання за ID
http://localhost:8080/api/v1/employees/2

PUT
Оновлення за ID
http://localhost:8080/api/v1/employees/3

{
	"firstName": "Theodore",
	"lastName": "Boss",
}

GET
Отримання даних за іменем
http://localhost:8080/api/v1/employees/first-name/Alice

Також можливо отримати за прізвищем, посадою, телефоном

DELETE
Видалення за ID
http://localhost:8080/api/v1/employees/3





