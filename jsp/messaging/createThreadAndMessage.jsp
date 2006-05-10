<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/fenix-renderers.tld" prefix="fr"%> 

<html:errors/>

<logic:present name="forum">
	
	<h2><bean:message key="label.createThreadAndMessage.title"/></h2>
	
	<fr:view name="forum" layout="tabular" schema="forum.view-with-topics-and-message-count">
		<fr:layout name="tabular">
	        <fr:property name="classes" value="style1"/>
	        <fr:property name="columnClasses" value="listClasses,"/>
		</fr:layout>
	</fr:view>
	
	<bean:define id="forumId" name="forum" property="idInternal"/>
	
	<fr:create type="net.sourceforge.fenixedu.domain.messaging.ConversationMessage" layout="tabular"
           schema="conversationThreadAndMessage.create"
           action="<%="/forunsManagement.do?method=viewForum&forumId="+forumId %>">
           <fr:hidden slot="creator" name="person"/>
           <fr:hidden slot="conversationThread.creator" name="person"/>
           <fr:hidden slot="conversationThread.forum" name="forum"/>
           <fr:destination name="cancel" path="<%="/forunsManagement.do?method=viewForum&forumId="+forumId%>"/>
	</fr:create>


</logic:present>