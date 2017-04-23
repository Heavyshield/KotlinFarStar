package Vaisseaux
import Actions.IEquiperArmes
import  Positions
import  Armes.AArmes
import Armes.Phasers
import AElements


/**
 * spécialisation de vaisseaux ajoutant la notion de capacité en armes ainsi que des fonctions
 * permettant de les équiper désequiper
 */

abstract class AVaisseauxCombat(id: String) : AVaisseaux(id), IEquiperArmes {

    var listeArmes = mutableListOf<AElements>()

    var capaciteArmes: Int = 0

    init {
        volume = 100f
        volumeRestant = 90f
        masseInitiale = 100f
        masse = masseInitiale
        masseMaximal = 300f
        capaciteArmes = 4
    }

    /**
     * ajoute une arme a listeElement passe le statut a: équipé
     * Opérateur cast moyen  non sécurisé de convertir des types nullables en type safe
     */
    override fun equiperArme(arme: AArmes) {

        if(capaciteArmesControle(capaciteArmes) && masseControle(masseMaximal as Float,masse as Float,arme.masseInitiale as Float) && arme.positions.position == "hangar" )
        {
            listeArmes.add(arme)
            masse = masse as Float + arme.masse as Float
            arme.positions = Positions(this.identifiant)
            arme.parent = this
            arme.status = Status.équipé

        }

    }

    /**
     * retire une arme de listeElement passe le statut a: stocké, retourne l'arme
     * Opérateur !! moyen non sécurisé de manipuler des types nullable
     * si l'une des références donne un null génére un nullPointerException
     */
    override fun desequiperArme(arme: AArmes): AArmes {

        if (listeArmes.remove(arme))
        {
            masse = masse !! - arme.masse !!
            arme.positions = Positions("hangar")
            arme.parent = null
            arme.status = Status.stocké

        }
        else
        {
            print("cette arme n'est pas équipée")
        }

        return arme
    }

    /**
     * vérifie que la quantité d'arme ajoutée ne dépasse pas la capacité en arme
     */
    override fun capaciteArmesControle( nombreArmes: Int) : Boolean {
        var nombreArmesActuel : Int = 0

        for (element : AElements in listeArmes)
        {
            if (element.status == Status.équipé) nombreArmesActuel += 1
        }


        if(nombreArmesActuel + nombreArmes < capaciteArmes + 1)
        {
            return true
        }
        else
        {
            println("La capacite en armes de " + capaciteArmes + " a était dépassé")
            return false
        }
    }

}