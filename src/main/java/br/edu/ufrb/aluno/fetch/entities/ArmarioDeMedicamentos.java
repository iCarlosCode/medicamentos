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
        /*ATIVE ANTES DE ENVIAR PARA O PROFESSOR 
        if(placebo.getQuantidade() > 0 && placebo.getPesoEmGramas() > 0 && !placebo.getNome().isEmpty() && !placebo.getFabricante().isEmpty()){*/
            this.medicamentos.add(placebo);
            return ResponseEntity.ok("ok");
        /*}
    
        
        throw new IllegalArgumentException("temos um parametro invalido");*/
    }
    
    public ArrayList<Medicamento> searchMedicamento(String identificador){
        ArrayList<Medicamento> medicamentosProcurados = new ArrayList<Medicamento>();
        for (Medicamento medicamento: this.medicamentos){

            //juntando o nome e o codigo do medicamento em uma string só
            String identificadorMedicamento = medicamento.getNome() + " " + medicamento.getCodigo();

            //verificando se o identificador é ou o codigo ou o nome do medicamento
            if(identificadorMedicamento.contains(identificador)){
                medicamentosProcurados.add(medicamento);
            }
            
        }
        return medicamentosProcurados;
    }

    public void removeMedicamento(String codigo){
        for (Medicamento medicamento: this.medicamentos){

            if(medicamento.getCodigo().equals(codigo)){
                this.medicamentos.remove(medicamento);
            }
            
        }
    }
   
}
