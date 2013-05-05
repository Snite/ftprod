1 - Créer une BDD 'ftprod' grace au script suivant :

*******************************
drop database if exists ftprod;

create database ftprod;

grant all on ftprod.* to ftprod@localhost identified by 'ftprod';

flush privileges;

*******************************

2 - Lors du premier lancement de l'application, cliquer sur "Creer les status"
3 - Créez votre première caisse
4 - Cliquez sur "Gerer les produits" pour en rajouter
5 - Retourner sur la page d'accueil en cliquant sur "Home" (A faire à chaque fois que vous créez un objet sur le BO de Grails)
6 - Ajoutez-y une table
7 - Le menu en haut permet de switcher d'une vue à l'autre
8 - Gestion des objets en BO :
 * Status : http://localhost:8080/ftprod/status/list
 * Caisse : http://localhost:8080/ftprod/caisse/list
 * Table : http://localhost:8080/ftprod/table/list
 * MetaProduit : http://localhost:8080/ftprod/metaProduit/list
 * Produit : http://localhost:8080/ftprod/produit/list

9 - Piste d'amélioration :
 * Gestion des messages d'erreurs
 * Bo personnalisé
 * Internationalisation (i18n)
 * Sécurisation des controller
 * SpringSecurity afin de gérer le groupe d'administrateur (là, tout le monde peut faire tout et n'importe quoi)
 * Lors de l'ajout d'un produit, séléctionner un supplément et le distinguer sur la facture

10 - Problème avec les Double inList d'où l'utilisation d'un String pour TVA : http://www.developpez.net/forums/d983606/java/developpement-web-java/frameworks/autres/grails/separateur-decimal-sous-grails-resolu/

11 - Point d'intérets :
 * Url rewriting
 * Ajax
 * Gestion d'un formulaire avec command
 * templatisation (_tableau.gsp et _facturation.gsp)
 * etc.