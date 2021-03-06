<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="memberList.title"/></title>
    <meta name="menu" content="MemberMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="memberList.heading"/></h2>

    <form method="get" action="${ctx}/members" id="searchForm" class="form-inline">
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

    <fmt:message key="memberList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/memberform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>

<display:table name="memberList" class="table table-condensed table-striped table-hover" requestURI="" id="memberList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="memberform" media="html"
        paramId="id" paramProperty="id" titleKey="member.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="member.id"/>
    <display:column property="coopId" sortable="true" titleKey="member.coopId"/>
    <display:column property="description" sortable="true" titleKey="member.description"/>
    <display:column sortProperty="enabled" sortable="true" titleKey="member.enabled">
        <input type="checkbox" disabled="disabled" <c:if test="${memberList.enabled}">checked="checked"</c:if>/>
    </display:column>
    <display:column property="name" sortable="true" titleKey="member.name"/>
    <display:column property="phoneNo" sortable="true" titleKey="member.phoneNo"/>
    <display:column property="version" sortable="true" titleKey="member.version"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="memberList.member"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="memberList.members"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="memberList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="memberList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="memberList.title"/>.pdf</display:setProperty>
</display:table>
