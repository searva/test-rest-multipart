package test;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MultipartController {
	
		public static class ResponseDTO implements Serializable {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			
			
			private String code;
			private String message;
			
			
			public ResponseDTO(String code, String message) {
				this.code = code;
				this.message = message;
			}
			
			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			
			
			
			
		}
	
	   @RequestMapping(value = "/html/tramits/{uuid}", produces = { "application/json" }, consumes = {
	           "multipart/form-data" }, method = RequestMethod.POST)
	   ResponseEntity<ResponseDTO> postAnnexoFormulariHtml(
	           @PathVariable("uuid") String uuid,
	           @NotNull  @Valid @RequestPart("annexos") String rol,
	           @Valid @RequestPart("file") MultipartFile content){
		   
		   return new ResponseEntity<ResponseDTO>(new ResponseDTO("OK", "anexo guardado"), HttpStatus.CREATED);
		
	}

}
