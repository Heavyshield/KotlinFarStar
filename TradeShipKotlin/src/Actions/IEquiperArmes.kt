package Actions

import Armes.AArmes

interface IEquiperArmes {
    fun equiperArme(arme: AArmes) = Unit
    fun desequiperArme(arme: AArmes) : AArmes
    fun capaciteArmesControle( nombreArmes: Int) : Boolean

}