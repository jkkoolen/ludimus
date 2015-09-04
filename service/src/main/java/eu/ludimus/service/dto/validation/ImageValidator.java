package eu.ludimus.service.dto.validation;


import eu.ludimus.service.dto.TicketDto;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ImageValidator implements ConstraintValidator<CheckImage, TicketDto> {

	@Override
	public void initialize(CheckImage arg0) {
	}

	@Override
	public boolean isValid(TicketDto ticketDto, ConstraintValidatorContext context) {
		context
        .buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
        .addPropertyNode("ticketImage").addConstraintViolation()
        .disableDefaultConstraintViolation();
		
		if(ticketDto.ticketImage() == null || ticketDto.ticketImage().length == 0)
			return true;
		try {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(ticketDto.ticketImage()));
			if(image == null)
				return false;
		} catch(IOException e) {
			return false;
		}
		return true;
	}
}
