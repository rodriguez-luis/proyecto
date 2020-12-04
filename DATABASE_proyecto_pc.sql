drop database proyecto_pc;
create database proyecto_pc;
use proyecto_pc;
drop database proyecto_pc;
create database proyecto_pc;
use proyecto_pc;
-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-12-03 21:40:04.273

-- tables
-- Table: brands
CREATE TABLE brands (
                        brand_id int NOT NULL AUTO_INCREMENT,
                        name varchar(50) NOT NULL,
                        tx_id int NOT NULL DEFAULT 1,
                        tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                        tx_user_id int NOT NULL DEFAULT 0,
                        tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                        status int NOT NULL DEFAULT 1,
                        CONSTRAINT brands_pk PRIMARY KEY (brand_id)
);

-- Table: cart
CREATE TABLE cart (
                      cart_id int NOT NULL AUTO_INCREMENT,
                      purchase_details_id int NOT NULL,
                      user_id int NOT NULL,
                      tx_id int NOT NULL DEFAULT 1,
                      tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                      tx_user_id int NOT NULL DEFAULT 0,
                      tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                      status int NOT NULL DEFAULT 1,
                      CONSTRAINT cart_pk PRIMARY KEY (cart_id)
);

-- Table: category
CREATE TABLE category (
                          category_id int NOT NULL AUTO_INCREMENT,
                          category_name varchar(120) NOT NULL,
                          tx_id int NOT NULL DEFAULT 1,
                          tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                          tx_user_id int NOT NULL DEFAULT 0,
                          tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                          status int NOT NULL DEFAULT 1,
                          CONSTRAINT category_pk PRIMARY KEY (category_id)
);

-- Table: category_product
CREATE TABLE category_product (
                                  category_product_id int NOT NULL AUTO_INCREMENT,
                                  product_id int NOT NULL,
                                  category_id int NOT NULL,
                                  status int NOT NULL DEFAULT 1,
                                  CONSTRAINT category_product_pk PRIMARY KEY (category_product_id)
);

-- Table: chat
CREATE TABLE chat (
                      chat_id int NOT NULL AUTO_INCREMENT,
                      date date NOT NULL,
                      start time NOT NULL,
                      end time NOT NULL,
                      log varchar(50) NOT NULL,
                      tx_id int NOT NULL DEFAULT 1,
                      tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                      tx_user_id int NOT NULL DEFAULT 0,
                      tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                      costumer_id int NOT NULL,
                      vendor_id int NOT NULL,
                      status int NOT NULL DEFAULT 1,
                      CONSTRAINT chat_pk PRIMARY KEY (chat_id)
);

-- Table: checkout
CREATE TABLE checkout (
                          checkout_id int NOT NULL AUTO_INCREMENT,
                          cart_id int NOT NULL,
                          payment_details_id int NOT NULL,
                          date timestamp NOT NULL,
                          total numeric(12,6) NOT NULL,
                          tx_id int NOT NULL DEFAULT 1,
                          tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                          tx_user_id int NOT NULL DEFAULT 0,
                          tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                          status int NOT NULL DEFAULT 1,
                          contact varchar(50) NOT NULL,
                          address varchar(150) NOT NULL,
                          CONSTRAINT checkout_pk PRIMARY KEY (checkout_id)
);

-- Table: city
CREATE TABLE city (
                      city_id int NOT NULL AUTO_INCREMENT,
                      city_name varchar(128) NULL,
                      tx_id int NOT NULL DEFAULT 1,
                      tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                      tx_user_id int NOT NULL DEFAULT 0,
                      tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                      status int NOT NULL DEFAULT 1,
                      CONSTRAINT city_pk PRIMARY KEY (city_id)
);

-- Table: company
CREATE TABLE company (
                         company_id int NOT NULL AUTO_INCREMENT,
                         name varchar(50) NOT NULL,
                         direction varchar(50) NOT NULL,
                         phone varchar(50) NOT NULL,
                         email varchar(50) NULL,
                         tx_id int NOT NULL DEFAULT 1,
                         tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                         tx_user_id int NOT NULL DEFAULT 0,
                         tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                         status int NOT NULL DEFAULT 1,
                         CONSTRAINT company_pk PRIMARY KEY (company_id)
);

-- Table: h_checkout
CREATE TABLE h_checkout (
                            checkout_id int NOT NULL AUTO_INCREMENT,
                            cart_id int NOT NULL,
                            payment_details_id int NOT NULL,
                            date date NOT NULL,
                            total numeric(12,6) NOT NULL,
                            tx_id int NOT NULL DEFAULT 1,
                            tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                            tx_user_id int NOT NULL DEFAULT 0,
                            tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                            status int NOT NULL DEFAULT 1,
                            CONSTRAINT h_checkout_pk PRIMARY KEY (checkout_id)
);

