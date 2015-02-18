package hu.czirbesz

import hu.czirbesz.payment.Account
import hu.czirbesz.payment.Transaction

class PaymentController {

    def paymentService

    def index = {
        redirect(action: "transactions", params: params)
    }

    def transactions = {
        if (params?.accountId) {
            def accountInstance = Account.get(params.accountId)
            if (!accountInstance) {
                flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'account.label', default: 'Account'), params.accountId])}"
                redirect(action: "list")
            }
            else {
                [accountInstance: accountInstance, transactionList: Transaction.findAllByReceiverOrSender(accountInstance, accountInstance)]
            }

        }
    }

    def pay = {
        if (params.pay == "Pay") {
            def transactionInstance = new Transaction(params)
            if (paymentService.commitPayment(transactionInstance)) {
                flash.message = "${message(code: 'default.created.message', args: [message(code: 'transaction.label', default: 'Transaction'), transactionInstance.id])}"
                redirect(action: "transactions", params: [accountId: transactionInstance.sender.id])
            }
            else {
                render(view: "pay", model: [transactionInstance: transactionInstance])
            }
        }
        else {
            render(view: "pay")
        }
    }

}
