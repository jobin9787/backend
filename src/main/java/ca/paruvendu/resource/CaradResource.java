package ca.paruvendu.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import ca.paruvendu.domain.Book;
import ca.paruvendu.domain.Carad;
import ca.paruvendu.service.CaradService;

@RestController
@RequestMapping("/carad")
public class CaradResource {

	private static final Logger logger = LoggerFactory.getLogger(CaradResource.class);

	@Autowired
	private CaradService caradService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Carad addCarad(@RequestBody Carad carad) {

		logger.info("Car ad called");
		return caradService.save(carad);

	}

	@RequestMapping(value = "/add/image", method = RequestMethod.POST)
	public ResponseEntity upload(@RequestParam("id") String id, HttpServletResponse response,
			HttpServletRequest request) {
		try {
			Carad carad = caradService.findById(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id + ".png";

			byte[] bytes = multipartFile.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/image/carad/" + fileName)));
			stream.write(bytes);
			stream.close();

			return new ResponseEntity("Upload Success!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}

}
