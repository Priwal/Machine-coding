package src.com.splitwise.split;

import src.com.splitwise.models.User;

public class EqualSplit extends Split {

    public EqualSplit(User user, double share) {
        super(splitType.EQUAL, user, share);
    }

    @Override
    public double getShare() {
        // TODO Auto-generated method stub
        return super.getShare();
    }

}
