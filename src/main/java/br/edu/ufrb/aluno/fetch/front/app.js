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
        return jsonData;
     })
     .catch(function(e){
        console.log("Erro: " + e)
    })
}