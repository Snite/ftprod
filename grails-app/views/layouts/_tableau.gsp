<table>
	<caption>${caption}</caption>
	
	<thead>
		<tr>
			<g:each in="${titles}" var="title">
				<th>${title}</th>
			</g:each>
		</tr>
	</thead>
 	<tbody>
 		<g:if test="${tables}">
		 	<g:each in="${tables}" var="table">
		 		<tr>
		 			<g:each in="${properties}" var="propertie">
		 				<td>
			 				<g:if test="${propertie == 'voir'}">
		 						<g:link controller="table" action="voir" params="${[tableId: table.id, caisseId: caisse.id]}">${propertie}</g:link>
			 				</g:if>
			 				<g:elseif test="${propertie == 'deldit'}">
				 				<g:link controller="table" action="edit" params="${[id: table.id]}">Modifier</g:link> -
								<g:link controller="table" action="confirm" params="${[caisseId: caisse.id, tableId: table.id]}">Supprimer</g:link>
			 				</g:elseif>
			 				<g:else>
			 					${table."$propertie"}
			 				</g:else>
		 				</td>
		 			</g:each>
				</tr>
			</g:each>
		</g:if>
		<g:else>
			<g:each in="${caisses}" var="caisse">
				<tr>
					<td>${caisse}</td>
					<td>
						<g:link controller="caisse" params="${[caisseId: caisse.id]}">Administrateur</g:link> -
						<g:link controller="frontCaisse" params="${[caisseId: caisse.id]}">Serveur</g:link>
					</td>
	 				<td>
		 				<g:link controller="caisse" action="edit" params="${[id: caisse.id]}">Modifier</g:link> -
						<g:link controller="caisse" action="confirm" params="${[caisseId: caisse.id]}">Supprimer</g:link>
	 				</td>
				</tr>
			</g:each>
		</g:else>
	</tbody>
</table>