package org.openmrs.web.taglib;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.web.WebConstants;

public class GlobalPropertyTag extends TagSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Log log = LogFactory.getLog(getClass());
	
	private String key="";
	private String defaultValue="";
	private String var=null;
	
	public int doStartTag() {

		HttpSession httpSession = pageContext.getSession();
		Context context = (Context)httpSession.getAttribute(WebConstants.OPENMRS_CONTEXT_HTTPSESSION_ATTR);
		String value = defaultValue;
		// If user is logged in
		if ( context != null && context.isAuthenticated()) { 
			value = (String) context.getAdministrationService().getGlobalProperty(key);
		}
		
		try {
			if (var != null)
				pageContext.setAttribute(var, value);
			else
				pageContext.getOut().write(value);

		} catch (Exception e) { 
			log.error("error getting global property", e);
		}
		return SKIP_BODY;
	}

	
	public String getKey() { 
		return this.key;
	}
	
	public void setKey(String key) { 
		this.key = key;
	}
	
	public String getDefaultValue() { 
		return this.defaultValue;
	}
	
	public void setDefaultValue(String defaultValue) { 
		this.defaultValue = defaultValue;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}
	
}
