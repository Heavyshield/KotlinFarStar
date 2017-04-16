package Vaisseaux

import Armes.AArmes
import Actions.IEquiperArmes
import  Positions

/**
 * Created by thiba on 01/04/2017.
 */
class VaisseauxLourd(id: String) :AVaisseauxCombat(id){

    init {
        volume = 20f
        volumeRestant = 16f
        masseInitiale = 20f
        masse = masseInitiale
        capaciteArmes = 4
    }
}