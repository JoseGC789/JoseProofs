package edu.JoseGC789.joseproofs.patterns.singleton;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Classic version of singleton...
 * Lazy initialization of its instance.
 * The worst type of singleton you can implement.
 * Don't use this unless you have a valid reason.
 */
@Getter
@ToString
@EqualsAndHashCode
final class LazyConnection{
    private static LazyConnection myLazyConnection;
    private final String content;

    private LazyConnection(final String content){
        this.content = content;
    }

    public static LazyConnection getInstance(){
        if(myLazyConnection == null){
            myLazyConnection = new LazyConnection("My lazy connection");
        }
        return myLazyConnection;
    }
}

/**
 * Classic version of singleton...
 * Eager initialization of its instance.
 * Not the best implementation of singleton.
 * No real reason to use this over the better alternative.
 */
@Getter
@ToString
@EqualsAndHashCode
final class EagerConnection{
    private static final EagerConnection MY_EAGER_CONNECTION = new EagerConnection("My eager connection");
    private final String content;

    private EagerConnection(final String content){
        this.content = content;
    }

    public static EagerConnection getInstance(){
        return MY_EAGER_CONNECTION;
    }
}

/**
 * Demonstration
 */
public final class ClassicSingleton{
    public static void main(String[] args){
        final LazyConnection mySQL = LazyConnection.getInstance();
        final EagerConnection h2 = EagerConnection.getInstance();
        System.out.println(mySQL.getContent());
        System.out.println(h2.getContent());
    }
}
