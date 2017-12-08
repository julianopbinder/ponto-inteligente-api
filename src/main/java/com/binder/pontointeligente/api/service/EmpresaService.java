package com.binder.pontointeligente.api.service;

import java.util.Optional;

import com.binder.pontointeligente.api.entities.Empresa;

public interface EmpresaService {

Optional <Empresa> buscarPorCnpj(String cnpj);	

Empresa persistir(Empresa empresa);

	
}
