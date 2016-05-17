package hibernate;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sbt-yablokov-mv on 16.05.2016.
 */
@Entity
@Table(name = "CLIENTS", schema = "PUBLIC", catalog = "H2_DATABASE")
public class ClientsEntity {
    private Integer id;
    private String fio;
    private List<AccountsEntity> accounts;

    @Id
    @Column(name = "ID", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIO", nullable = false, length = 100)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientsEntity that = (ClientsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "client")
    public List<AccountsEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountsEntity> accounts) {
        this.accounts = accounts;
    }
}
