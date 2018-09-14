package hello.model.entities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class Utils {
    public static boolean saveToFile(String file, Map objects){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(new File(file), objects);
        } catch (Exception e){
            return false;
        }
        return true;
    }
}
