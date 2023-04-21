package TaskMenager;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
    public static String[][] loadTasks (String filename) {
        Path path = Paths.get(filename);
        if (!Files.exists(path)) {
            System.out.println("File does not exist");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(path);
            tab = new String[strings.size()][strings.get(0).split(",").length];
            //for (int i = 0; i < ; i++) {
                
            }
        }
    }
}
