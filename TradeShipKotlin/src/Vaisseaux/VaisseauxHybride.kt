package Vaisseaux
import Actions.IEquiperArmes
import Positions
import Armes.AArmes
import AElements

/**
 * Spécialisation de VaisseauxTransport lui permettant de transporter
 * Implémentation de l'interface IEquiperArme car la spécialisation de vaisseauxCombat n'est pas possible faute d'héritage mutliple
 */
class VaisseauxHybride(id: String) : VaisseauxTransport(id),IEquiperArmes {

    var capaciteArmes: Int? = null

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
     */
    override fun equiperArme(arme: AArmes) {

        if(capaciteArmesControle(capaciteArmes as Int) && masseControle(masseMaximal as Float,masse as Float,arme.masseInitiale as Float) && volumeControle(volumeRestant as Float,arme.volume as Float) )
        {
            listeElements.add(arme)
            volumeRestant = volumeRestant as Float - arme.volume as Float
            masse = masse as Float + arme.masseInitiale as Float
            arme.positions = Positions(this.identifiant)
            arme.parent = this
            arme.status = Status.équipé

            if (this.parent != null)
            {
                rafraichirMasse(this.parent as VaisseauxTransport)
                rafraichirVolume(this.parent as VaisseauxTransport)
                rafraichirHangar(this.parent as AElements)
            }

        }
    }

    /**
     * retire une arme de listeElement passe le statut a: stocké, retourne l'arme
     * Opérateur !! moyen non sécurisé de manipuler des types nullable
     * si l'une des références donne un null génére un nullPointerException
    */
    override fun desequiperArme(arme: AArmes): AArmes {

        if (listeElements.remove(arme))
        {
            volumeRestant = volumeRestant !! + arme.volume !!
            masse = masse !! - arme.masseInitiale !!
            arme.positions = Positions("hangar")
            arme.parent = null
            arme.status = Status.stocké

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
            print("cette arme n'est pas équipée")
        }

        return arme
    }

    /**
     * vérifie que la quantité d'arme ajouté ne dépasse pas la capacité en arme
     */
    override fun capaciteArmesControle( nombreArmes: Int) : Boolean {
        var nombreArmesActuel : Int = 0

        for (element : AElements in listeElements)
        {
            if (element.status == Status.équipé) nombreArmesActuel += 1
        }


        if(nombreArmesActuel + nombreArmes < capaciteArmes as Int + 1)
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