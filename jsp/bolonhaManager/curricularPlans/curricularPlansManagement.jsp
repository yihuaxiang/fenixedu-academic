<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib uri="/WEB-INF/jsf_core.tld" prefix="f"%>
<%@ taglib uri="/WEB-INF/jsf_tiles.tld" prefix="ft"%>
<%@ taglib uri="/WEB-INF/html_basic.tld" prefix="h"%>
<%@ taglib uri="/WEB-INF/jsf_fenix_components.tld" prefix="fc"%>

<ft:tilesView definition="bolonhaManager.masterPage" attributeName="body-inline">
	<f:loadBundle basename="resources/BolonhaManagerResources" var="bolonhaBundle"/>
	<f:loadBundle basename="resources/EnumerationResources" var="enumerationBundle"/>
	
	<h:outputText value="<i>#{bolonhaBundle['bolonhaManager']}</i>" escape="false"/>
	<h:outputText value="<h2>#{bolonhaBundle['curricularPlans']}</h2>" escape="false"/>

	<h:outputText value="<i>#{bolonhaBundle['no.degree.access']}</i>" escape="false" rendered="#{empty ScientificCouncilDegreeManagement.filteredBolonhaDegrees}"/>

	<h:panelGroup>
		<h:outputText value="<br/>" escape="false" />
		<h:messages errorClass="error0" infoClass="success0"/>
	
		<fc:dataRepeater value="#{ScientificCouncilDegreeManagement.filteredBolonhaDegrees}" var="degree" rendered="#{!empty ScientificCouncilDegreeManagement.filteredBolonhaDegrees}">
			<h:outputText value="<table style='width: 720px' class='showinfo1 bgcolor1'>" escape="false"/>
			<h:outputText value="<tr><th width='80px'><strong>#{bolonhaBundle['degree']}:</strong></th>" escape="false"/>
	
			<h:outputText value="<td> #{enumerationBundle[degree.bolonhaDegreeType.name]} #{degree.nome} (#{degree.acronym})</td>" escape="false"/>
			<h:outputText value="<td style='width: 110px'>" escape="false"/>
			<h:outputLink value="viewDegree.faces">
				<h:outputFormat value="#{bolonhaBundle['view']}"/>
				<f:param name="degreeId" value="#{degree.idInternal}"/>
			</h:outputLink>
			<h:outputText value="</td></tr>" escape="false"/>

			<h:outputText value="<tr><td colspan='3' align='center'><i>#{bolonhaBundle['no.curricularPlan']}.</i></td></tr>" escape="false" rendered="#{empty degree.degreeCurricularPlans}"/>
	
			<fc:dataRepeater value="#{degree.degreeCurricularPlans}" var="degreeCurricularPlan" rendered="#{!empty degree.degreeCurricularPlans}" rowIndexVar="index">
				<h:outputText value="<tr>" escape="false"/>

				<h:outputText value="<tr>" escape="false"/>
				<h:outputText rendered="#{index == 0}" value="<th><strong>#{bolonhaBundle['plans']}:</strong></th>" escape="false"/>
				<h:outputText rendered="#{index > 0}" value="<th></th>" escape="false"/>
	
				<h:outputText value="<td><em style='color: #777; background-color: #ffa;'>#{enumerationBundle[degreeCurricularPlan.curricularStage.name]}</em> " escape="false" />
				<h:outputText value="#{degreeCurricularPlan.name}</td>" escape="false" />
	
				<h:outputText value="<td>" escape="false"/>
				<h:outputLink value="viewCurricularPlan.faces">
					<h:outputText value="#{bolonhaBundle['view']}" />
					<f:param name="degreeCurricularPlanID" value="#{degreeCurricularPlan.idInternal}"/>
					<f:param name="organizeBy" value="groups"/>
					<f:param name="showRules" value="false"/>
					<f:param name="hideCourses" value="false"/>					
					<f:param name="action" value="view"/>
				</h:outputLink>
				<h:outputText value=" , " escape="false" rendered="#{degreeCurricularPlan.userCanBuild}"/>
				<h:outputLink value="buildCurricularPlan.faces" rendered="#{degreeCurricularPlan.userCanBuild}">
					<h:outputText value="#{bolonhaBundle['manageCurricularPlan']}" />
					<f:param name="degreeCurricularPlanID" value="#{degreeCurricularPlan.idInternal}"/>
					<f:param name="organizeBy" value="groups"/>
					<f:param name="showRules" value="false"/>
					<f:param name="hideCourses" value="false"/>					
					<f:param name="action" value="view"/>				
				</h:outputLink>
				<h:outputText value="</td></tr>" escape="false"/>
			</fc:dataRepeater>
	
			<h:outputText value="</table><br/>" escape="false"/>
		</fc:dataRepeater>

	</h:panelGroup>

</ft:tilesView>
