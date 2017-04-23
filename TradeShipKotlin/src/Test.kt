import Actions.IEquiperArmes
import Armes.AArmes
import Armes.Blasters
import Armes.Phasers
import Vaisseaux.VaisseauxHybride
import Vaisseaux.VaisseauxLeger
import Vaisseaux.VaisseauxLourd
import Vaisseaux.VaisseauxTransport

import org.junit.Test

/**
 * Junit tests unitaire testant les fonctionnalités de bases : manipuler les elements, vérifier leurs attributs dans les listes
 */

class Test {

    @Test fun rafraichirHangar() {

        val vc1 = VaisseauxLeger("vl1")
        val phaser1 = Phasers("p1")
        val vt1 = VaisseauxTransport("vt1")

        vc1.equiperArme(phaser1)
        vt1.chargerElement(vc1)

        var liste = Hangar.listeElements

        assert(Hangar.listeElements.count() == 3)

        vc1.desequiperArme(phaser1)


        var liste2 = Hangar.listeElements

        assert(Hangar.listeElements.contains(vc1))

    }


    @Test fun equiperArme() {
        val blaster1 = Blasters("b1", 100)
        val lourd1 = VaisseauxLourd("vl1")

        lourd1.equiperArme(blaster1)
    }

    @Test fun desequiperArme() {
        val blaster1 = Blasters("b1", 100)
        val lourd1 = VaisseauxLourd("vl1")

        lourd1.equiperArme(blaster1)
        lourd1.desequiperArme(blaster1)
    }


    @Test fun rafraichirTransport() {
        val vt1 = VaisseauxTransport("vt1")
        val cn1 = Conteneurs("cn1")

        assert(vt1.masse == 100f)
        assert(vt1.volumeRestant == 90f)

        vt1.chargerElement(cn1)

        assert(vt1.trouverElement("cn1") == cn1)
        assert(vt1.volumeRestant == 80f)
        assert(vt1.masse == 110f)
        assert(cn1.positions.position == "vt1")

    }

    @Test fun rafraichirHybride() {
        val vl1 = VaisseauxLourd("vh1")
        val vh1 = VaisseauxHybride(vl1)
        val cn1 = Conteneurs("cn1")
        val blaster1 = Blasters("b1", 100)

        assert(vh1.masse == 100f)
        assert(vh1.volumeRestant == 90f)

        vh1.equiperArme(blaster1)

        vh1.rafraichirMasse(vh1)
        assert(vh1.masse == 102f)
        assert(blaster1.positions.position == "vh1")


        vh1.chargerElement(cn1)

        assert(vh1.trouverElement("cn1") == cn1)
        assert(vh1.volumeRestant == 80f)
        assert(vh1.masse == 112f)
        assert(cn1.positions.position == "vh1")


    }

    @Test fun rafraichirCombat() {
        val vc1 = VaisseauxLeger("vl1")
        val phaser1 = Phasers("p1")

        assert(vc1.masse == 10f)

        vc1.equiperArme(phaser1)

        assert(vc1.masse == 11f)
        assert(phaser1.positions.position == "vl1")

        vc1.desequiperArme(phaser1)

        assert(vc1.masse == 10F)
    }




    @Test fun chargerElement() {

        val vt1 = VaisseauxTransport("vt1")
        val cn1 = Conteneurs("cn1")

        vt1.chargerElement(cn1)
        assert(vt1.trouverElement("cn1") == cn1)
    }

    @Test fun dechargerElement() {

        val vt1 = VaisseauxTransport("vt1")
        val cn1 = Conteneurs("cn1")

        vt1.chargerElement(cn1)
        vt1.dechargerElement(cn1)
        assert(vt1.trouverElement("cn1") == null)
    }

    @Test fun chercherElement() {

        val vt1 = VaisseauxTransport("vt1")

        assert(Hangar.chercherElement("vt1") == vt1)
    }

}