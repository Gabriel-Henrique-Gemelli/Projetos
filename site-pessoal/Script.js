function copy(){
    navigator.clipboard.writeText("gabrielhenriquegemelli@gmail.com")
}



function exibirAlerta() {
    
    copy()
    document.getElementById('alerta').style.display = 'block';
    document.getElementById('overlay').style.display = 'block';
    document.body.style.overflow = "hidden"
    
  }


function fecharAlerta() {

    document.getElementById('alerta').style.display = 'none';
    document.getElementById('overlay').style.display = 'none';
    document.body.style.overflow = "auto"

}