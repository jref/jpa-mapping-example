package ua.com.codespace.jpa.mapping.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Boss extends Employee {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_Id")
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Boss boss = (Boss) o;

        return account != null ? account.equals(boss.account) : boss.account == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "account=" + account +
                '}';
    }
}
