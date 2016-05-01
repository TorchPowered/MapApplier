package net.mapapplier.model

/**
 * Represents a field model of an obfuscation map.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
open class FieldModel(declaringClass: String, mappingDescriptor: String, originalName: String, mappedName: String, originalDescriptor: String) : DescriptableModel {
    private val declaringClass: String
    private val mappingDescriptor: String
    private val originalName: String
    private val mappedName: String
    private val originalDescriptor: String

    init {
        this.declaringClass = declaringClass
        this.mappingDescriptor = mappingDescriptor
        this.originalName = originalName
        this.mappedName = mappedName
        this.originalDescriptor = originalDescriptor
    }

    override fun getDeclaringClass(): String {
        return declaringClass
    }

    override fun getMappedDescriptor(): String {
        return mappingDescriptor
    }

    override fun getOriginalName(): String {
        return originalName
    }

    override fun getMappedName(): String {
        return mappedName
    }

    override fun getOriginalDescriptor(): String {
        return originalDescriptor
    }
}