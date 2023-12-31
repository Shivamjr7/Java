package json;

import java.util.List;

public class RollInfo {

    public String getDeployStrategy() {
        return deployStrategy;
    }

    public void setDeployStrategy(String deployStrategy) {
        this.deployStrategy = deployStrategy;
    }

    private String deployStrategy;

    public long getWait_in_time() {
        return wait_in_time;
    }

    public void setWait_in_time(long wait_in_time) {
        this.wait_in_time = wait_in_time;
    }

    public List<String> getSequenceOfColos() {
        return sequenceOfColos;
    }

    public void setSequenceOfColos(List<String> sequenceOfColos) {
        this.sequenceOfColos = sequenceOfColos;
    }

    public int getMax_colos() {
        return max_colos;
    }

    public void setMax_colos(int max_colos) {
        this.max_colos = max_colos;
    }

    private long wait_in_time;

    private List<String> sequenceOfColos;

    private int max_colos;

}