-- Table: h_product
CREATE TABLE h_product (
                           product_id int NOT NULL AUTO_INCREMENT,
                           product_name varchar(64) NOT NULL,
                           model varchar(50) NOT NULL,
                           product_description varchar(255) NOT NULL,
                           stock int NOT NULL,
                           weight double(6,3) NOT NULL,
                           company_id int NOT NULL,
                           product_type_id int NOT NULL,
                           city_id int NOT NULL,
                           price_per_unit numeric(12,6) NOT NULL,
                           currency int NOT NULL,
                           tx_id int NOT NULL DEFAULT 1,
                           tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                           tx_user_id int NOT NULL DEFAULT 0,
                           tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                           status int NOT NULL,
                           brand_id int NOT NULL DEFAULT 1,
                           CONSTRAINT h_product_pk PRIMARY KEY (product_id)
);

-- Table: h_user
CREATE TABLE h_user (
                        user_id int NOT NULL AUTO_INCREMENT,
                        person_id int NOT NULL,
                        company_id int NOT NULL,
                        username varchar(50) NOT NULL,
                        password varchar(50) NOT NULL,
                        salt varchar(50) NULL,
                        token int NULL,
                        tx_id int NOT NULL DEFAULT 1,
                        tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                        tx_user_id int NOT NULL DEFAULT 0,
                        tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                        status int NOT NULL DEFAULT 1,
                        CONSTRAINT h_user_pk PRIMARY KEY (user_id)
) COMMENT 'Tabla de usuarios';

-- Table: message
CREATE TABLE message (
                         message_id int NOT NULL AUTO_INCREMENT,
                         chat_id int NOT NULL,
                         time time NOT NULL,
                         content varchar(500) NOT NULL,
                         tx_id int NOT NULL DEFAULT 1,
                         tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                         tx_user_id int NOT NULL DEFAULT 0,
                         tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                         status int NOT NULL DEFAULT 1,
                         CONSTRAINT message_pk PRIMARY KEY (message_id)
);

-- Table: payment_data
CREATE TABLE payment_data (
                              payment_data_id int NOT NULL AUTO_INCREMENT,
                              payment_type_id int NOT NULL,
                              data_name varchar(255) NULL,
                              data_type varchar(255) NULL,
                              tx_id int NOT NULL DEFAULT 1,
                              tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                              tx_user_id int NOT NULL DEFAULT 0,
                              tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                              status int NOT NULL DEFAULT 1,
                              UNIQUE INDEX payment_data_ak_1 (payment_type_id,data_name),
                              CONSTRAINT payment_data_pk PRIMARY KEY (payment_data_id)
);

-- Table: payment_details
CREATE TABLE payment_details (
                                 payment_details_id int NOT NULL AUTO_INCREMENT,
                                 payment_data_id int NOT NULL,
                                 value varchar(255) NULL,
                                 tx_id int NOT NULL DEFAULT 1,
                                 tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                                 tx_user_id int NOT NULL DEFAULT 0,
                                 tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                                 status int NOT NULL DEFAULT 1,
                                 CONSTRAINT payment_details_pk PRIMARY KEY (payment_details_id)
);

-- Table: payment_type
CREATE TABLE payment_type (
                              payment_type_id int NOT NULL AUTO_INCREMENT,
                              type_name varchar(64) NOT NULL,
                              tx_id int NOT NULL DEFAULT 1,
                              tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                              tx_user_id int NOT NULL DEFAULT 0,
                              tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                              status int NOT NULL DEFAULT 1,
                              CONSTRAINT payment_type_pk PRIMARY KEY (payment_type_id)
) COMMENT 'e.g. card, cash, paypal, wire transfer';

-- Table: person
CREATE TABLE person (
                        person_id int NOT NULL AUTO_INCREMENT,
                        city_id int NOT NULL,
                        first_name varchar(50) NOT NULL,
                        last_name varchar(50) NOT NULL,
                        phone varchar(25) NOT NULL,
                        birthday date NOT NULL,
                        email varchar(50) NOT NULL,
                        tx_id int NOT NULL DEFAULT 1,
                        tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                        tx_user_id int NOT NULL DEFAULT 0,
                        tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                        status int NOT NULL DEFAULT 1,
                        CONSTRAINT person_pk PRIMARY KEY (person_id)
);

