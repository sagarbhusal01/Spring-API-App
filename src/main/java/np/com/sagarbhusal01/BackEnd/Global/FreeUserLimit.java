package np.com.sagarbhusal01.BackEnd.Global;

import org.springframework.stereotype.Component;

@Component
public class FreeUserLimit {
    private int ReadLimit=500;
    private int WriteLimit=250;

    public int getReadLimit() {
        return ReadLimit;
    }
    public int getWriteLimit() {
        return WriteLimit;
    }

}
