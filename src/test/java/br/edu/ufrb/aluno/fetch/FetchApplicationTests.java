package br.edu.ufrb.aluno.fetch;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.edu.ufrb.aluno.fetch.entities.Fornecedor;
import br.edu.ufrb.aluno.fetch.entities.ListaFornecedor;
import br.edu.ufrb.aluno.fetch.entities.Medicamento;

@SpringBootTest
class FetchApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void medicamentoPossuiFornecedorCadastrado() {
		Medicamento medicamento = new Medicamento("D0001", 
		2, 
		200,
		true, 
		true,
		"Dipirona", 
		"EMS", 
		"Feito de farinha de mandioca.");

		Fornecedor guezzo = new Fornecedor("GUEZZO FARMA", "1234567891011");
		
		medicamento.setFornecedor(guezzo);
		
		Assertions.assertEquals(medicamento.getFornecedor().getNome(), guezzo.getNome());
	}

}
