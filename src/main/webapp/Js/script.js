window.onload=function(){
};

function manipularElementosDelDom(){
    let libro= new Object();
    let isbn=document.getElementById("isbn");
    let titulo=document.getElementById("titulo");
    let autor=document.getElementById("autor");
    libro.isbn=isbn.value;
    libro.titulo=titulo.value;
    libro.autor=autor.value;
    console.log(libro);
    isbn.value='';
    titulo.value='';
    autor.value='';
};

function enviarFormulario(){
	let request = new XMLHttpRequest();
request.open('POST', 'LibroServlet', true);
request.setRequestHeader('Content-Type', 'text/plain; charset=UTF-8');

request.onreadystatechange = function() {
  if (request.readyState === XMLHttpRequest.DONE) {
    // Peticion terminada.
    if (request.status === 200) {
      // Todo salio bien
      console.log(request.response);
    } else {
      console.log("Error en el envío " + request.response);
    }
  }
};

var formData = new FormData(document.getElementById('form'));
request.send(formData);
};

function enviarFormularioOpcion2(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
         
	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'LibroServlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          
          XHR.onload = () => {
            if (XHR.readyState === XHR.DONE && XHR.status === 200) {
              console.log("response => " + XHR.response);
              //console.log("response xml=> " + XHR.responseXML);
              document.getElementById('bodyTable').innerHTML=XHR.response;
              mostrarMensaje('Libro guardado exitosamente');
              limpiarFormulario();
            }
          };   
          XHR.send(formData);         
}


function limpiarFormulario(){
    document.getElementById("isbn").value='';
    document.getElementById("titulo").value='';
    document.getElementById("anio").value='';
    document.getElementById("autor").value='';
    document.getElementById("clasificacion").value='';
    document.getElementById("paginas").value='';
    document.getElementById("pasta").value='';
};

function mostrarLibros(){
    var control = document.getElementById("control");
    control.value="mostrar";
    const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();
	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });
	  // Set up our request
	  XHR.open('POST', 'LibroServlet', true);
          XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
          
          XHR.onload = () => {
            if (XHR.readyState === XHR.DONE && XHR.status === 200) {
              console.log("response => " + XHR.response);
              document.getElementById('bodyTable').innerHTML=XHR.response;
              mostrarMensaje('Libros mostrados exitosamente');
              limpiarFormulario();
            }
          };   
          XHR.send(formData); 
};

function limpiarTabla(){
   var tabla=document.getElementById('tabla1');
   var totalFilas = tabla.rows.length;   
   for (var i = totalFilas -1; i >0; i--){
       tabla.deleteRow(i);
   }
};

