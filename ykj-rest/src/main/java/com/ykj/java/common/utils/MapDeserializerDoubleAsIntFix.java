package com.ykj.java.common.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;


/**
 *最近在研究网络请求数据解析的问题，发现json数据被强制转换为map结构的时候，会出现int变成double的问题
 *在stackoverflow上看到了一个这个How can I prevent gson from converting integers to doubles 的问题，采用了这个答案
 *https://stackoverflow.com/a/36529534/5279354答案
 */

public class MapDeserializerDoubleAsIntFix implements JsonDeserializer<Map<String, Object>> {

    @Override
    public Map<String, Object> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return (Map<String, Object>) read(jsonElement);
    }

    public Object read(JsonElement in) {
        if(in.isJsonArray()){
            List<Object> list = new ArrayList<>();
            JsonArray arr = in.getAsJsonArray();
            for (JsonElement anArr : arr) {
                list.add(read(anArr));
            }
            return list;
        }else if(in.isJsonObject()){
            Map<String, Object> map = new HashMap<>();
            JsonObject obj = in.getAsJsonObject();
            Set<Map.Entry<String, JsonElement>> entitySet = obj.entrySet();
            for(Map.Entry<String, JsonElement> entry: entitySet){
                map.put(entry.getKey(), read(entry.getValue()));
            }
            return map;
        }else if( in.isJsonPrimitive()){
            JsonPrimitive prim = in.getAsJsonPrimitive();
            if(prim.isBoolean()){
                return prim.getAsBoolean();
            }else if(prim.isString()){
                return prim.getAsString();
            }else if(prim.isNumber()){
                Number num = prim.getAsNumber();
                // here you can handle double int/long values
                // and return any type you want
                // this solution will transform 3.0 float to long values
                if(Math.ceil(num.doubleValue())  == num.longValue())
                    return num.longValue();
                else{
                    return num.doubleValue();
                }
            }
        }
        return null;
    }

    public static HashMap<String, Object> fromJson(String json){

        GsonBuilder gsonBuilder = new GsonBuilder().setLenient();
        gsonBuilder.registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(),  new MapDeserializerDoubleAsIntFix());
        Gson gson = gsonBuilder.create();
        return gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());

    }
}
