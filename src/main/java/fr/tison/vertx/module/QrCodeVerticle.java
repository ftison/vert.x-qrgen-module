package fr.tison.vertx.module;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;
import org.vertx.java.platform.Verticle;

/**
 * This module receives a JSON containing the value to encode in QRCode
 */
public class QrCodeVerticle extends Verticle {
    private static final String MODULE_ADDRESS = "fr.tison.qrcode.generator";

    @Override
    public void start() {
        EventBus eb = vertx.eventBus();
        Handler<Message<JsonObject>> myHandler = new Handler<Message<JsonObject>>() {
            @Override
            public void handle(Message<JsonObject> in) {
                in.reply(QrCodeImpl.generateImage(in.body().getString("value")));
            }
        };

        eb.registerHandler(MODULE_ADDRESS, myHandler);
    }
}