<g:applyLayout name="front">
	<g:if test="${metaProducts}">
		<h1>Ajouter produit</h1>
		<div>
			<g:each in="${metaProducts}" var="metaProduct">
				<g:remoteLink controller="table"
					action="addProduct"
					params="${[
						metaProductId: metaProduct.id,
						tableId: table.id]}"
					update="facturation">
					${metaProduct} : ${metaProduct.price}€</g:remoteLink>
					(TVA à ${metaProduct.tva}%) <br />
			</g:each>
			<g:remoteLink controller="table"
				action="addDiverProduct"
				params="${[tableId: table.id]}"
				update="addDiverProduct">
				Divers</g:remoteLink>
			<div id="addDiverProduct"></div>
		</div>
		<div id="facturation">
			<g:if test="${factu}">
				<g:render template="/table/facturation" model="${[
					caption: 'Détails de  ' + table,
					titles: ['Item', 'Nombre', 'Montant unitaire', 'total'],
					factu: factu
				]}" />
			</g:if>
			<g:else>
				Aucun produit n'a été ajouté à la table
			</g:else>
		</div>
	</g:if>
	<g:else>
		<div>Aucun produit n'est disponible pour votre caisse.</div>
	</g:else>
</g:applyLayout>