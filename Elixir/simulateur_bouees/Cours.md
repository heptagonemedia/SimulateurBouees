GRAAL :

Le fonctionnel serait il le graal ? La silver bullet de la programmation
Machine d'état (Joueur qui peut être dans l'état debout, couché, debout en course, debout en course)
Une série d'options possibles, par exemple 6 types d'animations pour juste la course

Il ne faut donc pas se focus sur un seul type de programmes. Quand on choisit on choisit en fonction d'une balance

Fontion pure :
* Elle doit retourner quelque chose
* Elle effectue une transformation et elle retourne le résultat
* Elle n'a aucun contexte et elle recoit tout ce dont elle a besoin
* Ne peut **en aucun cas** changer l'état de ce qu'elle reçoit =­> Tout est immutable
* Sécuritaire, il n'y a pas de concurrence entre les variables et les process. Ne peut rien modifier en dehors de son corps


La POO est du procédural ré organisé, ou du modulaire et structuré.
* Elle permet la discussion ou l'échange avec l'extérieur

En fonctionnel pur on aura des points de sortie qui ne seront pas purs, ce seront des in/out procéduraux. Ils auront accès à l'extérieur (SGBD)
Le mastermind de notre programme sera du procédural. Lui aura aura des variables environnementales. Il aura des états internes. Persistant en mémoire, en ram. C'est un utilisateur et pas un service utilisé. La communication externe lui est permise, c'est même sa raison d'être
Il peut donc travailler dans un écosystème

On doit donc concentrer le procédural dans le moins de lignes possibles

On fabrique notre programme avec des fonctions de bases, puis on les assemble, on les contextualise jusqu'a arriver à notre couche application

Composition, curry, synthetic sugar
