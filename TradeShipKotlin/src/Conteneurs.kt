import Vaisseaux.AVaisseaux
import Vaisseaux.VaisseauxTransport

/**
 * spécialisation de VaisseauxTransport, par convenience car le comportement est le même
 */
class Conteneurs(id: String) :VaisseauxTransport(id) {

    init {
        volume = 10f
        masseInitiale = 10f
        masse = masseInitiale
        }

}