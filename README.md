# Projet XML : Service REST

Cette application web a été crée à partir du Framework Spring et avec Maven

## Éxécuter le projet sur le serveur distant
Le serveur de l'application étant hébergé sur Clever CLoud depuis un répertoire GitHub, il suffit donc de démarrer 
l'application depuis le hub de Clever Cloud pour démarrer le projet. 
Attention : le projet peut démarrer automatiquement en effectuant un push du répertoire GitHub.
La base de données de l'application est elle aussi hébergée sur Clever CLoud, via un addon PostgreSQL.

## Éxécuter le projet sur un serveur local

Avant de lancer l'application, vous devez d'abord configurer votre environnement de développement en suivant ces étapes :

1. Assurez-vous d'avoir Maven installé sur votre machine. Si ce n'est pas le cas, vous pouvez le télécharger et l'installer à partir du site officiel de Maven : https://maven.apache.org/download.cgi

2. Ouvrez un terminal ou une invite de commande et naviguez jusqu'au répertoire racine de votre projet.

3. Exécutez la commande suivante pour configurer le projet et télécharger toutes les dépendances nécessaires :
    ```
    mvn install
    ```
## Exécution du Projet

Une fois que la configuration est terminée, vous pouvez lancer l'application en utilisant la commandes suivante :

    ```
    mvn spring-boot:run
    ```