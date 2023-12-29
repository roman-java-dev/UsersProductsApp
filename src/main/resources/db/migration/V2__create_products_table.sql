CREATE TABLE products (
                          id bigint AUTO_INCREMENT PRIMARY KEY,
                          entry_date date DEFAULT NULL,
                          item_code bigint DEFAULT NULL,
                          item_name varchar(255) DEFAULT NULL,
                          item_quantity bigint DEFAULT NULL,
                          status varchar(255) DEFAULT NULL
);