<#include "/common/core_imports.ftl"/>
<#include "/common/client_list_macro.ftl"/>
<@siteContainer>
<@header/>
    <@body>
<div id="content">
<table class="client_list">
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
<h4>
    <#list 1..page_count as i>        
        <a href="#" class="${i}" id="page_${i}">${i}</a>
    </#list>
    Current page is: ${current_index}
</h4>
</div>


        <@footer/>
	</@body>
</@siteContainer>