package src.com.splitwise.UserInput;

import java.util.ArrayList;
import java.util.List;

import src.com.splitwise.Account;
import src.com.splitwise.Utils;
import src.com.splitwise.expense.EqualExpense;
import src.com.splitwise.expense.ExactExpense;
import src.com.splitwise.expense.Expense;
import src.com.splitwise.expense.ExpenseType;
import src.com.splitwise.expense.PercentExpense;
import src.com.splitwise.models.User;
import src.com.splitwise.split.EqualSplit;
import src.com.splitwise.split.ExactSplit;
import src.com.splitwise.split.PercentSplit;
import src.com.splitwise.split.Split;

public class AddExpense implements IUserInput {

    private static AddExpense addExpenseInstance;
    Account account;

    public AddExpense() {
        account = Account.getInstance();
    }

    public static synchronized AddExpense getInstance() {
        if (addExpenseInstance == null) {
            addExpenseInstance = new AddExpense();
        }
        return addExpenseInstance;
    }

    @Override
    public void runInput(String[] userInput) {
        // TODO Auto-generated method stub
        String expenseName = userInput[1];
        Double amount = Double.valueOf(userInput[2]);
        User paidBy = account.getUserById(Long.valueOf(userInput[3]));
        User createdBy = account.getUserById(Long.valueOf(userInput[4]));
        Long totalUsers = Long.valueOf(userInput[5]);
        List<Split> splitList = new ArrayList();
        ExpenseType expenseType = Utils.stringToExpenseType(userInput[6]);

        if (expenseType == ExpenseType.EQUAL)

        {
            Double getShareofEach = amount / totalUsers;
            for (int userCount = 0; userCount < totalUsers; userCount++) {

                Long userId = Long.valueOf(userInput[7 + userCount]);
                User user = account.getUserById(userId);
                splitList.add(new EqualSplit(user, getShareofEach));
            }

            Expense newExpenseCreated = new EqualExpense(amount, paidBy, createdBy, splitList, expenseName);

            for (Split s : newExpenseCreated.getSplitList()) {
                s.getUser().setTotalBalance(s.getShare());
                s.getUser().addExpense(newExpenseCreated);
            }

        } else if (expenseType == ExpenseType.EXACT) {
            for (int userCount = 0; userCount < totalUsers; userCount++) {
                Long userId = Long.valueOf(userInput[7 + userCount]);
                User user = account.getUserById(userId);
                Double getUserShare = Double.valueOf(userInput[Math.toIntExact(7 + totalUsers + userCount)]);
                splitList.add(new ExactSplit(user, getUserShare));
            }
            Expense newExpenseCreated = new ExactExpense(amount, paidBy, createdBy, splitList, expenseName);
            for (Split s : newExpenseCreated.getSplitList()) {
                s.getUser().setTotalBalance(s.getShare());
                s.getUser().addExpense(newExpenseCreated);
            }
        }

        else if (expenseType == ExpenseType.PERCENT) {
            for (int userCount = 0; userCount < totalUsers; userCount++) {
                Long userId = Long.valueOf(userInput[7 + userCount]);
                User user = account.getUserById(userId);
                Double getPercent = Double.valueOf(userInput[Math.toIntExact(7 + totalUsers + userCount)]);
                Double userShare = Utils.getAmountFromPercent(amount, getPercent);
                splitList.add(new PercentSplit(user, userShare, getPercent));
            }
            Expense newExpenseCreated = new PercentExpense(amount, paidBy, createdBy, splitList, expenseName);
            for (Split s : newExpenseCreated.getSplitList()) {
                s.getUser().setTotalBalance(s.getShare());
                s.getUser().addExpense(newExpenseCreated);
            }
        }
        System.out.println("Expense created successfully");

    }
}
