package src.com.splitwise;

public class uidGenerator {

    private static long newUid = 0;
    private final long uId;

    protected uidGenerator() {
        uId = ++newUid;
    }

    public long getuId() {
        return uId;
    }
}
