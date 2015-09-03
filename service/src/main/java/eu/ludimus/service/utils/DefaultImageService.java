package eu.ludimus.service.utils;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DefaultImageService implements ImageService {
	private final Logger logger = Logger.getLogger(this.getClass());

	public byte[] resize(byte[] image, int newWidth, int newHeight) {
		BufferedImage result;

		try {
			result = ImageIO.read(new ByteArrayInputStream(image));
            if(result == null) {
                logger.warn("byte[] is not an image");
                return null;
            }

			if (newWidth == 0 || newHeight == 0) {
				logger.warn(String.format(
						"No valid width : %s  or height : %s", newWidth,
						newHeight));
				return null;
			}

			int originalWidth = result.getWidth();
			int originalHeight = result.getHeight();

			if (originalWidth > newWidth && originalHeight > newHeight) { /** only resize when it'ssmaller*/
				double scaleX = (double) newWidth / originalWidth;
				double scaleY = (double) newHeight / originalHeight;
				AffineTransformOp transformation = new AffineTransformOp(
						AffineTransform.getScaleInstance(scaleX, scaleY),
						AffineTransformOp.TYPE_BILINEAR);

				BufferedImage scaledLogoImage = transformation
						.createCompatibleDestImage(result, null);
				transformation.filter(result, scaledLogoImage);

                result = scaledLogoImage;
			}
			return toByteArray(result);
		} catch (IOException e) {
			logger.warn("Image could not be read", e);
			return null;
		}
	}

    @Override
    public byte[] toJpg(byte[] originalImage) {
        if(originalImage == null) {
            return null;
        }
        try {
            return toByteArray(ImageIO.read(new ByteArrayInputStream(originalImage)));
        } catch (IOException e) {
            logger.warn("Image could not be read", e);
        }
        return null;
    }

    private byte[] toByteArray(BufferedImage image) throws IOException {
        if(image == null) {
            return null;
        }
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "jpg", baos);
		return baos.toByteArray();
	}
}
