<g:applyLayout name="front">
	<g:if test="${caisse.tables}">
		<g:render template="/layouts/tableau" model="${[
			caption: 'Gestions des tables de ' + caisse,
			titles: ['Tables', 'Nombre de couverts', 'Etat', 'Actions'],
			properties: ['name', 'nbCouverts', 'status', 'voir'],
			tables: caisse.tables
		]}" />
	</g:if>
	<g:else>
		<div>
			Aucune table n'est attribuée à cette caisse,
			veuillez passer en mode
			<g:link controller="caisse" params="${[caisseId: caisse.id]}">
				Administrateur
			</g:link>
			afin d'en rajouter une.
		</div>
	</g:else>
</g:applyLayout>