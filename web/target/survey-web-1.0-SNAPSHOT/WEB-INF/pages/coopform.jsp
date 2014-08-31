<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="coopDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='coopDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="coopList.coop"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="coopDetail.heading"/></h2>
    <fmt:message key="coopDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="coop" method="post" action="coopform" cssClass="well"
           id="coopForm" onsubmit="return validateCoop(this)">
<form:hidden path="id"/>
    <spring:bind path="coop.coopCode">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.coopCode" styleClass="control-label"/>
        <form:input cssClass="form-control" path="coopCode" id="coopCode"  maxlength="3"/>
        <form:errors path="coopCode" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.description">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.description" styleClass="control-label"/>
        <form:input cssClass="form-control" path="description" id="description"  maxlength="200"/>
        <form:errors path="description" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.enabled">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.enabled" styleClass="control-label"/>
        <form:checkbox path="enabled" id="enabled" cssClass="checkbox"/>
        <form:errors path="enabled" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.incorporatedDate">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.incorporatedDate" styleClass="control-label"/>
        <form:input cssClass="form-control" path="incorporatedDate" id="incorporatedDate" size="11" title="date" datepicker="true"/>
        <form:errors path="incorporatedDate" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.name" styleClass="control-label"/>
        <form:input cssClass="form-control" path="name" id="name"  maxlength="50"/>
        <form:errors path="name" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.phoneNo">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.phoneNo" styleClass="control-label"/>
        <form:input cssClass="form-control" path="phoneNo" id="phoneNo"  maxlength="12"/>
        <form:errors path="phoneNo" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.phoneNo2">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.phoneNo2" styleClass="control-label"/>
        <form:input cssClass="form-control" path="phoneNo2" id="phoneNo2"  maxlength="12"/>
        <form:errors path="phoneNo2" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.phoneNo3">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.phoneNo3" styleClass="control-label"/>
        <form:input cssClass="form-control" path="phoneNo3" id="phoneNo3"  maxlength="12"/>
        <form:errors path="phoneNo3" cssClass="help-block"/>
    </div>
    <spring:bind path="coop.version">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="coop.version" styleClass="control-label"/>
        <form:input cssClass="form-control" path="version" id="version"  maxlength="255"/>
        <form:errors path="version" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty coop.id}">
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

<v:javascript formName="coop" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/webjars/bootstrap-datepicker/1.2.0/css/datepicker.css'/>" />
<script type="text/javascript" src="<c:url value='/webjars/bootstrap-datepicker/1.2.0/js/bootstrap-datepicker.js'/>"></script>
<c:if test="${pageContext.request.locale.language != 'en'}">
<script type="text/javascript" src="<c:url value='/webjars/bootstrap-datepicker/1.2.0/js/locales/bootstrap-datepicker.${pageContext.request.locale.language}.js'/>"></script>
</c:if>
<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['coopForm']).focus();
        $('.text-right.date').datepicker({format: "<fmt:message key='calendar.format'/>", weekStart: "<fmt:message key='calendar.weekstart'/>", language: '${pageContext.request.locale.language}'});
    });
</script>
