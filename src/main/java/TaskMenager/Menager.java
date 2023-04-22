package TaskMenager;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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
                tasks = Arrays.copyOf(tasks, tasks.length + 1);
                System.out.println("Please add task description");
                String description = scanner.nextLine();
                System.out.println("Please add task due date");
                String dueDate = scanner.nextLine();
                System.out.println("Is your task important: true/false");
                String isImportant = scanner.nextLine();
                tasks[tasks.length - 1] = new String[3];
                tasks[tasks.length - 1][0] = description;
                tasks[tasks.length - 1][1] = dueDate;
                tasks[tasks.length - 1][2] = isImportant;
                sentence = scanner.nextLine();
            } else if (sentence.equals("remove")) {
                try {
                    int index = getNumber();
                    if (index < tasks.length) {
                        tasks = ArrayUtils.remove(tasks,index);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Element not exist in tasks");
                }
                sentence = scanner.nextLine();
            } else if (sentence.equals("list")) {
                showList(tasks);
                sentence = scanner.nextLine();
            } else if (sentence.equals("exit")) {
                System.out.println(ConsoleColors.RED + "Bye Bye");
                Path path = Paths.get("src/main/java/TaskMenager/tasks.csv");
                String[] lines = new String[tasks.length];
                for (int i = 0; i < tasks.length; i++) {
                    lines[i] = String.join(",", tasks[i]);
                }
                try {
                    Files.write(path, Arrays.asList(lines));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
    public static boolean isNumberGreaterOrEqualZero(String input) {
        if (NumberUtils.isParsable(input)) {
            return Integer.parseInt(input) >= 0;
        }
        return false;
    }
    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove.");
        String n = scanner.nextLine();
        while (!isNumberGreaterOrEqualZero(n)) {
            System.out.println("Incorrect argument passed. Please give number greater or equal 0");
            scanner.nextLine();
        }
        return Integer.parseInt(n);
    }
}
