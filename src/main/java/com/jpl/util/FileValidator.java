package com.jpl.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jpl.ui.model.UploadedFile;

	public class FileValidator implements Validator{

		public boolean supports(Class<?> clazz) {  
		  // TODO Auto-generated method stub  
		  return false;  
		 }  
		  
		 public void validate(Object uploadedFile, Errors errors) {  
		  
		  UploadedFile file = (UploadedFile) uploadedFile;  
		  
		  if (file.getFile().getSize() == 0) {  
		   errors.rejectValue("file", "uploadForm.salectFile",  
		     "Please select a file!");  
		  }  
		  
		 }	 
		
	}

