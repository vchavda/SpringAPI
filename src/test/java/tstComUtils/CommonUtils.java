package tstComUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CommonUtils {

    private ArrayList<String> jsonArrayList = new ArrayList<>();

    public static void getStaticJSON(String filepath) throws IOException {

        File file = (new File(filepath));
        String sampleResponse = org.apache.commons.io.FileUtils.readFileToString(file);
        ResponseMap.setResponseMap(200,sampleResponse);

    }




    /// for free texts /////
    public ArrayList<String> findFreeText(String textToFind, String jsonBody) throws JSONException {
        createJSONMap(new JSONObject(jsonBody));
        ArrayList<String> list = new ArrayList<>();
        String[] searchTextValues  = textToFind.split(",");

        for (int i= 0; i < jsonArrayList.size(); i++) {
            if (Arrays.stream(searchTextValues).map(x ->  x.toLowerCase()).anyMatch(jsonArrayList.get(i).split(":")[1].toLowerCase()::equals));
            {
                list.add(jsonArrayList.get(i));
            }
        }

        return list;

    }


    private void createJSONMap(JSONObject json) throws JSONException {
        Iterator<String> keys = json.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (json.get(key) instanceof JSONArray) {
                JSONArray ja = (JSONArray) json.get(key);
                for (int i = 0; i < ja.length(); i++) {
                    if (ja.get(i) instanceof JSONObject) {
                        createJSONMap((JSONObject) ja.get(i));

                    } else {
                        jsonArrayList.add(key + ":" + ja.get(i).toString());
                    }
                }
            } else  if (json.get(key) instanceof JSONObject) {
                createJSONMap((JSONObject) json.get(key));
            } else {
                jsonArrayList.add(key + ":" + json.get(key).toString());
            }
        }

    }

}
