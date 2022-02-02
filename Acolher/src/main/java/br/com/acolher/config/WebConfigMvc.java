package br.com.acolher.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.acolher.convert.CadPessoaConvert;


@Configuration
public class WebConfigMvc implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new CadPessoaConvert());  	}

	
	
	

}
