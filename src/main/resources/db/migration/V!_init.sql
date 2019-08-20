CREATE database javaEE;

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS products;

CREATE TABLE  products(
  id               INT(11) NOT NULL AUTO_INCREMENT,
  title            VARCHAR(50) NOT NULL,
  descript         VARCHAR(3000) NOT NULL,
  cost             INT(11) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS products_categories;

CREATE TABLE products_categories(
	product_id         INT(11) NOT NULL,
	category_id        INT(11) NOT NULL,
    PRIMARY KEY (product_id,category_id),

    CONSTRAINT FK_PRODUCTS_ID_01 FOREIGN KEY (product_id)
    REFERENCES products (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT FK_CATEGORY_ID FOREIGN KEY (category_id)
    REFERENCES categories (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS orders;

CREATE TABLE orders(
	id             INT(11) NOT NULL AUTO_INCREMENT,
	user_id           INT(11) NOT NULL,
    status_id             INT(11) NOT NULL,
    create_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_at             TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT FK_STATUS_ID FOREIGN KEY (status_id)
  REFERENCES orders_statuses (id),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS orders_statuses;

CREATE TABLE orders_statuses (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  title                 VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS orders_products;

CREATE TABLE orders_products(
	order_id         INT(11) NOT NULL,
	product_id        INT(11) NOT NULL,
    PRIMARY KEY (order_id,product_id),

    CONSTRAINT FK_ORDER_ID FOREIGN KEY (order_id)
    REFERENCES orders (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,

    CONSTRAINT FK_PRODUCTS_ID_01 FOREIGN KEY (product_id)
    REFERENCES products (id)
    ON DELETE NO ACTION ON UPDATE NO ACTION,
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



INSERT INTO products(title, descript, cost) VALUES
('мыло', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 50),
('мачалка', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 150),
('зубная паста',  'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 220),
('шампунь', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 200),
('кастрюля', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 1000),
('вилка', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 43),
('ложка', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 60),
('сковорода', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 2000),
('нож', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam veritatis voluptate voluptates. Id minima nisi porro.', 120);


DROP TABLE IF EXISTS categories;

 CREATE TABLE categories(
	id                 INT(11) NOT NULL AUTO_INCREMENT,
	name              VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO categories(name) VALUES
('посуда'),
('личная гигиена'),
('электроника');

