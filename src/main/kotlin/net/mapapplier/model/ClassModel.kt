package net.mapapplier.model

/**
 * Represents a class model of an obfuscation map.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class ClassModel(mappedName: String, originalName: String) : Model {
    private val mappedName: String
    private val originalName: String

    init {
        this.mappedName = mappedName
        this.originalName = originalName
    }

    override fun getMappedName(): String {
        return mappedName
    }

    override fun getOriginalName(): String {
        return mappedName
    }
}