Q1) app/src/main/res/layout/activity_main.xml
Q2) Modification de l attribut "text" dans le TextView
Q3)
J'ai été dans file -> new -> image asset | puis j'ai ajouté mon logo
Q4)
Techniquement, non, ce n’est pas nécessaire si vous appelez immédiatement putExtra(...) avec le contenu de l’EditText dès que vous cliquez sur "Next". Dans ce cas, le texte sera transmis à MainActivity2 même sans passer par un bouton "Valider".

Q5)
Cela dépend du processus métier que vous souhaitez. Si l’utilisateur doit confirmer son texte avec un bouton "Valider" avant d’aller à la page suivante, il est plus logique de ne transmettre les données qu’après ce clic.
Dans de nombreuses applis, on veut être sûr que l’utilisateur confirme ou valide sa saisie avant de changer d’écran.

Q6) Ajoutez un bouton "Valider" dans la première activité.
Ne mettez la valeur dans l’intent.putExtra(...) que lorsqu’on clique sur "Valider".
Si l’utilisateur clique sur "Next" sans avoir validé, soit vous n’envoyez pas de texte (ou un texte vide), soit vous empêchez le passage à la page suivante.

