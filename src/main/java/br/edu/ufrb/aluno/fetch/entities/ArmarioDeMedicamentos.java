package br.edu.ufrb.aluno.fetch.entities;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ArmarioDeMedicamentos {
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    
    
    //Getters e Setters
    public ArrayList<Medicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public ResponseEntity<String> setMedicamentos(Medicamento placebo) {
        
        if(placebo.getQuantidade() > 0 && placebo.getPesoEmGramas() > 0 && !placebo.getNome().isEmpty() && !placebo.getFabricante().isEmpty()){
            this.medicamentos.add(placebo);
            return ResponseEntity.ok("ok");
        }
    
        
        throw new IllegalArgumentException("temos um parametro invalido");
    }
    
    public ArrayList<Medicamento> searchMedicamento(String identificador){
        ArrayList<Medicamento> medicamentosProcurados = new ArrayList<Medicamento>();
        for (Medicamento medicamento: this.medicamentos){

            //juntando o nome e o codigo do medicamento em uma string só
            String identificadorMedicamento = medicamento.getNome() + " " + medicamento.getCodigo();

            //verificando se o identificador bate com o codigo ou o nome do medicamento
            if(identificadorMedicamento.toLowerCase().contains(identificador.toLowerCase())){
                medicamentosProcurados.add(medicamento);
            }
            
        }

        return medicamentosProcurados;
    }

    public ResponseEntity<String> removeMedicamento(String codigo){
        for (Medicamento medicamento: this.medicamentos){

            if(medicamento.getCodigo().equals(codigo)){
                this.medicamentos.remove(medicamento);
                return new ResponseEntity<>("Medicamento removido com sucesso.", HttpStatus.OK);
            }
            
        }
        return new ResponseEntity<>("Medicamento não encontrado.", HttpStatus.NOT_FOUND);
    }
   
    public ResponseEntity<String> editMedicamento(String codigoAntigo, String codigoNovo, int quantidade, int peso, boolean generico, boolean tarjaPreta, String nome, String fabricante, String info){
        /*codigo, 
    int quantidade, 
    int pesoEmGramas,
    boolean statusGenerico, 
    boolean statusTarjaPreta,
    String nome, 
    String fabricante, 
    String outrasInformacoes */
        Medicamento medicamentoEditado = new Medicamento(codigoNovo, 
        quantidade, 
        peso,
        generico, 
        tarjaPreta, 
        nome, 
        fabricante, 
        info);

        for(int i = 0; i < this.medicamentos.size(); i++){
            if(this.medicamentos.get(i).getCodigo().equals(codigoAntigo)){
                //System.out.println("entrei no if");
                this.medicamentos.set(i, medicamentoEditado);
                return new ResponseEntity<>("Medicamento editado com sucesso.", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Medicamento não editado.", HttpStatus.NOT_FOUND);
    }
}
