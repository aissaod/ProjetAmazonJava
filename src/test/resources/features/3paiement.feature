@PAIEMENT_AMAZON
  Feature: Automatisation de la procédure de paiement de la page Amazon
    Scenario: Passer à la page de paiement
      Given j'ai ajouté au panier tout mes articles
      And que je souhaite passer au paiement
      When je clique sur passer la commande
      And je cliquer sur "Continuer sans Prime"
      Then je devrais etre redirigé vers la page de paiement
      And mes articles devraient etre recapitules
