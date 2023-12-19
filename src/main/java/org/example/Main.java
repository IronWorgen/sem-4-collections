package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        task1();
        System.out.println("\n================================\n");
        task2();
        System.out.println("\n================================\n");
        task3();
    }

    /**
     * ● Создайте коллекцию мужских и женских имен с помощью интерфейса List
     * ● Отсортируйте коллекцию в алфавитном порядке
     * ● Отсортируйте коллекцию по количеству букв в слове
     * ● Разверните коллекцию
     */
    static  void task1 () {
        List<String> list = new ArrayList<>(List.of("Стас", "Анна", "Антон", "Света"));
        Collections.sort(list);
        System.out.println(list);

        list.sort((x, y) -> x.length() - y.length());
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }

    /**
     * В рамках выполнения задачи необходимо:
     * ● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
     * добавьте повторяющиеся значения
     * ● Получите уникальный список Set на основании List
     * ● Определите наименьший элемент (алфавитный порядок)
     * ● Определите наибольший элемент (по количеству букв в слове но в обратном
     * порядке)
     * ● Удалите все элементы содержащие букву ‘A’
     */

    static void task2(){
       List<String> list = new ArrayList<>(List.of("Олег","Стас", "Анна", "Анна", "Света"));
        Set<String> set = new HashSet<>(list);
        System.out.println(set);


        System.out.println(set.stream().max((x,y)->y.compareTo(x)));

        System.out.println(set.stream().max((x,y)->x.length()-y.length()));

        set = set.stream()
                .filter(x->!(x.contains(new StringBuffer("а"))||x.contains(new StringBuffer("А"))))
                .collect(Collectors.toSet());
        System.out.println(set);
    }
    /**
     * Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
     * значение
     * ● Найдите человека с самым маленьким номером телефона
     * ● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
     */
    static void task3(){
        Map<String, Integer> phone = new HashMap<>();
        phone.put("ivan", 12345);
        phone.put("stas", 23345);
        phone.put("anton", 12344);

        var max = phone.entrySet().stream().max((x, y)->x.getValue()- y.getValue()).orElse(null);
        System.out.println(max);

        var maxName = phone.entrySet().stream().max((y, x)->x.getKey().compareTo(y.getKey())).orElse(null);
        System.out.println(maxName);
    }
}