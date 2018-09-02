package com.ykj.java;


import com.ykj.java.common.utils.MapDeserializerDoubleAsIntFix;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.*;


public class JsonTest {

//    Gson gson = new GsonBuilder()
//            .registerTypeAdapter(
//                    new TypeToken<HashMap<String, Object>>(){}.getType(),
//                    (JsonDeserializer<HashMap<String, Object>>) (json, typeOfT, context) -> {
//
//                        HashMap<String, Object> hashMap = new HashMap<>();
//                        JsonObject jsonObject = json.getAsJsonObject();
//                        Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
//                        for (Map.Entry<String, JsonElement> entry : entrySet) {
//                            hashMap.put(entry.getKey(), entry.getValue());
//                        }
//                        return hashMap;
//                    }).create();


//    @Override
//    public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        return (Map<String, Object>) read(jsonElement);
//    }
//
//    public Object read(JsonElement in) {
//        if(in.isJsonArray()){
//            List<Object> list = new ArrayList<>();
//            JsonArray arr = in.getAsJsonArray();
//            for (JsonElement anArr : arr) {
//                list.add(read(anArr));
//            }
//            return list;
//        }else if(in.isJsonObject()){
//            Map<String, Object> map = new LinkedTreeMap<String, Object>();
//            JsonObject obj = in.getAsJsonObject();
//            Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
//            for(Map.Entry<String, JsonElement> entry: entitySet){
//                map.put(entry.getKey(), read(entry.getValue()));
//            }
//            return map;
//        }else if( in.isJsonPrimitive()){
//            JsonPrimitive prim = in.getAsJsonPrimitive();
//            if(prim.isBoolean()){
//                return prim.getAsBoolean();
//            }else if(prim.isString()){
//                return prim.getAsString();
//            }else if(prim.isNumber()){
//                Number num = prim.getAsNumber();
//                // here you can handle double int/long values
//                // and return any type you want
//                // this solution will transform 3.0 float to long values
//                if(Math.ceil(num.doubleValue())  == num.longValue())
//                    return num.longValue();
//                else{
//                    return num.doubleValue();
//                }
//            }
//        }
//        return null;
//    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}


