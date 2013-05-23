package tch.code.clientcatalog.core.service.data.model;

/**
 *
 * @author tch
 */
public enum ClientType {
   UNKNOWN(0), PRIVATE(1) ,COMPANY(2);
   
   private final int typeId;
   
   ClientType(int typeId) {
       this.typeId = typeId;
   }
   
   public int getTypeId() {
       return this.typeId;
   }
}
