<#include "/common/core_imports.ftl"/>
<@siteContainer>
	<@header/>
	<@body>
<table>
    <tr>        
        <th>ID</th>
        <th>Typ</th>
        <th>Imie</th>
        <th>Nazwisko</th>
        <th>Nazwa</th>
        <th>Opis</th>
    </tr>
   <#if client_list?? && client_list?size &gt; 0>                
    <#list client_list as val>
    <tr>
        <td>${val.clientId}</td>        		
        <td>${val.type!"-"}</td>
        <td>${val.companyData.companyName!"-"}</td>
        <td>${val.privatePersonData.firstName!"-"}</td>
        <td>${val.privatePersonData.lastName!"-"}</td>
        <td>${val.description!"-"}</td>
    </tr>
    </#list>
    </#if>
    
</table>


        <@footer/>
	</@body>
</@siteContainer>