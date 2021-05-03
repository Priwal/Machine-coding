package src.com.splitwise;

import src.com.splitwise.expense.ExpenseType;

public class Utils {
    public static double getAmountFromPercent(double totalAmount, double percent) {
        double amount = (totalAmount * percent) / 100.0d;
        return amount;
    }

    public static double getEqualShare(double totalAmount, long userCount) {
        double share = totalAmount / totalAmount;
        share = share * 100.0d / 100.0d;
        return share;
    }

    public static ExpenseType stringToExpenseType(String expType) {
        if (expType.toLowerCase().equals("equal")) {
            return ExpenseType.EQUAL;
        } else if (expType.toLowerCase().equals("exact")) {
            return ExpenseType.EXACT;
        }
        return ExpenseType.PERCENT;
    }
}
