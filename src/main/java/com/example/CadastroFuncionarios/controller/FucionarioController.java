package com.example.CadastroFuncionarios.controller;

import com.example.CadastroFuncionarios.entity.Funcionario;
import com.example.CadastroFuncionarios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FucionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public List<Funcionario> fetchFuncionarios(){
        return funcionarioService.fetchFuncionarios();
    }

    @GetMapping("/funcionario/{id}")
    public Funcionario fetchFuncionarioById(@PathVariable Long id){
        return funcionarioService.fetchFuncionarioById(id);
    }

    @GetMapping("/funcionario/name/{name}")
    public Funcionario fetcFuncionarioByName(@PathVariable String name){
        return funcionarioService.fetchFuncionarioByName(name);
    }

    @PostMapping("/funcionario")
    public Funcionario saveFuncionario(@RequestBody Funcionario funcionario){
        return funcionarioService.saveFuncionario(funcionario);
    }

    @PutMapping("/funcionario/{id}")
    public Funcionario updateFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return funcionarioService.updateFuncionario(id, funcionario);
    }

    @DeleteMapping("/funcionario/{id}")
    public String deleteFuncionario(@PathVariable Long id){
        funcionarioService.deleteFuncionario(id);
        return "Funcionario excluído com sucesso";
    }
}
