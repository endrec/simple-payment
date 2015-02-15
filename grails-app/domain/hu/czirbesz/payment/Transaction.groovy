package hu.czirbesz.payment

import org.joda.time.DateTime

class Transaction {
    DateTime dateCreated
    Account sender
    Account receiver
    BigDecimal amount

    static constraints = {
        sender nullable: false, validator: { val, obj -> val != obj.receiver }
        receiver nullable: false, validator: { val, obj -> val != obj.sender }
        amount min: 0.01, validator: { val, obj -> val <= obj.sender.balance ?: ["transaction.low.sender.balance", obj.sender.balance] }
    }
}
