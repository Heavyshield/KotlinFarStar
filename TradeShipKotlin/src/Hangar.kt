import Actions.IchercherElements

/**
 * Created by thiba on 06/04/2017.
 */


/**
 * Singleton contenant une liste avec tous les elements existant
 */
object Hangar : IchercherElements{
    var listeElements = mutableListOf<AElements>()

    /**
     * retourne l'element correspondant à l'identifiant
     */
    override fun chercherElement(id: String) :AElements?
    {
        for (element: AElements in listeElements)
        {
            if(element.identifiant == id)
            {
                return element
            }
        }

        return null
    }
}