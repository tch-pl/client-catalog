/*
 */
package tch.code.clientcatalog.core.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tch.code.clientcatalog.core.service.data.model.ClientDTOBuilder;
import tch.code.clientcatalog.core.service.data.model.ClientType;

/**
 *
 * @author tch
 */
public class ClientServiceTest {
    
    @Test
    public void builderTest() {            
        Assert.assertEquals(ClientDTOBuilder.companyTypeClient().getType(), ClientType.COMPANY);
        Assert.assertEquals(ClientDTOBuilder.privateTypeClient().getType(), ClientType.PRIVATE);
        Assert.assertEquals(ClientDTOBuilder.rawTypeClient().getType(), ClientType.UNKNOWN);
    }
    
}
