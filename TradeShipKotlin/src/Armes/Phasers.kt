package Armes

/**
 * spécialisation de AArmes
 */
class Phasers(id: String) : AArmes(id) {

    init {
        volume = 1f
        masseInitiale = 1f
        masse = masseInitiale
    }
}