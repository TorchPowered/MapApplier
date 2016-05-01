package net.mapapplier

import javassist.ClassPool
import net.mapapplier.ext.JavaUtil
import net.mapapplier.model.ClassModel
import net.mapapplier.parser.ObfMapParser
import java.io.File

/**
 * The entry point of the application.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class Launch {
    companion object Static {
        @JvmStatic fun main(args: Array<String>) {
            // java -jar MapApplier.jar -obfmap:example.obfmap -jar:Example.jar
            // will output to Example-Remapped.jar
            if (args.size < 2) {
                println("Insufficent arguments!")
                println("Usage: java -jar MapApplier.jar -obfmap:<mapFileLoc> -jar <jarFileLoc>")
                return
            }
            println("Processing arguments...")
            var mapLoc: File? = null
            var jarLoc: File? = null
            for (arg in args) {
                if (arg.startsWith("-obfmap:")) {
                    val splitted = arg.split(":")
                    mapLoc = File(splitted[1])
                    continue
                }
                if (arg.startsWith("-jar:")) {
                    val splitted = arg.split(":")
                    jarLoc = File(splitted[1])
                    continue
                }
            }
            println("Adding JAR to classpath...")
            ClassPool.getDefault().insertClassPath(jarLoc?.absolutePath)
            println("Discovering classes inside of the JAR...")
            val classes = JavaUtil.getAllClasses(jarLoc)
            println("Parsing obfuscation map...")
            val parser = ObfMapParser()
            val parsedModels = parser.parse(mapLoc!!)
            println("Conducting class models...")
            for (model in parsedModels) {
                if (model is ClassModel) {
                    //TODO
                }
            }
        }
    }
}