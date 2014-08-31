<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="memberDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='memberDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="memberList.member"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="memberDetail.heading"/></h2>
    <fmt:message key="memberDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="member" method="post" action="memberform" cssClass="well"
           id="memberForm" onsubmit="return validateMember(this)">
<form:hidden path="id"/>
    <spring:bind path="member.coopId">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="member.coopId" styleClass="control-label"/>
        <form:input cssClass="form-control" path="coopId" id="coopId"  maxlength="3"/>
        <form:errors path="coopId" cssClass="help-block"/>
    </div>
    <spring:bind path="member.description">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="member.description" styleClass="control-label"/>
        <form:input cssClass="form-control" path="description" id="description"  maxlength="200"/>
        <form:errors path="description" cssClass="help-block"/>
    </div>
    <spring:bind path="member.enabled">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="member.enabled" styleClass="control-label"/>
        <form:checkbox path="enabled" id="enabled" cssClass="checkbox"/>
        <form:errors path="enabled" cssClass="help-block"/>
    </div>
    <spring:bind path="member.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="member.name" styleClass="control-label"/>
        <form:input cssClass="form-control" path="name" id="name"  maxlength="50"/>
        <form:errors path="name" cssClass="help-block"/>
    </div>
    <spring:bind path="member.phoneNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="member.phoneNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="phoneNo" id="phoneNo"  maxlength="12"/>
        <form:errors path="phoneNo" cssClass="help-block"/>
    </div>
    <spring:bind path="member.version">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="member.version" styleClass="control-label"/>
        <form:input cssClass="form-control" path="version" id="version"  maxlength="255"/>
        <form:errors path="version" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty member.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="member" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['memberForm']).focus();
    });
</script>