-- Table: privilege
CREATE TABLE privilege (
                           privilege_id int NOT NULL AUTO_INCREMENT,
                           privilege_name varchar(50) NOT NULL,
                           tx_id int NOT NULL DEFAULT 1,
                           tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                           tx_user_id int NOT NULL DEFAULT 0,
                           tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                           status int NOT NULL DEFAULT 1,
                           CONSTRAINT privilege_pk PRIMARY KEY (privilege_id)
);

-- Table: product
CREATE TABLE product (
                         product_id int NOT NULL AUTO_INCREMENT,
                         product_name varchar(64) NOT NULL,
                         model varchar(50) NOT NULL,
                         product_description varchar(500) NOT NULL,
                         stock int NOT NULL,
                         weight double(6,3) NOT NULL,
                         company_id int NOT NULL,
                         product_type_id int NOT NULL,
                         city_id int NOT NULL,
                         price_per_unit numeric(12,6) NOT NULL,
                         currency int NOT NULL,
                         tx_id int NOT NULL DEFAULT 1,
                         tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                         tx_user_id int NOT NULL DEFAULT 0,
                         tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                         status int NOT NULL DEFAULT 1,
                         brand_id int NOT NULL DEFAULT 1,
                         img varchar(150) NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (product_id)
);

-- Table: product_type
CREATE TABLE product_type (
                              product_type_id int NOT NULL AUTO_INCREMENT,
                              type_name varchar(64) NOT NULL,
                              tx_id int NOT NULL DEFAULT 1,
                              tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                              tx_user_id int NOT NULL DEFAULT 0,
                              tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                              status int NOT NULL DEFAULT 1,
                              CONSTRAINT product_type_pk PRIMARY KEY (product_type_id)
) COMMENT '
';

-- Table: purchase_details
CREATE TABLE purchase_details (
                                  purchase_details_id int NOT NULL AUTO_INCREMENT,
                                  product_id int NOT NULL,
                                  quanitity int NOT NULL,
                                  unit_price numeric(12,6) NOT NULL,
                                  price numeric(12,6) NOT NULL,
                                  tx_id int NOT NULL DEFAULT 1,
                                  tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                                  tx_user_id int NOT NULL DEFAULT 0,
                                  tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                                  status int NOT NULL DEFAULT 1,
                                  UNIQUE INDEX shipmet_details_ak_1 (product_id),
                                  CONSTRAINT purchase_details_pk PRIMARY KEY (purchase_details_id)
);

-- Table: rol_privilege
CREATE TABLE rol_privilege (
                               role_privilege_id int NOT NULL AUTO_INCREMENT,
                               role_id int NOT NULL,
                               privilege_id int NOT NULL,
                               status int NOT NULL DEFAULT 1,
                               CONSTRAINT rol_privilege_pk PRIMARY KEY (role_privilege_id)
);

-- Table: role
CREATE TABLE role (
                      role_id int NOT NULL AUTO_INCREMENT,
                      rol_name varchar(50) NOT NULL,
                      tx_id int NOT NULL DEFAULT 1,
                      tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                      tx_user_id int NOT NULL DEFAULT 0,
                      tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                      status int NOT NULL DEFAULT 1,
                      CONSTRAINT role_pk PRIMARY KEY (role_id)
);

-- Table: transaction
CREATE TABLE transaction (
                             transaction_id int NOT NULL AUTO_INCREMENT,
                             tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                             tx_user_id int NOT NULL DEFAULT 0,
                             tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                             CONSTRAINT transaction_pk PRIMARY KEY (transaction_id)
);

-- Table: user
CREATE TABLE user (
                      user_id int NOT NULL AUTO_INCREMENT,
                      person_id int NOT NULL,
                      company_id int NOT NULL,
                      username varchar(50) NOT NULL,
                      password varchar(50) NOT NULL,
                      salt varchar(50) NULL,
                      token int NULL,
                      tx_id int NOT NULL DEFAULT 1,
                      tx_host varchar(50) NOT NULL DEFAULT '127.0.0.1',
                      tx_user_id int NOT NULL DEFAULT 0,
                      tx_date timestamp NOT NULL DEFAULT '2020-11-22 00:00:00',
                      status int NOT NULL DEFAULT 1,
                      CONSTRAINT user_pk PRIMARY KEY (user_id)
) COMMENT 'Tabla de usuarios';

-- Table: user_role
CREATE TABLE user_role (
                           id_user_role int NOT NULL AUTO_INCREMENT,
                           user_id int NOT NULL,
                           role_id int NOT NULL,
                           status int NOT NULL DEFAULT 1,
                           CONSTRAINT user_role_pk PRIMARY KEY (id_user_role)
);

