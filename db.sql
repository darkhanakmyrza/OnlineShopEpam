
-- Creating database schema
CREATE SCHEMA `onlineshopepam` ;


CREATE TABLE user (
	id INT PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(45) NOT NULL,
	last_name VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	password VARCHAR(45) NOT NULL,
	admin BOOLEAN,
	active BOOLEAN
);



CREATE TABLE product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price INT NOT NULL,
    image_url VARCHAR(500) NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES user(id)
);


CREATE TABLE cart(
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    user_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);


CREATE TABLE ordering_status(
    id INT PRIMARY KEY AUTO_INCREMENT,
    status_name VARCHAR(45) NOT NULL
);

INSERT INTO `ordering_status` (`id`, `status_name`) VALUES ('1', 'wont be send');
INSERT INTO `ordering_status` (`id`, `status_name`) VALUES ('2', 'canceled');
INSERT INTO `ordering_status` (`id`, `status_name`) VALUES ('3', 'arrived');
INSERT INTO `ordering_status` (`id`, `status_name`) VALUES ('4', 'shipped');
INSERT INTO `ordering_status` (`id`, `status_name`) VALUES ('5', 'pending');


CREATE TABLE address(
    id INT PRIMARY KEY AUTO_INCREMENT,
    country VARCHAR(45) NOT NULL,
    city VARCHAR(45) NOT NULL,
    street VARCHAR(45) NOT NULL,
    phone VARCHAR(45) NOT NULL
);




CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date_time DATETIME NOT NULL,
    status INT,
    delivery_address INT,
    FOREIGN KEY (status) REFERENCES ordering_status(id),
    FOREIGN KEY (delivery_address) REFERENCES address(id)
);

CREATE TABLE order_item(
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    user_id INT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (user_id) REFERENCES user(id)
);



-- admin user with password 1
insert user values(1,'admin','admin', 'ad@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b',1,1);

-- test user with password 1
insert user values(2,'testUser','testUser', 'test@gmail.com', 'c4ca4238a0b923820dcc509a6f75849b',0,1);



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


