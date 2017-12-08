package com.binder.pontointeligente.api.repositories;

import static org.junit.Assert.assertEquals;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.binder.pontointeligente.api.entities.Empresa;

 

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")

public class EmpresaRepositoryTest {

	@Autowired
	private EmpresaRepository empresaRepository;
	private static final String CNPJ = "51463645000100";
	
	@org.junit.Before
	public void setUp() throws Exception{
	  Empresa empresa = new Empresa();
	  empresa.setRazaoSocial("Empresa de exemplo");
	  empresa.setCnpj(CNPJ);
	  this.empresaRepository.save(empresa);
    }
	
	@org.junit.After
	public final void tearDown() {
	   this.empresaRepository.deleteAll();	
	}
	
	@Test
	public void testBuscarPorCnpj() {
		Empresa empresa = this.empresaRepository.findByCnpj(CNPJ);
		assertEquals(CNPJ, empresa.getCnpj());
	}
	
}
