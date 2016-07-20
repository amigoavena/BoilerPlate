package org.elavena.util;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elavena.domain.IOTObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.HttpMessageConverterExtractor;

public class IOTResponseExtractor extends HttpMessageConverterExtractor<IOTObject> {
	
	private static final Logger log = LogManager.getLogger(IOTResponseExtractor.class);

	public IOTResponseExtractor (Class<IOTObject> responseType,
	      List<HttpMessageConverter<?>> messageConverters) {
	        super(responseType, messageConverters);
	    }

	@Override
	public IOTObject extractData(ClientHttpResponse response) throws IOException {

		IOTObject result;
		log.debug(response.getStatusCode());
		log.debug(response.getBody());

		if (response.getStatusCode() == HttpStatus.OK) {
			result = super.extractData(response);
		} else {
			result = null;
		}

		return result;
	}

}
