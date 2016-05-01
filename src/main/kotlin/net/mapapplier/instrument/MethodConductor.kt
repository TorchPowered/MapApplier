package net.mapapplier.instrument

import javassist.CodeConverter
import javassist.CtClass
import javassist.CtNewMethod
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
            if (ctClass?.name.equals(convertedModel.getDeclaringClass())) {
                for (method in ctClass?.declaredMethods!!) {
                    if (method.name.equals(convertedModel.getOriginalName()) && method.methodInfo2.descriptor.equals(convertedModel.getOriginalDescriptor())) {
                        val converter: CodeConverter = CodeConverter()
                        converter.redirectMethodCall(method, CtNewMethod.copy(method, convertedModel.getMappedName(), ctClass, null))
                    }
                }
            }
        }
        return ctClass
    }
}