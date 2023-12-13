@AMAZON_CONNEXION

      Feature: Tester le bout en bout d'une commande amazon
    Scenario: 1 Accéder à l'identification
    Given je suis sur la page d'acceuil Amazon, je souhaite m'identifier
    When je clique sur "Se connecter en toute sécurité"
    Then je suis redirigé vers la page S'identifier



    Scenario: Identification
    Given je suis sur la page S'identifier
    When je saisis mon user "aissaod77@gmail.com"
    And je clique Sur le bouton "Continuer"
    And je saisis mon password "Magnetos64"
    And je clique sur "Rester connecté"
    And je clique sur "S'identifier"
    Then je suis redirigé vers la page d'acceuil amazon

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

    Scenario: Passer à la page de paiement
      Given j'ai ajouté au panier tout mes articles
      And que je souhaite passer au paiement
      When je clique sur passer la commande
      And je cliquer sur "Continuer sans Prime"
      Then je devrais etre redirigé vers la page de paiement
      And mes articles devraient etre recapitules






