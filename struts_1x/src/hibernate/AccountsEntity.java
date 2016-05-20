package hibernate;

import javax.persistence.*;
import java.math.BigDecimal;

@NamedQueries({
    @NamedQuery(
        name = "getClientById_hql",
        query = "from ClientsEntity clients where clients.id=:clientId"
    )
})

@NamedNativeQueries({
    @NamedNativeQuery(
        name = "getClientById_sql",
        query = "select * from clients where clients.id=:clientId",
        resultClass = ClientsEntity.class
    )
})

@Entity
@Table(name = "ACCOUNTS", schema = "PUBLIC", catalog = "H2_DATABASE")
public class AccountsEntity {
    private Long number;
    private BigDecimal rest;
    private ClientsEntity client;

    @Id
    @Column(name = "NUMBER", nullable = false, precision = 0)
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
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

        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (rest != null ? !rest.equals(that.rest) : that.rest != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
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
