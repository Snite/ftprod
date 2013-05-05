<g:applyLayout name="front">
	<g:if test="${status && status.size() == 2}">
		<h1>Bienvenue sur votre gestionaire de caisse.</h1>
		<g:if test="${caisses}">
			<g:render template="/layouts/tableau" model="${[
				caption: 'Gestions de vos caisses',
				titles: ['Caisses', 'Management', 'Actions'],]}" />
			<g:link controller="caisse" action="create">Ajouter une caisse</g:link>
		</g:if>
		<g:else>
			<p>
				Aucune caisse n'a été créée pour l'instant,
				<g:link controller="caisse" action="create">
					créez votre première caisse
				</g:link>
			</p>
		</g:else>
		
		<p><g:link controller="metaProduit" action="list">Gérer les produits</g:link></p>
	</g:if>
	<g:else>
		<p>
			Avant de démarrer, merci de créer les status "Libre" et "Occupée" pour la gestion de vos tables <br />
			<g:link controller="status" action="init">Créer les status</g:link>
		</p>
	</g:else>
</g:applyLayout>