package com.ykj.java;


import com.ykj.java.common.utils.MapDeserializerDoubleAsIntFix;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.*;


public class JsonTest extends Thread {

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

    @Autowired
    private AppMemberDao appMemberDao;

    @Test
    public void test() {

        String json = "{username : '你好吗,  ,,  哈哈哈'}";
//        HashMap<String, Object> hashMap = gson.fromJson(str, new TypeToken<HashMap<String, Object>>(){}.getType());
//        String mobile = hashMap.get("username").toString();
//
//        System.out.println(mobile);

//        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.registerTypeAdapter(new TypeToken<Map <String, Object>>(){}.getType(),  new JsonTest());
//        Gson gson = gsonBuilder.create();
//        Map<String, Object> map = gson.fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
//        System.out.println(map.get("username").getClass());

//       HashMap<String, Object> map =  MapDeserializerDoubleAsIntFix.createJson().fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        HashMap<String, Object> map = MapDeserializerDoubleAsIntFix.fromJson(json);
        String username = map.get("username").toString();
        System.out.println(username);

        Sex<String> stringSex = new Sex<>("world");
        Class<? extends Sex> aClass = stringSex.getClass();
        System.out.println(aClass.getName());


        new Thread().run();

        try {
            Field declaredField = aClass.getDeclaredField("t");
            System.out.println(declaredField.getName() + declaredField.getType().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));

    }

    @Test
    public void testlist(){
        List<HashMap<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map;
        for (int i = 0; i < 2; i++) {
            map = new HashMap<>();
            map.put("id", i);
            list.add(map);
        }

        System.out.println(list);

    }

    @Test
    public void thread(){
        Random random = new Random(47);
        ThreadGroup threadGroup = new ThreadGroup("12");
        for (int i = 0; i < 3; i++) {
            new Thread(threadGroup, new Runnable() {
                @Override
                public void run() {
                    System.out.println(random.nextInt(30));
                }
            }).start();
        }
    }

}

class Sex<T extends String>{
    T t;

    public Sex(T t){
        this.t = t;
    }
}
