@COMMANDE_AMAZON
Feature: Tester le bout en bout d'une commande amazon
  Scenario Outline: Effectuer une commande d'un article amazon
    Given j'ai réussi à me connecter sur mon compte Amazon
    When je recherche <article> dans la barre de recherche
    And je clique sur l'article "<articleName>"
    Then je devrais etre redirigé vers ce produit
    Examples:
      | article     | articleName                       |
      | "iphone 14" | Apple iPhone 14 (128 Go) - Minuit |

  Scenario: Ajouter le produit au panier
    Given je suis sur la page de mon article
    And que je souhaite acheter l'article
    When je clique sur le bouton "Ajouter au panier"
    And je clique sur "Non Merci"
    And je clique sur "Panier"
    Then le produit doit etre dans mon panier et je peux passer à la commande


