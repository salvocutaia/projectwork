package it.eng.unipa.projectwork.channel.websocket;

import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class SampleDecoder implements Decoder.Text<Message> {

        @Override
        public Message decode(String s) {
            return new Message();
        }

        @Override
        public boolean willDecode(String s) {
            return true;
        }

        @Override
        public void init(EndpointConfig config) {
            // do nothing.
        }

        @Override
        public void destroy() {
            // do nothing.
        }
    }