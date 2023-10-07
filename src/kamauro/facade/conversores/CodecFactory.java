package kamauro.facade.conversores;

import kamauro.facade.conversor.Codec;
import kamauro.facade.conversor.MPEG4CompressionCodec;
import kamauro.facade.conversor.OggCompressionCodec;
import kamauro.facade.model.VideoFile;

/**
 * @author Mauricio
 * Acompanhe mais exemplos no site a seguir
 * @see https://refactoring.guru/pt-br/design-patterns/java
 */

public class CodecFactory {

    public static Codec extract(VideoFile file) {
        
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: Extraindo audio mpeg...");
            return new MPEG4CompressionCodec();
        }
        else {
            System.out.println("CodecFactory: Extraindo audio ogg...");
            return new OggCompressionCodec();
        }
    }
    
}
