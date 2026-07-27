package org.example.springbootcondition.condition;

import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class ClassCondition implements Condition {
    /**
     *
     * @param context 上下文对象，获取环境、IOC容器、Classloader对象
     * @param metadata 注解的元对象，用于获取注解定义的属性值
     * @return
     */

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // 需求1：
//        boolean result = true;
//        try {
//            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
//        } catch (ClassNotFoundException e) {
//            result = false;
//            throw new RuntimeException(e);
//        }
//        return result;

        Map<String, Object> map = metadata.getAnnotationAttributes(ConditionOnClass.class.getName());
//        System.out.println(map);

        String[] value = (String[]) map.get("value");
        boolean result = true;
        try {
            for (String key : value) {
                Class<?> cls = Class.forName(key);
            }

        } catch (ClassNotFoundException e) {
            result = false;
        }
        return result;
    }
}
