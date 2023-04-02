package br.edu.ufrb.aluno.fetch.entities;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

public class ArmarioDeMedicamentos {
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    
    //Getters e Setters
    public ArrayList<Medicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public ResponseEntity<String> setMedicamentos(Medicamento placebo) {
        if(!placebo.getCodigo().isEmpty() && placebo.getQuantidade() > 0 && placebo.getPesoEmGramas() > 0 && !placebo.getNome().isEmpty() && !placebo.getFabricante().isEmpty()){
            this.medicamentos.add(placebo);
            return ResponseEntity.ok("ok");
        }
        
        
        throw new IllegalArgumentException("temos um parametro invalido");
    }
    
}
