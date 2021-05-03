package src.com.splitwise.UserInput;

import src.com.splitwise.Account;
import src.com.splitwise.models.User;

public class ShowUserExpense implements IUserInput {

    private static ShowUserExpense showUserExpenseInstance;
    Account account;

    public ShowUserExpense() {
        account = Account.getInstance();
    }

    public static synchronized ShowUserExpense getInstance() {
        if (showUserExpenseInstance == null) {
            showUserExpenseInstance = new ShowUserExpense();
        }
        return showUserExpenseInstance;
    }

    @Override
    public void runInput(String[] userInput) {
        // TODO Auto-generated method stub

        Long userId = Long.valueOf(userInput[1]);
        User user = account.getUserById(userId);
        System.out.println(user.getExpenseList());

    }

}
