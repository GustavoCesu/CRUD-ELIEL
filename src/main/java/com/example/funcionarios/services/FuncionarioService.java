package com.example.funcionarios.services;

import com.example.funcionarios.FuncionariosApplication;
import com.example.funcionarios.models.FuncionarioModel;
import com.example.funcionarios.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> findAll(){return funcionarioRepository.findAll();}

    public FuncionarioModel buscarPorId(Long id){
        return funcionarioRepository.findById(id).get();
    }

    public FuncionarioModel criar(FuncionarioModel funcionarioModel){
        return funcionarioRepository.save(funcionarioModel);
    }

    public void deletar(Long id){
        funcionarioRepository.deleteById(id);
    }

    public FuncionarioModel atualizar(FuncionarioModel funcionariosNew, Long id){
        FuncionarioModel funcionarioModel = funcionarioRepository.findById(id).get();
        funcionarioModel.setNome(funcionariosNew.getNome());
        funcionarioModel.setEndereco(funcionariosNew.getEndereco());
        funcionarioModel.setIdade(funcionariosNew.getIdade());

        return funcionarioRepository.save(funcionarioModel);
    }
}
