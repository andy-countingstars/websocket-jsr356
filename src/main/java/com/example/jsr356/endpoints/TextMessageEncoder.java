package com.example.jsr356.endpoints;

import com.example.jsr356.dto.MessageDTO;
import com.example.jsr356.dto.QrMessageDTO;
import com.google.gson.Gson;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * This is Description
 *
 * @author xulongjie
 * @date 2019/10/24
 */
public class TextMessageEncoder implements Encoder.Text<QrMessageDTO> {

    @Override
    public String encode(QrMessageDTO messageDTO) throws EncodeException {
        Gson gson = new Gson();
        return gson.toJson(messageDTO);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }

}
