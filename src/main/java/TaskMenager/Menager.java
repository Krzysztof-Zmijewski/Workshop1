package TaskMenager;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class  Menager {
    public static void main(String[] args) {
        String[][] tasks = loadTasks("src/main/java/TaskMenager/tasks.csv");
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
                showList(tasks);
                sentence = scanner.nextLine();
            } else if (sentence.equals("exit")) {
                System.out.println("Bye Bye");
                IsLoopWorking = false;
            } else {
                System.out.println(ConsoleColors.RED + "Please select a correct option" + ConsoleColors.RESET);
                sentence = scanner.nextLine();
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
            for (int i = 0; i <strings.size() ; i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file does not exists");
        }
        return tab;
    }
    public static void showList (String[][] listName){
        for (int i = 0; i < listName.length ; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j <listName[i].length ; j++) {
                System.out.print(listName[i][j] + " ");
            }
            System.out.println();
        }

    }
}
