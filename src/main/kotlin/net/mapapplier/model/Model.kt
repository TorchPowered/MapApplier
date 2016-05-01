package net.mapapplier.model

/**
 * Represents a model of an obfuscation map.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
interface Model {
    /**
     * Retrieves the original name.
     */
    fun getOriginalName() : String

    /**
     * Retrieves the mapped name.
     */
    fun getMappedName() : String
}