package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;

public class ConvertToJsonString {

    public static void main(String[] args) throws JsonProcessingException {

        RollInfo rollInfo = new RollInfo();
        rollInfo.setDeployStrategy("COLO_WISE");
        rollInfo.setMax_colos(2);
        rollInfo.setWait_in_time(60);
        rollInfo.setSequenceOfColos(Arrays.asList(new String[]{"1","2"}));


        ObjectMapper objectMapper = new ObjectMapper();
        String res = objectMapper.writeValueAsString(rollInfo);
        System.out.println(res);
    }
}
