package src.com.splitwise.expense;

import java.util.List;

import src.com.splitwise.uidGenerator;
import src.com.splitwise.models.User;
import src.com.splitwise.split.Split;

public abstract class Expense extends uidGenerator {

    private Double totalAmount;
    final private ExpenseType expenseType;
    private User paidBy;
    private User createdBy;
    private List<Split> splitList;
    private String expenseName;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<Split> getSplitList() {
        return splitList;
    }

    public void setSplitList(List<Split> splitList) {
        // validateSplit(splitList);
        // validateExpense(splitList);
        this.splitList = splitList;
    }

    public Expense(Double totalAmount, ExpenseType expenseType, User paidBy, User createdBy, List<Split> splitList,
            String expenseName) {
        this.totalAmount = totalAmount;
        this.expenseType = expenseType;
        this.paidBy = paidBy;
        this.createdBy = createdBy;
        this.splitList = splitList;
        this.expenseName = expenseName;
    }

    @Override
    public String toString() {
        return "Expense [createdBy=" + createdBy + ", expenseName=" + expenseName + ", expenseType=" + expenseType
                + ", paidBy=" + paidBy + ", splitList=" + splitList + ", totalAmount=" + totalAmount + "]";
    }

    // abstract void validateExpense(List<Split> splitList) throws
    // IllegalSplitException;

    // abstract void validateSplit(List<Split> splitList) throws
    // IllegalSplitException;

}
