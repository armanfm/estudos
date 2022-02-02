package br.com.acolher.convert;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.com.acolher.model.CadPessoa;


@Component
public class CadPessoaConvert implements Converter<Long, CadPessoa>{

	@Override
	public CadPessoa convert(Long value) {
		CadPessoa cad = new CadPessoa();
		cad.setIdPessoa(value);
		return new CadPessoa();
	}

}
