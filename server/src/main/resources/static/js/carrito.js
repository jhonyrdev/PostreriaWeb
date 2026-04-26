const keyLocalstorage = "pasteles";
/** Agrega un producto al carrito */
function agregarAlCarrito(producto) {
  let memoria = JSON.parse(localStorage.getItem(keyLocalstorage)) || [];
  const indice = memoria.findIndex(item => item.id === producto.id);

  if (indice === -1) {
    const nuevoProducto = {
      id: producto.id,
      nombre: producto.nombre,
      precio: producto.precio,
      cantidad: 1
    };
    memoria.push(nuevoProducto);
  } else {
    memoria[indice].cantidad++;
  }

  localStorage.setItem(keyLocalstorage, JSON.stringify(memoria));
}

function restarAlCarrito(producto) {
  let memoria = JSON.parse(localStorage.getItem(keyLocalstorage));
  if (!memoria) return;

  const indice = memoria.findIndex(item => item.id === producto.id);
  if (indice === -1) return;

  memoria[indice].cantidad--;
  if (memoria[indice].cantidad <= 0) {
    memoria.splice(indice, 1);
  }

  localStorage.setItem(keyLocalstorage, JSON.stringify(memoria));
}

//Reinicia el carrito //
function reiniciarCarrito() {
  localStorage.removeItem(keyLocalstorage);
}

//Obtiene todos los productos del carrito //
function obtenerCarrito() {
  return JSON.parse(localStorage.getItem(keyLocalstorage)) || [];
}

function compraRealizada() {
  const carrito = obtenerCarrito(); // tu función ya definida
  if (carrito.length === 0) {
    alert("El carrito está vacío");
    return;
  }
  document.getElementById("carritoJson").value = JSON.stringify(carrito);
  document.getElementById("form-compra").submit();
}

/** Calcula el total general del carrito */
function calcularTotalGeneral() {
  const memoria = obtenerCarrito();
  return memoria.reduce((acc, item) => acc + item.precio * item.cantidad, 0);
}