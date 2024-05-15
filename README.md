# Projet XML : Service REST

Cette application web a été crée à partir du Framework Spring et avec Maven

## Éxécuter le projet sur le serveur distant
Le serveur de l'application étant hébergé sur Clever CLoud depuis un répertoire GitHub, il suffit donc de démarrer 
l'application depuis le hub de Clever Cloud pour démarrer le projet. 
Attention : le projet peut démarrer automatiquement en effectuant un push du répertoire GitHub.
La base de données de l'application est elle aussi hébergée sur Clever CLoud, via un addon PostgreSQL.  
L'URL de l'application est : https://cv24v1.cleverapps.io/

## Éxécuter le projet sur un serveur local
Deux solutions sont proposés pour faire tourner l'application en local :
1. En utilisant la base de données Clever CLoud :  il est nécessaire avant tout d'avoir installé Maven sur votre machine.  
(Lien d'installation : https://maven.apache.org/download.cgi)  
Ensuite, ouvrez un terminal ou une invite de commande et naviguez jusqu'au répertoire racine de votre projet, et 
éxécutez la commande suivante :
    ```
    mvn clean install
    ```  
Une fois que la configuration est terminée, vous pouvez lancer l'application en utilisant la commandes suivante :
   ```
    mvn spring-boot:run
   ```
2.  Avec une base de données PostgreSQL sur Docker : il est nécessaire d'avoir installé Docker Hub sur votre machine  
    (Lien d'installation : https://www.docker.com/products/docker-hub/)  .  
   Dans le fichier application.properties présent dans le dossier resources de l'application, décommentez les 4 lignes
présents sous le commentaire "Database (Docker)" et commentez les 4 sous le commentaire "Database (Clever Cloud)".  
Enfin,  ouvrez un terminal ou une invite de commande et naviguez jusqu'au répertoire racine de votre projet, et
    éxécutez la commande suivante pour démarrer l'application :
    ```
    docker compose up --build
    ```
Un conteneur adminer est aussi présent, afin de consulter les données persistés dans la base PostgreSQL