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
@SequenceGenerator(name = "seq_generator", 
                      sequenceName = "client_sequence")
public class Company implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="seq_generator")
    private Long id;
    
    @Column(name = "company_name")
    private String companyName;
        
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id", referencedColumnName="client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClientId(Client clientId) {
        this.client = client;
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
