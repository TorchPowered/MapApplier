package net.mapapplier.instrument

import javassist.ClassPool
import javassist.CtClass
import net.mapapplier.model.ClassModel
import net.mapapplier.model.Model
import java.io.File

/**
 * Conducts classes.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class ClassConductor : Conductor {
    override fun conduct(ctClass: CtClass?, model: Model, out: File) : CtClass? {
        if (model is ClassModel) {
            val convertedModel: ClassModel = model
            if (ctClass?.name.equals(convertedModel.getOriginalName())) {
                val ctClasses: CtClass = ClassPool.getDefault().getAndRename(convertedModel.getOriginalName(), convertedModel.getMappedName())
                return ctClasses
            }
        }
        return null
    }
}