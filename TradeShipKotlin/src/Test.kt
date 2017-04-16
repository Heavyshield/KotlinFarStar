import Actions.IEquiperArmes
import Armes.AArmes
import Armes.Blasters
import Armes.Phasers
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

    @Test fun equiperTrouverDesequiperArme() {

        val phaser1 = Phasers("p1")
        val leger1 = VaisseauxLeger("vc1")

        leger1.equiperArme(phaser1)

        /*
        trouverArme est une function retournant le type nullable AArmes? d'ou le cast en AArmes
         */
       val phaser1copie = leger1.trouverElement("p1") as AArmes

        leger1.desequiperArme(phaser1copie)

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

    @Test fun rafraichirCombat() {
        val vc1 = VaisseauxLeger("vl1")
        val phaser1 = Phasers("p1")

        assert(vc1.masse == 10f)
        assert(vc1.volumeRestant == 8f)

        vc1.equiperArme(phaser1)

        assert(vc1.masse == 11f)
        assert(vc1.volumeRestant == 7f)
        assert(phaser1.positions.position == "vl1")

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