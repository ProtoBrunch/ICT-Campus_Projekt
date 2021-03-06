package WebCamChat.Client;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.nio.ByteBuffer;

/**
 * Logik des Clients.
 * Created by meiersila on 30.03.2017.
 */
public class ServerInputProcessor {

    /**
     * Webcam Bild wird zum bytearray.
     * @param webcam Frame von der Webcam
     * @return Umgewandeltes Frame wird als Bytearray zurück gegeben.
     */
    public byte[] webcamImageToByteArray(Webcam webcam){
        ByteBuffer byteBuffer = webcam.getImageBytes();
        byte[] data = new byte[byteBuffer.capacity()];
        ((ByteBuffer) byteBuffer.duplicate().clear()).get(data);
        return data;
    }

    /**
     *
     * @param webcamArray ByteArray von der Webcam
     * @return ImageIcon für JLabel.
     */
    public ImageIcon byteArrayToImageIcon(byte[] webcamArray, int byteArrayLength){
        BufferedImage img = createRGBImage(webcamArray, (int) WebcamResolution.VGA.getSize().getWidth(), (int)WebcamResolution.VGA.getSize().getHeight(), byteArrayLength );
        return new ImageIcon(img);
    }

    /**
     * Aus den Parametern wird ein neues BufferedImage erstellt
     * @param bytes Bytesarray von der Webcam
     * @param width Breite des ursprünglichen Bildes
     * @param height Höhe des urpsrünglichen Bildes
     * @return BufferedImage wird zurück gegeben.
     */
    private static BufferedImage createRGBImage(byte[] bytes, int width, int height, int byteArrayLength) {
        DataBufferByte buffer = new DataBufferByte(bytes, byteArrayLength);
        ColorModel cm = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB), new int[]{8, 8, 8}, false, false, Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
        return new BufferedImage(cm, Raster.createInterleavedRaster(buffer, width-1, height-1, (width * 3)-1, 3, new int[]{0, 1, 2}, null), false, null);
    }
}
