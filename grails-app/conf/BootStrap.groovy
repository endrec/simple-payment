import hu.czirbesz.payment.Account

class BootStrap {

    def init = { servletContext ->
        if (!Account.count()) {
            // Names from http://random-name-generator.info/
            new Account(name: "Leonard Weber", email: "Leonard.Weber@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Cassandra Austin", email: "Cassandra.Austin@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Sonya Phillips", email: "Sonya.Phillips@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Anthony Webster", email: "Anthony.Webster@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Ada Palmer", email: "Ada.Palmer@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Jermaine Murray", email: "Jermaine.Murray@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Della Shelton", email: "Della.Shelton@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Erik Sullivan", email: "Erik.Sullivan@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Sidney Frazier", email: "Sidney.Frazier@yopmail.com", balance: 200).save(failonerror: true)
            new Account(name: "Cedric Rice", email: "Cedric.Rice@yopmail.com", balance: 200).save(failonerror: true)
        }
    }
    def destroy = {
    }
}
