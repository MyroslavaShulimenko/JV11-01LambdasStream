package JV2301;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

       /* int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(arr));
        int[] arr1 = Arrays.stream(arr).flatMapToInt(
                Arrays::stream).toArray();
        System.out.println(Arrays.toString(arr1));
        List<String> words1 = List.of("d1", "d2", "d3", "d4");
        List<String> words2 = List.of("e1", "e2", "e3", "e4");
        List<List<String>> listifWords = new ArrayList<List<String>>();
        listifWords.add(words1);
        listifWords.add(words2);
        System.out.println(listifWords.stream().flatMap((List<String> words) -> words.stream())
                .collect(Collectors.toList()));
        ;

        List<String> res = listifWords.stream().flatMap(words -> words.stream()).collect(Collectors.toList());

        System.out.println(res);
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        //  отфильтровать "a" (исключить из печати) и распечатать все символы.
        List<String> res2 = Arrays.stream(array).flatMap(w -> Arrays.stream(w).filter(x -> x != "a"))
                //  { if(!x.equals("a"))})
                .collect(Collectors.toList());
        System.out.println(res2);
//Студент записывает книги которые прочитал, задача вывести все прочитанные книги у всех студентов (в качестве дополнения, применить фильтр на любую тему)
        Student str1 = new Student("Petr");
        str1.addBook("Java 8");
        str1.addBook("Java 11 vs Java8");
        str1.addBook("HTNL in practices");
        str1.addBook("Scala best practices");
        Student str2 = new Student("Oksana");
        str2.addBook("Java 8");
        str2.addBook("Java 9");
        Student str3 = new Student("Petr");
        str3.addBook("Java 8");
        str3.addBook("Java 11 vs Java8");
        str3.addBook("HTNL in practices");
        str3.addBook("Scala best practices");
        //str2.addBook("HTNL in practices");
        str2.addBook("Scala best practices");
        List<Student> studentList = new ArrayList<>();
        studentList.add(str1);
        studentList.add(str2);
        studentList.add(str3);

        Stream<Set<String>> streamOfBooks = studentList.stream().map((Student student) -> student.getBooks());
        Stream<String> streamOfString = streamOfBooks.flatMap(x -> x.stream());
        //  List<String>list1=streamOfString.collect(Collectors.toList());
        //  System.out.println(list1);
        Set<String> list2 = streamOfString.collect(Collectors.toSet());
        System.out.println("list  2 "+list2);
        Set<String> stringSet = studentList.stream()
                .map(Student::getBooks)
                .flatMap(x -> x.stream()).
                filter(x -> x.contains("Java"))
                .collect(Collectors.toSet());
        System.out.println(stringSet);
        System.out.println(studentList.stream()
                .map(x -> x.getBooks())
                .flatMap(x0 -> x0.stream())
                .collect(Collectors.toMap(k -> k, k1 -> 1, (y1, y2) -> (y1 + y2))));
        //посчитать общее количество слов (дополнительно, посчитать только не повторяющиесь слова)
        String[][] array5 = new String[][]{{"Hello", "world"}, {"Hello", "Java"}, {"Hello", "student"}, {"Welcome", "to", "Tel-Ran"}};
        long res5 = Arrays.stream(array5).flatMap(x -> Arrays.stream(x))
                // .distinct()
                .count();
        System.out.println(res5);
        System.out.println("-----------------------------");
        Map<String, List<Student>> spisok = studentList
                .stream()
                .collect(Collectors
                        .groupingBy(Student::getName));

        System.out.println(spisok);*/

        // homework

        System.out.println("-----------homework--------------");
        Emploee sotr = new Emploee("Oleg", "marketing", 2000);
        Emploee sotr2 = new Emploee("Nick", "marketing", 900);
        Emploee sotr3 = new Emploee("Eva", "marketing", 2220);
        Emploee sotr4 = new Emploee("Tiva", "accounting", 3500);
        Emploee sotr5 = new Emploee("Mila", "accounting", 500);
        Emploee sotr6 = new Emploee("Ivan", "IT", 4000);
        Emploee sotr7 = new Emploee("Roman", "IT", 5000);
        Emploee sotr8 = new Emploee("Nick", "IT", 4600);
        List<Emploee> sotrlist = Arrays.asList(sotr, sotr2, sotr3, sotr4, sotr5, sotr6, sotr7, sotr8);
        Map<String, List<Emploee>> spisokPosition = sotrlist
                .stream()
                .collect(Collectors
                        .groupingBy(Emploee::getPosition));
        System.out.println("Сгрупировать сотрудников по должности");
        System.out.println(spisokPosition);
        List<Emploee> sotrSalary =  sotrlist.stream()
                .filter(x->x.getSalary()<1000)
               // .collect(Collectors.groupingBy(Emploee::getSalary));
                       .collect(Collectors.toList());
        System.out.println("Получить список сотрудников с зп < 1000  "+sotrSalary);
      Set<Integer> sotrSalary1000 = (Set<Integer>) sotrlist.stream()
                .map(Emploee::getSalary)
                .sorted()
                .filter(x0->x0<1000).collect(Collectors.toSet());
        System.out.println("Получить список сотрудников с зп < 1000"+sotrSalary1000);
        Comparator<Emploee> comparatorMin=(l1, l2) -> l1.getSalary()-l2.getSalary();

        /*    if (l1.getSalary()>l2.getSalary()) return 1;
            if (l1.getSalary()<l2.getSalary()) return -1;
            return 0;*/

        Comparator<Emploee> comparatorMax= (l1, l2) ->l2.getSalary()-l1.getSalary();
        /*{

            if (l1.getSalary()>l2.getSalary()) return 1;
            if (l1.getSalary()<l2.getSalary()) return -1;
            return 0;
        };*/
      //  sotrlist.clear();
      //  sotrlist=new ArrayList<>();
        Optional<Emploee> sotrSalaryMin =sotrlist.stream().min(comparatorMin);
        System.out.println("min - "+sotrlist.stream().min(comparatorMin)
                .orElse(new Emploee("xxx","xxx",000)).getSalary());
        Optional<Emploee> sotrSalaryMax =sotrlist.stream().max(comparatorMax);

        System.out.println("Получить сотрудника с самой низкой зп  "+sotrSalaryMin);
        System.out.println("Получить сотрудника с самой большой зп  "+sotrSalaryMax);
        System.out.println("+-+-+-"+ sotrlist.stream()
                .map(x ->  Math.abs(x.getSalary()))
                      //  .orElseThrow(IllegalStateException::new)
                );

       // sotrlist=new ArrayList<>();
        System.out.println("Вычислить среднюю зарплату всех сотрудников - "+
                sotrlist.stream()
                        .mapToLong(Emploee::getSalary)
                        .average()
                        .orElseThrow()

        );
        System.out.println("Вычислить min зарплату всех сотрудников - "+
                sotrlist.stream()
                        .mapToInt(Emploee::getSalary)
                        .min()
                        .orElseThrow()

        );
        System.out.println("Получить список сотрудников из отдела маркетинг и увеличить зп на 15%  "+
                sotrlist.stream()
                        //.filter(x -> "marketing".equals(x.getPosition()))
                        .filter(x -> x.getPosition().equals("marketing"))
                        // .filter(e->e.equals())
                      // .peek(x -> x.setSalary((int) Math.round(x.getSalary() * 1.15)))
                       .peek(x -> x.setSalary(x.getSalary() * 2))
                    //    .map(e ->new Emploee(e.getName(),e.getPosition(),e.getSalary() * 2))
                    .collect(Collectors.toList()));

        System.out.println("Получите сотрудников из всех отделов с максимальной зп - "+
                sotrlist.stream()
                        .collect(Collectors.groupingBy(Emploee::getPosition))
                        .values()
                        .stream()
                      //  .map(list -> list.stream().max(Comparator.comparingLong(Emploee::getSalary)).orElseThrow())
                        .map(list -> list.stream().max(comparatorMax))
                        .collect(Collectors.toList())

        );
        List<Optional<Emploee>>emploeeList= sotrlist.stream()
                .collect(Collectors.groupingBy(Emploee::getPosition))
                .values()
                .stream()
                .map(list -> list.stream().max(comparatorMax))
                .collect(Collectors.toList());

        System.out.println(emploeeList);
        System.out.println(sotrlist.stream()
                .collect(Collectors.groupingBy(Emploee::getPosition, Collectors.maxBy(Comparator.comparing(Emploee::getSalary)))));

    }
}
//Создать класс Emploee
//
//2. Сгрупировать сотрудников по должности  marketing. accounting.
//
//3. Вычислить среднюю зарплату всех сотрудников
//
//4. Получить список сотрудников с зп > 1000
//
//5. Получить список сотрудников из отдела маркетинг и увеличить зп на 15%
//
//6. Получить сотрудника с самой низкой зп
//
//7. Получите сотрудников из всех отделов с максимальной зп