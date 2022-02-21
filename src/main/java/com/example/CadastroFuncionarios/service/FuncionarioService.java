package com.example.CadastroFuncionarios.service;

import com.example.CadastroFuncionarios.entity.Funcionario;

import java.util.List;

public interface FuncionarioService {
    public List<Funcionario> fetchFuncionarios();

    public Funcionario saveFuncionario(Funcionario funcionario);

    public Funcionario fetchFuncionarioById(Long id);

    public Funcionario fetchFuncionarioByName(String name);

    public Funcionario updateFuncionario(Long id, Funcionario funcionario);

    public void deleteFuncionario(Long id);
}
