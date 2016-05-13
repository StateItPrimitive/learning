package easy;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by sbt-yablokov-mv on 06.05.2016.
 */
@Entity
@Table(name = "ACCOUNTS", schema = "PUBLIC", catalog = "H2_DATABASE")
public class AccountsEntity {
    private Long accountNumber;
    private BigDecimal rest;
    private ClientsEntity client;

    @Id
    @Column(name = "ACCOUNT_NUMBER", nullable = false, precision = 0)
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Basic
    @Column(name = "REST", nullable = false, precision = 2)
    public BigDecimal getRest() {
        return rest;
    }

    public void setRest(BigDecimal rest) {
        this.rest = rest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountsEntity that = (AccountsEntity) o;

        if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null)
            return false;
        if (rest != null ? !rest.equals(that.rest) : that.rest != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountNumber != null ? accountNumber.hashCode() : 0;
        result = 31 * result + (rest != null ? rest.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID_REF", referencedColumnName = "ID", nullable = false)
    public ClientsEntity getClient() {
        return client;
    }

    public void setClient(ClientsEntity client) {
        this.client = client;
    }
}
