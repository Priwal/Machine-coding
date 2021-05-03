package src.com.splitwise.split;

import src.com.splitwise.models.User;

public class PercentSplit extends Split {
    private double percent;

    public PercentSplit(User user, double share, double percent) {
        super(splitType.PERCENT, user, share);
        this.percent = percent;
    }

    @Override
    public double getShare() {
        // TODO Auto-generated method stub
        return super.getShare();
    }

    public double getPercent() {
        return percent;
    }

}
