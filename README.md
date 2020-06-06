# WhiteApp

Exemple architectural de projet avec les technologies Jakarta EE & Quarkus.

Ce projet est sous licence **CeCILL** (**CE**A **C**NRS **I**NRIA **L**ogiciel **L**ibre),
une licence de logiciel libre compatible avec la **GNU GPL**.

> En savoir plus sur la licence [CeCILL](http://cecill.info/index.fr.html)

## Objectifs

Mettre en oeuvre:

* Une architecture hexagonale
* Quarkus

## Module

Ce projet ce compose d'un seul module de type **JAR** *(Java ARchive)*.
   
## Architecture

L’architecture logicielle mise en place est **HA** *(Hexagonal Architecture)*.

* *Domain*
    * Représente le coeur métier de l'application en pur Java, sans dépendance.
* *Infrastructure*
    * Représente l'implémentation technique du domaine basé sur Quarkus et Jakarta.

## Environnement

Ce projet est réalisé en **Java 11** *(OpenJDK)*, **Jakarta EE 8** et **Quarkus 1.4.2.Final**.
Il utilise l'outil **Maven** en version 3.6.2.

### Exécution

Récupération du projet:
~~~
    git clone https://github.com/ZelmoTheDragon/whiteapp-ha.git
    mvn install
~~~

Exécution du projet pour le développement:
~~~
    mvn compile quarkus:dev
~~~

Puis accéder à l'adresse:
~~~
http://localhost:8080/whiteapp
~~~
