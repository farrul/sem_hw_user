import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String... args) {
        List<User> users = Arrays.asList(
                new User(1, "Mikhail", "Komarov", 34, "Russia"),
                new User(2, "Viktoria", "Komarova", 10, "Russia"),
                new User(3, "James", "Belton", 23, "USA"),
                new User(4, "Basim", "Ibn Ishaq", 1188, "Abbasid Halifate"),
                new User(5, "William Sydney", "Potter", 161, "USA"),
                new User(5, "Jane", "Austin", 236, "UK"));

        // Task 1
        System.out.println("Sorted by age:");
        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList()
                .forEach(System.out::println);

        // Task 2
        System.out.println("Группировка по id:");
        Map<Long, List<User>> groupById = users.stream().collect(Collectors.groupingBy(User::getId));
        for (Map.Entry<Long, List<User>> entry : groupById.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        // Task 3
        System.out.println("Number of different nationalities:");
        int differentNationsNum = users.stream().
                collect(Collectors.groupingBy(User::getNationality)).keySet().size();
        System.out.println(differentNationsNum);

        //Task 4
        System.out.println("Users with age>10 and firstName[0]!=M");
        users.stream()
                .filter(user -> (!user.getFirstName().startsWith("M")))
                .filter(user -> (user.getAge() > 10))
                .toList().forEach(System.out::println);

    }

}
