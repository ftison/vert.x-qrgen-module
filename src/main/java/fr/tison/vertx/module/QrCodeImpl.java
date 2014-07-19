package fr.tison.vertx.module;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.vertx.java.core.buffer.Buffer;

import java.io.File;

/**
 * QRCode creation
 */
public class QrCodeImpl {
    public static Buffer generateImage(String value) {
        return new Buffer(QRCode.from(value).to(ImageType.JPG).stream().toByteArray());
    }
}
