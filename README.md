Geenson_Game 
@Autheurs Nicolas Brasset et Adèle Richard

Lancer le jeu : java Main --w2v ../Geenson_Game/ --nbPlayers 2 --nbTry 3 --k 3
    --w2v + chemin du dossier où se trouve le fichier des vecteurs de mot
    --nbPlayers + nombre de joueurs
    --nbTry + nombre d'essai autorisé pour faire deviner le mot
    --k + nombre de mot à afficher après avoir donné les indices

Geenson Game est un jeu de plateau à 25 cases. Sur ce plateau de jeu on peut trouver plusieurs types de cases :
    1) Normal qui consiste à faire deviner un mot à l'ordinateur en entrant 3 indices. Ces indices doivent être des mots les plus proche possible du mot à faire deviner. Pour chaque indice entré, appuyez sur "entré". Si le joueur n'a pas réussis la première fois, il a le droit de retenter autant de fois qu'il l'a décidé en début de partie.
    2) Le joueur relance le dé.
    3) Le joueur recule de 3 cases.

En début de partie chaque joueur est ammené à choisir un dé spécial. Ces dés spéciaux aurons des chiffres et des effets bien à eux.
Chaque tour ce déroule de la façon suivante :
    1) Le joueur lance le dé qu'il veut, soit normal soit spécial.
    2) L'effet de la case sur lequel il tombe s'active.
    3) Le tour se termine pour le joueur.
