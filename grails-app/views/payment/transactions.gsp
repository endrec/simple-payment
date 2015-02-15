<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>See transactions</title>
    <meta name="layout" content="main"/>
</head>

<body>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>

    <g:hasErrors bean="${accountInstance}">
        <div class="errors">
            <g:renderErrors bean="${accountInstance}" as="list"/>
        </div>
    </g:hasErrors>
    <div>
        <h2>Pay</h2>
        <br/>
    <g:form action="transactions" >
        <b>Person:</b><g:select name="accountId" from="${hu.czirbesz.payment.Account.list()}" optionKey="id"
                                value="${accountInstance?.id}"/>
        <br/>
        <b><g:submitButton name="transactions" value="List transactions"/></b>
    </g:form>

    <div class="list">
        <g:if test="${accountInstance}">
            <g:if test="${transactionList}">
            <table>
                <thead>
                <tr>
                    <th><g:message code="transaction.sender.label" default="Sender"/></th>
                    <th><g:message code="transaction.receiver.label" default="Receiver"/></th>
                    <g:sortableColumn property="amount" title="${message(code: 'transaction.amount.label', default: 'Amount')}"/>
                    <g:sortableColumn property="dateCreated" title="${message(code: 'transaction.dateCreated.label', default: 'Date Created')}"/>
                </tr>
                </thead>
                <tbody>
                <g:each in="${transactionList}"
                        status="i" var="transactionInstance">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <td>${fieldValue(bean: transactionInstance, field: "sender")}</td>
                        <td>${fieldValue(bean: transactionInstance, field: "receiver")}</td>
                        <td>${fieldValue(bean: transactionInstance, field: "amount")}</td>
                        <td>${fieldValue(bean: transactionInstance, field: "dateCreated")}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
            </g:if>
            <g:else>No transaction to display.</g:else>
        </g:if>
    </div>
</div>
</body>
</html>