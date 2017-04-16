package Armes

/**
 * spécialisation de AArmes
 */
class Blasters (id: String, gNiveau: Int) : AArmes(id){
    var niveauGaz: Int = gNiveau

    init {
        volume = 2f
        masseInitiale = 2f
        masse = masseInitiale
    }
}