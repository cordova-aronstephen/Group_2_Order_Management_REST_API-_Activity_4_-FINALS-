CREATE TABLE order_item (
	id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL CHECK(total_price > 0),
    quantity INT NOT NULL CHECK(quantity > 0),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_order_item_order FOREIGN KEY (order_id)
	REFERENCES orders(id),
    
    CONSTRAINT fk_order_item_product FOREIGN KEY (product_id)
    REFERENCES product(id)
);

ALTER TABLE order_item
ADD UNIQUE INDEX uq_order_product (order_id, product_id);