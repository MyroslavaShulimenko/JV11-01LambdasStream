package JV2501;

import JV2301.Emploee;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Math.max;

public class Home2501 {
    public static void main(String[] args) {


        //First level: Напишите код, который создает Stream из массива чисел, фильтрует его по четным числам и выводит результат в консоль.
        Integer[] arr = {41, 5, 66, 8, 72, 12, 13, 65, 33};
        List<Integer>integerList=Arrays.asList(10,45,33,21,74,98,1,6);

        System.out.println("Напишите код, который создает Stream из массива чисел, фильтрует его по четным числам и выводит результат в консоль."+"/n"
                +Arrays.stream(arr).filter(x -> x % 2 == 0).collect(Collectors.toList()));

        // Напишите код, который соз дает Stream из списка строк, отсортировывает его по длине строк и выводит результат в консоль.
        System.out.println("Напишите код, который создает Stream из списка строк, отсортировывает его по длине строк и выводит результат в консоль.");
        List<String>stringList=Arrays.asList("document","contains","the","field","with","a","in");
         System.out.println(stringList.stream()
                 .sorted((x,y)-> x.length()-y.length()).collect(Collectors.toList()));
        System.out.println("Напишите код, который создает Stream из списка строк, отсортировывает его по длине строк и выводит результат в консоль.");
        stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);
        System.out.println();
        // Напишите код, который создает Stream из диапазона чисел, отображает каждое число к его квадрату и выводит результат в консоль.
      /*  Arrays.stream(arr)
                .forEach(x -> System.out.printf(x + "->" + (x * x) + "; "));
        System.out.println("");*/
        IntStream.range(1, 7)
                .map(e -> e * e)
                .forEach(System.out::println);
        System.out.println(Arrays.toString(IntStream.range(1, 7)
                .map(e -> e * e)
                .toArray()));
        System.out.println();
        // Напишите код, который создает Stream из списка объектов, объединяет их в одну строку и выводит результат на консоль.
        Emploee sotr = new Emploee("Oleg", "marketing", 2000);
        Emploee sotr2 = new Emploee("Nick", "marketing", 900);
        Emploee sotr3 = new Emploee("Eva", "marketing", 2220);
        Emploee sotr4 = new Emploee("Tiva", "accounting", 3500);
        Emploee sotr5 = new Emploee("Mila", "accounting", 500);
        Emploee sotr6 = new Emploee("Ivan", "IT", 4000);
        Emploee sotr7 = new Emploee("Roman", "IT", 5000);
        Emploee sotr8 = new Emploee("Nick", "IT", 4600);
        List<Emploee> listEmploee = Arrays.asList(sotr, sotr2, sotr3, sotr4, sotr5, sotr6, sotr7, sotr8);
        System.out.println("Напишите код, который создает Stream из списка объектов, объединяет их в одну строку и выводит результат на консоль."+'\n' + listEmploee.stream().collect(Collectors.toList()));

        listEmploee .stream()
                .forEach(x -> System.out.printf(String.valueOf(x)));
        System.out.println("Напишите код, который создает Stream из списка чисел, используя метод reduce() находит наибольшее число в списке.");
        //Напишите код, который создает Stream из списка чисел, используя метод reduce() находит наибольшее число в списке.
        Comparator<Integer> comparatorMax= (l1, l2) -> l1-l2;
      //  System.out.println(integerList.stream().reduce((a,b)->max(a,b)).get());
        System.out.println(integerList.stream().reduce(Math::max).get());
     //   System.out.println(integerList.stream().max(comparatorMax).get());
        System.out.println(integerList.stream()
                .reduce(0, Integer::max));
        System.out.println("------------------------------------------");
        // Напишите код, который создает Stream из Map, используя метод filter() и метод forEach() выводит ключ-значение только тех элементов, значение которых больше заданного.
        Map<String,Integer>stringIntegerMap=new HashMap<>();
              stringIntegerMap=  Map.of("qqqq",18,"oooo",5,"sss",14,"bbbbbb",11);
     //   System.out.println(stringIntegerMap.containsKey("oooo"));
    //    System.out.println(stringIntegerMap.get("oooo"));

       System.out.println(stringIntegerMap
                .entrySet().stream()
                       .filter(x->x.getValue()>=10)
                               .toList());

        stringIntegerMap.entrySet().stream()
                .filter(x -> x.getValue() >= 10)
                .forEach(System.out::println);
        // Напишите код, который считывает текстовый файл и используя Stream API, подсчитывает количество слов в файле.
       try (Stream<String> stream = Files.lines(Paths.get("data1.txt"))) {
            System.out.println(
                    stream.map(s -> s.trim().split("[\s\t\r\n]+"))
                            .flatMap(Arrays::stream)
                            .count()
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
//class Employee