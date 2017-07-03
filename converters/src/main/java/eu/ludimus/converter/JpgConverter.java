package eu.ludimus.converter;

import java.io.InputStream;

public interface JpgConverter {
    byte[] toJpg(final InputStream input) throws ConvertException;
}
