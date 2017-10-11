package com.dubbo.error;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * gaosiAssert
 *
 * @author sunxueqiang
 */
public final class GaosiAssert {

    private GaosiAssert() {
    }

    /**
     * 断言表达式是true
     *
     * @param expression 表达式
     * @param errorCode  错误编码
     * @param message    异常信息
     * @throws GaosiException 如果不满足表达式会抛出gaosiexception
     */
    public static void isTrue(boolean expression, ErrorCode errorCode, String message) throws GaosiException {
        if (!expression) {
            throw new GaosiException(errorCode, message);
        }
    }

    /**
     * 断言对象是null
     *
     * @param object    要判断的对象
     * @param errorCode 错误编码
     * @param message   异常信息
     * @throws GaosiException 如果不为空会抛出gaosiexception
     */
    public static void isNull(Object object, ErrorCode errorCode, String message) throws GaosiException {
        if (object != null) {
            throw new GaosiException(errorCode, message);
        }
    }

    /**
     * 断言对象不是null
     *
     * @param object    要判断的对象
     * @param errorCode 错误编码
     * @param message   异常信息
     * @throws GaosiException 如果为空会抛出该异常
     */
    public static void notNull(Object object, ErrorCode errorCode, String message) {
        if (object == null) {
            throw new GaosiException(errorCode, message);
        }
    }

    /**
     * 断言字符串不是空的
     *
     * @param text      要判断的文本
     * @param errorCode 错误编码
     * @param message   异常信息
     * @throws GaosiException 如果字符串为空抛出该异常
     */
    public static void hasLength(String text, ErrorCode errorCode, String message) throws GaosiException {
        if (!StringUtils.hasLength(text)) {
            throw new GaosiException(errorCode, message);
        }
    }


    /**
     * 字符串有内容
     *
     * @param text      要判断的文本
     * @param errorCode 错误编码
     * @param message   异常信息
     * @throws GaosiException 如果字符串没内容抛出该异常
     */
    public static void hasText(String text, ErrorCode errorCode, String message) throws GaosiException {
        if (!StringUtils.hasText(text)) {
            throw new GaosiException(errorCode, message);
        }
    }

    /**
     * textToSearch 不包含 substring
     *
     * @param textToSearch 被查找的内容
     * @param substring    要查找的内容
     * @param errorCode    错误编码
     * @param message      错误显示信息
     * @throws GaosiException 如果字符串中包含该字符串则抛出该异常
     */
    public static void doesNotContain(String textToSearch, String substring, ErrorCode errorCode, String message)
            throws GaosiException {
        if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring)
                && textToSearch.contains(substring)) {
            throw new GaosiException(errorCode, message);
        }
    }

    /**
     * 数组不空
     *
     * @param array     数组
     * @param message   异常信息
     * @param errorCode 错误编码
     * @throws GaosiException 如果数组为空抛出该异常
     */
    public static void notEmpty(Object[] array, ErrorCode errorCode, String message) throws GaosiException {
        if (ObjectUtils.isEmpty(array)) {
            throw new GaosiException(errorCode, message);
        }
    }

    /**
     * 数组没有空对象
     *
     * @param array     the array to check
     * @param errorCode 错误编码
     * @param message   the exception message to use if the assertion fails
     * @throws GaosiException if the object array contains a {@code null} element
     */
    public static void noNullElements(Object[] array, ErrorCode errorCode, String message) throws GaosiException {
        if (array != null) {
            for (Object element : array) {
                if (element == null) {
                    throw new GaosiException(errorCode, message);
                }
            }
        }
    }

    /**
     * 集合不空
     *
     * @param collection the collection to check
     * @param errorCode  错误编码
     * @param message    the exception message to use if the assertion fails
     * @throws GaosiException if the collection is {@code null} or has no elements
     */
    public static void notEmpty(Collection<?> collection, ErrorCode errorCode, String message) throws GaosiException {
        if (CollectionUtils.isEmpty(collection)) {
            throw new GaosiException(errorCode, message);
        }
    }


    /**
     * Map不为空
     *
     * @param map       the map to check
     * @param errorCode 错误编码
     * @param message   the exception message to use if the assertion fails
     * @throws GaosiException if the map is {@code null} or has no entries
     */
    @SuppressWarnings("rawtypes")
    public static void notEmpty(Map map, ErrorCode errorCode, String message) throws GaosiException {
        if (CollectionUtils.isEmpty(map)) {
            throw new GaosiException(errorCode, message);
        }
    }


    /**
     * 判断实例类型
     *
     * @param type      类型
     * @param obj       对象
     * @param errorCode 错误编码
     * @param message   消息
     * @throws GaosiException if the object is not an instance of clazz
     * @see Class#isInstance
     */
    public static void isInstanceOf(Class<?> type, Object obj, ErrorCode errorCode, String message) throws GaosiException {
        notNull(type, errorCode, "Type to check against must not be null");
        if (!type.isInstance(obj)) {
            throw new GaosiException(errorCode,
                    (StringUtils.hasLength(message) ? message + " " : "")
                            + "Object of class [" + (obj != null ? obj.getClass().getName() : "null")
                            + "] must be an instance of " + type);
        }
    }

    /**
     * 判断一个类superType和另一个类subType是否相同或是另一个类的超类或接口
     *
     * @param superType 父类类型
     * @param subType   另一个类型
     * @param errorCode 错误编码
     * @param message   信息
     * @throws GaosiException if the classes are not assignable
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, ErrorCode errorCode, String message) throws GaosiException {
        notNull(superType, errorCode, "Type to check against must not be null");
        if (subType == null || !superType.isAssignableFrom(subType)) {
            throw new GaosiException(errorCode, message + subType + " is not assignable to " + superType);
        }
    }

}
