<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Pay Some Person</title>
    <meta name="layout" content="main"/>
</head>

<body>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>

<g:hasErrors bean="${transactionInstance}">
    <div class="errors">
        <g:renderErrors bean="${transactionInstance}" as="list"/>
    </div>
</g:hasErrors>
<div>
    <h2>Pay</h2>
    <br/>
    <g:form action="pay">
        <b>From:</b><g:select name="sender.id" from="${hu.czirbesz.payment.Account.list()}" optionKey="id" value="${transactionInstance?.sender?.id}"/>
        <br/>
        <b>To:</b><g:select name="receiver.id" from="${hu.czirbesz.payment.Account.list()}" optionKey="id" value="${transactionInstance?.receiver?.id}"/>
        <br/>
        <b>Amount:</b><g:textField name="amount" value="${fieldValue(bean: transactionInstance, field: 'amount')}"/>
        <b><g:submitButton name="pay" value="Pay"/></b>
    </g:form>
</div>
</body>
</html>