create TABLE IF NOT EXISTS 'customer'(
    'customer_id' int AUTO_INCREMENT  PRIMARY KEY,
    'customer_name' varchar2(50) NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

create TABLE IF NOT EXISTS 'transaction'(
    'transaction' int AUTO_INCREMENT  PRIMARY KEY ,
    'customer_id' int NOT NULL,
    'transaction_date' date NOT NULL,
    'transaction_amount' int NOT NULL,
    `created_at` date NOT NULL,
    `created_by` varchar(20) NOT NULL,
    `updated_at` date DEFAULT NULL,
    `updated_by` varchar(20) DEFAULT NULL
);

INSERT INTO customer(customer_id,customer_name) values (1001,'customer1');
INSERT INTO customer(customer_id,customer_name) values (1002,'customer2');
INSERT INTO customer(customer_id,customer_name) values (1003,'customer3');


INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10001,1001,'2024-04-12',120);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10002,1001,'2024-04-01',85);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10003,1001,'2024-03-04',160);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10004,1001,'2024-03-01',90);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10005,1001,'2024-02-04',120);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10006,1001,'2024-02-05',165);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10007,1002,'2024-04-05',113);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10008,1002,'2024-03-27',80);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10009,1002,'2024-03-04',102);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10010,1002,'2024-03-01',210);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10011,1002,'2024-02-27',130);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10012,1002,'2024-04-15',88);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10013,1003,'2024-04-05',102);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10014,1003,'2024-03-27',84);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10015,1003,'2024-03-04',200);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10016,1003,'2024-03-01',103);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10017,1003,'2024-03-27',500);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10018,1003,'2024-04-20',585);
INSERT INTO transaction(transaction_id,customer_id,transaction_date,transaction_amount) VALUES (10019,1003,'2024-03-14',102);
COMMIT;