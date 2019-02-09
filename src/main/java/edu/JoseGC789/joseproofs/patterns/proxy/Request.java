package edu.JoseGC789.joseproofs.patterns.proxy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Request data class
 */
@Getter
@ToString
@EqualsAndHashCode
public final class Request{
    private final DeviceType deviceType;
    private final String content;

    public Request(DeviceType deviceType, String content){
        this.deviceType = deviceType;
        this.content = content;
    }
}
