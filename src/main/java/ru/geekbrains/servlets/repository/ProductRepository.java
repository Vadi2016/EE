package ru.geekbrains.servlets.repository;

import ru.geekbrains.servlets.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {


    public List<Product> getProducts() {
        Product p1 = new Product(1L, "мыло", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 50);
        Product p2 = new Product(2L, "мачалка", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 150);
        Product p3 = new Product(3L, "шампунь", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 200);
        Product p4 = new Product(4L, "зубная паста", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 220);
        Product p5 = new Product(5L, "кастрюля", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 1000);
        Product p6 = new Product(6L, "вилка", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 43);
        Product p7 = new Product(7L, "ложка", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 60);
        Product p8 = new Product(8L, "сковорода", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 2000);
        Product p9 = new Product(9L, "нож", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusamus dicta dignissimos quisquam sit. Ad asperiores\n" +
                "        cupiditate debitis dicta dignissimos distinctio earum eos est explicabo iusto laboriosam magnam minima molestias\n" +
                "        nesciunt non pariatur quaerat, quibusdam quo quod repellat repudiandae rerum sapiente sint suscipit veniam\n" +
                "        veritatis voluptate voluptates. Id minima nisi porro.", 120);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);
        products.add(p8);
        products.add(p9);

        return products;
    }

}
