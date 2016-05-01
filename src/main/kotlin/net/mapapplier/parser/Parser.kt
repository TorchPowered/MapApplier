package net.mapapplier.parser

import net.mapapplier.model.Model
import java.io.File

/**
 * Represents an obfuscation map parser.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
interface Parser {
    /**
     * Parses a file.
     */
    fun parse(file: File) : Array<Model>
}