import javafx.scene.Parent

/**
 * Consommation de l'API
 */


    fun main(args : Array<String>)
{

    var kotlinAttribute = JavaClass.dangerousString()

    /**
     * type déduit int
     */
    var i = 2

    /**
     * type déduit float
     */
    var j = 2f

    /**
     * type déduit string
     */
    var k = "string"

}

/**
 * Exemple d'une classe ne possédant que des attributs safe
 */
class ElementsSafe (id: String, mI: Float, ma: Float, vo: Float, po: Positions)
{
    val identifiant: String = id
    var masseInitiale: Float = mI
    var masse: Float = masseInitiale
    var volume: Float = vo
    var positions: Positions = Positions("hangar")
    var parent: ElementsSafe? = null
    var status: Status = Status.stocké


     fun returnUnsafeString(): String? {

        return null
    }

    open fun openFunction(){}

    fun returnSafeString(): String {

        return "safe"

    }

    fun returnUnsafeInt(): Int? {

        return null
    }
}

