package it.eng.unipa.projectwork.channel.websocket;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class SampleEncoder implements Encoder.Text<Message> {

        @Override
        public String encode(Message message) {
            return message.toString();
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