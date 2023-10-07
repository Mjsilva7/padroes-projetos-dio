package kamauro.facade.conversores;

import kamauro.facade.conversor.Codec;
import kamauro.facade.model.VideoFile;

/**
 * @author Mauricio
 * Acompanhe mais exemplos no site a seguir
 * @see https://refactoring.guru/pt-br/design-patterns/java
 */

public class BitrateReader {

    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: Lendo...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: Escrevendo...");
        return buffer;
    }
    
}
