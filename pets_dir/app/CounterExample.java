import java.util.Scanner;

public class CounterExample {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Заведите новое животное? (да/нет)");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("да")) {
                counter.add();
                System.out.println("Животное добавлено.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
