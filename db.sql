-- Creating database schema
CREATE SCHEMA `onlineshopepam` ;

--creating user table
CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(45) NOT NULL,
	last_name VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	admin BOOLEAN,
	active BOOLEAN
);

--creating product table
CREATE TABLE product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price INT NOT NULL,
    image_url VARCHAR(500) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);

--creating table cart
CREATE TABLE cart(
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    user_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);

insert user values(1,'admin','admin', 'ad@gmail.com', 'admin',1,1);
insert user values(2,'testUser','testUser', 'test@gmail.com', 'test',0,1);
insert user values(3,'testUser2','testUser2', 'test2@gmail.com', 'test2',0,1);


insert product values(1, 'Apple MacBook Pro 13',
'- операционная система: Mac OS
- диагональ экрана: 13.3 дюйм
- разрешение экрана: 2560x1600
- процессор: Core i5
- тип видеоадаптера: встроенная видеокарта
- видеокарта: Intel Iris Plus Graphics 645
- размер оперативной памяти: 8 ГБ
- тип жесткого диска: SSD
- общий объем накопителей: 128 ГБ',
430000,
'https://cdn-kaspi.kz/shop/medias/sys_master/images/images/h3b/h00/10447217426462/apple-macbook-pro-13-2019-with-touch-bar-muhn2-space-gray-1307050-1.jpg',
1);

insert product values(2, 'Lenovo thinkPad',
'- тип: ноутбук
- операционная система: Без ОС
- диагональ экрана: 14 дюйм
- разрешение экрана: 1920x1080
- процессор: Intel Core i5-8265U
- тип видеоадаптера: встроенная видеокарта
- видеокарта: Intel UHD Graphics 620
- размер оперативной памяти: 8 ГБ
- тип жесткого диска: SSD
- общий объем накопителей: 256 ГБ',
399500,
'https://cdn-kaspi.kz/shop/medias/sys_master/images/images/h3f/hf4/13549040467998/lenovo-thinkpad-t490-20n2004grt-cernyj-100377620-4.png',
1);
