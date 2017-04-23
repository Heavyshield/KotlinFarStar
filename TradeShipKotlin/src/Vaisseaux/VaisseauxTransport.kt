package Vaisseaux

import  Positions
import Actions.ITransporter
import AElements
import Armes.AArmes

/**
 * spécialisation de AVaisseaux impémentant ITransporter
 */
open class VaisseauxTransport(id: String) :  AVaisseaux( id), ITransporter {

    var listeElements = mutableListOf<AElements>()


    init {
        volume = 100f
        volumeRestant = 90f
        masseInitiale = 100f
        masse = 100f
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

    /**
     * calcul la masse total en faisant une somme des masses des elements dans listeElements
     */
    open fun rafraichirMasse(vaisseau: VaisseauxTransport) {
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
     fun rafraichirVolume(vaisseau: VaisseauxTransport) {
        var v : Float = vaisseau.volume as Float
        for (element: AElements in vaisseau.listeElements)
        {
            v -= element.volume as Float
        }
        vaisseau.volumeRestant = v
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