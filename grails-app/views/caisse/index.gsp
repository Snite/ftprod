<g:applyLayout name="front">
	<g:if test="${caisse.tables}">
		<g:render template="/layouts/tableau" model="${[
			caption: 'Gestions des tables de ' + caisse,
			titles: ['Tables', 'Capacité nominale', 'Actions'],
			properties: ['name', 'nbMax', 'deldit'],
			tables: caisse.tables
		]}" />
		<div><g:link controller="table" action="create">Ajouter une table</g:link></div>
	</g:if>
	<g:else>
		<div>
			Vous n'avez pas encore créé de tables pour cette caisse,
			<g:link controller="table" action="create">
				ajoutez votre première table
			</g:link>
		</div>
	</g:else>
</g:applyLayout>