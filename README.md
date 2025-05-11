#  Proto-Simulateur d’Automate Cellulaire

##  Objectif du Projet
Ce projet a pour but d’implémenter un **proto-simulateur d’automate cellulaire** représentant des interactions dynamiques entre **pompiers** et **feux** sur une grille.

##  Fonctionnement Général
- La simulation se déroule sur une grille composée de différents types d’éléments : pompiers, feux, nuages, obstacles, etc.
- À chaque tour :
  - Un **pompier** peut soit éteindre tous les feux autour de lui, soit se déplacer vers le feu le plus proche et tenter de l’éteindre.
  - Un **feu** se propage aux cases voisines **tous les deux tours**.

##  Code Couleur des Éléments de la Grille
| Élément                  | Couleur     | Description                                                                 |
|--------------------------|-------------|-----------------------------------------------------------------------------|
| `Cloud`                  | Violet      | Se déplace aléatoirement, éteint les feux.                                 |
| `MotorizedFireFighter`   | Orange      | Pompier motorisé, se déplace de deux cases.                                |
| `Mountain`               | Gris foncé  | Infranchissable (ni feu ni pompier).                                       |
| `Road`                   | Noir        | Franchissable uniquement par les pompiers.                                 |
| `Rockery`                | Vert        | Le feu y met 4 tours pour se propager.                                     |
| `FireFighter`            | Bleu        | Pompier classique.                                                         |
| `Fire`                   | Rouge       | Se propage toutes les deux itérations.                                     |


---

##  Architecture & Design Patterns

Ce projet respecte les **principes SOLID** et adopte deux design patterns principaux :  
- **Factory** : pour créer dynamiquement les objets de la simulation (pompiers, feux, obstacles, etc.) via des classes `Factory` dédiées.  
- **Strategy** : pour déléguer le comportement dynamique (déplacement, extinction, propagation...) via des interfaces `Update` (éléments mobiles) et `Impact` (éléments fixes).

---

##  Composants du Système

###  Composants Mobiles (`movable`)
Ces éléments changent de position à chaque tour et implémentent l’interface `Update` :
```java
void influence(BoardElement element);
```

- `Cloud` / `CloudUpdate` / `CloudFactory`  
- `MotorizedFireFighter` / `MotorizedFireFighterUpdate` / `MotorizedFireFighterFactory`

###  Composants Fixes (`motionless`)
Ils sont statiques, mais influencent le système, et implémentent l’interface `Impact` :
```java
void impact();
```

- `Mountain` / `MountainImpact` / `MountainFactory`
- `Road` / `RoadImpact` / `RoadFactory`
- `Rockery` / `RockeryImpact` / `RockeryFactory`
- `Fire` / `FireImpact` / `FireFactory`
- `FireFighter` / `FireFighterImpact` / `FireFighterFactory`




