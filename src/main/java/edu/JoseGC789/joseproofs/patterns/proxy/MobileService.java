package edu.JoseGC789.joseproofs.patterns.proxy;

/**
 * Possible view for mobiles
 */
public final class MobileService implements WebViewable{

    private static final String CONTENT = "Mobile view for: ";

    @Override
    public String view(final Request request){
        return CONTENT + request.getContent();
    }
}
