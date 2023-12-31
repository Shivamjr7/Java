package serialization;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;

public class ValidateSerializable implements Serializable {

    public static void main(String[] args) {
        SerializationUtils.serialize(new ValidateSerializable());
    }
}
