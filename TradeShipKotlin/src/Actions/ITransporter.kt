package Actions

import AElements
import Armes.AArmes

interface ITransporter {
    fun chargerElement(element: AElements) = Unit
    fun dechargerElement(element: AElements) : AElements

}