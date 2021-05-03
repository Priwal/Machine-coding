package src.com.splitwise.split;

import src.com.splitwise.uidGenerator;
import src.com.splitwise.models.User;

public abstract class Split extends uidGenerator {

    final private splitType splittype;
    private User user;
    private double share;

    public Split(splitType splittype, User user, double share) {
        this.splittype = splittype;
        this.user = user;
        this.share = share;
    }

    public splitType getSplittype() {
        return splittype;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getShare() {
        return share;
    }

    public void setShare(double share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "Split { share=" + share + ", splittype=" + splittype + ", user=" + user + "}";
    }

}
