<!DOCTYPE html>

	<head>
		<r:require module="core"/>
		<r:layoutResources/>
	</head>

<!--[if IE 8]>    <body class="ie ie8"><![endif]-->
<!--[if IE 7]>    <body class="ie ie7"><![endif]-->
<!--[if IE 6]>    <body class="ie ie6"><![endif]-->
<!--[if !IE]>-->  <body>               <!--<![endif]-->
	<g:if test="${params.controller != 'pizzeria'}">
		<div>
			<ul>
				<g:each in="[
					'Accueil':'pizzeria',
					'Administrateur':'caisse',
					'Serveur':'frontCaisse']" var="menuElem">
					<li><g:link controller="${menuElem.value}" params="${[caisseId: caisse.id]}">${menuElem.key}</g:link></li>
				</g:each>
			</ul>
		</div>
	</g:if>	
	<g:layoutBody />
	<r:layoutResources/>
</body>
</html>
