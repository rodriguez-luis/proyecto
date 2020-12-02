/*select * from city;*/
INSERT INTO `proyecto_pc2`.`city` (`city_name`) VALUES ('La Paz');
INSERT INTO `proyecto_pc2`.`city` (`city_name`) VALUES ('Cochabamba');
INSERT INTO `proyecto_pc2`.`city` (`city_name`) VALUES ('Santa Cruz');
INSERT INTO `proyecto_pc2`.`city` (`city_name`) VALUES ('Oruro');
INSERT INTO `proyecto_pc2`.`city` (`city_name`) VALUES ('Tarija');

/*select * from brands;*/
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('Asus');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('MSI');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('HP');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('Nvidia');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('Deepcool');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('REDRAGON');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('Intel');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('AMD');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('EVGA');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('Samsung');
INSERT INTO `proyecto_pc2`.`brands` (`name`) VALUES ('ROCCAT');

/*select * from category;*/
INSERT INTO `proyecto_pc2`.`category` (`category_name`) VALUES ('Games');
INSERT INTO `proyecto_pc2`.`category` (`category_name`) VALUES ('Work');
INSERT INTO `proyecto_pc2`.`category` (`category_name`) VALUES ('Home');
INSERT INTO `proyecto_pc2`.`category` (`category_name`) VALUES ('Study');

/*select * from product_type;*/
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('Motherboard');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('CPU');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('GPU');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('Keyboard');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('Mouse');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('Screencooler');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('Cooler');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('RAM');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('SSD');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('HDD');
INSERT INTO `proyecto_pc2`.`product_type` (`type_name`) VALUES ('Power Supply');

/*select * from payment_type;*/
INSERT INTO `proyecto_pc2`.`payment_type` (`type_name`) VALUES ('Cash');
INSERT INTO `proyecto_pc2`.`payment_type` (`type_name`) VALUES ('Debit card');
INSERT INTO `proyecto_pc2`.`payment_type` (`type_name`) VALUES ('Credit card');

/*select * from privilege;*/
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Create account');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Delete account');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Add product');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Delete product');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Modify product');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('See product');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Sell product');
INSERT INTO `proyecto_pc2`.`privilege` (`privilege_name`) VALUES ('Buy product');

/*select * from role;*/
INSERT INTO `proyecto_pc2`.`role` (`rol_name`) VALUES ('Admin');
INSERT INTO `proyecto_pc2`.`role` (`rol_name`) VALUES ('Seller');
INSERT INTO `proyecto_pc2`.`role` (`rol_name`) VALUES ('Buyer');

/*select * from company;*/
INSERT INTO `proyecto_pc2`.`company` (`name`, `direction`, `phone`, `email`) VALUES ('Big PC', 'TODO', '22222222', 'bigpc@bigpc.com');
INSERT INTO `proyecto_pc2`.`company` (`name`, `direction`, `phone`, `email`) VALUES ('No company', 'nowhere', '00000000', 'nomail');
INSERT INTO `proyecto_pc2`.`company` (`name`, `direction`, `phone`, `email`) VALUES ('Computadoras Gonzales', 'Av. Calatayud N. 255', '22555555', 'comgonzales@gmail.com');
INSERT INTO `proyecto_pc2`.`company` (`name`, `direction`, `phone`, `email`) VALUES ('Grandes Partes', 'Av. Calatayud N. 480', '22555554', 'gpartes@gmail.com');
INSERT INTO `proyecto_pc2`.`company` (`name`, `direction`, `phone`, `email`) VALUES ('Turbo', 'Av. Eloy Salmon', '22555553', 'turbo@gmail.com');

/*select * from rol_privilege;*/
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '1');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '2');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '3');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '4');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '5');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '6');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('1', '7');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('2', '3');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('2', '4');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('2', '5');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('2', '6');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('2', '7');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('2', '8');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('3', '6');
INSERT INTO `proyecto_pc2`.`rol_privilege` (`role_id`, `privilege_id`) VALUES ('3', '8');

