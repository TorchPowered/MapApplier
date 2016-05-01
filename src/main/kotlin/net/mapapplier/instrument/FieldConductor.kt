package net.mapapplier.instrument

import javassist.CodeConverter
import javassist.CtClass
import net.mapapplier.model.FieldModel
import net.mapapplier.model.Model
import java.io.File

/**
 * Conducts fields.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class FieldConductor : Conductor {
    override fun conduct(ctClass: CtClass?, model: Model, outputFile: File): CtClass? {
        if (model is FieldModel) {
            val convertedModel: FieldModel = model
            val converter: CodeConverter = CodeConverter()
            if (ctClass?.name.equals(convertedModel.getOriginalName())) {
                ctClass?.getDeclaredField(convertedModel.getOriginalName(), convertedModel.getOriginalDescriptor())?.fieldInfo?.descriptor = convertedModel.getMappedDescriptor()
                converter.redirectFieldAccess(ctClass?.getDeclaredField(convertedModel.getOriginalName()), ctClass, convertedModel.getMappedName())
                ctClass?.instrument(converter)
                return ctClass
            }
        }
        return ctClass
    }
}