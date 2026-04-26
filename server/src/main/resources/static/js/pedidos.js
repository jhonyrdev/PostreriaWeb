const contenedor = document.getElementById("carrito-container");
const totalGeneralElement = document.getElementById("total-general");
const cantidadElement = document.getElementById("cantidad");
const carritoVacio = document.getElementById("carrito-vacio");
const totales = document.getElementById("totales");
const btnReiniciar = document.getElementById("reiniciar");

function renderizarCarrito() {
  contenedor.innerHTML = "";
  const productos = obtenerCarrito();

  if (!productos || productos.length === 0) {
    carritoVacio.style.display = "block";
    totales.style.display = "none";
    return;
  }

  carritoVacio.style.display = "none";
  totales.style.display = "block";

  let totalUnidades = 0;
  let totalPrecio = 0;

  productos.forEach(producto => {
    totalUnidades += producto.cantidad;
    totalPrecio += producto.precio * producto.cantidad;

    const tarjeta = document.createElement("div");
    tarjeta.className = "card mb-3";
    tarjeta.innerHTML = `
      <div class="card-body d-flex justify-content-between align-items-center">
        <div>
          <h5 class="card-title mb-1">${producto.nombre}</h5>
          <p class="mb-0">Precio unitario: S/. ${producto.precio.toFixed(2)}</p>
          <p class="mb-0">Total: S/. ${(producto.precio * producto.cantidad).toFixed(2)}</p>
        </div>
        <div class="d-flex align-items-center">
          <button class="btn btn-light border-danger text-danger fw-bold btn-sm me-2">-</button>
          <span class="me-2">${producto.cantidad}</span>
          <button class="btn btn-light border-danger text-danger fw-bold btn-sm">+</button>
        </div>
      </div>
    `;

    const botones = tarjeta.querySelectorAll("button");
    const btnRestar = botones[0];
    const btnSumar = botones[1];

    if (btnRestar && btnSumar) {
      btnRestar.addEventListener("click", () => {
        restarAlCarrito(producto);
        renderizarCarrito();
      });

      btnSumar.addEventListener("click", () => {
        agregarAlCarrito(producto);
        renderizarCarrito();
      });
    }

    contenedor.appendChild(tarjeta);
  });

  cantidadElement.textContent = totalUnidades;
  totalGeneralElement.textContent = totalPrecio.toFixed(2);
}

btnReiniciar.addEventListener("click", () => {
  reiniciarCarrito();
  renderizarCarrito();
});

renderizarCarrito();

document.getElementById("form-compra").addEventListener("submit", function (event) {
  const productos = obtenerCarrito(); // tu función que devuelve el array de productos
  document.getElementById("carritoJson").value = JSON.stringify(productos);
  console.log("Carrito enviado:", document.getElementById("carritoJson").value);
});