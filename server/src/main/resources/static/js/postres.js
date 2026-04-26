document.addEventListener("DOMContentLoaded", function () { 

  document.getElementById('combo_Postre').addEventListener('change', function () {
    const categoria = this.value;
    document.querySelectorAll('.grupo-productos').forEach(el => {
      el.style.display = (categoria === 'todos' || el.classList.contains(categoria)) ? 'block' : 'none';
    });
  });


  //supuestamente codigo para las prmociones que diga vencido o sin stock
  document.querySelectorAll('.promo').forEach(promo => {
    const fechaExpira = new Date(promo.dataset.expira);
    const hoy = new Date();
    const estado = promo.querySelector('.estado');

    if (hoy > fechaExpira) {
      promo.classList.add('border-danger');
      estado.textContent = 'Promoción vencida';
      estado.style.color = 'red';
    } else {
      promo.classList.add('border-success');
      estado.textContent = 'Promoción vigente';
      estado.style.color = 'green';
    }
  });

  /*<-- Validación básica --> */
  document.getElementById("contactForm").addEventListener("submit", function (e) {
    e.preventDefault();
    alert("Formulario enviado correctamente ");
  });

});
