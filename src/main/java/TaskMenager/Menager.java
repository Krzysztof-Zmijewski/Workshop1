package TaskMenager;

public class  Menager {
    public static void main(String[] args) {
        String[] options = {ConsoleColors.BLUE + "Please select an option:",ConsoleColors.RESET + "add", "remove", "list", "exit"};
        for (String option : options) {
            System.out.println(option);

        }
    }
}
