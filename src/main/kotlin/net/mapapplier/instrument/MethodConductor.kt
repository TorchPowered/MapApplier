package net.mapapplier.instrument

import javassist.CtClass
import net.mapapplier.model.FieldModel
import net.mapapplier.model.MethodModel
import net.mapapplier.model.Model
import java.io.File

/**
 * Conducts method.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class MethodConductor : Conductor {
    override fun conduct(ctClass: CtClass?, model: Model, outputFile: File): CtClass? {
        if (model is FieldModel) {
            val convertedModel: MethodModel = model as MethodModel
            //TODO
        }
        return ctClass
    }
}