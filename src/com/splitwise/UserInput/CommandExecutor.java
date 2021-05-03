package src.com.splitwise.UserInput;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor implements IUserInput {

    private Map<String, IUserInput> inputMap;
    private static CommandExecutor commandExecutorInstance;

    private CommandExecutor() {
        inputMap = new HashMap<>();
        // inputMap.put("Add_User", AddUserCommand.getInstance());
        inputMap.put("Add_Expense", AddExpense.getInstance());
        // inputMap.put("Show_User_Data", ShowUserInfoCommand.getInstance());
        inputMap.put("Show_All_User_Balance", ShowAllUserBalance.getInstance());
        inputMap.put("Show_User_Expense", ShowUserExpense.getInstance());
    }

    public static synchronized CommandExecutor getInstance() {
        if (commandExecutorInstance == null) {
            commandExecutorInstance = new CommandExecutor();
        }
        return commandExecutorInstance;
    }

    public Map<String, IUserInput> getInputMap() {
        return inputMap;
    }

    @Override
    public void runInput(String[] userInput) {
        // TODO Auto-generated method stub

        getInputMap().get(userInput[0]).runInput(userInput);

    }

}
