package kamauro.facade.conversores;

import java.io.File;

import kamauro.facade.conversor.Codec;
import kamauro.facade.conversor.MPEG4CompressionCodec;
import kamauro.facade.conversor.OggCompressionCodec;
import kamauro.facade.model.VideoFile;

/**
 * @author Mauricio
 * Acompanhe mais exemplos no site a seguir
 * @see https://refactoring.guru/pt-br/design-patterns/java
 */

public class VideoConversionFacade {

    public File convertVideo(String fileName, String format) {

        System.out.println("VideoConversionFacade: Conversão iniciada.");

        VideoFile file = new VideoFile(fileName);
        Codec sourceCodec = CodecFactory.extract(file);
        Codec destinationCodec;

        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        VideoFile buffer = BitrateReader.read(file, sourceCodec);
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
        File result = (new AudioMixer()).fix(intermediateResult);
        
        System.out.println("VideoConversionFacade: Conversão completa.");

        return result;
    }
    
}
