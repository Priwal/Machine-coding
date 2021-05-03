package src.com.splitwise.UserInput;

import src.com.splitwise.Account;

public class ShowAllUserBalance implements IUserInput {

    private static ShowAllUserBalance showAllUserBalanceInstance;
    Account account;

    public ShowAllUserBalance() {
        account = Account.getInstance();
    }

    public static synchronized ShowAllUserBalance getInstance()
    {
        if(showAllUserBalanceInstance==null)
        {
            showAllUserBalanceInstance =new ShowAllUserBalance()
        }
        return showAllUserBalanceInstance;
    }

    @Override
    public void runInput(String[] userInput) {
        // TODO Auto-generated method stub
        account.getAllUsers();
    }

}
