//Este código asume que las librerías de P5.js ya están cargadas.
//Esta función se ejecuta una sola vez al inicio del script.
function setup() {
  createCanvas(640, 480);
}
// Esta función se ejecuta repetidas veces indefinidamente.
function draw() {
  if (mouseIsPressed === true) {
    var getColor = axios.get('/color').then(color => {
    console.log(color,'color')
      fill(color.data.r,color.data.g,color.data.b);
      ellipse(mouseX, mouseY, 20, 20);
      var pixel = [mouseX,mouseY,color.data.r,color.data.g,color.data.b];
      axios.post('/pixel',pixel);
    }).catch(e =>{
              console.log(e,e.error);
          });;


  }
  if (mouseIsPressed === false) {
    fill(255,255,255);
  }

}
function refrescar(){
    var getpixeles =axios.get('/pixel').then(pixel => {
    clear();
    console.log(pixel,'pixel')
        if(pixel.data != null){
            for( var i = 0 ; i<pixel.data.length ; i++){
                fill(pixel.data[i][2],pixel.data[i][3],pixel.data[i][4]);
                ellipse(pixel.data[i][0], pixel.data[i][1], 20, 20);
            }

        }

    })
}
function reiniciar(){
    clear();
    axios.post("/reiniciar")
}
function registrarPersona(){
    var nombre = document.getElementById("textid").value;
    console.log(nombre,"nombre");
    axios.get('/setname?name=' + nombre).catch(e =>{
        console.log(e,e.error);
    });
}
setInterval(refrescar,1000)