


function start(){
    clearScreen();
    requestGet();
    console.log("start ativada");
}
function requestGet(){
    console.log("Função Get foi ativada")
    
    const response = fetch("http://localhost:8082/api/armario/get/medicamentos")
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

function requestGetSearch(event){
    clearScreen();
    console.log("Função GetSearch foi ativada")
    const searchedNome = event.target.value;

    if(searchedNome.length == 0){
        console.log("n tem nada na barra de pesquisa")
        requestGet();
        return;
    }
    const response = fetch(`http://localhost:8082/api/armario/get/medicamento?nome=${searchedNome}`)
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
    const response = fetch("http://localhost:8082/api/armario/create/medicamento", init)
    .then( function (responseData){
           return responseData.json()
    })
     .then(function(jsonData){
        console.log(jsonData)
        
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
    modalBody.innerHTML = `<p><strong>Código:</strong> <span><input id="modal-codigo" value="${medicamento.codigo}"></span></p>
                            <p><strong>Quantidade:</strong> <input id="modal-quantidade" value="${medicamento.quantidade}"></p>
                            <p><strong>Peso em gramas:</strong>  <input id="modal-peso" value="${medicamento.pesoEmGramas}"></p>
                            <p><strong>Status Genérico:</strong>  <input id="modal-generico" value="${medicamento.statusGenerico}"></p>
                            <p><strong>Status Tarja Preta:</strong>  <input id="modal-tarja-preta" value="${medicamento.statusTarjaPreta}"></p>
                            <p><strong>Fabricante:</strong>  <input id="modal-fabricante" value="${medicamento.fabricante}"></p>
                            <p><strong>Outras informações:</strong>  <input id="modal-info" value="${medicamento.outrasInformacoes}"></p>`;
    
    modal.show();
}


function clearScreen() {
    const medicamentos = document.querySelectorAll(".list-group");
    for (let i = 0; i < medicamentos.length; i++) {
      medicamentos[i].remove();
    }
}

function requestPOSTFAKE(){
    for(var i = 0; i < 10; i++){
        var formInputs = document.querySelectorAll("#form-cadastro input");
    
        const randomNum = Math.floor(Math.random() * 1000); // gera um número aleatório entre 0 e 999

    console.log("Função POST FAKE foi ativada")
    const headers = {
        "Content-Type": "application/json",
        "Testando": "Teste"
    }
    const init = {
        'method': "POST",
        'headers': headers,
        'body': JSON.stringify({
            "codigo": "teste123",
            "quantidade": 123,
            "pesoEmGramas": 123,
            "statusGenerico": true ,
            "statusTarjaPreta": true,
            "nome": String(randomNum),
            "fabricante": "padrao",
            "outrasInformacoes": "fake"
        }),
    };
    const response = fetch("http://localhost:8082/api/armario/create/medicamento", init)
    .then( function (responseData){
           return responseData.json()
    })
     .then(function(jsonData){
        console.log(jsonData)
        
        return jsonData;
     })
     .catch(function(e){
        console.log("Erro: " + e)
    })
    }
    
}

function requestDelete() {
    //var modalConteudo = document.querySelector(".modal-body");
    var modalSpanDentro = document.querySelector("#modal-codigo")

    fetch(`http://localhost:8082/api/armario/remove/medicamento?codigo=${modalSpanDentro.value}`, {
      method: 'DELETE'
    })
    .then(response => {
      if (response.ok) {
        console.log('Medicamento removido com sucesso!');
        // Força a recarga da página a partir do servidor
        location.reload(true);

      } else {
        throw new Error('Não foi possível remover o medicamento.');
      }
    })
    .catch(error => {
      console.error(error);
    });

  }