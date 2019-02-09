package edu.JoseGC789.joseproofs.patterns.proxy;

import static edu.JoseGC789.joseproofs.patterns.proxy.DeviceType.DESK;
import static edu.JoseGC789.joseproofs.patterns.proxy.DeviceType.MOBILE;

/**
 * Proxy pattern with singleton implementation for a typical micro-service api
 */
public enum ProxyService implements WebViewable{
    INSTANCE;

    private static final String INCORRECT = "Incorrect request's state";

    @Override
    public String view(final Request request){
        switch(request.getDeviceType()){
            case MOBILE:
                return new MobileService().view(request);
            case DESK:
                return new DeskService().view(request);
        }
        throw new IllegalStateException(INCORRECT);
    }

    public static void main(String[] args){
        final WebViewable service = ProxyService.INSTANCE;
        final Request mobile = new Request(MOBILE, "Mobile request");
        final Request desk = new Request(DESK, "Desk request");
        System.out.println(service.view(mobile));
        System.out.println(service.view(desk));
    }
}

