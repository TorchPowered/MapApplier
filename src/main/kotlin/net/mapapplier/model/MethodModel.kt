package net.mapapplier.model

/**
 * Represents a method model on a obfuscation map.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class MethodModel(declaringClass: String, mappingDescriptor: String, originalName: String, mappedName: String, originalDescriptor: String) : FieldModel(declaringClass, mappingDescriptor, originalName, mappedName, originalDescriptor) {}