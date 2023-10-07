package kamauro.singleton;
public class Main {
    
    public static void main(String[] args) {

        System.out.println("Se vier o mesmo valor, então o singleton foi reutilizado...oba!" + "\n" +
                "Se for valores diferentes, então foram criados 2 singletons...booo!! volte e reavalie o que está de errado" + "\n\n" +
                "RESULTADO:" + "\n");
                
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton outroSingleton = Singleton.getInstance("BAR");
       
        System.out.println(singleton.value);
        System.out.println(outroSingleton.value);
        
    }
}
