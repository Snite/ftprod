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
 		<g:each in="${factu}" var="entry">
 			<g:if test="${entry.key != 'prices'}">
	 			<tr>
	 				<td>${entry.key}</td>
	 				<td>${entry.key.price}</td>
	 				<td>${entry.value.nb}</td>
	 				<td>${entry.value.price}</td>
	 			</tr>
 			</g:if>
 		</g:each>
	</tbody>
</table>
<g:if test="${factu}">
	<g:set var="prices" value="${factu.prices}"/>
	<g:set var="totalTTC" value="${prices.total + prices.tva5 + prices.tva19}"/>
	<div>
		<b>Total HT &nbsp;:</b> ${prices.total} <br />
		<b>TVA 5.5% &nbsp;:</b> ${prices?.tva5?.round(2)} <br />
		<b>TVA 19.6%&nbsp;:</b> ${prices?.tva19?.round(2)} <br />
		<i><b>Total TTC&nbsp;: ${totalTTC.round(2)}</b></i>
	</div>
</g:if>