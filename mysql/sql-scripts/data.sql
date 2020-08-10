CREATE DATABASE mysqldb;

CREATE TABLE mysqldb.t_user
( user_id  INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  age smallint,
  email VARCHAR(255),
  CONSTRAINT t_user_pkey PRIMARY KEY (user_id),
  CONSTRAINT uk_t_user_email UNIQUE (email)
);

CREATE TABLE mysqldb.t_order
(
    order_id INT(11) NOT NULL AUTO_INCREMENT,
    user_id INT(11),
    amount numeric(18,2),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT t_order_pkey PRIMARY KEY (order_id)
);
    
INSERT INTO mysqldb.t_user(name, age, email) VALUES ('Praveen Dabas', 23, 'Praveen@test.com');
INSERT INTO mysqldb.t_user(name, age, email) VALUES ('Rahul', 43, 'Rahul@test.com');

INSERT INTO mysqldb.t_order(user_id, amount) VALUES (1, 1235.50);
INSERT INTO mysqldb.t_order(user_id, amount) VALUES (1, 1035.80);
INSERT INTO mysqldb.t_order(user_id, amount) VALUES (1, 7235.50);
INSERT INTO mysqldb.t_order(user_id, amount) VALUES (2, 935.50);
INSERT INTO mysqldb.t_order(user_id, amount) VALUES (2, 12350.50);
	