package com.humana.odm.utility.sitescope;

public class ApplicationUtility {
	
	
	/**
	 * checkAndSetSiteScope
	 * @param sitescopeMonitoringObj
	 * @return
	 */
	public static boolean checkAndSetSiteScope(SitescopeMonitoring sitescopeMonitoringObj){
			
			boolean flag = false;
			
			if((sitescopeMonitoringObj!=null) && (null!=sitescopeMonitoringObj.getSitescopeMonitoringInput() && 
					"MONITOR".equalsIgnoreCase(sitescopeMonitoringObj.getSitescopeMonitoringInput()))){
							sitescopeMonitoringObj.setSitescopeMonitoringEnabled(true);
							 flag = true;
							
							 
			}
			
			else{
				sitescopeMonitoringObj=null;
			}
			
			
			
			return flag;

				
				
		}
	
	
	/**initiateSitescope
	 * 
	 * @param sitescopeMonitoringObj
	 * @return
	 */
	public static SitescopeMonitoring initiateSitescope(SitescopeMonitoring sitescopeMonitoringObj){
		
	/*	if((sitescopeMonitoringObj!=null) && (null!=sitescopeMonitoringObj.getSitescopeMonitoringInput() && 
				"MONITOR".equalsIgnoreCase(sitescopeMonitoringObj.getSitescopeMonitoringInput()))){
						sitescopeMonitoringObj.setSitescopeMonitoringEnabled(true);
		}
		
		else{
			sitescopeMonitoringObj=null;
		}*/
		sitescopeMonitoringObj=null;
		
		return sitescopeMonitoringObj;
	}
	
	/*public static WatsonProviderRouting initiateWatsonObj(WatsonProviderRouting watsonProviderRouting){
		
			if((sitescopeMonitoringObj!=null) && (null!=sitescopeMonitoringObj.getSitescopeMonitoringInput() && 
					"MONITOR".equalsIgnoreCase(sitescopeMonitoringObj.getSitescopeMonitoringInput()))){
							sitescopeMonitoringObj.setSitescopeMonitoringEnabled(true);
			}
			
			else{
				sitescopeMonitoringObj=null;
			}
		watsonProviderRouting=null;
			
			return watsonProviderRouting;

}*/

}
