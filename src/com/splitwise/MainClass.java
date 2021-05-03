package src.com.splitwise;

import java.util.Scanner;

import src.com.splitwise.UserInput.CommandExecutor;
import src.com.splitwise.models.User;

public class MainClass {
    public static void main(String[] args) {
        System.out.println("***Splitwise***");
        Account account = Account.getInstance();
        User u1 = new User("Ankit", "ankit12@gmail.com", "4763785683");
        User u2 = new User("Ridhi", "rid355@gmail.com", "7879");
        User u3 = new User("Samyak", "sam456@gmail.com", "6899656");

        account.addUser(u1);
        account.addUser(u2);
        account.addUser(u3);

        // System.out.println(u1.toString());
        // System.out.println(u2.toString());
        // System.out.println(u3.toString());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(">");
            String[] userInput = sc.nextLine().split(" ");
            CommandExecutor.getInstance().runInput(userInput);
            // System.out.println("input");
        }
    }
}
