-intitulé de projet : FireFighter Starter .
-Binome : BENHILA Douaa , MOTAIM Badr , (groupe3)

-Le but de ce projet : implémenter un proto-simulateur d'automate cellulaire.
-Ce que fait le projet : j'ai une grille ou  les éléments seront des pompiers et des feux. A chaque tour, chaque pompier éteindra soit tous les feux autour de lui soit se dirigera vers le feu le plus proche et éteindra ensuite le feu
autour de lui. Le feu de son côté s'étendra autour de lui tous les deux tours. 
-Code couleur de la grille : cloud(purple), MotorizedFireFighter(orange),Mountain(DARKGREY),Road(Black),ROCKERY(Green),FIREFIGHTER(BLEU),FIRE(rouge).
-Remarque:"nous sommes  au courant que la couleur de nuage doit etre  Light Grey (d'apres ce que vous avez dit en tp ) mais nous l'avons changer pour raisons d'affichage vu que la couleur ressembler au couleur des montagnes"
-Taches suivi afin de realiser ce projet:

taches 1:
    Afin d'avoir un code qui respecte les principes  SOLID .Nous avons suivi le pattern Factory ainsi que Strategy.
    Apartir de   la classe FireFirghterBoard et l'interface Board j'avais déleguer plusieurs classes et plusieurs interface .
    

tache 2:
    Dans cette etape nous devrons implemntez autres fonctionnalites plus precisament ajouter des elements dans mon board et gerer leur comportement (elements ajoutes et leur comportement c'etait determine dans la planche du projet)

    pour le reste de projet nous avons suivi le pattern factory et strategy  :
    en implementant j'ai realié que ces elements nous pouvant les divises en deux :
         motionelless elements and movable elements .
         tous elements que j'ai defini elles suivent la meme strucure :
            une classe avec le nom d'elements : afin de le creer.
            une classe intutule : nom_elementUpdate  son but de decrire le mouvement de cette classe.
            et une classe intitule : nom_elementFactory son but est de de  créer des objets dans une classe mère (nouveau types pompiers/cloud...).

         pour movable elements: (Package Movable)
            les classes responsables de la description du mouvement des élèments implemntent  mon interface Update a son tour qui a la fonction void influence(BoardElement element)
            cette fonction change d'un element a un autre vu que chaque elements a sa propre fonctionnalité.
            mes movable elements (elements mobiles) sont :
                Cloud/CloudUpdate/CloudFactory : Des nuages qui se déplacent aléatoirement et qui éteignent les feux.
                                                 Couleur dans la grille : purple "nous sommes  au courant que nous devions faire Light Grey mais nous l'avons changer pour raisons d'affichage vu que la couleur ressembler au couleur des montagnes"

                MotorizedFireFighter /MotorizedFireFighterUpdate / MotorizedFireFighterFactory :Des pompiers motorisés qui peuvent se déplacer de deux cases.
                                                                                                Couleur dans la grille : orange.



         pour motionelless element: (Package Motionless) 
            les classes responsables de la description du comportemet des élèments   implemntent  mon interface Impact  qui a la fonction  void impact();
            cette fonction change d'un element a un autre vu que chaque elements a sa propre fonctionnalité.
                mes motionelless elements (obstacles ) sont :
                Mountain/MountainFactory/MountainImpact: Des cases montagnes qui en sont pas franchissable par le feu ni par les pompiers.
                                                         Couleur dans la grille : DARKGREY.
                Road/RoadFactory/RoadImpact: Des cases routes qui ne sont franchissables que par les pompiers.
                                             Couleur dans la grille : BLACK.
                ROCKERY/ROCKERYFACTORY/ROCKERYIMPACT: Des cases rocailles sur lesquelles le feu mets quatre tours à se propager.
                                                        Couleur dans la grille : GREEN.


INFORMATIONS SUR AUTRE ELEMENTS DE MON BOARD:

                FIRE/FireFactory/FireImpact:   Le feu de son côté s'étendra autour de lui tous les deux tours.
                                                fire sont presentes en rouge dans ma grille .

                FireFighter/FireFighterFactory/FireFighterImpact: pompier éteindra soit tous les feux autour de lui soit se dirigera vers le feu le plus proche et éteindra ensuite le feu
                                                                  autour de lui.
                                                                  pompiers sont presentes en bleue dans ma grille .


