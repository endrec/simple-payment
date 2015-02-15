package hu.czirbesz.payment

class Account {
    String name;
    String email;
    BigDecimal balance;

    static constraints = {
        name(blank: false)
        email(blank: false, email: true)
    }

    @Override
    public String toString() {
        return name ;
    }
}
