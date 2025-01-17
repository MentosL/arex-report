package com.arextest.web.core.repository.mongo.util;

import com.arextest.web.common.LogUtils;
import com.arextest.web.core.repository.RepositoryProvider;
import com.arextest.web.model.dao.mongodb.ModelBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MongoHelper {
    public static Update getUpdate() {
        Update update = new Update();
        update.set(RepositoryProvider.DATA_CHANGE_UPDATE_TIME, System.currentTimeMillis());
        update.setOnInsert(RepositoryProvider.DATA_CHANGE_CREATE_TIME, System.currentTimeMillis());
        return update;
    }

    public static void appendFullProperties(Update update, Object obj) {
        Map<String, Field> allFields = getAllField(obj);
        for (Field field : allFields.values()) {
            try {
                field.setAccessible(true);
                if (field.get(obj) != null) {
                    update.set(field.getName(), field.get(obj));
                }
            } catch (IllegalAccessException e) {
                LogUtils.error(LOGGER,
                        String.format("Class:[%s]. failed to get field %s",
                                obj.getClass().getName(),
                                field.getName()), e);
            }
        }
    }

    // This method is disabled for fields with the same name in parent and child classes
    public static void appendSpecifiedProperties(Update update, Object obj, String... fieldNames) {
        Map<String, Field> allField = getAllField(obj);
        for (String fieldName : fieldNames) {
            try {
                if (allField.containsKey(fieldName)) {
                    Field declaredField = allField.get(fieldName);
                    declaredField.setAccessible(true);
                    Object targetObj = declaredField.get(obj);
                    if (targetObj != null) {
                        update.set(fieldName, targetObj);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    private static Map<String, Field> getAllField(Object bean) {
        Class<?> clazz = bean.getClass();
        Map<String, Field> fieldMap = new HashMap<>();
        while (clazz != null) {
            for (Field field : clazz.getDeclaredFields()) {
                if (!fieldMap.containsKey(field.getName())) {
                    fieldMap.put(field.getName(), field);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return fieldMap;
    }

    public static <T extends ModelBase> T initInsertObject(T obj) {
        obj.setDataChangeCreateTime(System.currentTimeMillis());
        obj.setDataChangeUpdateTime(System.currentTimeMillis());
        return obj;
    }

    public static Update getConfigUpdate() {
        Update update = new Update();
        update.set("dataChangeUpdateTime", System.currentTimeMillis());
        return update;
    }

    public static void assertNull(String msg, Object... obj) {
        for (Object o : obj) {
            if (o == null) {
                throw new RuntimeException(msg);
            }
        }
    }
}
