package eu.ludimus.service.dto.validation;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import eu.ludimus.service.dto.TicketDto;

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
		
		if(ticketDto.getTicketImage() == null || ticketDto.getTicketImage().length == 0)
			return true;
		try {
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(ticketDto.getTicketImage()));
			if(image == null)
				return false;
		} catch(IOException e) {
			return false;
		}
		return true;
	}
}
