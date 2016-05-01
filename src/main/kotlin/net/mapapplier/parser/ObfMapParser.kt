package net.mapapplier.parser

import net.mapapplier.model.ClassModel
import net.mapapplier.model.FieldModel
import net.mapapplier.model.MethodModel
import net.mapapplier.model.Model
import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files

/**
 * The implementation of a parser of an obfuscation map.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
class ObfMapParser : Parser {
    override fun parse(file: File): Array<Model> {
        val modelList: List<Model> = listOf()
        val fileLines: List<String> = Files.readAllLines(file.toPath(), Charset.defaultCharset())
        for (line in fileLines) {
            if (line.startsWith("#")) {
                continue
            }
            if (line.isBlank()) {
                continue
            }
            if (line.startsWith("CLASS:")) {
                val splitted: List<String> = line.split(":");
                val cleanerString: String = splitted[1]
                val trimmedString: String = cleanerString.trim()
                val parameters: List<String> = trimmedString.split(" ")
                modelList.plus(ClassModel(parameters[1], parameters[0]))
                continue
            }
            if (line.startsWith("METHOD:")) {
                val splitted: List<String> = line.split(":");
                val cleanerString: String = splitted[1]
                val trimmedString: String = cleanerString.trim()
                val parameters: List<String> = trimmedString.split(" ")
                modelList.plus(MethodModel(parameters[0], parameters[4], parameters[1], parameters[2], parameters[3]))
                continue
            }
            if (line.startsWith("FIELD:")) {
                val splitted: List<String> = line.split(":");
                val cleanerString: String = splitted[1]
                val trimmedString: String = cleanerString.trim()
                val parameters: List<String> = trimmedString.split(" ")
                modelList.plus(FieldModel(parameters[0], parameters[4], parameters[1], parameters[2], parameters[3]))
                continue
            }
        }
        return modelList.toTypedArray()
    }
}