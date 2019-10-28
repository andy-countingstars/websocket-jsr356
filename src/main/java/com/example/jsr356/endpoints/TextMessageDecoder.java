package com.example.jsr356.endpoints;


import com.example.jsr356.dto.MessageDTO;
import com.example.jsr356.dto.QrMessageDTO;
import com.google.gson.Gson;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
public class TextMessageDecoder implements Decoder.Text<QrMessageDTO> {
    @Override
    public QrMessageDTO decode(String json) throws DecodeException {
        Gson gson = new Gson();
        return gson.fromJson(json, QrMessageDTO.class);
    }

    @Override
    public boolean willDecode(String s) {
        return true;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
