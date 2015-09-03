package eu.ludimus.service.utils;

public interface ImageService {
	/**
	 * Resize image only if newWidt and newHeight is smaller then the actual image size
	 * @param image the image
	 * @param newWidth the new width
	 * @param newHeight the new height
	 * @return byte[] which is the resized image
	 */
	public byte[] resize(byte[] image, int newWidth, int newHeight);

    public byte[] toJpg(byte[] originalImage);
}
