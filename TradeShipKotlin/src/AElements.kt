

/**
 * type le plus général, les elements peuvent être chargé / déchargé
 */

abstract class AElements(id: String) {
     val identifiant: String = id
     var masseInitiale: Float? = null
     var masse: Float? = masseInitiale
     var volume: Float? = null
     var positions: Positions = Positions("hangar")
     var parent: AElements? = null
    var status: Status = Status.stocké

     init {
          Hangar.listeElements.add(this)
     }

    /**
     * fonctions récusirve: supprime l'element du Hanger et le rajoute pour mettre à jours ses attributs
     */
    fun rafraichirHangar(element: AElements): Boolean
     {
         var i = 0
         for (elementStocke : AElements in Hangar.listeElements)
         {
             if (element.identifiant == elementStocke.identifiant)
             {
                 Hangar.listeElements[i] = element
                 break
             }

             i ++
         }


         if (element.parent != null)
         {
             rafraichirHangar(element.parent as AElements)
         }

         return true

     }

}

