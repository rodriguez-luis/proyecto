-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-10-29 21:39:51.339

-- tables
-- Table: cart
CREATE TABLE cart (
    cart_id int NOT NULL AUTO_INCREMENT,
    purchase_details_id int NOT NULL,
    id_status int NOT NULL,
    id_user int NOT NULL,
    CONSTRAINT cart_pk PRIMARY KEY (cart_id)
);

-- Table: chat
CREATE TABLE chat (
    chat_id int NOT NULL AUTO_INCREMENT,
    id_user int NOT NULL,
    date date NOT NULL,
    start time NOT NULL,
    end time NOT NULL,
    log varchar(50) NOT NULL,
    CONSTRAINT chat_pk PRIMARY KEY (chat_id)
);

-- Table: checkout
CREATE TABLE checkout (
    id_checkout int NOT NULL AUTO_INCREMENT,
    cart_id int NOT NULL,
    payment_details_id int NOT NULL,
    date date NOT NULL,
    total numeric(12,6) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    id_user int NOT NULL,
    CONSTRAINT checkout_pk PRIMARY KEY (id_checkout)
);

-- Table: city
CREATE TABLE city (
    id int NOT NULL AUTO_INCREMENT,
    city_name varchar(128) NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: company
CREATE TABLE company (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NULL,
    direction varchar(50) NULL,
    phone varchar(50) NULL,
    email varchar(50) NOT NULL,
    CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: h_checkout
CREATE TABLE h_checkout (
    h_checkout_id int NOT NULL,
    client_id int NOT NULL,
    cart_cart_id int NOT NULL,
    payment_details_id int NOT NULL,
    date date NOT NULL,
    total numeric(12,6) NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_checkout_pk PRIMARY KEY (h_checkout_id)
);

-- Table: h_inventory
CREATE TABLE h_inventory (
    h_inventory_id int NOT NULL,
    in_stock decimal(8,2) NULL,
    last_update_time timestamp NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_inventory_pk PRIMARY KEY (h_inventory_id)
);

-- Table: h_product
CREATE TABLE h_product (
    h_product_id int NOT NULL,
    product_type_id int NOT NULL,
    company_id int NOT NULL,
    city_id int NOT NULL,
    status_id_status int NOT NULL,
    product_name varchar(64) NULL,
    product_description varchar(255) NULL,
    unit varchar(16) NULL,
    price_per_unit numeric(12,6) NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_product_pk PRIMARY KEY (h_product_id)
);

-- Table: h_user
CREATE TABLE h_user (
    h_user_id int NOT NULL,
    id_user int NOT NULL,
    person_id int NOT NULL,
    company_id int NOT NULL,
    id_status int NOT NULL,
    username varchar(50) NULL,
    password varchar(50) NULL,
    salt varchar(50) NOT NULL,
    token int NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    deleted_at timestamp NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT h_user_pk PRIMARY KEY (h_user_id)
) COMMENT 'Tabla de usuarios';

-- Table: inventory
CREATE TABLE inventory (
    product_id int NOT NULL AUTO_INCREMENT,
    in_stock decimal(8,2) NULL,
    last_update_time timestamp NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT inventory_pk PRIMARY KEY (product_id)
);

-- Table: message
CREATE TABLE message (
    id_message int NOT NULL AUTO_INCREMENT,
    chat_id int NOT NULL,
    time time NOT NULL,
    content text NOT NULL,
    CONSTRAINT message_pk PRIMARY KEY (id_message)
);

-- Table: payment_data
CREATE TABLE payment_data (
    id int NOT NULL AUTO_INCREMENT,
    payment_type_id int NOT NULL,
    data_name varchar(255) NULL,
    data_type varchar(255) NOT NULL,
    UNIQUE INDEX payment_data_ak_1 (payment_type_id,data_name),
    CONSTRAINT payment_data_pk PRIMARY KEY (id)
);

-- Table: payment_details
CREATE TABLE payment_details (
    id int NOT NULL AUTO_INCREMENT,
    payment_data_id int NOT NULL,
    value varchar(255) NULL,
    CONSTRAINT payment_details_pk PRIMARY KEY (id)
);

-- Table: payment_type
CREATE TABLE payment_type (
    id int NOT NULL AUTO_INCREMENT,
    type_name varchar(64) NULL,
    CONSTRAINT payment_type_pk PRIMARY KEY (id)
) COMMENT 'e.g. card, cash, paypal, wire transfer';

-- Table: person
CREATE TABLE person (
    id int NOT NULL,
    city_id int NOT NULL,
    id_status int NOT NULL,
    first_name int NULL,
    last_name varchar(50) NULL,
    phone varchar(25) NULL,
    birth_date date NULL,
    email varchar(50) NULL,
    address varchar(50) NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id)
);

-- Table: privilege
CREATE TABLE privilege (
    id_privilege int NOT NULL,
    privilegio_nombre varchar(50) NULL,
    CONSTRAINT privilege_pk PRIMARY KEY (id_privilege)
);

-- Table: product
CREATE TABLE product (
    id int NOT NULL AUTO_INCREMENT,
    product_type_id int NOT NULL,
    company_id int NOT NULL,
    city_id int NOT NULL,
    status_id_status int NOT NULL,
    product_name varchar(64) NULL,
    product_description varchar(255) NULL,
    unit varchar(16) NULL,
    price_per_unit numeric(12,6) NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: product_type
CREATE TABLE product_type (
    id int NOT NULL AUTO_INCREMENT,
    type_name varchar(64) NOT NULL,
    CONSTRAINT product_type_pk PRIMARY KEY (id)
);

-- Table: purchase_details
CREATE TABLE purchase_details (
    id int NOT NULL AUTO_INCREMENT,
    product_id int NOT NULL,
    quanitity decimal(12,6) NULL,
    price_per_unit numeric(12,6) NOT NULL,
    price numeric(12,6) NULL,
    UNIQUE INDEX shipmet_details_ak_1 (product_id),
    CONSTRAINT purchase_details_pk PRIMARY KEY (id)
);

-- Table: rol_privilege
CREATE TABLE rol_privilege (
    id_role_privil int NOT NULL,
    id_role int NOT NULL,
    id_privilege int NOT NULL,
    CONSTRAINT rol_privilege_pk PRIMARY KEY (id_role_privil)
);

-- Table: role
CREATE TABLE role (
    id_role int NOT NULL,
    rol_nombre varchar(50) NULL,
    CONSTRAINT role_pk PRIMARY KEY (id_role)
);

-- Table: status
CREATE TABLE status (
    id_status int NOT NULL AUTO_INCREMENT,
    status_name varchar(64) NULL,
    CONSTRAINT status_pk PRIMARY KEY (id_status)
);

-- Table: transaction
CREATE TABLE transaction (
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT transaction_pk PRIMARY KEY (tx_id)
);

-- Table: user
CREATE TABLE user (
    id_user int NOT NULL,
    person_id int NOT NULL,
    company_id int NOT NULL,
    id_status int NOT NULL,
    username varchar(50) NULL,
    password varchar(50) NULL,
    salt varchar(50) NOT NULL,
    token int NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    deleted_at timestamp NOT NULL,
    tx_id int NOT NULL,
    tx_host varchar(50) NOT NULL,
    tx_user_id int NOT NULL,
    tx_date timestamp NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id_user)
) COMMENT 'Tabla de usuarios';

-- Table: user_role
CREATE TABLE user_role (
    id_user_role int NOT NULL,
    id_role int NOT NULL,
    id_user int NOT NULL,
    CONSTRAINT user_role_pk PRIMARY KEY (id_user_role)
);

-- views
-- View: product_details
CREATE VIEW product_details AS
SELECT
  p.id,
  p.product_name,
  p.product_description,
  pt.type_name,
  p.unit,
  p.price_per_unit,
  s.in_stock,
  s.last_update_time
FROM product p
LEFT JOIN product_type pt ON p.product_type_id = pt.id
LEFT JOIN inventory s ON p.id = s.product_id;

-- foreign keys
-- Reference: cart_purchase_details (table: cart)
ALTER TABLE cart ADD CONSTRAINT cart_purchase_details FOREIGN KEY cart_purchase_details (purchase_details_id)
    REFERENCES purchase_details (id);

-- Reference: cart_status (table: cart)
ALTER TABLE cart ADD CONSTRAINT cart_status FOREIGN KEY cart_status (id_status)
    REFERENCES status (id_status);

-- Reference: cart_user (table: cart)
ALTER TABLE cart ADD CONSTRAINT cart_user FOREIGN KEY cart_user (id_user)
    REFERENCES user (id_user);

-- Reference: chat_user (table: chat)
ALTER TABLE chat ADD CONSTRAINT chat_user FOREIGN KEY chat_user (id_user)
    REFERENCES user (id_user);

-- Reference: checkout_cart (table: checkout)
ALTER TABLE checkout ADD CONSTRAINT checkout_cart FOREIGN KEY checkout_cart (cart_id)
    REFERENCES cart (cart_id);

-- Reference: checkout_payment_details (table: checkout)
ALTER TABLE checkout ADD CONSTRAINT checkout_payment_details FOREIGN KEY checkout_payment_details (payment_details_id)
    REFERENCES payment_details (id);

-- Reference: checkout_user (table: checkout)
ALTER TABLE checkout ADD CONSTRAINT checkout_user FOREIGN KEY checkout_user (id_user)
    REFERENCES user (id_user);

-- Reference: message_chat (table: message)
ALTER TABLE message ADD CONSTRAINT message_chat FOREIGN KEY message_chat (chat_id)
    REFERENCES chat (chat_id);

-- Reference: payment_data_payment_type (table: payment_data)
ALTER TABLE payment_data ADD CONSTRAINT payment_data_payment_type FOREIGN KEY payment_data_payment_type (payment_type_id)
    REFERENCES payment_type (id);

-- Reference: payment_details_payment_data (table: payment_details)
ALTER TABLE payment_details ADD CONSTRAINT payment_details_payment_data FOREIGN KEY payment_details_payment_data (payment_data_id)
    REFERENCES payment_data (id);

-- Reference: person_city (table: person)
ALTER TABLE person ADD CONSTRAINT person_city FOREIGN KEY person_city (city_id)
    REFERENCES city (id);

-- Reference: person_status (table: person)
ALTER TABLE person ADD CONSTRAINT person_status FOREIGN KEY person_status (id_status)
    REFERENCES status (id_status);

-- Reference: product_city (table: product)
ALTER TABLE product ADD CONSTRAINT product_city FOREIGN KEY product_city (city_id)
    REFERENCES city (id);

-- Reference: product_company (table: product)
ALTER TABLE product ADD CONSTRAINT product_company FOREIGN KEY product_company (company_id)
    REFERENCES company (id);

-- Reference: product_product_type (table: product)
ALTER TABLE product ADD CONSTRAINT product_product_type FOREIGN KEY product_product_type (product_type_id)
    REFERENCES product_type (id);

-- Reference: product_status (table: product)
ALTER TABLE product ADD CONSTRAINT product_status FOREIGN KEY product_status (status_id_status)
    REFERENCES status (id_status);

-- Reference: rol_privilege_privilege (table: rol_privilege)
ALTER TABLE rol_privilege ADD CONSTRAINT rol_privilege_privilege FOREIGN KEY rol_privilege_privilege (id_privilege)
    REFERENCES privilege (id_privilege);

-- Reference: rol_privilegio_rol (table: rol_privilege)
ALTER TABLE rol_privilege ADD CONSTRAINT rol_privilegio_rol FOREIGN KEY rol_privilegio_rol (id_role)
    REFERENCES role (id_role);

-- Reference: shipmet_details_product (table: purchase_details)
ALTER TABLE purchase_details ADD CONSTRAINT shipmet_details_product FOREIGN KEY shipmet_details_product (product_id)
    REFERENCES product (id);

-- Reference: stock_product (table: inventory)
ALTER TABLE inventory ADD CONSTRAINT stock_product FOREIGN KEY stock_product (product_id)
    REFERENCES product (id);

-- Reference: user_company (table: user)
ALTER TABLE user ADD CONSTRAINT user_company FOREIGN KEY user_company (company_id)
    REFERENCES company (id);

-- Reference: user_person (table: user)
ALTER TABLE user ADD CONSTRAINT user_person FOREIGN KEY user_person (person_id)
    REFERENCES person (id);

-- Reference: user_rol_rol (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_rol_rol FOREIGN KEY user_rol_rol (id_role)
    REFERENCES role (id_role);

-- Reference: user_rol_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_rol_user FOREIGN KEY user_rol_user (id_user)
    REFERENCES user (id_user);

-- Reference: user_status (table: user)
ALTER TABLE user ADD CONSTRAINT user_status FOREIGN KEY user_status (id_status)
    REFERENCES status (id_status);

-- End of file.

