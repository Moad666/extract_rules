package com.humana.odm.utility.exception.bo;

import java.util.Map;

import com.humana.odm.utility.StringUtility;
import com.ibm.rules.engine.ruledef.runtime.CustomRuleflowExceptionHandler;
import com.ibm.rules.engine.ruledef.runtime.RuleInstance;
import com.ibm.rules.engine.runtime.EngineData;

import ilog.rules.bom.annotations.NotBusiness;

@NotBusiness
public class ExceptionHandling implements CustomRuleflowExceptionHandler {

	@Override
	public void handleActionException(Exception arg0, RuleInstance ruleInstance)
			throws Exception {
		EngineData data = ruleInstance.getEngineData();
		Map<String, Object> outs = data.getOut();
		if (outs != null) {
			for (Map.Entry<String, Object> entry : outs.entrySet()) {
				if (entry.getValue().getClass().getName().equalsIgnoreCase("com.humana.odm.batch.utility.TechnicalError")) {
					TechnicalError r = (TechnicalError) entry.getValue();
					r.getTechnicalErrorList().add("Exception found in the Action part of the Rule -" + ruleInstance.getRuleName() + " and the exception is:" + arg0.fillInStackTrace());
					//r.getTechnicalErrorList().add("Exception Found at Action: arg0.fillInStackTrace()" + arg0.fillInStackTrace());
					entry.setValue(r);
				}
			}
		}
	}

	@Override
	public void handleConditionException(Exception e) throws Exception {
		Map<String,Object> technicalErrorCache = TechnicalError.technicalErrorCache;
		TechnicalError r = (TechnicalError)technicalErrorCache.get("technicalError");
		r.getTechnicalErrorList().add("Exception found in the Condition part of the rule is -" + e.fillInStackTrace());
				
		}
	
	@Override
	public void handleRuleflowException(final Exception exception) throws Exception {
		Map<String, Object> technicalErrorCache = TechnicalError.technicalErrorCache;
		TechnicalError r = (TechnicalError) technicalErrorCache.get("technicalError");
		if(exception.fillInStackTrace().getMessage().contains(StringUtility.SPECIAL_CHAR_PRESENT_ERROR_MSG)) {

            throw new Exception(StringUtility.SPECIAL_CHAR_PRESENT_ERROR_MSG);
        }
        else {
            r.getTechnicalErrorList().add("Exception found in the RuleFlow part  -" + exception.fillInStackTrace());
        }
	}
}


