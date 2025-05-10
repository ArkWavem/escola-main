package com.senai.escola.Controller;

import com.senai.escola.Service.AlunoService;
import com.senai.escola.model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> listaDeAluno() {
        return alunoService.buscarAlunos();
    }

    @GetMapping("/id")
    public Aluno buscarAluno(@PathVariable Long id) {
        return alunoService.buscarAlunoId(id);
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvaAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAlterado) {

        Aluno verficaAluno = alunoService.buscarAlunoId(id);
        if (verficaAluno ==  null) return null;
        verficaAluno.setNomeAluno(alunoAlterado.getNomeAluno());
        verficaAluno.setEmailAluno(alunoAlterado.getEmailAluno());
        verficaAluno.setTelefoneAluno(alunoAlterado.getTelefoneAluno());
        return alunoService.salvaAluno(verficaAluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
    }

}
