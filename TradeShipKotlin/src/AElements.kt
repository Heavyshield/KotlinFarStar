import kotlin.properties.Delegates

/**
 * type le plus général, les elements peuvent être chargé / déchargé
 */

abstract class AElements(id: String) {
     val identifiant: String = id
     var masseInitiale: Float? = null

    /**
     * Pattern observer observable sur la masse
     */
   open var masse: Float? by Delegates.observable(null as Float?) {
        prop, old, new ->
        println("$this masse est modifié : $old -> $new")
    }

     var volume: Float? = null
     var positions: Positions = Positions("hangar")
     var parent: AElements? = null
    var status: Status = Status.stocké

     init {
          Hangar.listeElements.add(this)
     }

    /**
     * fonctions récusirve: remplace l'element stocké par celui en paramètre pour rafraichir ses attributs
     * si l'element à un parent appel le rafraichissement sur le parent
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

