package kamauro.facade.conversores;

import java.io.File;

import kamauro.facade.model.VideoFile;

/**
 * @author Mauricio
 * Acompanhe mais exemplos no site a seguir
 * @see https://refactoring.guru/pt-br/design-patterns/java
 */

public class AudioMixer {

    public File fix(VideoFile result){
        System.out.println("AudioMixer: Verificando audio...");
        return new File("tmp");
    }
}
