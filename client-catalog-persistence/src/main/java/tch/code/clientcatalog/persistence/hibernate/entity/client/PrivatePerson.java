/*
 */
package tch.code.clientcatalog.persistence.hibernate.entity.client;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * entity for type private person
 *
 * @author tch
 */
@Entity
@Table(name = "client_private_person")
public class PrivatePerson implements Serializable {
//    @OneToMany(mappedBy = "membersOfBoard")
//    private List<Company> companys;

    @SuppressWarnings("unchecked")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name="client_id")
    private Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}