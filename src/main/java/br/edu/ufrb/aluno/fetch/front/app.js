function start(){
    requestGet();
}
function requestGet(){
    console.log("Função Get foi ativada")
    
    const response = fetch("http://localhost:8080/api/armario/get/medicamentos")
    .then( function (responseData){
           return responseData.json()
    })
     .then(function(jsonData){
        console.log(jsonData)
            let ul = document.createElement('ul');
            ul.className = "list-group";
            jsonData.forEach(function(medicamento) {
                let li = document.createElement('li');
                li.className = "list-group-item d-flex justify-content-between align-items-center";

                let nome = document.createTextNode(medicamento.nome);
                let codigo = document.createTextNode("Codigo do Medicamento: " + medicamento.codigo);
                let span = document.createElement('span');
                span.className = "badge bg-primary rounded-pill";

                span.appendChild(codigo);
                li.appendChild(nome);
                li.appendChild(span);
                ul.appendChild(li);

                li.addEventListener("click", function() {
                    abrirModal(medicamento);
                });
            });
        document.body.appendChild(ul);
        return jsonData;
     })
     .catch(function(e){
        console.log("Erro: " + e)
     })
}

function requestPOST(){
    var formInputs = document.querySelectorAll("#form-cadastro input");
    console.log(formInputs[3].checked)


    console.log("Função POST foi ativada")
    const headers = {
        "Content-Type": "application/json",
        "Testando": "Teste"
    }
    const init = {
        'method': "POST",
        'headers': headers,
        'body': JSON.stringify({
            "codigo": formInputs[1].value,
            "quantidade": formInputs[3].value,
            "pesoEmGramas": formInputs[2].value,
            "statusGenerico": formInputs[6].checked ,
            "statusTarjaPreta": formInputs[7].checked,
            "nome": formInputs[0].value,
            "fabricante": formInputs[4].value,
            "outrasInformacoes": formInputs[5].value
        }),
    };
    const response = fetch("http://localhost:8080/api/armario/create/medicamento", init)
    .then( function (responseData){
           return responseData.json()
    })
     .then(function(jsonData){
        console.log(jsonData)
        requestGet();
        
        return jsonData;
     })
     .catch(function(e){
        console.log("Erro: " + e)
    })
}

function abrirModal(medicamento) {
    var modal = new bootstrap.Modal(document.getElementById('exampleModal'));
    var modalTitle = document.querySelector('.modal-title');
    var modalBody = document.querySelector('.modal-body');
    
    modalTitle.textContent = medicamento.nome;
    modalBody.innerHTML = `<p><strong>Código:</strong> ${medicamento.codigo}</p>
                            <p><strong>Quantidade:</strong> ${medicamento.quantidade}</p>
                            <p><strong>Peso em gramas:</strong> ${medicamento.pesoEmGramas}</p>
                            <p><strong>Status Genérico:</strong> ${medicamento.statusGenerico}</p>
                            <p><strong>Status Tarja Preta:</strong> ${medicamento.statusTarjaPreta}</p>
                            <p><strong>Fabricante:</strong> ${medicamento.fabricante}</p>
                            <p><strong>Outras informações:</strong> ${medicamento.outrasInformacoes}</p>`;
    
    modal.show();
}

