package kamauro.facade.model;

/**
 * @author: Mauricio
 * Acompanhe mais exemplos no site a seguir
 * @see https://refactoring.guru/pt-br/design-patterns/java
 */

public class VideoFile {

    private String nome;
    private String codecType;

    public VideoFile(String nome) {
        this.nome = nome;
        this.codecType = nome.substring(nome.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getNome() {
        return nome;
    }
}
    

