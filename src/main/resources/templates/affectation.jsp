<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Assign Employee to Project</title>
</head>
<body>
<h2>Assign Employee to Project</h2>
<h:form>
    <h:panelGrid columns="2">
        <!-- Employee Selection -->
        <h:outputLabel for="employeeId" value="Employee Name: " />
        <h:selectOneMenu id="employeeId" value="#{employeeBean.selectedEmployee}" required="true">
            <f:selectItem itemLabel="Select Employee" itemValue="" />
            <f:selectItems value="#{employeeBean.allEmployees}" var="emp" itemValue="#{emp.id}" itemLabel="#{emp.name}" />
        </h:selectOneMenu>

        <!-- Project Selection -->
        <h:outputLabel for="projectId" value="Project Name: " />
        <h:selectOneMenu id="projectId" value="#{employeeBean.selectedProject}" required="true">
            <f:selectItem itemLabel="Select Project" itemValue="" />
            <f:selectItems value="#{employeeBean.allProjects}" var="proj" itemValue="#{proj.id}" itemLabel="#{proj.name}" />
        </h:selectOneMenu>

        <!-- Implication Input -->
        <h:outputLabel for="implication" value="Implication (%): " />
        <h:inputText id="implication" value="#{employeeBean.implication}" required="true" type="number" min="0" max="100" step="5" />
    </h:panelGrid>

    <!-- Submit Button -->
    <h:commandButton value="Assign" action="#{employeeBean.assignEmployeeToProject}" />
</h:form>
</body>
</html>
