/*
 */
package tch.code.clientcatalog.persistence.hibernate.entity.client;

import java.io.Serializable;
import javax.persistence.*;

/**
 * entity for type private person
 *
 * @author tch
 */
@Entity
@Table(name = "client_private_person")
@SequenceGenerator(name = "seq_generator", 
                      sequenceName = "client_sequence")
public class PrivatePerson implements Serializable {
    @SuppressWarnings("unchecked")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="seq_generator")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    
    @JoinColumn(name="client_id")
    @ManyToOne
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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