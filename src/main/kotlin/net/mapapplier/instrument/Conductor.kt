package net.mapapplier.instrument

import javassist.CtClass
import net.mapapplier.model.Model
import java.io.File

/**
 * Represents a conductor of bytecode.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
interface Conductor {
    /**
     * Called when the program wants to conduct the model.
     * The outputFile is used for the final conductor to the complete class model.
     * The ctClass parameter can be null if there is no parent class model.
     */
    fun conduct(ctClass: CtClass?, model: Model, outputFile: File) : CtClass?
}