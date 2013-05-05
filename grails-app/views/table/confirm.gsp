<div>
	Êtes-vous sûr de vouloir supprimer ${table} ?
	<g:link controller="table" action="delete" params="${[id: table.id]}">Oui</g:link> -
	<g:link controller="caisse" params="${[caisseId: caisse.id, tableId: table.id]}">Annuler</g:link>
</div>