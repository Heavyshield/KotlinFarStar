package Vaisseaux
import Actions.IEquiperArmes
import Positions
import Armes.AArmes
import AElements
import kotlin.properties.Delegates

/**
 * Hérite de vaisseaux de transport
 * Delegue l'équipement désequipement d'arme à un objet de type AVaisseauxCombat
 */
class VaisseauxHybride(combatDelegation: AVaisseauxCombat) :VaisseauxTransport(combatDelegation.identifiant), IEquiperArmes by combatDelegation {

    /**
     * Smart cast combat --> AVaisseauxCombat
     */
    var combat = combatDelegation


    /**
     * calcul la masse total en faisant une somme des masses des elements dans listeElements et listeArmes
     */
    override fun rafraichirMasse(vaisseau: VaisseauxTransport) {
        var m : Float = masseInitiale as Float
        for (element: AElements in listeElements)
        {
            m += element.masse as Float
        }
        for(element: AElements in combat.listeArmes)
        {
            m += element.masse as Float
        }
        masse = m
    }

}