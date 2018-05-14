package jd.wjlogin_sdk.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* compiled from: TbsSdkJava */
public class JSONHelper {
    public static String toJSON(Object obj) {
        JSONStringer jSONStringer = new JSONStringer();
        serialize(jSONStringer, obj);
        return jSONStringer.toString();
    }

    private static void serialize(JSONStringer jSONStringer, Object obj) {
        if (isNull(obj)) {
            try {
                jSONStringer.value(null);
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        Class cls = obj.getClass();
        if (isObject(cls)) {
            serializeObject(jSONStringer, obj);
        } else if (isArray(cls)) {
            serializeArray(jSONStringer, obj);
        } else if (isCollection(cls)) {
            serializeCollect(jSONStringer, (Collection) obj);
        } else if (isMap(cls)) {
            serializeMap(jSONStringer, (HashMap) obj);
        } else {
            try {
                jSONStringer.value(obj);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static void serializeArray(JSONStringer jSONStringer, Object obj) {
        try {
            jSONStringer.array();
            for (int i = 0; i < Array.getLength(obj); i++) {
                serialize(jSONStringer, Array.get(obj, i));
            }
            jSONStringer.endArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serializeCollect(JSONStringer jSONStringer, Collection<?> collection) {
        try {
            jSONStringer.array();
            for (Object serialize : collection) {
                serialize(jSONStringer, serialize);
            }
            jSONStringer.endArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serializeMap(JSONStringer jSONStringer, Map<?, ?> map) {
        try {
            jSONStringer.object();
            for (Entry entry : map.entrySet()) {
                jSONStringer.key((String) entry.getKey());
                serialize(jSONStringer, entry.getValue());
            }
            jSONStringer.endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serializeObject(JSONStringer jSONStringer, Object obj) {
        try {
            jSONStringer.object();
            Class cls = obj.getClass();
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Field field : cls.getDeclaredFields()) {
                try {
                    String simpleName = field.getType().getSimpleName();
                    String parseMethodName = parseMethodName(field.getName(), "get");
                    if (haveMethod(declaredMethods, parseMethodName)) {
                        Object invoke = cls.getMethod(parseMethodName, new Class[0]).invoke(obj, new Object[0]);
                        if ("Date".equals(simpleName)) {
                            parseMethodName = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format((Date) invoke);
                            jSONStringer.key(field.getName());
                            serialize(jSONStringer, parseMethodName);
                        } else if (invoke != null) {
                            parseMethodName = String.valueOf(invoke);
                            jSONStringer.key(field.getName());
                            serialize(jSONStringer, parseMethodName);
                        }
                    }
                } catch (Exception e) {
                }
            }
            jSONStringer.endObject();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean haveMethod(Method[] methodArr, String str) {
        for (Method name : methodArr) {
            if (str.equals(name.getName())) {
                return true;
            }
        }
        return false;
    }

    public static String parseMethodName(String str, String str2) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return new StringBuilder(String.valueOf(str2)).append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
    }

    public static void setFieldValue(Object obj, Map<String, String> map) {
        Class cls = obj.getClass();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            try {
                String parseMethodName = parseMethodName(field.getName(), "set");
                if (haveMethod(declaredMethods, parseMethodName)) {
                    Method method = cls.getMethod(parseMethodName, new Class[]{field.getType()});
                    parseMethodName = (String) map.get(field.getName());
                    if (!(parseMethodName == null || "".equals(parseMethodName))) {
                        String simpleName = field.getType().getSimpleName();
                        if ("String".equals(simpleName)) {
                            method.invoke(obj, new Object[]{parseMethodName});
                        } else if ("Date".equals(simpleName)) {
                            Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(parseMethodName);
                            method.invoke(obj, new Object[]{parse});
                        } else if ("Integer".equals(simpleName) || "int".equals(simpleName)) {
                            method.invoke(obj, new Object[]{Integer.valueOf(Integer.parseInt(parseMethodName))});
                        } else if ("Long".equalsIgnoreCase(simpleName)) {
                            method.invoke(obj, new Object[]{Long.valueOf(Long.parseLong(parseMethodName))});
                        } else if ("Double".equalsIgnoreCase(simpleName)) {
                            method.invoke(obj, new Object[]{Double.valueOf(Double.parseDouble(parseMethodName))});
                        } else if ("Boolean".equalsIgnoreCase(simpleName)) {
                            method.invoke(obj, new Object[]{Boolean.valueOf(Boolean.parseBoolean(parseMethodName))});
                        } else {
                            System.out.println("setFieldValue not supper type:" + simpleName);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static Map<String, String> beanToMap(Object obj) {
        Class cls = obj.getClass();
        Map<String, String> hashMap = new HashMap();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            try {
                String simpleName = field.getType().getSimpleName();
                String parseMethodName = parseMethodName(field.getName(), "get");
                if (haveMethod(declaredMethods, parseMethodName)) {
                    Object invoke = cls.getMethod(parseMethodName, new Class[0]).invoke(obj, new Object[0]);
                    invoke = "Date".equals(simpleName) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format((Date) invoke) : invoke != null ? String.valueOf(invoke) : null;
                    hashMap.put(field.getName(), invoke);
                }
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    public static void setFiedlValue(Object obj, Method method, String str, Object obj2) {
        if (obj2 != null) {
            try {
                if (!"".equals(obj2)) {
                    if ("String".equals(str)) {
                        method.invoke(obj, new Object[]{obj2.toString()});
                    } else if ("Date".equals(str)) {
                        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString());
                        method.invoke(obj, new Object[]{parse});
                    } else if ("Integer".equals(str) || "int".equals(str)) {
                        method.invoke(obj, new Object[]{Integer.valueOf(Integer.parseInt(obj2.toString()))});
                    } else if ("Long".equalsIgnoreCase(str)) {
                        method.invoke(obj, new Object[]{Long.valueOf(Long.parseLong(obj2.toString()))});
                    } else if ("Double".equalsIgnoreCase(str)) {
                        method.invoke(obj, new Object[]{Double.valueOf(Double.parseDouble(obj2.toString()))});
                    } else if ("Boolean".equalsIgnoreCase(str)) {
                        method.invoke(obj, new Object[]{Boolean.valueOf(Boolean.parseBoolean(obj2.toString()))});
                    } else {
                        method.invoke(obj, new Object[]{obj2});
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T parseObject(JSONObject jSONObject, Class<T> cls) throws JSONException {
        if (cls == null || isNull(jSONObject)) {
            return null;
        }
        T newInstance = newInstance(cls);
        if (newInstance == null) {
            return null;
        }
        if (isMap(cls)) {
            setField(newInstance, jSONObject);
        } else {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Field field : cls.getDeclaredFields()) {
                String parseMethodName = parseMethodName(field.getName(), "set");
                if (haveMethod(declaredMethods, parseMethodName)) {
                    try {
                        setField(newInstance, cls.getMethod(parseMethodName, new Class[]{field.getType()}), field, jSONObject);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return newInstance;
    }

    public static <T> T parseObject(String str, Class<T> cls) throws JSONException {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (isNull(jSONObject)) {
            return null;
        }
        return parseObject(jSONObject, (Class) cls);
    }

    public static <T> T[] parseArray(JSONArray jSONArray, Class<T> cls) {
        if (cls == null || isNull(jSONArray)) {
            return null;
        }
        int length = jSONArray.length();
        Object[] objArr = (Object[]) Array.newInstance(cls, length);
        for (int i = 0; i < length; i++) {
            try {
                objArr[i] = parseObject(jSONArray.getJSONObject(i), (Class) cls);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return objArr;
    }

    public static <T> T[] parseArray(String str, Class<T> cls) {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (isNull(jSONArray)) {
            return null;
        }
        return parseArray(jSONArray, (Class) cls);
    }

    public static <T> Collection<T> parseCollection(JSONArray jSONArray, Class<?> cls, Class<T> cls2) throws JSONException {
        if (cls == null || cls2 == null || isNull(jSONArray)) {
            return null;
        }
        Collection<T> collection = (Collection) newInstance(cls);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                collection.add(parseObject(jSONArray.getJSONObject(i), (Class) cls2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return collection;
    }

    public static <T> Collection<T> parseCollection(String str, Class<?> cls, Class<T> cls2) throws JSONException {
        if (cls == null || cls2 == null || str == null || str.length() == 0) {
            return null;
        }
        JSONArray jSONArray;
        try {
            String substring;
            int indexOf = str.indexOf("[");
            if (-1 != indexOf) {
                substring = str.substring(indexOf);
            } else {
                substring = null;
            }
            if (substring != null) {
                jSONArray = new JSONArray(substring);
            } else {
                jSONArray = new JSONArray(str);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (isNull(jSONArray)) {
            return null;
        }
        return parseCollection(jSONArray, (Class) cls, (Class) cls2);
    }

    private static <T> T newInstance(Class<T> cls) throws JSONException {
        if (cls == null) {
            return null;
        }
        if (!cls.isInterface()) {
            try {
                return cls.newInstance();
            } catch (Exception e) {
                throw new JSONException("unknown class type: " + cls);
            }
        } else if (cls.equals(Map.class)) {
            return new HashMap();
        } else {
            if (cls.equals(List.class)) {
                return new ArrayList();
            }
            if (cls.equals(Set.class)) {
                return new HashSet();
            }
            throw new JSONException("unknown interface: " + cls);
        }
    }

    private static void setField(Object obj, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            Map map = (Map) obj;
            while (keys.hasNext()) {
                String str = (String) keys.next();
                map.put(str, jSONObject.get(str));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void setField(Object obj, Method method, Field field, JSONObject jSONObject) {
        String name = field.getName();
        Class type = field.getType();
        try {
            Class componentType;
            JSONArray optJSONArray;
            if (isArray(type)) {
                componentType = type.getComponentType();
                optJSONArray = jSONObject.optJSONArray(name);
                if (!isNull(optJSONArray)) {
                    setFiedlValue(obj, method, type.getSimpleName(), parseArray(optJSONArray, componentType));
                }
            } else if (isCollection(type)) {
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                        componentType = (Class) actualTypeArguments[0];
                        optJSONArray = jSONObject.optJSONArray(name);
                        if (!isNull(optJSONArray)) {
                            setFiedlValue(obj, method, type.getSimpleName(), parseCollection(optJSONArray, type, componentType));
                        }
                    }
                }
                componentType = null;
                optJSONArray = jSONObject.optJSONArray(name);
                if (!isNull(optJSONArray)) {
                    setFiedlValue(obj, method, type.getSimpleName(), parseCollection(optJSONArray, type, componentType));
                }
            } else if (isSingle(type) || "Date".equals(type.getSimpleName())) {
                Object opt = jSONObject.opt(name);
                if (opt != null) {
                    setFiedlValue(obj, method, type.getSimpleName(), opt);
                }
            } else if (isObject(type)) {
                JSONObject optJSONObject = jSONObject.optJSONObject(name);
                if (!isNull(optJSONObject)) {
                    setFiedlValue(obj, method, type.getSimpleName(), parseObject(optJSONObject, type));
                }
            } else {
                throw new Exception("unknow type!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setField(Object obj, Field field, JSONObject jSONObject) {
        String name = field.getName();
        Class type = field.getType();
        try {
            Class componentType;
            JSONArray optJSONArray;
            if (isArray(type)) {
                componentType = type.getComponentType();
                optJSONArray = jSONObject.optJSONArray(name);
                if (!isNull(optJSONArray)) {
                    field.set(obj, parseArray(optJSONArray, componentType));
                }
            } else if (isCollection(type)) {
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (actualTypeArguments != null && actualTypeArguments.length > 0) {
                        componentType = (Class) actualTypeArguments[0];
                        optJSONArray = jSONObject.optJSONArray(name);
                        if (!isNull(optJSONArray)) {
                            field.set(obj, parseCollection(optJSONArray, type, componentType));
                        }
                    }
                }
                componentType = null;
                optJSONArray = jSONObject.optJSONArray(name);
                if (!isNull(optJSONArray)) {
                    field.set(obj, parseCollection(optJSONArray, type, componentType));
                }
            } else if (isSingle(type)) {
                Object opt = jSONObject.opt(name);
                if (opt != null) {
                    field.set(obj, opt);
                }
            } else if (isObject(type)) {
                r0 = jSONObject.optJSONObject(name);
                if (!isNull(r0)) {
                    field.set(obj, parseObject(r0, type));
                }
            } else if (isList(type)) {
                r0 = jSONObject.optJSONObject(name);
                if (!isNull(r0)) {
                    field.set(obj, parseObject(r0, type));
                }
            } else {
                throw new Exception("unknow type!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isNull(Object obj) {
        if (obj instanceof JSONObject) {
            return JSONObject.NULL.equals(obj);
        }
        return obj == null;
    }

    private static boolean isSingle(Class<?> cls) {
        return isBoolean(cls) || isNumber(cls) || isString(cls);
    }

    public static boolean isBoolean(Class<?> cls) {
        return cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls));
    }

    public static boolean isNumber(Class<?> cls) {
        return cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls));
    }

    public static boolean isString(Class<?> cls) {
        return cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls));
    }

    private static boolean isObject(Class<?> cls) {
        return (cls == null || isSingle(cls) || isArray(cls) || isCollection(cls) || isMap(cls)) ? false : true;
    }

    public static boolean isArray(Class<?> cls) {
        return cls != null && cls.isArray();
    }

    public static boolean isCollection(Class<?> cls) {
        return cls != null && Collection.class.isAssignableFrom(cls);
    }

    public static boolean isMap(Class<?> cls) {
        return cls != null && Map.class.isAssignableFrom(cls);
    }

    public static boolean isList(Class<?> cls) {
        return cls != null && List.class.isAssignableFrom(cls);
    }
}
