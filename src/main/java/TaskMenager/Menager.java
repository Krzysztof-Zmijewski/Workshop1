package TaskMenager;

import java.util.Scanner;

public class  Menager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {ConsoleColors.BLUE + "Please select an option:", ConsoleColors.RESET + "add", "remove", "list", "exit"};
        for (String option : options) {
            System.out.println(option);
        }
        String sentence = scanner.nextLine();
        boolean IsLoopWorking = true;
        while (IsLoopWorking) {
            if (sentence.equals("add")) {
                //dodawanie tasków
            } else if (sentence.equals("remove")) {
                //tutaj usuwanie
            } else if (sentence.equals("list")) {
                //tutaj lista wszystkich tasków
            } else if (sentence.equals("exit")) {
                System.out.println("Bye Bye");
                IsLoopWorking = false;
            }
        }

    }
}
