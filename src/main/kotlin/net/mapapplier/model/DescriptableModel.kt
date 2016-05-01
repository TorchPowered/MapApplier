package net.mapapplier.model

/**
 * Represents a model that has a descriptor.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
interface DescriptableModel : DeclarableModel {
    /**
     * Retrieves the original descriptor.
     */
    fun getOriginalDescriptor() : String

    /**
     * Retrieves the mapped descriptor.
     */
    fun getMappedDescriptor() : String
}