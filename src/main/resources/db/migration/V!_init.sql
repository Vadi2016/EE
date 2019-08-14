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

