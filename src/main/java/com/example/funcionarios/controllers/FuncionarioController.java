package com.example.funcionarios.controllers;

import com.example.funcionarios.models.FuncionarioModel;
import com.example.funcionarios.services.FuncionarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/funcionarios")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<List<FuncionarioModel>> findAll(){
        List<FuncionarioModel> response = funcionarioService.findAll();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioModel> findById(@PathVariable Long id){
        FuncionarioModel response = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok().body(response);
    }
    @PostMapping
    public ResponseEntity<FuncionarioModel> criar(@RequestBody FuncionarioModel funcionarioModel){
        FuncionarioModel response = funcionarioService.criar(funcionarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioModel> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel funcionarioModel) {
        FuncionarioModel response = funcionarioService.atualizar(funcionarioModel, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
