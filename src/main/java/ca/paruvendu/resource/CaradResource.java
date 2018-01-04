package ca.paruvendu.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
			
			List<MultipartFile> multi = multipartRequest.  getFiles("uploads[]");
	
			int i=1;
						
			File theDir = new File("src/main/resources/static/image/carad/"+id);
        	saveFilesToServer(multi,id);
		
			// if the directory does not exist, create it
//			if (!theDir.exists()) {
//			    System.out.println("creating directory: " + theDir.getName());
//			    boolean result = false;
//
//			    try{
//			        theDir.mkdir();
//			        result = true;
//			    } 
//			    catch(SecurityException se){
//			        //handle it
//			    }        
//			    if(result) {    
//			        System.out.println("DIR created");  
//			    }
//			}
			
			
//			while ( it.hasNext() )
//			{
//			MultipartFile multipartFile = multipartRequest.getFile(it.next());
//			String fileName = id+i+ ".png";
//            String reponame=id;
//            
//           logger.info("----->"+ multipartFile.getName());
//			byte[] bytes = multipartFile.getBytes();
//			BufferedOutputStream stream = new BufferedOutputStream(
//					new FileOutputStream(new File("src/main/resources/static/image/carad/"+reponame+"/" + fileName)));
//			stream.write(bytes);
//			stream.close();
//			i++;
//			}
			return new ResponseEntity("Upload Success!", HttpStatus.OK);
		
		
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	  public void saveFilesToServer(List<MultipartFile> multipartFiles, String id) throws IOException {
		  	String directory = "src/main/resources/static/image/carad/"+id;
			int i=1;
		  	File file = new File(directory);
			file.mkdirs();
			for (MultipartFile multipartFile : multipartFiles) {
				file = new File(directory+"/" + id+i+".png");
				IOUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
				i++;
			}
		  }
	  
	  @RequestMapping(value="caradList", method=RequestMethod.GET)
	  public List<Carad> getCaradLsit(){
		return   caradService.findAll();
		  
	  }
	  
	  @RequestMapping("/{id}")
	  public Carad getCaradById(@PathVariable("id")  String id){
		  ObjectMapper mapper = new ObjectMapper();
			//Convert object to JSON string
		 Carad carad= caradService.findById(id);
			String jsonInString;
			try {
				jsonInString = mapper.writeValueAsString(carad);
				System.out.println(jsonInString);
				 logger.info("jsonInString---> "+jsonInString);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		  
		  logger.info("id---> "+id);
		  return carad;
	  }
	

}
