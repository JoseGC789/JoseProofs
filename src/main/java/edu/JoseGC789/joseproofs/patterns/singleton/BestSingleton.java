package edu.JoseGC789.joseproofs.patterns.singleton;

/**
 * Enum version of singleton and the best version.
 * Be aware that this type of singleton only supports EAGER initialization.
 * If for some reason you require LAZY initialization, then you're out of luck.
 */
enum BestConnection{
    INSTANCE("My only connect instance");

    private final String connection;

    BestConnection(String connection){
        this.connection = connection;
    }

    public String connect(){
        return connection;
    }
}

/**
 * Demonstration
 */
public final class BestSingleton{
    public static void main(String[] args){
        final BestConnection mySQL = BestConnection.INSTANCE;
        System.out.println(mySQL.connect());
    }
}
