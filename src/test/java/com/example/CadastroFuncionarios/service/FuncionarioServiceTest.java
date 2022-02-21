package com.example.CadastroFuncionarios.service;

import com.example.CadastroFuncionarios.entity.Funcionario;
import com.example.CadastroFuncionarios.repository.FuncionarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FuncionarioServiceTest {
    @Autowired
    FuncionarioService funcionarioService;
    @MockBean
    FuncionarioRepository funcionarioRepository;

    Funcionario funcionario1 = new Funcionario(1L,"Rafael","Pereira","rafael@gmail.com");
    Funcionario funcionario2 = new Funcionario(2L,"João","Silva","joao@gmail.com");
    Funcionario newFuncionario = new Funcionario(3L, "Maria", "Oliveira", "maria@gmail.com");
    Funcionario updatedFuncionario = new Funcionario(1L, "Rafael","Pereira", "rafael@gmail.com");

    List<Funcionario> funcionarioList = new ArrayList<Funcionario>();


    @BeforeEach
    void setUp() {
        funcionarioList.add(funcionario1);
        funcionarioList.add(funcionario2);

        Mockito.when(funcionarioRepository.findAll()).thenReturn(funcionarioList);
        Mockito.when(funcionarioRepository.findById(1L)).thenReturn(Optional.of(funcionario1));
        Mockito.when(funcionarioRepository.findByFirstNameIgnoreCase("Rafael")).thenReturn(funcionario1);
        Mockito.when(funcionarioRepository.save(newFuncionario)).thenReturn(newFuncionario);
        Mockito.when(funcionarioRepository.save(updatedFuncionario)).thenReturn(updatedFuncionario);
    }

    @Test
    @DisplayName("Receber lista de funcionarios")
    public void getListOfFuncionarios(){
        List<Funcionario> found = funcionarioService.fetchFuncionarios();

        Assertions.assertEquals(funcionarioList.get(0).getFirstName(), found.get(0).getFirstName());
    }
    @Test
    @DisplayName("Receber funcionario pelo id")
    public void getFuncionarioById(){
        Long id = 1L;
        Funcionario found = funcionarioService.fetchFuncionarioById(id);

        Assertions.assertEquals(found.getId(),id);
    }
    @Test
    @DisplayName("Receber funcionario pelo nome")
    public void getFuncionarioByName(){
        String name = "Rafael";
        Funcionario found = funcionarioService.fetchFuncionarioByName(name);

        Assertions.assertEquals(name, found.getFirstName());
    }
    @Test
    @DisplayName("Receber novo funcionario apos cadastrar")
    public void saveAndGetNewFuncionario(){
        Funcionario found = funcionarioService.saveFuncionario(newFuncionario);

        Assertions.assertEquals(newFuncionario.getFirstName(), found.getFirstName());
    }
    @Test
    @DisplayName("Receber funcionario com atributo alterado")
    public void getUpdatedFuncionario(){
        Long id = 1L;
        Funcionario found = funcionarioService.updateFuncionario(id, updatedFuncionario);

        Assertions.assertEquals(found.getLastName(), updatedFuncionario.getLastName());
    }
}