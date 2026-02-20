# Projet SDIA - IOC (Inversion of Control)

Ce projet est une démonstration des principes de l'**Inversion de Contrôle (IOC)** et de l'**Injection des Dépendances** en Java, en utilisant Spring Framework ainsi que des approches natives.

## Objectif du projet

Montrer 5 façons différentes d'instancier et d'injecter la dépendance `IDao` dans `MetierImpl` :

| Présentation       | Technique utilisée                                 | Type de couplage | Fichier de configuration | Annotation Spring |
|--------------------|-----------------------------------------------------|------------------|---------------------------|-------------------|
| Pres1.java         | Instanciation manuelle (new)                        | Fort             | —                         | Non               |
| Pres2.java         | Instanciation dynamique (réflexion + fichier txt)  | Faible           | config.txt                | Non               |
| PresSpringXML.java | Spring – configuration XML                          | Faible           | config.xml                | Non               |
| PresSpringAnnotation.java | Spring – configuration par annotations     | Faible           | — (scan des packages)     | Oui               |
| (MetierImpl)       | Injection via constructeur + @Qualifier             | Faible           | —                         | Oui               |

## Structure du projet
```
SDIA-IOC
├── src
│   └── main
│       ├── java
│       │   └── net.lasfar
│       │       ├── dao
│       │       │   ├── IDao.java
│       │       │   ├── DaoImpl.java           (@Component("d"))
│       │       │   └── ext
│       │       │       └── DaoImplV2.java     (@Repository("d2"))
│       │       ├── metier
│       │       │   ├── IMetier.java
│       │       │   └── MetierImpl.java        (@Service + @Qualifier possible)
│       │       └── pres
│       │           ├── Pres1.java
│       │           ├── Pres2.java             (réflexion + config.txt)
│       │           ├── PresSpringXML.java
│       │           └── PresSpringAnnotation.java
│       └── resources
│           └── config.xml                     (version XML Spring)
├── config.txt                                 (utilisé par Pres2)
└── pom.xml
```

## Description des composants

### Couche DAO (Data Access Object)
- **IDao.java** : Interface définissant la méthode `getData()`
- **DaoImpl.java** : Implémentation simulant un accès base de données (retourne 34)
- **DaoImplV2.java** : Implémentation simulant des capteurs (retourne 12)

### Couche Métier
- **IMetier.java** : Interface définissant la méthode `calcul()`
- **MetierImpl.java** : Implémentation utilisant un DAO pour effectuer un calcul

### Couche Présentation
Différentes classes pour démontrer les approches d'injection :

1. **Pres1.java** : Instanciation statique manuelle
2. **Pres2.java** : Instanciation dynamique par réflexion
3. **PresSpringAnnotation.java** : Configuration Spring par annotations
4. **PresSpringXML.java** : Configuration Spring par XML

## Comment exécuter chaque version

### 1. Version statique – couplage fort (Pres1)

```bash
# Modifier directement le code pour choisir DaoImpl ou DaoImplV2
java net.lasfar.pres.Pres1
```
### 2. Version dynamique – réflexion (Pres2)
```bash
# Vérifiez / modifiez config.txt
cat config.txt
# Exemple de contenu :
# net.lasfar.ext.DaoImplV2
# net.lasfar.metier.MetierImpl
java net.lasfar.pres.Pres2
```
### 3. Version Spring XML (PresSpringXML)
```bash
# Vérifiez config.xml (bean id="d" ou changez vers "d2")
java net.lasfar.pres.PresSpringXML
```

### 4. Version Spring Annotations (PresSpringAnnotation)
```bash
# Le scan démarre depuis le package "net.lasfar"
# @Qualifier("d2") est actuellement actif dans MetierImpl
java net.lasfar.pres.PresSpringAnnotation
```

### Résultats attendus (exemples)

  1. **DaoImpl**     → Version base de données → t = 34
  2. **DaoImplV2**   → Version capteurs ....   → t = 12

### Prérequis

  - **Java 23 (ou au minimum Java 17 recommandé)**
  - **Maven**
  - **IDE recommandé : IntelliJ IDEA (le projet est déjà configuré avec .idea)**

## Dépendances

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>6.2.16</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>6.2.16</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>6.2.16</version>
    </dependency>
</dependencies>
```


