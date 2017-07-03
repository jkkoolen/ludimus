package eu.ludimus.converter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

class Image2JpgConverter implements JpgConverter {
    @Override
    public byte[] toJpg(final InputStream input) throws ConvertException {
        try {
            return toByteArray(ImageIO.read(input));
        } catch (IOException e) {
            throw new ConvertException(e);
        }
    }

    private byte[] toByteArray(BufferedImage image) throws IOException {
        if(image == null) {
            return new byte[0];
        }
        // create a blank, RGB, same width and height, and a white background
        final int width = image.getWidth();
        final int height = image.getHeight();
        BufferedImage newImage = new BufferedImage(width,
                height, BufferedImage.TYPE_INT_RGB);
        newImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(newImage, "JPEG", baos);
        return baos.toByteArray();
    }
}
