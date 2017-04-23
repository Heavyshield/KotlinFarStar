package Vaisseaux

import Armes.AArmes
import Actions.IEquiperArmes
import  Positions

/**
 * Created by thiba on 01/04/2017.
 */
class VaisseauxLourd(id: String) :AVaisseauxCombat(id){

    init {
        volume = 100f
        volumeRestant = 90f
        masseInitiale = 100f
        masse = masseInitiale
        masseMaximal = 300f
        capaciteArmes = 4
    }
}