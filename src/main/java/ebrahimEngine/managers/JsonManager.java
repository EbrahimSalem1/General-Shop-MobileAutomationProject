package ebrahimEngine.managers;

import com.google.gson.*;
import com.jayway.jsonpath.JsonPath;
import ebrahimEngine.loggers.LogHelper;

import java.io.File;

public class JsonManager {

    //Variables
    private String filePath;

    //Constructor
    public JsonManager(String filePath) {
        this.filePath = filePath;
    }

    //Method to Get JsonData as String using JsonPath Expression
    public String getData(String jsonPath) {
        try {
            String data;
        Object result = JsonPath.parse(new File(filePath)).read(jsonPath);
        if (result.toString().contains("{"))
            data = JsonPath.parse(result).jsonString();
        else
            data = result.toString();

        LogHelper.logInfoStep("Getting Test Data ["+data+"] by Json Path ["+jsonPath+"]");
        return data;

        }catch (Exception e){
            LogHelper.logErrorStep("Failed to Read Test Data by Json Path ["+jsonPath+"]",e);
            return null;
        }
    }
}


