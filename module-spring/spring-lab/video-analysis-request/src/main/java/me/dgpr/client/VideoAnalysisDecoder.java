package me.dgpr.client;

import feign.Response;
import feign.codec.ErrorDecoder;

public class VideoAnalysisDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        throw new IllegalStateException();
    }
}
