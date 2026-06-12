CREATE TABLE orders(
	id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    total_quantity INT NOT NULL CHECK(total_quantity >= 0),
    status_id INT NOT NULL,
    order_price_total DECIMAL(10,2) NOT NULL CHECK(order_price_total > 0),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    
	CONSTRAINT fk_customer_orders FOREIGN KEY (customer_id)
	REFERENCES customer(id)
);

ALTER TABLE orders
	ADD CONSTRAINT fk_orders_status FOREIGN KEY (status_id)
		REFERENCES status(id);