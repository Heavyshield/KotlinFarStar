package Vaisseaux

import  Positions
import Actions.ITransporter
import AElements
import Armes.AArmes

/**
 * spécialisation de AVaisseaux impémentant ITransporter
 */
open class VaisseauxTransport(id: String) :  AVaisseaux( id), ITransporter {


    init {
        volume = 100f
        volumeRestant = 90f
        masseInitiale = 100f
        masse = masseInitiale
        masseMaximal = 300f

    }

    /**
     * ajoute un element a listeElement passe le statut a : chargé
     */
    override fun chargerElement(element: AElements){

        if(masseControle(masseMaximal as Float,masse as Float,element.masseInitiale as Float) && volumeControle(volumeRestant as Float,element.volume as Float) && element.positions.position == "hangar")
        {
            listeElements.add(element)
            volumeRestant = volumeRestant as Float - element.volume as Float
            masse = masse as Float + element.masse as Float
            element.parent = this
            element.status = Status.chargé
            element.positions = Positions(this.identifiant)

            if (this.parent != null)
            {
                rafraichirMasse(this.parent as VaisseauxTransport)
                rafraichirVolume(this.parent as VaisseauxTransport)
                rafraichirHangar(this as AElements)
                rafraichirHangar(this.parent as AElements)
            }
        }
        else
        {
            println(this.identifiant + " ne peut charger " + element.identifiant)
        }
    }


    /**
     * retire un element a listeElement passe le statut a : stocké
     * Opérateur !! moyen non sécurisé de manipuler des types nullable
     * si l'une des références donne un null génére un nullPointerException
     */
    override fun dechargerElement(element: AElements) : AElements{

            listeElements.remove(element)
            volumeRestant = volumeRestant !! + element.volume !!
            masse = masse !! -  element.masse !!
            element.parent = null
            element.status = Status.stocké
            element.positions = Positions("hangar")

        if (this.parent != null)
        {
            rafraichirMasse(this.parent as VaisseauxTransport)
            rafraichirVolume(this.parent as VaisseauxTransport)
            rafraichirHangar(this as AElements)
            rafraichirHangar(this.parent as AElements)
        }


        return element
    }


}