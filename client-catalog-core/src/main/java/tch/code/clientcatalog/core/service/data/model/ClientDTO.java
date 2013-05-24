package tch.code.clientcatalog.core.service.data.model;

/**
 *
 * @author tch
 */
public class ClientDTO {
    private ClientType type = ClientType.UNKNOWN;
    
    private CompanyData companyData = null;
    private PrivatePersonData privatePersonData = null;
    private String description = null;
    private Long clientId;

    /** 
     * initializes companyData and privatePersonData
     **/
    public ClientDTO() {
        companyData = new CompanyData();
        privatePersonData = new PrivatePersonData();
    }
    
    public Long getClientId() {
        return clientId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public CompanyData getCompanyData() {
        return companyData;
    }

    public void setCompanyData(CompanyData companyData) {
        this.companyData = companyData;
    }

    public PrivatePersonData getPrivatePersonData() {
        return privatePersonData;
    }

    public void setPrivatePersonData(PrivatePersonData privatePersonData) {
        this.privatePersonData = privatePersonData;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientDTO other = (ClientDTO) obj;
        if (this.type != other.type) {
            return false;
        }
        if (this.clientId != other.clientId && (this.clientId == null || !this.clientId.equals(other.clientId))) {
            return false;
        }
        if (this.companyData != other.companyData && (this.companyData == null || !this.companyData.equals(other.companyData))) {
            return false;
        }
        if (this.privatePersonData != other.privatePersonData && (this.privatePersonData == null || !this.privatePersonData.equals(other.privatePersonData))) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        hash = 97 * hash + (this.clientId != null ? this.clientId.hashCode() : 0);
        hash = 97 * hash + (this.companyData != null ? this.companyData.hashCode() : 0);
        hash = 97 * hash + (this.privatePersonData != null ? this.privatePersonData.hashCode() : 0);
        hash = 97 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ClientDTO{" + "type=" + type + ", clientId=" + clientId + ", companyData=" + companyData + ", privatePersonData=" + privatePersonData + ", description=" + description + '}';
    }

    
    
    
}
