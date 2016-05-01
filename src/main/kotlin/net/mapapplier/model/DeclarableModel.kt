package net.mapapplier.model

/**
 * Represents a model that is declared inside of a class.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
interface DeclarableModel : Model {
    /**
     * Retrieves the declaring class's name.
     */
    fun getDeclaringClass() : String
}