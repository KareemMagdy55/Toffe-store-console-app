import java.util.Scanner;

public class Validator {
    public static int takeIntChoice(int lowerInputBound, int upperInputBound) {
        return takeIntChoice(lowerInputBound, upperInputBound, "Invalid choice, Try again:");
    }

    public static int takeIntChoice(int lowerInputBound, int upperInputBound, String message) {
        boolean firstIterate = true;
        int choice = upperInputBound + 1;
        Scanner in = new Scanner(System.in);
        while (choice > upperInputBound || choice < lowerInputBound) {
            if (!firstIterate)
                System.out.print(message);
            else
                firstIterate = false;
            try {
                choice = in.nextInt();
            } catch (Exception ignored) {
                in.nextLine();
            }
        }
        in.nextLine();
        return choice;
    }
}
