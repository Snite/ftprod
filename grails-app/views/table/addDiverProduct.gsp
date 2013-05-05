<g:form controller="table" action="doAddDiverProduct">
	<g:hiddenField name="tableId" value="${table.id}" />
	<label for="name">Nom *: </label>
	<g:field type="text" name="name" value="${command?.name ?: ''}" /> <br />
	<label for="name">Prix *: </label>
	<g:field type="text" name="price" value="${command?.price ?: ''}" /> <br />
	<label for="name">Tva *: </label>
	<g:select name="tva" from="${['5.5', '19.6']}" /> <br />
	<input type="submit" value="Ajouter un produit divers" />
</g:form>