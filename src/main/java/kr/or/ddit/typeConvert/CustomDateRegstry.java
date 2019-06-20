package kr.or.ddit.typeConvert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDateRegstry implements PropertyEditorRegistrar{
	private static final Logger logger = LoggerFactory.getLogger(CustomDateRegstry.class);

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		
		logger.debug("CustomDateRegstry");
		
		registry.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		
	}

}
