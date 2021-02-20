package shop;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    private Shop shop = new Shop();

    Scanner scanner = new Scanner(System.in);

    public Application(Shop shop) {
        this.shop = shop;
    }

    public Application() {
    }

    public void start() {
        System.out.println("======== Добро пожаловать в магазин ========");
        try {
            this.run();
        } catch (ExceptionCloseApp e) {
            System.out.println("======== Пока прощай ========");
        }
    }

    private void run() throws ExceptionCloseApp {
        while (true) {
            this.mainMenu();
            int number = selectNumber(0, 4);

            if (number == 1) {
                this.sortMenu();

                int sort = selectNumber(0, 5);

                List<Product> list = shop.getAll();

                switch (sort) {
                    case 1:
                        Collections.sort(list, new ProductSortByPrice());
                        System.out.println(list);
                        break;
                    case 2:
                        Collections.sort(list, new ProductSortByPrice().reversed());
                        System.out.println(list);
                        break;
                    case 3:
                        Collections.reverse(list);
                        System.out.println(list);
                        break;
                    case 4:
                        System.out.println(list);
                        break;
                    case 5:
                        continue;
                    case 0:
                        throw new ExceptionCloseApp();
                }
            } else if (number == 2) {
                System.out.println("Введите Id товара:");
                int id = selectNumber(1, 1000000);

                System.out.println("Введите название товара:");
                String name = scanner.next();

                System.out.println("Введите цену товара:");
                int price = selectNumber(1, 1000000);

               try {
                   shop.add(new Product(id, name, price));
                   System.out.println("Товар - '" + name + "' успешно добавлен!");
               } catch(ExceptionDuplicationProduct e) {
                   System.out.println(e.getMessage());
                   continue;
               }
            } else if (number == 3) {

                System.out.println("Введите Id товара который нужно удалить:");
                int id = selectNumber(1, 1000000);

                try {
                    shop.remove(id);
                    System.out.println("Товар с id - " + id + " успешно удален!");
                } catch (ExceptionProductNotFound e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (number == 4) {

                System.out.println("Введите Id товара который нужно обновить:");
                int id = selectNumber(1, 1000000);

                System.out.println("Введите новое название товара:");
                String name = scanner.next();

                System.out.println("Введите новую цену товара:");
                int price = selectNumber(1, 1000000);

                try {
                    shop.edit(new Product(id, name, price));
                    System.out.println("Товар успегно обновлен!");
                } catch (ExceptionProductNotFound e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (number == 0) {
                throw new ExceptionCloseApp();
            }
        }
    }

    private int selectNumber(int min, int max) {
        while (true) {

            if (!scanner.hasNextInt()) {
                System.out.println("Вы ввели не целое число. Повторите попытку:");
                scanner.next();
                continue;
            }

            int number = scanner.nextInt();

            if (number >= min && number <= max) {
                return number;
            } else {
                System.out.println("Выберите вариант из предложеного. Повторите попытку:");
            }
        }
    }

    private void mainMenu() {
        System.out.println("+++++ Выберите что вас интересует +++++");
        System.out.println("1 - Вывод всех товаров >>>");
        System.out.println("2 - Добавление товара");
        System.out.println("3 - Удаление товара");
        System.out.println("4 - Редактирование товара");
        System.out.println("0 - Выход");
    }

    private void sortMenu() {
        System.out.println("----- Выберите метод сортировки -----");
        System.out.println("1 - По возрастанию цены");
        System.out.println("2 - По убыванию цены");
        System.out.println("3 - Сначала самые новые");
        System.out.println("4 - Сначала самые старые");
        System.out.println("5 - <<< Назад в основное меню");
        System.out.println("0 - Выход");
    }
}
