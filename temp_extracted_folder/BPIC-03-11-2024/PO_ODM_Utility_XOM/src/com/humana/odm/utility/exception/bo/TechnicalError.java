package com.humana.odm.utility.exception.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author
 *
 */
public class TechnicalError {
	List<String> technicalErrorList = new ArrayList<String>();
	public static final Map<String, Object> technicalErrorCache = new ConcurrentHashMap<String, Object>();

	/**
	 * @return the technicalErrorList
	 */
	public List<String> getTechnicalErrorList() {
		return technicalErrorList;
	}

	/**
	 * @param technicalErrorList
	 *            the technicalErrorList to set
	 */
	public void setTechnicalErrorList(List<String> technicalErrorList) {
		this.technicalErrorList = technicalErrorList;
	}

	public TechnicalError() {
		super();
		technicalErrorCache.put("technicalError", this);
	}

}