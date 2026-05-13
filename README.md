# MAITOPHP — Système de Gestion d'Annuaire Étudiant

## 📝 Présentation du Projet
Ce projet consiste en une application Android native développée en **Java** qui communique avec un backend **PHP 8**. L'application permet d'ajouter des étudiants à une base de données **MySQL** distante et d'afficher la liste synchronisée en temps réel. 

Il a été réalisé dans le cadre du module de développement mobile pour démontrer la consommation de Web Services via les bibliothèques **Volley** et **Gson**.

---

## 🚀 Fonctionnalités
- **Formulaire d'ajout** : Saisie du nom, prénom, ville (via Spinner) et sexe (via RadioGroup).
- **Communication Synchrone/Asynchrone** : Utilisation de Volley pour les requêtes HTTP POST et GET.
- **Parsing JSON** : Transformation automatique des réponses JSON en objets Java grâce à Gson.
- **Visualisation des données** : Affichage dynamique via un `RecyclerView`.
- **Backend Robuste** : Gestion de la base de données avec PDO pour une sécurité accrue.

---

## 📸 Aperçu de l'Application

### Interface Mobile (UI)
L'application propose une interface intuitive pour la gestion de l'annuaire.
<img width="440" height="867" alt="Screenshot 2026-05-13 154523" src="https://github.com/user-attachments/assets/08e3985c-cd19-46b0-86d3-173722ae463e" />


### Administration de la Base de Données
Les données sont stockées de manière persistante dans une base de données MySQL nommée `campus_db`.
<img width="1318" height="623" alt="Screenshot 2026-05-13 154534" src="https://github.com/user-attachments/assets/92821407-33f1-4403-99ab-750ccb864aa2" />

---

## 🛠️ Stack Technique
- **Mobile** : Android Studio, Java, Volley, Gson, RecyclerView.
- **Backend** : PHP 8, Architecture DAO (Data Access Object), PDO.
- **Base de données** : MySQL (via XAMPP/WAMP).

--- 

## ⚙️ Configuration du Système

### 1. Base de données
Créer une base de données nommée `campus_db` et exécuter le script suivant :
```sql
CREATE TABLE student_records (
    student_id INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(60) NOT NULL,
    first_name VARCHAR(60) NOT NULL,
    city VARCHAR(50),
    gender VARCHAR(15)
);
```
### 2. Backend PHP 
Placer les fichiers PHP dans votre dossier htdocs (ex: api_v1/). Assurez-vous que le fichier de connexion utilise les bons identifiants localhost, root et "".

### 3. Application Android
- **Configurer l'URL du serveur dans MainActivity.java.**

- **Note importante : Pour les tests sur émulateur, utilisez l'adresse 10.0.2.2 au lieu de localhost.**

- **Vérifier que le fichier network_security_config.xml est bien déclaré dans le AndroidManifest.xml pour autoriser le trafic HTTP.**

---

 ### 👤 Auteur
Mohamed AIT OURAJLI
Étudiant en 4ème année Génie Cyber-Défense et Systèmes de Télécommunications Embarqués (GCDSTE)
ENSA Marrakech
