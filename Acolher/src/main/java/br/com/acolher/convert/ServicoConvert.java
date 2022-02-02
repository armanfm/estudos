package br.com.acolher.convert;

import org.springframework.core.convert.converter.Converter;

import br.com.acolher.model.Servico;

public class ServicoConvert implements Converter<Integer, Servico> {

	@Override
	public Servico convert(Integer value) {
		Servico serv = new Servico();
		serv.setIdServico(value);
		return new Servico();
	}

}
