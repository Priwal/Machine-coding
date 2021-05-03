package src.com.splitwise.split;

import src.com.splitwise.models.User;

public class ExactSplit extends Split {
    public ExactSplit(User user, double share) {
        super(splitType.EXACT, user, share);
    }

    @Override
    public double getShare() {
        // TODO Auto-generated method stub
        return super.getShare();
    }

}
