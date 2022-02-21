package com.example.CadastroFuncionarios.service;

import com.example.CadastroFuncionarios.entity.Funcionario;
import com.example.CadastroFuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{
    @Autowired
    FuncionarioRepository funcionarioRepository;
    @Override
    public List<Funcionario> fetchFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario saveFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario fetchFuncionarioById(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Funcionario fetchFuncionarioByName(String name) {
        return funcionarioRepository.findByFirstNameIgnoreCase(name);
    }

    @Override
    public Funcionario updateFuncionario(Long id, Funcionario funcionario) {
        Funcionario funcionarioDb = funcionarioRepository.findById(id).get();

        if(funcionario.getFirstName() == null || "".equalsIgnoreCase(funcionario.getFirstName())){
            funcionario.setFirstName(funcionarioDb.getFirstName());
        }
        if(funcionario.getLastName() == null || "".equalsIgnoreCase(funcionario.getLastName())){
            funcionario.setLastName(funcionarioDb.getLastName());
        }
        if(funcionario.getEmail() == null || "".equalsIgnoreCase(funcionario.getEmail())){
            funcionario.setEmail(funcionarioDb.getEmail());
        }
        funcionario.setId(funcionarioDb.getId());

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public void deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
