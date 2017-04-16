package Vaisseaux
import AElements
import Actions.IEquiperArmes
import  Positions

/**
  * spécialisation de AElements introduisant les notions de masse maximal, volume restant, la capacité de contenir des elements
  * et des fonctions permettant de les manipuler
 */
abstract class AVaisseaux(id: String) :AElements(id) {

     var masseMaximal: Float? = null
     var volumeRestant: Float? = null
     var listeElements = mutableListOf<AElements>()

     fun volumeControle(capaciteVolume: Float,  volumeAjoute: Float) : Boolean {

         if(capaciteVolume - volumeAjoute > 0)
         {
             return true
         }
         else
         {
             println("La capacite en volume restant de " + capaciteVolume + " a était dépassé")
             return false
         }
     }

    /**
      * vérifie que la masse ajouté ne dépasse pas la masse maximal
     */
    fun masseControle(capaciteMasse: Float, masseActuelle: Float, masseAjoute: Float) : Boolean {

        if(masseActuelle + masseAjoute < capaciteMasse)
        {
            return true
        }
        else
        {
            println("La capacite en masse de " + capaciteMasse + " a était dépassé")
            return false
        }
    }

    /**
      * calcul la masse total en faisant une somme des masses des elements dans listeElements
     */
     fun rafraichirMasse(vaisseau: VaisseauxTransport) {
        var m : Float = vaisseau.masseInitiale as Float
        for (element: AElements in vaisseau.listeElements)
        {
            m += element.masse as Float
        }
        vaisseau.masse = m
    }

    /**
     * calcul le volume restant en soustrayant les volumes des elements dans listeElements
     */
   open fun rafraichirVolume(vaisseau: VaisseauxTransport) {
        var v : Float = vaisseau.volume as Float
        for (element: AElements in vaisseau.listeElements)
        {
            v -= element.volume as Float
        }
        vaisseau.volume = v
    }

    /**
      * retourne un element dans listeElements correspondant a l'identifiant donné
     */
     fun trouverElement(nomElement: String): AElements? {

        var nullableResult : AElements? = null

        for(element: AElements in listeElements)
        {
            if (element.identifiant == nomElement)
            {
                nullableResult = element
                break
            }
        }

        return nullableResult
    }


}