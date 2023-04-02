package br.edu.ufrb.aluno.fetch.entities;

import java.util.ArrayList;

public class ArmarioDeMedicamentos {
    private ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
    
    //Getters e Setters
    public ArrayList<Medicamento> getMedicamentos() {
        return this.medicamentos;
    }

    public void setMedicamentos(Medicamento placebo) {
        this.medicamentos.add(placebo);
    }
    
}
