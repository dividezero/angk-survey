<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="coopList.title"/></title>
    <meta name="menu" content="CoopMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="coopList.heading"/></h2>

    <form method="get" action="${ctx}/coops" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-default" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="coopList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/coopform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="coopList" class="table table-condensed table-striped table-hover" requestURI="" id="coopList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="coopform" media="html"
        paramId="id" paramProperty="id" titleKey="coop.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="coop.id"/>
    <display:column property="coopId" sortable="true" titleKey="coop.coopId"/>
    <display:column sortProperty="enabled" sortable="true" titleKey="coop.enabled">
        <input type="checkbox" disabled="disabled" <c:if test="${coopList.enabled}">checked="checked"</c:if>/>
    </display:column>
    <display:column sortProperty="incorporatedDate" sortable="true" titleKey="coop.incorporatedDate">
         <fmt:formatDate value="${coopList.incorporatedDate}" pattern="${datePattern}"/>
    </display:column>
    <display:column property="name" sortable="true" titleKey="coop.name"/>
    <display:column property="phoneNo" sortable="true" titleKey="coop.phoneNo"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="coopList.coop"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="coopList.coops"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="coopList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="coopList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="coopList.title"/>.pdf</display:setProperty>
</display:table>
