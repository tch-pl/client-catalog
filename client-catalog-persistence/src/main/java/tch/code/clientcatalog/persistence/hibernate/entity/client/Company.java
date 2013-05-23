package tch.code.clientcatalog.persistence.hibernate.entity.client;

import java.io.Serializable;
import javax.persistence.*;

/**
 * represents
 *
 * @author tch
 */
@Entity
@Table(name = "client_company")
public class Company implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "company_name")
    private String companyName;
        
    @Column(name="client_id")
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
