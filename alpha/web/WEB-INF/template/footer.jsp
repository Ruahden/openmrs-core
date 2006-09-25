		<br/>
		</div>
	</div>

	<div id="footer">
		<div id="footerInner">
		
			<span id="localeOptions">
				<%  //removes last instance of lang= from querystring
					String qs = request.getQueryString();
					if (qs == null)
						qs = "";
					int i = qs.lastIndexOf("&lang=");
					if (i == -1)
						i = qs.length();
					pageContext.setAttribute("qs", qs.substring(0, i));
					pageContext.setAttribute("locales", org.openmrs.util.OpenmrsConstants.OPENMRS_LOCALES());
					pageContext.setAttribute("openmrsVersion", org.openmrs.util.OpenmrsConstants.OPENMRS_VERSION);
					pageContext.setAttribute("databaseVersion", org.openmrs.util.OpenmrsConstants.DATABASE_VERSION);
					pageContext.setAttribute("databaseVersionExpected", org.openmrs.util.OpenmrsConstants.DATABASE_VERSION_EXPECTED);
					pageContext.setAttribute("context", session.getAttribute(org.openmrs.web.WebConstants.OPENMRS_CONTEXT_HTTPSESSION_ATTR));
				%>
		
				<c:forEach items="${locales}" var="loc" varStatus="status">
					<%
						java.util.Locale locTmp = (java.util.Locale) pageContext.getAttribute("loc");
						pageContext.setAttribute("locDisplayName", locTmp.getDisplayName(locTmp));
					%>
					<c:if test="${status.index != 0}">| </c:if>
					<c:if test="${fn:toLowerCase(context.locale) == fn:toLowerCase(loc)}">${locDisplayName}</c:if>
					<c:if test="${fn:toLowerCase(context.locale) != fn:toLowerCase(loc)}"><a href="?${qs}&lang=${loc}">${locDisplayName}</a></c:if> 
				</c:forEach>
			</span>	
	
			<span id="buildDate">Last Build: @TIMESTAMP@</span>
			
			<span id="codeVersion">Version: ${openmrsVersion}</span>
	
			<span id="databaseVersion">Database Version: ${databaseVersion}</span>
			
			<c:if test="${databaseVersionExpected != databaseVersion}">
				<span id="databaseVersionError"><img src="${pageContext.request.contextPath}/images/problem.gif" align="top"> Expected: ${databaseVersionExpected}</span>
			</c:if>
		</div>
	</div>

</body>
</html>