-- foreign keys
-- Reference: cart_purchase_details (table: cart)
ALTER TABLE cart ADD CONSTRAINT cart_purchase_details FOREIGN KEY cart_purchase_details (purchase_details_id)
    REFERENCES purchase_details (purchase_details_id);

-- Reference: cart_user (table: cart)
ALTER TABLE cart ADD CONSTRAINT cart_user FOREIGN KEY cart_user (user_id)
    REFERENCES user (user_id);

-- Reference: category_product_category (table: category_product)
ALTER TABLE category_product ADD CONSTRAINT category_product_category FOREIGN KEY category_product_category (category_id)
    REFERENCES category (category_id);

-- Reference: category_product_product (table: category_product)
ALTER TABLE category_product ADD CONSTRAINT category_product_product FOREIGN KEY category_product_product (product_id)
    REFERENCES product (product_id);

-- Reference: char_client (table: chat)
ALTER TABLE chat ADD CONSTRAINT char_client FOREIGN KEY char_client (vendor_id)
    REFERENCES user (user_id);

-- Reference: chat_vendor (table: chat)
ALTER TABLE chat ADD CONSTRAINT chat_vendor FOREIGN KEY chat_vendor (costumer_id)
    REFERENCES user (user_id);

-- Reference: checkout_cart (table: checkout)
ALTER TABLE checkout ADD CONSTRAINT checkout_cart FOREIGN KEY checkout_cart (cart_id)
    REFERENCES cart (cart_id);

-- Reference: checkout_payment_details (table: checkout)
ALTER TABLE checkout ADD CONSTRAINT checkout_payment_details FOREIGN KEY checkout_payment_details (payment_details_id)
    REFERENCES payment_details (payment_details_id);

-- Reference: message_chat (table: message)
ALTER TABLE message ADD CONSTRAINT message_chat FOREIGN KEY message_chat (chat_id)
    REFERENCES chat (chat_id);

-- Reference: payment_data_payment_type (table: payment_data)
ALTER TABLE payment_data ADD CONSTRAINT payment_data_payment_type FOREIGN KEY payment_data_payment_type (payment_type_id)
    REFERENCES payment_type (payment_type_id);

-- Reference: payment_details_payment_data (table: payment_details)
ALTER TABLE payment_details ADD CONSTRAINT payment_details_payment_data FOREIGN KEY payment_details_payment_data (payment_data_id)
    REFERENCES payment_data (payment_data_id);

-- Reference: person_city (table: person)
ALTER TABLE person ADD CONSTRAINT person_city FOREIGN KEY person_city (city_id)
    REFERENCES city (city_id);

-- Reference: product_brands (table: product)
ALTER TABLE product ADD CONSTRAINT product_brands FOREIGN KEY product_brands (brand_id)
    REFERENCES brands (brand_id);

-- Reference: product_city (table: product)
ALTER TABLE product ADD CONSTRAINT product_city FOREIGN KEY product_city (city_id)
    REFERENCES city (city_id);

-- Reference: product_company (table: product)
ALTER TABLE product ADD CONSTRAINT product_company FOREIGN KEY product_company (company_id)
    REFERENCES company (company_id);

-- Reference: product_product_type (table: product)
ALTER TABLE product ADD CONSTRAINT product_product_type FOREIGN KEY product_product_type (product_type_id)
    REFERENCES product_type (product_type_id);

-- Reference: rol_privilege_privilege (table: rol_privilege)
ALTER TABLE rol_privilege ADD CONSTRAINT rol_privilege_privilege FOREIGN KEY rol_privilege_privilege (privilege_id)
    REFERENCES privilege (privilege_id);

-- Reference: rol_privilegio_rol (table: rol_privilege)
ALTER TABLE rol_privilege ADD CONSTRAINT rol_privilegio_rol FOREIGN KEY rol_privilegio_rol (role_id)
    REFERENCES role (role_id);

-- Reference: shipmet_details_product (table: purchase_details)
ALTER TABLE purchase_details ADD CONSTRAINT shipmet_details_product FOREIGN KEY shipmet_details_product (product_id)
    REFERENCES product (product_id);

-- Reference: user_company (table: user)
ALTER TABLE user ADD CONSTRAINT user_company FOREIGN KEY user_company (company_id)
    REFERENCES company (company_id);

-- Reference: user_person (table: user)
ALTER TABLE user ADD CONSTRAINT user_person FOREIGN KEY user_person (person_id)
    REFERENCES person (person_id);

-- Reference: user_rol_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_rol_user FOREIGN KEY user_rol_user (user_id)
    REFERENCES user (user_id);

-- Reference: user_role_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT user_role_role FOREIGN KEY user_role_role (role_id)
    REFERENCES role (role_id);

-- End of file.

