package WebCamChat.Client;

import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.nio.ByteBuffer;

/**
 * Created by meiersila on 30.03.2017.
 */
public class ServerInputProcessor {

    public ImageIcon byteArrayToImageIcon(byte[] webcamArray){
        BufferedImage img2 = createRGBImage(webcamArray, (int) WebcamResolution.VGA.getSize().getWidth(), (int)WebcamResolution.VGA.getSize().getHeight());
        return new ImageIcon(img2);
    }

    private static BufferedImage createRGBImage(byte[] bytes, int width, int height) {
        DataBufferByte buffer = new DataBufferByte(bytes, bytes.length);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width, height, width * 3, 3, new int[]{0, 1, 2}, null), false, null);
    }
}
