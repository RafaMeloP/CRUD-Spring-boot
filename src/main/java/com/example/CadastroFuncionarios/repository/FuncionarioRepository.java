package com.example.CadastroFuncionarios.repository;

import com.example.CadastroFuncionarios.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    public Funcionario findByFirstNameIgnoreCase(String name);
}
