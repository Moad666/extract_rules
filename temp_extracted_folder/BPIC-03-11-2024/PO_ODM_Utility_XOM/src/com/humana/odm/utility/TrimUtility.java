/**
 * 
 */
package com.humana.odm.utility;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author RXB4571
 *
 */
public final class TrimUtility {
	
	
	
	

//	private static final String SET = "set";




	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object trimReflective(Object object) throws Exception {
		
		String set = "set";
		if (object == null)
			return null;

		Class<? extends Object> c = object.getClass();
		String name = null;
		String property = null;
		Method method = null;
		Method setter = null;
		Object[] objectArray = null;
		String[] propertyArray = null;
		String[] modifiedArray = null;
		String element = null;
		Object objectProperty = null;

		try {
			// Introspector usage to pick the getters conveniently thereby
			// excluding the Object getters
			for (PropertyDescriptor propertyDescriptor : Introspector
					.getBeanInfo(c, Object.class).getPropertyDescriptors()) {
				method = propertyDescriptor.getReadMethod();

				if (null != method) {
					//
					name = method.getName();

					if (method.getReturnType().equals(String.class)) {
						property = (String) method.invoke(object);
						if (property != null) {
							setter = c.getMethod(set + name.substring(3),
									new Class<?>[] { String.class });
							if (setter != null)

								setter.invoke(object, property.trim());
						}
					}

					if (method.getReturnType().isArray()
							&& !method.getReturnType().isPrimitive()
							&& !method.getReturnType().equals(String[].class)
							&& !method.getReturnType().equals(byte[].class)) {
						// System.out.println(aMethod.getReturnType());

						if (method.invoke(object) instanceof Object[]) {
							objectArray = (Object[]) method.invoke(object);
							if (objectArray != null) {
								for (Object obj : (Object[]) objectArray) {
									trimReflective(obj);
								}
							}
						}
					}

					if (method.getReturnType().equals(String[].class)) {
						propertyArray = (String[]) method.invoke(object);
						if (propertyArray != null) {
							setter = c.getMethod(set + name.substring(3),
									new Class<?>[] { String[].class });
							if (setter != null) {
								modifiedArray = new String[propertyArray.length];
								for (int i = 0; i < propertyArray.length; i++)
									if (propertyArray[i] != null)
										modifiedArray[i] = propertyArray[i]
												.trim();

								setter.invoke(object,
										new Object[] { modifiedArray });
							}
						}
					}

					if (Collection.class.isAssignableFrom(method
							.getReturnType())) {
						Collection collectionProperty = (Collection) method
								.invoke(object);
						if (collectionProperty != null) {
							for (int index = 0; index < collectionProperty
									.size(); index++) {
								if (collectionProperty.toArray()[index] instanceof String) {
									element = (String) collectionProperty
											.toArray()[index];

									if (element != null) {

										if (collectionProperty instanceof List) {
											((List) collectionProperty).set(
													index, element.trim());
										} else {
											collectionProperty.remove(element);
											collectionProperty.add(element
													.trim());
										}
									}
								} else {

									trimReflective(collectionProperty.toArray()[index]);
								}
							}
						}
					}

					if (method.getReturnType().equals(Map.class)) {
						Map mapProperty = (Map) method.invoke(object);
						if (mapProperty != null) {

							for (int index = 0; index < mapProperty.keySet()
									.size(); index++) {
								if (mapProperty.keySet().toArray()[index] instanceof String) {
									element = (String) mapProperty.keySet()
											.toArray()[index];
									if (element != null) {
										mapProperty.put(element.trim(),
												mapProperty.get(element));
										mapProperty.remove(element);
									}
								} else {

									trimReflective(mapProperty.get(index));
								}

							}

							for (Map.Entry entry : (Set<Map.Entry>) mapProperty
									.entrySet()) {

								if (entry.getValue() instanceof String) {
									element = (String) entry.getValue();
									if (element != null) {
										entry.setValue(element.trim());
									}
								} else {

									trimReflective(entry.getValue());
								}
							}
						}
					} else {
						objectProperty = (Object) method.invoke(object);
						if (property != null) {
							trimReflective(property);
						}
					}
				}
			}

		} catch (Exception e) {
			throw new Exception("Strings cannot be trimmed because: ", e);
		}
		
		
		// nullify all the strings
			set=null;
			name = null;
			property = null;
			method = null;
			setter = null;
			objectArray = null;
			propertyArray = null;
			modifiedArray = null;
			element = null;
			objectProperty = null;
			

		
		return object;
	}

}
