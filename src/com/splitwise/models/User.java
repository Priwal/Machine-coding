package src.com.splitwise.models;

import java.util.ArrayList;
import java.util.List;

import src.com.splitwise.uidGenerator;
import src.com.splitwise.expense.Expense;

public class User extends uidGenerator {
    private String name;
    private String email;
    private String phone;
    private double totalBalance;
    private List<Expense> expenseList;

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.totalBalance = 0;
        expenseList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    // public void addBalance(double balance){
    // this.totalBalance = Utils.roundOff(this.totalBalance + balance);
    // }

    public String showUserExpense() {
        return expenseList.toString();
    }

    @Override
    public String toString() {
        return "User { id=" + getuId() + "email=" + email + ", name=" + name + ", phone=" + phone + ", totalBalance="
                + totalBalance + "}";
    }
}
