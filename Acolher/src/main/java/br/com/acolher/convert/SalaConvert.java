package br.com.acolher.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


import br.com.acolher.model.Sala;

@Component
public class SalaConvert implements Converter<Integer, Sala>{

	@Override
	public Sala convert(Integer value) {
		Sala sal = new Sala();
		sal.setIdSala(value);
		return new Sala();
	}
}


