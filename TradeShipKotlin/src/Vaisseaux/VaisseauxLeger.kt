package Vaisseaux

import Actions.IEquiperArmes
import Armes.AArmes
import Armes.Blasters
import Armes.Phasers
import Positions
import AElements

/**
 * Created by thiba on 01/04/2017.
 */
class VaisseauxLeger(id: String) :AVaisseauxCombat(id){

    init {
        volume = 10f
        volumeRestant = 8f
        masseInitiale = 10f
        masse = masseInitiale
        capaciteArmes = 2
    }

    /**
     * empêche l'ajout d'un blaster
     */
    fun equiperArme(arme: Blasters)
    {
        println(arme.identifiant + " n'est pas un type d'arme autorisé pour ce vaisseau")
    }

    }

