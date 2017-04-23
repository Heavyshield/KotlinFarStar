package Vaisseaux
import AElements
import Actions.IEquiperArmes
import  Positions
import kotlin.properties.Delegates

/**
  * spécialisation de AElements introduisant les notions de masse maximal, volume restant, la capacité de contenir des elements
  * et des fonctions permettant de les manipuler
 */
abstract class AVaisseaux(id: String) :AElements(id) {

     var masseMaximal: Float? = null

    /**
     * Pattern observer observable sur le volumeRestant
     */
    var volumeRestant: Float? by Delegates.observable(null as Float?) {
        prop, old, new ->
        println("$this volumeRestant est modifié : $old -> $new")
    }


    /**
     * Vérifie que le volumeRestant soit supérieur à 0
     */
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



}