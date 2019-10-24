package ru.job4j.pojo;

public class Shop {

    public static Product[] delete(Product[] products, int index) {
        System.arraycopy(products, index+1, products, index, products.length - 1 - index);
        products[products.length - 1] = null;
//        products[index] = null;
//        for (int i = index; i < products.length - 1; i++) {
//            products[i] = products[i + 1];
//        }
        return products;
    }

    private static void printList(Product[] list) {
        for (Product product : list) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        printList(products);

        System.out.println("\nУдаляем значение из ячейки с индексом 1");
        products[1] = null;
        printList(products);

        System.out.println("\nЗаписываем  в ячейку с индексом 1 значение ячейки с индексом 2 и удаляем значение из ячейки с индексом 2");
        products[1] = products[2];
        products[2] = null;
        printList(products);

        System.out.println("\nДемонстрация работы метода delete()");
        Product[] anotherProducts = new Product[5];
        anotherProducts[0] = new Product("Meat", 10);
        anotherProducts[1] = new Product("Cheese", 4);
        anotherProducts[2] = new Product("Butter", 19);
        anotherProducts[3] = new Product("Mushrooms", 15);
        printList(anotherProducts);

        System.out.println("\nУдаляем ячейку \"Butter\" и сдвигаем оставшиеся в начало:");
        delete(anotherProducts, 2);
        printList(anotherProducts);
        System.out.println("\nУдаляем ячейку \"Meat\" и сдвигаем оставшиеся в начало:");
        delete(anotherProducts, 0);
        printList(anotherProducts);

    }
}