/*select * from person;*/
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Ricardo', 'Torrez', '77717774', '1993-10-08', 'ricar@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Manuel', 'Daza', '77717773', '1992-10-31', 'man@gmailc.om');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('2', 'Rodrigo', 'Jaramillo', '77717772', '1977-12-03', 'rod@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('3', 'Alejandro', 'Moreno', '77727771', '1979-11-28', 'ale@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('4', 'Fernanda', 'Gomez', '77727772', '1974-07-27', 'fer@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('4', 'Marcela', 'Rios', '77727773', '1983-08-20', 'mar@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('5', 'Carlos', 'Varela', '77747771', '1977-05-17', 'car@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('5', 'Eduardo', 'Hernandez', '77747778', '1978-02-18', 'edu@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('3', 'Maximiliano', 'Lopez', '77787779', '1980-09-21', 'max@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('2', 'Jorge', 'Rojas', '77767776', '1985-06-24', 'jor@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Francisca', 'Garcia', '77747776', '1988-04-28', 'fra@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Mariana', 'Fernandez', '77747775', '1978-06-10', 'mar@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('3', 'Sergio', 'Chavez', '77757775', '1982-07-19', 'ser@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('5', 'Mauricio', 'Trevilla', '77747774', '1992-06-20', 'mau@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('5', 'Yamil', 'Ballarta', '77777777', '1998-02-14', 'yam@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('4', 'Rafael', 'Perez', '78888888', '1994-05-12', 'raf@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Gabriel ', 'Loza', '75292809', '1997-08-15', 'gabriel.loza.lucero@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Luis', 'Rodriguez', '78730291', '1998-05-12', 'luis@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1', 'Nilson', 'Contreras', '71965701', '1997-12-20', 'nilson@gmail.com');
INSERT INTO `proyecto_pc2`.`person` (`city_id`, `first_name`, `last_name`, `phone`, `birthday`, `email`) VALUES ('1','Alvaro', 'Moller', '60571824', '1999-01-05', 'alvaromollerlima@gmail.com');

/*select * from product;*/
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('Asus ROG Maximus', ' XII Extreme', 'Asus ROG Maximus XII Extreme\', \'CPU support: Intel 10th Gen~Socket: LGA 1200~Memory support: 4x DIMM, up to 128GB, DDR4-4700~Video ports: 2x Thunderbolt 3 ports on extensioncard (DP1.4)~Rear USB: 10X USB 3.2, 2X USB 2.0~Network: 1x 10GB Marvell ethernet, Intel WI-FI 6 wireless', '5', '1.5', '5', '1', '1', '740', '1', '1', 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6306/6306415_sd.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('AMD Radeon', 'RX 5700', 'Processors: 2304~Core Clock: 1465 MHz~Memory: 8GB GDDR6~Memory Clock: 14Gbps~Power Connector: 1 x 8-pin, 1 x 6-pin~Outputs: 1 x DisplayPort 1.4 with DSC, 1 x HDMI with 4k60 support', '10', '0.75', '5', '3', '1', '2997', '0', '8', 'https://www.pcguide.com/wp-content/uploads/2019/09/best-rx-5700-graphics-card-amd-radeon-rx-5700-reviews-1200x720.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('MSI Optix', 'Optix-MAG241C', 'Curved display[1500R]~FHD High Resolution~144Hz Refresh Rate~1ms response time~True colors~AMD FreeSync~Anti-Flicker and Less Blue Light~Frameless desing~178 wide view angle', '3', '4', '5', '6', '1', '1620', '0', '2', 'https://sgstore.msi.com/wp-content/uploads/2020/04/product_6_20180612110658_5b1f38d2cf530.png');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('Deepcool ', 'N9BLACK', 'Dimension: 380X279X34mm~Fan Dimension: 180x15mm~Net Weight: 1700g~Operating Voltage: 4.5-5VDC~Fan speed: 600+-150 -1000+-10%RPM', '20', '2.1', '5', '7', '1', '36', '1', '5', 'https://www.deepcool.com/product/nbcooler/Upload/67845b0c1c5044a38482bf57c51b5604.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('Samsung SSD', '860 EVO', '1 TB~2.5 Inch~ SATA III~ Internal SSD', '12', '0.2', '4', '9', '1', '980', '0', '10', 'https://www.vortez.net/articles_file/38481_samsung_860_evo_intro.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('EVGA SuperNova', '850 Ga', '80 plus Gold 850W~Fully Modular~Eco Mode with Dbb Fan~Size: 150mm', '16', '5', '3', '11', '1', '1150', '0', '9', 'https://images.evga.com/products/gallery/png/220-GA-0850-X1_XL_4.png');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('Intel Core i9', '10900K', 'Cores: 10~Threads: 20~Base Frequency: 3.70GHz~Turbo Frequency: 5.30 GHz~Cache: 20MB~Bus Speed: 8GT/s', '8', '0.85', '3', '2', '1', '3500', '0', '7', 'https://www.hd-tecnologia.com/imagenes/articulos/2020/05/Asus-revela-el-rendimiento-del-Intel-Core-i9-10900K-en-Cinebench-R15-1280x720.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('ROCCAT Vulcan', '120 AIMO', 'Type: Mechanical Keyboard~3.6mm travel distance~1.8m USB cable~Polling rate: 1000Hz', '40', '3.2', '3', '4', '5', '880', '0', '11', 'https://cdn.mos.cms.futurecdn.net/N88JYZQyU35xYnd8F4oTYf.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('AMD Radeon', 'VII', 'Processors: 3840~Core Clock: 1400MHz~Memory: 16GB HBM2~Memory Clock: Gbps~Power Connectors: 2 x 8-pin~Outputs: 3 x DisplayPort 1.4, 1 x HDMI 2.0', '4', '2.2', '3', '3', '5', '2295', '0', '8', 'https://www.extremetech.com/wp-content/uploads/2019/01/Radeon-VII-Feature.jpg');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('REDRAGON MOUSE', 'IMPACT', '1000Hz 30G ACC~Super fast game engine~18 programmable buttons~5 Memory nodes~12400 DPI', '20', '0.5', '3', '5', '5', '250', '0', '6', 'https://redragonla.com/wp-content/uploads/2019/04/M908-6.png');
INSERT INTO `proyecto_pc2`.`product` (`product_name`, `model`, `product_description`, `stock`, `weight`, `company_id`, `product_type_id`, `city_id`, `price_per_unit`, `currency`, `brand_id`) VALUES ('AMD Ryzen 3', '5300X', 'Cores: 4~Threads: 8~Base Frequency 3.9GHz~Turbo Frequency 4.5 GHz~Cache memory 16MB~Max memory capacity: 64GB~Memory types: DDR4-3200', '13', '1', '4', '2', '5', '1400', '0', '8', 'https://gadgetversus.com/img/Intel_Celeron_J4115.jpg');

/*select * from user;*/
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('17', '1', 'gabriellozalucero', 'admin1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('18', '1', 'luisrodriguez', 'admin1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('19', '1', 'nilsoncontreras', 'admin1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('20', '1', 'alvaromoller', 'admin1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('1', '2', 'ricartorrez', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('2', '2', 'mandaza', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('3', '2', 'rodja', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('4', '2', 'alemo', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('5', '2', 'fergo', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('6', '2', 'marri', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('7', '2', 'carva', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('8', '2', 'eduher', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('9', '2', 'maxlo', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('10', '5', 'jorro', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('11', '5', 'fraga', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('12', '3', 'marfer', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('13', '3', 'sercha', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('14', '4', 'mautre', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('15', '2', 'yamba', 'user1');
INSERT INTO `proyecto_pc2`.`user` (`person_id`, `company_id`, `username`, `password`) VALUES ('16', '2', 'rafpe', 'user1');

/*select * from payment_data;*/
INSERT INTO `proyecto_pc2`.`payment_data` (`payment_type_id`) VALUES ('1');
INSERT INTO `proyecto_pc2`.`payment_data` (`payment_type_id`) VALUES ('2');
INSERT INTO `proyecto_pc2`.`payment_data` (`payment_type_id`) VALUES ('3');
INSERT INTO `proyecto_pc2`.`payment_data` (`payment_type_id`) VALUES ('1');
INSERT INTO `proyecto_pc2`.`payment_data` (`payment_type_id`) VALUES ('2');
INSERT INTO `proyecto_pc2`.`payment_data` (`payment_type_id`) VALUES ('3');

/*select * from payment_details;*/
INSERT INTO `proyecto_pc2`.`payment_details` (`payment_data_id`) VALUES ('1');
INSERT INTO `proyecto_pc2`.`payment_details` (`payment_data_id`) VALUES ('2');
INSERT INTO `proyecto_pc2`.`payment_details` (`payment_data_id`) VALUES ('3');
INSERT INTO `proyecto_pc2`.`payment_details` (`payment_data_id`) VALUES ('4');
INSERT INTO `proyecto_pc2`.`payment_details` (`payment_data_id`) VALUES ('5');
INSERT INTO `proyecto_pc2`.`payment_details` (`payment_data_id`) VALUES ('6');

/*select * from purchase_details;*/
INSERT INTO `proyecto_pc2`.`purchase_details` (`product_id`, `quanitity`, `unit_price`, `price`) VALUES ('2', '1', '2997', '2997');
INSERT INTO `proyecto_pc2`.`purchase_details` (`product_id`, `quanitity`, `unit_price`, `price`) VALUES ('5', '2', '980', '1960');
INSERT INTO `proyecto_pc2`.`purchase_details` (`product_id`, `quanitity`, `unit_price`, `price`) VALUES ('10', '5', '2295', '11475');
INSERT INTO `proyecto_pc2`.`purchase_details` (`product_id`, `quanitity`, `unit_price`, `price`) VALUES ('11', '2', '1400', '2800');

/*select * from cart;*/
INSERT INTO `proyecto_pc2`.`cart` (`purchase_details_id`, `user_id`) VALUES ('1', '20');
INSERT INTO `proyecto_pc2`.`cart` (`purchase_details_id`, `user_id`) VALUES ('2', '16');
INSERT INTO `proyecto_pc2`.`cart` (`purchase_details_id`, `user_id`) VALUES ('3', '12');
INSERT INTO `proyecto_pc2`.`cart` (`purchase_details_id`, `user_id`) VALUES ('4', '8');

/*select * from checkout;*/
INSERT INTO `proyecto_pc2`.`checkout` (`cart_id`, `payment_details_id`, `date`, `total`) VALUES ('1', '2', '2020-11-05', '5150');
INSERT INTO `proyecto_pc2`.`checkout` (`cart_id`, `payment_details_id`, `date`, `total`) VALUES ('2', '4', '2020-11-05', '1960');

/*select * from user_role;*/
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('1', '2');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('1', '3');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('1', '4');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('2', '14');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('2', '15');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('2', '16');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('2', '17');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('2', '18');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '19');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '20');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '5');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '6');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '7');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '8');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '9');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '10');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '11');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '12');
INSERT INTO `proyecto_pc2`.`user_role` (`role_id`, `user_id`) VALUES ('3', '13');

/*select * from category_product;*/
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('3', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('1', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('1', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('2', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('2', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('4', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('4', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('4', '3');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('5', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('5', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('6', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('6', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('7', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('7', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('8', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('8', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('9', '2');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('10', '1');
INSERT INTO `proyecto_pc2`.`category_product` (`product_id`, `category_id`) VALUES ('11', '2');