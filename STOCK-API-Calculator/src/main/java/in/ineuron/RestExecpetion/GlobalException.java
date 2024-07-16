package in.ineuron.RestExecpetion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.exception.StockNotFoundException;

@RestControllerAdvice

public class GlobalException {
	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<?> showtheReason(StockNotFoundException e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> showtheReasonGlobally(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);		
	}
}
