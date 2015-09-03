package eu.ludimus.web.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping(value="/")
public class EncryptionController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "sha", method = RequestMethod.GET)
	public String sha(Model model) {
		return "sha/index";
	}
	
	@RequestMapping(value = "md5", method = RequestMethod.GET)
	public String md5(Model model) {
		return "md5/index";
	}

	@RequestMapping(value = "calculateSha", method = RequestMethod.POST)
	public String calculateSha(Model model
			,@RequestParam(value="value", required=true) String value
			,@RequestParam(value="sha", required=true) String sha) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance(sha);
		messageDigest.update(value.getBytes());
		model.addAttribute("value", value);
		model.addAttribute("result", toHex(messageDigest.digest()));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		return "sha/index";
	}
	
	@RequestMapping(value = "calculateMd5", method = RequestMethod.POST)
	public String calculateMd5(Model model
			,@RequestParam(value="value", required=true) String value
			,@RequestParam(value="md5", required=true) String md5) {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance(md5);
			messageDigest.update(value.getBytes());
			model.addAttribute("value", value);
			model.addAttribute("result", toHex(messageDigest.digest()));
		} catch (NoSuchAlgorithmException e) {
			logger.error(e.getMessage(), e);
		}
		return "md5/index";
	}
	
	private String toHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		if(bytes == null)
			return sb.toString();
	    for (byte b : bytes) {
	        sb.append(String.format("%02x", b));
	    }
	    return sb.toString();
	}
	
	
}
