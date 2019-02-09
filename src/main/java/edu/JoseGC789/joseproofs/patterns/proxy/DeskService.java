package edu.JoseGC789.joseproofs.patterns.proxy;

/**
 * Possible view for desktops
 */
public final class DeskService implements WebViewable{

    private static final String CONTENT = "Desk view for: ";

    @Override
    public String view(final Request request){
        return CONTENT + request.getContent();
    }
}
