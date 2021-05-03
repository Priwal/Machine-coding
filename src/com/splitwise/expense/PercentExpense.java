package src.com.splitwise.expense;

import java.util.List;

import src.com.splitwise.models.User;
import src.com.splitwise.split.Split;

public class PercentExpense extends Expense {

    public PercentExpense(Double totalAmount, User paidBy, User createdBy, List<Split> splitList, String expenseName) {
        super(totalAmount, ExpenseType.PERCENT, paidBy, createdBy, splitList, expenseName);
    }

}
