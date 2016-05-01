package net.torchpowered.mapapplier;

import cuchaz.enigma.Deobfuscator;
import cuchaz.enigma.mapping.MappingParseException;
import cuchaz.enigma.mapping.Mappings;
import cuchaz.enigma.mapping.MappingsReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URISyntaxException;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class Launch {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException, IOException{
        Logger logger = LoggerFactory.getLogger("MapApplier");
        if(args.length < 1){
            logger.info("Oops! You didn't startup MapApplier with any parameters. Try doing the ? or help parameter to see help guide.");
            return;
        }
        if(args[0].equalsIgnoreCase("?") || args[0].equalsIgnoreCase("help")){
            logger.info("Usage: java -jar mapapplier.jar <mappingfile> <inputjar> <outputjar>");
            return;
        }
        File mappingFile = new File(args[0]);
        File inputJar = new File(args[1]);
        File outputJar = new File(args[2]);
        if(!mappingFile.exists()){
            logger.error("Mapping file doesn't exist!");
            return;
        }
        if(!inputJar.exists()){
            logger.error("Input JAR file doesn't exist!");
            return;
        }
        if(!outputJar.exists()){
            
            // instead of throwing an error, just create it.
            
            outputJar.mkdirs();
            // input file 
            FileInputStream in = new FileInputStream(new File(Launch.class.getResource("/net/torchpowered/mapapplier/.mapapplier").toURI()));

            // out put file 
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputJar.getAbsolutePath()));

            // name the file inside the zip  file 
            out.putNextEntry(new ZipEntry(".mapapplier")); 

            // buffer size
            byte[] b = new byte[1024];
            int count;

            while ((count = in.read(b)) > 0) {
                System.out.println();
                out.write(b, 0, count);
            }
            out.close();
            in.close();
        }
        logger.info("=========================");
        logger.info("       MAPAPPLIER        ");
        logger.info("    APPLYING MAPPINGS    ");
        logger.info("=========================");
        JarFile jarFile;
        Deobfuscator deobfuscator;
        try {
            jarFile = new JarFile(inputJar);
            deobfuscator = new Deobfuscator(jarFile);
        } catch (Exception e){
            logger.error("Failed to convert file to JAR object and create a new deobfuscator object.");
            e.printStackTrace();
            return;
        }
        MappingsReader mappingsReader = new MappingsReader();
        logger.info("Reading mappings...");
        FileReader fileReader;
        try {
            fileReader = new FileReader(mappingFile);
        } catch (FileNotFoundException e) {
            logger.error("Failed to load mappings!");
            e.printStackTrace();
            return;
        }
        Mappings theMappings;
        try {
            theMappings = mappingsReader.read(fileReader);
        } catch (IOException e) {
            logger.error("Failed to read mappings!");
            e.printStackTrace();
            return;
        } catch (MappingParseException e) {
            logger.error("Could not parse the mappings!");
            e.printStackTrace();
            return;
        }
        deobfuscator.setMappings(theMappings);
        Deobfuscator.ProgressListener progressListener = new Deobfuscator.ProgressListener() {
            public void init(int i, String s) {

            }

            public void onProgress(int i, String s) {

            }
        };
        logger.info("=========================");
        logger.info("       MAPAPPLIER        ");
        logger.info("      EXPORTING JAR      ");
        logger.info("=========================");
        deobfuscator.writeJar(outputJar, progressListener);
        logger.info("=========================");
        logger.info("       MAPAPPLIER        ");
        logger.info("     BUILD SUCCESSS      ");
        logger.info("=========================");
    }
}
