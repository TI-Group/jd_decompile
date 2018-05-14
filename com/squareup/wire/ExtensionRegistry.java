package com.squareup.wire;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: TbsSdkJava */
final class ExtensionRegistry {
    private final Map<Class<? extends ExtendableMessage>, Map<String, Extension<?, ?>>> extensionsByName = new LinkedHashMap();
    private final Map<Class<? extends ExtendableMessage>, Map<Integer, Extension<?, ?>>> extensionsByTag = new LinkedHashMap();

    ExtensionRegistry() {
    }

    public <T extends ExtendableMessage<?>, E> void add(Extension<T, E> extension) {
        Class extendedType = extension.getExtendedType();
        Map map = (Map) this.extensionsByTag.get(extendedType);
        Map map2 = (Map) this.extensionsByName.get(extendedType);
        if (map == null) {
            map = new LinkedHashMap();
            map2 = new LinkedHashMap();
            this.extensionsByTag.put(extendedType, map);
            this.extensionsByName.put(extendedType, map2);
        }
        map.put(Integer.valueOf(extension.getTag()), extension);
        map2.put(extension.getName(), extension);
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, int i) {
        Map map = (Map) this.extensionsByTag.get(cls);
        return map == null ? null : (Extension) map.get(Integer.valueOf(i));
    }

    public <T extends ExtendableMessage<?>, E> Extension<T, E> getExtension(Class<T> cls, String str) {
        Map map = (Map) this.extensionsByName.get(cls);
        return map == null ? null : (Extension) map.get(str);
    }
}
