/*
 */
package tch.code.clientcatalog.persistence.hibernate.entity.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import tch.code.clientcatalog.core.service.data.model.ClientType;

/**
 *
 * @author tch
 */
@Entity
@Table(name = "client")
@SequenceGenerator(name = "seq_generator",
sequenceName = "client_sequence")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_generator")
    @Column(name = "client_id")
    private Long id;
    @Column(name = "description")
    private String description;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

//    public PrivatePerson getPrivatePerson() {
//        return privatePerson;
//    }
//
//    public void setPrivatePerson(PrivatePerson privatePerson) {
//        this.privatePerson = privatePerson;
//    }
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "client_type ")
    private ClientType type; 
    /**
     * MAPPING TO USE IN FUTURE
    *
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Company company;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
    @JoinColumn(name="client_id")
    private List<PrivatePerson> privatePersons;

    public List<PrivatePerson> getPrivatePersons() {
        if (privatePersons == null) {
            privatePersons = new ArrayList<PrivatePerson>();
        }
        return privatePersons;
    }

    public void setPrivatePersons(List<PrivatePerson> privatePersons) {
        this.privatePersons = privatePersons;
    }
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
