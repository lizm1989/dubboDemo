package com.dubbo.error;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * @author sunxueqiang
 *
 */
public abstract class GaosiAssert {

	/**
	 * 断言表达式是true
	 * @throws GaosiException
	 */
	public static void isTrue(boolean expression, String message) throws GaosiException {
		if (!expression) {
			throw new GaosiException(message);
		}
	}

	/**
	 * 断言对象是null
	 * @throws GaosiException 
	 */
	public static void isNull(Object object, String message) throws GaosiException {
		if (object != null) {
			throw new GaosiException(message);
		}
	}

	/**
	 * 断言对象不是null
	 * @throws GaosiException 
	 */
	public static void notNull(Object object, String message) throws GaosiException {
		if (object == null) {
			throw new GaosiException(message);
		}
	}

	/**
	 * 断言字符串不是空的
	 */
	public static void hasLength(String text, String message) throws GaosiException {
		if (!StringUtils.hasLength(text)) {
			throw new GaosiException(message);
		}
	}


	/**
	 * 字符串有内容
	 * @throws GaosiException 
	 */
	public static void hasText(String text, String message) throws GaosiException {
		if (!StringUtils.hasText(text)) {
			throw new GaosiException(message);
		}
	}

	/**
	 * textToSearch 不包含 substring
	 * @param textToSearch 被查找的内容
	 * @param substring 要查找的内容
	 * @param message 错误显示信息
	 * @throws GaosiException 
	 */
	public static void doesNotContain(String textToSearch, String substring, String message) throws GaosiException {
		if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring) &&
				textToSearch.contains(substring)) {
			throw new GaosiException(message);
		}
	}

	/**
	 * 数组不空
	 */
	public static void notEmpty(Object[] array, String message) throws GaosiException {
		if (ObjectUtils.isEmpty(array)) {
			throw new GaosiException(message);
		}
	}

	/**
	 * 数组没有空对象
	 * @param array the array to check
	 * @param message the exception message to use if the assertion fails
	 * @throws GaosiException if the object array contains a {@code null} element
	 */
	public static void noNullElements(Object[] array, String message) throws GaosiException {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw new GaosiException(message);
				}
			}
		}
	}

	/**
	 * 集合不空
	 * @param collection the collection to check
	 * @param message the exception message to use if the assertion fails
	 * @throws GaosiException if the collection is {@code null} or has no elements
	 */
	public static void notEmpty(Collection<?> collection, String message) throws GaosiException {
		if (CollectionUtils.isEmpty(collection)) {
			throw new GaosiException(message);
		}
	}


	/**
	 * Map不为空
	 * @param map the map to check
	 * @param message the exception message to use if the assertion fails
	 * @throws GaosiException if the map is {@code null} or has no entries
	 */
	@SuppressWarnings("rawtypes")
    public static void notEmpty(Map map, String message) throws GaosiException {
		if (CollectionUtils.isEmpty(map)) {
			throw new GaosiException(message);
		}
	}


	/**
	 * 判断实例类型
	 * @throws GaosiException if the object is not an instance of clazz
	 * @see Class#isInstance
	 */
	public static void isInstanceOf(Class<?> type, Object obj, String message) throws GaosiException {
		notNull(type, "Type to check against must not be null");
		if (!type.isInstance(obj)) {
			throw new GaosiException(
					(StringUtils.hasLength(message) ? message + " " : "") +
					"Object of class [" + (obj != null ? obj.getClass().getName() : "null") +
					"] must be an instance of " + type);
		}
	}

	/**
	 * 判断一个类superType和另一个类subType是否相同或是另一个类的超类或接口
	 * @throws GaosiException if the classes are not assignable
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType, String message) throws GaosiException {
		notNull(superType, "Type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw new GaosiException(message + subType + " is not assignable to " + superType);
		}
	}

}
