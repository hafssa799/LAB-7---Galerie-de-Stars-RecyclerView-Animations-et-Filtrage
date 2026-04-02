# LAB-7---Galerie-de-Stars-RecyclerView-Animations-et-Filtrage


StarsGallery est une application Android permettant de visualiser une galerie de célébrités. L'application met en œuvre des concepts fondamentaux du développement Android : RecyclerView, 

filtrage dynamique, gestion d'images distantes/locales et animations.

## Fonctionnalités

•Écran de démarrage (Splash Screen) : Animation de rotation et de fondu au lancement.

•Liste de Stars : Affichage fluide avec des images circulaires et un système de notation (RatingBar).

•Recherche Dynamique : Filtrage en temps réel des stars par nom via la barre de recherche.

•Partage Social : Fonctionnalité de partage du contenu texte vers d'autres applications.

•Design Moderne : Utilisation d'une Toolbar personnalisée noire mat et d'accents turquoise.

## Stack Technique

•Langage : Java

•UI : ConstraintLayout, RecyclerView, CardView, CircleImageView.

•Gestion d'images : Glide (v4.15.1).

•Architecture : Pattern DAO (Data Access Object) et Service (Singleton).

## Structure du Projet

- Le projet est organisé selon les packages suivants :

•beans : Contient la classe Star (modèle de données).

•dao : Interface générique IDao pour les opérations CRUD.

•service : Classe StarService gérant la liste des stars en mémoire.

•adapter : Classe StarAdapter assurant la liaison entre les données et le RecyclerView, incluant la logique de filtrage.

•ui : Contient les activités SplashActivity (démarrage) et ListActivity (affichage principal).

## Étapes de Réalisation


### Étape 1 : Configuration du projet

•Création des packages.

•Ajout des dépendances (Glide, CircleImageView) dans build.gradle.kts.

•Importation des photos des stars dans le dossier res/drawable.

### Étape 2 : Modèle et Couche Service

•Implémentation de la classe Star avec un ID auto-incrémenté.

•Création de l'interface IDao et du service StarService (Singleton) avec des données de test (seed()).

### Étape 3 : Design de l'interface

•Splash Screen : Configuration d'un ImageView centré avec des animations Java (animate()).

•Item de liste : Création de star_item.xml avec CircleImageView pour la photo et RatingBar pour la note.

•Styles : Personnalisation des couleurs dans colors.xml (Noir #212121 et Turquoise #009688).

### Étape 4 : Adapter et RecyclerView

•Implémentation du StarAdapter.

•Utilisation de Glide pour charger les ressources drawable de manière optimisée.

•Gestion du filtrage en implémentant l'interface Filterable.

### Étape 5 : Recherche et Partage

•Création d'un menu XML (res/menu/menu.xml) contenant un SearchView et un bouton de partage.

•Connexion du filtre de l'Adapter à la barre de recherche dans ListActivity.

•Utilisation de ShareCompat.IntentBuilder pour la fonctionnalité de partage.


## 🎬 Démonstration Vidéo



https://github.com/user-attachments/assets/b3d1187c-321a-4eeb-b3a5-d2b2c4c00ad9


