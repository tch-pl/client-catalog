<form action="" method="POST">
  Name: 
  
  <@spring.formInput path, attributes, fieldType/>
  <input type="text" 
    name="${spring.status.expression}" 
    value="${spring.status.value?default("")}" /><br>
  <#list spring.status.errorMessages as error> <b>${error}</b> <br> </#list>
  <br>
  ... 
  <input type="submit" value="submit"/>
</form>