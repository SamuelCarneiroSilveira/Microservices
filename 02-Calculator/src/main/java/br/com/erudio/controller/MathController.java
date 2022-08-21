package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;
import br.com.erudio.math.SimpleMath;
import br.com.erudio.request.converters.NumberConverter;


@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET) // quando não especifica, ele entende como GET
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}		
		return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}",method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for subtraction");
		}
		return math.sub(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for multiplication");
		}
		
		return math.mult(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for division");
		}
		return math.div(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/sqrt/{number}")
	public Double sqrt(@PathVariable("number") String number) throws Exception {
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value for square");
		}
		
		return math.sqrt(NumberConverter.convertToDouble(number));
	}


}