package shop;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop();

        // добавление продуктов
        try {
            shop.add(new Product(
                    1,
                    "Помидор",
                    15
            ));
            shop.add(new Product(
                    2,
                    "Огурец",
                    10
            ));
            shop.add(new Product(
                    3,
                    "Картошка",
                    8
            ));
            shop.add(new Product(
                    4,
                    "Баклажан",
                    29
            ));
        } catch(ExceptionDuplicationProduct e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------ Сортировка по цене ------");
        List<Product> list = shop.getAll();
        Collections.sort(list, new ProductSortByPrice());
        System.out.println(list);

        // удаление продукта
        try {
            shop.remove(1);
        } catch (ExceptionProductNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n------ Сортировка по порядку добовления ------");
        list = shop.getAll();
        Collections.reverse(list);
        System.out.println(list);

        // редактирование продукта
        try {
            shop.edit(new Product(
                2,
                "Огурец свежий",
                25
            ));
        } catch (ExceptionProductNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n------ Отредактированый один продукт ------");
        System.out.println(shop.getAll());
    }
}
