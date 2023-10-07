package kamauro.facade;

import java.io.File;

import kamauro.facade.conversores.VideoConversionFacade;

/**
 * Interface simples para uma biblioteca de conversão de vídeo complexa
 * neste exemplo, o Facade simplifica a comunicação com uma estrutura complexa de conversão de vídeo.
 * O Facade fornece a uma única classe com um método único que lida com toda a complexidade de configurar 
 * as classes corretas da estrutura e recuperar o resultado em um formato correto.
 * S A I D A
 * VideoConversionFacade: Conversão iniciada.
 * CodecFactory: Extraindo audio ogg...
 * BitrateReader: Lendo...
 * BitrateReader: Escrevendo...
 * AudioMixer: Verificando audio...
 * VideoConversionFacade: Conversão completa.
 */

public class Main {

    public static void main(String[] args) {
        VideoConversionFacade converter = new VideoConversionFacade();
        File mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4");

       
    }
    
}
