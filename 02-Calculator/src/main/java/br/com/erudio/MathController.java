package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET) // quando não especifica, ele entende como GET
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo); 
		
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for subtraction");
		}
		
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sub;
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for multiplication");
		}
		
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return mult;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for division");
		}
		
		Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return div;
	}
	
	@RequestMapping(value="/sqrt/{number}")
	public Double sqrt(@PathVariable("number") String number) throws Exception {
		if(!isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for square");
		}
		
		Double sqrt = Math.sqrt(convertToDouble(number));
		return sqrt;
	}
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D; // 0 Double 
		String number = strNumber.replace(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D; // 0 Double
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}