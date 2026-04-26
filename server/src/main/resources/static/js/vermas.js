document.addEventListener("DOMContentLoaded", function () {
  const productos = {
   1: {
      id: 1,
      nombre: "Torta de tres leches",
      precio: 50.00,
      descripcion: "Esponjosa, húmeda y absolutamente irresistible. Nuestra torta de tres leches está bañada en una mezcla perfecta de leche evaporada, leche condensada y crema de leche, logrando una textura suave que se deshace en la boca. Decorada con un toque de canela o merengue, es el postre clásico que nunca falla en celebraciones, reuniones o simplemente para darte un gusto especial.",
      imagen: "https://wongfood.vtexassets.com/arquivos/ids/649061/221025-1.jpg?v=638266776488300000"
    },

    2: {
      id: 2,
      nombre: "Torta de Chocolate",
      precio: 55.00,
      descripcion: "Intensa, suave y profundamente deliciosa. Nuestra torta de chocolate está elaborada con cacao puro, logrando una textura húmeda y esponjosa que se derrite en cada bocado. Cubierta con una capa de fudge o ganache artesanal, es el postre ideal para los amantes del chocolate que buscan un sabor profundo y reconfortante.",
      imagen: "imagenes/torta_chocolate.jpg"
    },

    3:{
      id: 3,
      nombre: "Torta de Lúcuma",
      precio: 60.00,
      descripcion: "Nuestra torta de lúcuma combina la suavidad de un bizcocho esponjoso con el sabor auténtico de la lúcuma peruana. Rellena con una crema delicada y ligeramente dulce, cada porción ofrece una experiencia cremosa y equilibrada. Perfecta para quienes buscan un postre tradicional con un toque elegante y natural.",
      imagen: "https://metroio.vtexassets.com/arquivos/ids/495176/63145-01-40537.jpg?v=638339506006530000"
    },

    4:{
      id: 4,
      nombre: "Dulzura de pecanas",
      precio: 75.00,
      descripcion: "Una torta esponjosa y húmeda, enriquecida con trozos de pecanas que aportan textura y sabor. Rellena y cubierta con manjar cremoso, esta delicia combina lo crujiente de las nueces con la suavidad del bizcocho, creando una experiencia dulce y reconfortante. Ideal para compartir en momentos especiales o simplemente para darte un gusto elegante.",
      imagen: "imagenes/torta_pecanas.jpg"
    },

    5: {
      id: 5,
      nombre: "Galletas de chocolate",
      precio: 24.00,
      descripcion: "Crujientes por fuera, suaves por dentro y cargadas de chispas de chocolate. Nuestras galletas son el equilibrio perfecto entre textura y sabor, ideales para acompañar una bebida caliente o disfrutar como un antojo dulce en cualquier momento del día.",
      imagen: "https://cdn2.cocinadelirante.com/sites/default/files/images/2018/08/galletas-caseras-de-chispas-de-chocolate-sin-horno.jpg"
    },

    6:{
      id: 6,
      nombre: "Galletas de vainilla",
      precio: 24.00,
      descripcion: "Suaves, aromáticas y con el toque justo de dulzura. Nuestras galletas de vainilla están elaboradas con mantequilla fresca y extracto natural de vainilla, logrando una textura delicada que se deshace en la boca. Ideales para acompañar con café, té o simplemente disfrutar como un capricho ligero en cualquier momento del día.",
      imagen: "imagenes/galletas_vainilla.jpg"
    },

    7:{
      id: 7,
      nombre: "Galletas navideñas",
      precio: 24.00,
      descripcion: "Horneadas con cariño y decoradas a mano, nuestras galletas navideñas combinan sabores clásicos como vainilla, jengibre y chocolate con diseños festivos que alegran cualquier mesa. Crujientes, aromáticas y llenas de espíritu navideño, son ideales para regalar, compartir o disfrutar junto a una taza de chocolate caliente.",
      imagen: "imagenes/galletas_navideñas.jpg"
    },

    8:{
      id: 8,
      nombre: "Galletas de azucar",
      precio: 24.00,
      descripcion: "Clásicas, suaves y ligeramente crujientes. Nuestras galletas de azúcar están elaboradas con mantequilla fresca y un toque de vainilla, espolvoreadas con azúcar fina para lograr ese brillo irresistible. Son el acompañante perfecto para una tarde tranquila o como base para decoraciones creativas en celebraciones.",
      imagen: "imagenes/galletas_caseras.jpg"
    },

    9:{
      id: 9,
      nombre: "Helado de fresa",
      precio: 18.00,
      descripcion: "Refrescante, cremoso y naturalmente frutal. Nuestro helado de fresa está elaborado con pulpa de fresa fresca, crema de leche y un toque de vainilla, logrando una textura suave y un sabor auténtico. Ideal para días soleados, celebraciones o simplemente para disfrutar un momento dulce con estilo.",
      imagen: "https://th.bing.com/th/id/R.3fd1b86f797efcac41eb3f70918dcb6d?rik=HFeyh3pBD5ZqOQ&riu=http%3a%2f%2ftodofondos.com%2fbin%2ffondos%2f06%2f62%2f34d.jpg&ehk=CGZajbX0dBf6ajw6pv7pT%2b4B7GUGsqjN8tTipP7%2fedQ%3d&risl=&pid=ImgRaw&r=0"
    },

    10:{
      id: 10,
      nombre: "Helado de chocolate",
      precio: 12.00,
      descripcion: "Cremoso, intenso y lleno de carácter. Nuestro helado de chocolate está elaborado con cacao puro y crema fresca, logrando una textura suave y un sabor profundo que conquista desde el primer bocado. Ideal para los amantes del chocolate que buscan un postre clásico con un toque artesanal.",
      imagen: "imagenes/helado_de_chocolate.jpg"
    },

    11:{
      id: 11,
      nombre: "Helado de vainilla",
      precio: 12.50,
      descripcion: "Suave, cremoso y con un aroma delicado. Nuestro helado de vainilla está elaborado con crema fresca y extracto natural de vainilla, logrando un sabor clásico que nunca pasa de moda. Ideal para acompañar postres, disfrutar solo o combinar con tus toppings favoritos.",
      imagen: "imagenes/helado_de_vainilla.jpg"
    },

    12:{
      nombre: "Helado de lúcuma",
      precio: 12.50,
      descripcion: "Cremoso, suave y con el sabor único de la lúcuma peruana. Nuestro helado de lúcuma está elaborado con pulpa natural, leche fresca y un toque de vainilla, logrando una textura delicada y un dulzor equilibrado. Es el postre perfecto para quienes buscan una experiencia auténtica y refrescante con identidad local.",
      imagen: "imagenes/helado_lucuma.jpg"
    },

    13:{
      id: 13,
      nombre: "Tiramisú de licor de café",
      precio: 50.00,
      descripcion: "Una versión intensa y elegante del clásico italiano. Este tiramisú está elaborado con capas de bizcochos empapados en espresso y licor de café, que se alternan con una crema suave de mascarpone batido. El resultado es un postre con carácter, donde el sabor profundo del café se equilibra con la dulzura de la crema, creando una experiencia envolvente que conquista desde el primer bocado. Ideal para quienes disfrutan de postres con personalidad y un toque adulto.",
      imagen: "imagenes/tiramisu_cafe.jpg"
    },

    14:{
      id: 14,
      nombre: "Tiramisú de chocolate",
      precio: 60.00,
      descripcion: "Para los amantes del cacao, esta versión del tiramisú es pura indulgencia. Capas de bizcochos humedecidos en leche con cacao se combinan con una crema de mascarpone y chocolate fundido, logrando una textura cremosa y un sabor profundo. Espolvoreado con cacao puro y decorado con virutas de chocolate, este postre es perfecto para quienes buscan una experiencia intensa, suave y reconfortante.",
      imagen: "imagenes/tiramisu_chocolate.jpg"
    },

    15:{
      id: 15,
      nombre: "Tiramisú de pistacho",
      precio: 65.00,
      descripcion: "Delicado, aromático y visualmente encantador. Este tiramisú fusiona la suavidad del mascarpone con una crema de pistacho artesanal, logrando un sabor único y elegante. Los bizcochos se humedecen en café suave, y cada capa se corona con pistachos triturados que aportan textura y un color vibrante. Es una opción sofisticada que sorprende por su equilibrio entre lo cremoso y lo crujiente.",
      imagen: "imagenes/tiramisu_pistacho.jpg"
    },

    16:{
      id: 16,
      nombre: "Tiramisú de limón",
      precio: 50.00,
      descripcion: "Refrescante y ligero, con un toque cítrico que despierta los sentidos. Este tiramisú se prepara con bizcochos empapados en almíbar de limón y capas de crema de mascarpone mezclada con lemon curd casero. Su sabor es equilibrado entre lo dulce y lo ácido, y su textura es suave y aireada. Ideal para quienes buscan un postre fresco, elegante y diferente, perfecto para días cálidos o como cierre de una comida especial.",
      imagen: "imagenes/tiramisu_limon.jpg"
    },

    17:{
      id: 17,
      nombre: "Cheesecake de fresa",
      precio: 65.00,
      descripcion: "Suave, cremoso y con un toque frutal irresistible. Nuestro cheesecake de fresa combina una base crocante de galletas con un relleno de queso crema batido y una cobertura de mermelada de fresas frescas. El equilibrio entre dulzura y acidez lo convierte en el postre perfecto para cualquier ocasión, ideal para quienes buscan frescura y elegancia en cada bocado.",
      imagen: "imagenes/cheesecake_fresa.jpg"
    },

    18:{
      id: 18,
      nombre: "Cheesecake de fresa",
      precio: 65.00,
      descripcion: "Intenso y seductor. Este cheesecake está elaborado con chocolate fundido, logrando una textura rica y cremosa. Cubierto con ganache de chocolate, es el postre ideal para los amantes del cacao que buscan una experiencia indulgente y sofisticada.",
      imagen: "https://www.thereciperebel.com/wp-content/uploads/2016/12/The-Best-Chocolate-Cheesecake-www.thereciperebel.com-6-of-10.jpg"
    },

    19:{
      id: 19,
      nombre: "New York Cheesecake",
      precio: 75.00,
      descripcion: "Clásico, firme y lleno de carácter. El New York Cheesecake se distingue por su textura densa y cremosa, elaborada con queso crema, huevos y un toque de vainilla sobre una base de galleta horneada. Servido con mermelada de frutos rojos o simplemente al natural, es un ícono de la repostería que nunca pasa de moda.",
      imagen: "https://content-cocina.lecturas.com/medio/2021/11/10/paso_a_paso_para_realizar_new_york_cheesecake_resultado_final_f9830001_2000x1333.jpg"
    },

    20:{
      id: 20,
      nombre: "Cheesecake japonés",
      precio: 85.00,
      descripcion: "Ligero, esponjoso y delicado como una nube. Nuestro cheesecake japonés se hornea al baño maría para lograr esa textura aireada y temblorosa que lo hace único. Elaborado con queso crema, claras batidas y un toque de limón, es menos dulce que el tradicional y perfecto para quienes buscan un postre suave, elegante y diferente.",
      imagen: "https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2017/03/cheseecakejapones.jpg"
    },

    21:{
      id: 21,
      nombre: "Brownie de chocolate",
      precio: 45.00,
      descripcion: "Denso, húmedo y con sabor profundo a cacao. Nuestro brownie de chocolate está elaborado con mantequilla fresca y chocolate semiamargo, logrando una textura suave por dentro y ligeramente crujiente por fuera. Ideal para acompañar con helado o disfrutar solo como un clásico irresistible.",
      imagen: "https://cdn11.bigcommerce.com/s-oyt6pom1dt/images/stencil/2560w/products/3502/5819/chocolate-brownies-1__66470.1622216392.jpg?c=1"
    },

    22:{
      id: 22,
      nombre: "Brownie con nueces",
      precio: 45.00,
      descripcion: "Una combinación perfecta entre lo suave y lo crujiente. Este brownie mezcla chocolate intenso con trozos de nueces tostadas, aportando textura y un sabor ligeramente ahumado. Cada porción ofrece un equilibrio entre dulzura y carácter, ideal para quienes buscan un postre con personalidad.",
      imagen: "https://file-cdn.mercyforanimals.org/mercy4animals.wpengine.com/sites/446/2019/03/Brownies.jpg"
    },

    23:{
      id: 23,
      nombre: "Brownie de frambuesa",
      precio: 45.00,
      descripcion: "Jugoso y vibrante. Nuestro brownie de frambuesa fusiona la intensidad del chocolate con el frescor ácido de las frambuesas naturales. Las frutas se integran en la masa, liberando su jugo durante el horneado y creando una textura húmeda y un contraste de sabores que enamora.",
      imagen: "https://tse3.mm.bing.net/th/id/OIP.u5-yB5ewsjCb-zbbLG-X3wHaE8?rs=1&pid=ImgDetMain&o=7&rm=3"
    },

    24:{
      id: 24,
      nombre: "Brownie navideño",
      precio: 55.00,
      descripcion: "Festivo, aromático y lleno de encanto. Este brownie especial para la temporada combina chocolate oscuro con frutas secas, nueces y un toque de licor suave. Decorado con azúcar glas y detalles dorados, es el postre perfecto para compartir en celebraciones o regalar con estilo.",
      imagen: "https://dailyfoods.com.mx/wp-content/uploads/2021/12/Brownie-Daily-2-1024x607.jpeg"
    },

    25:{
      id: 25,
      nombre: "Cupcake Red Velvet",
      precio: 45.50,
      descripcion: "Elegante y seductor. Nuestro cupcake Red Velvet destaca por su textura suave y color vibrante, elaborado con cacao fino y un toque de vainilla. Coronado con un cremoso frosting de queso, cada bocado es una mezcla perfecta entre dulzura y carácter. Ideal para ocasiones especiales o simplemente para regalarte un momento de lujo.",
      imagen: "https://tse4.mm.bing.net/th/id/OIP.PODJt6OUcvAclwswC38vuwHaHa?rs=1&pid=ImgDetMain&o=7&rm=3"
    },

    26:{
      id: 26,
      nombre: "Cupcake de plátano",
      precio: 30.00,
      descripcion: "Natural, esponjoso y reconfortante. Este cupcake está elaborado con plátano maduro, mantequilla fresca y un toque de canela, logrando una textura húmeda y un sabor cálido. Decorado con crema de vainilla o nueces caramelizadas, es perfecto para quienes buscan un postre casero con alma.",
      imagen: "https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/11EAE394-4A91-4149-9B77-E9F84BB7F7EE/Derivates/DF4D536B-48EF-4B46-82AF-68D9ED18F6E3.jpg"
    },

    27:{
      id: 27,
      nombre: "Cupcake de vainilla",
      precio: 40.50,
      descripcion: "Clásico, delicado y siempre irresistible. Nuestro cupcake de vainilla se prepara con mantequilla batida, esencia natural y leche fresca, logrando una masa ligera y aireada. Decorado con buttercream suave y detalles coloridos, es ideal para celebraciones, mesas dulces o simplemente para disfrutar sin excusas.",
      imagen: "https://www.splenda.com/wp-content/uploads/2020/09/keto-vanilla-cupcakes-thumb.jpg"
    },

    28:{
      id: 28,
      nombre: "Cupcake de zanahoria",
      precio: 40.00,
      descripcion: "Aromático, húmedo y lleno de sabor. Este cupcake combina zanahoria rallada, especias suaves y nueces tostadas, logrando una textura rica y equilibrada. Cubierto con frosting de queso crema y decoraciones naturales, es una opción deliciosa para quienes aman los postres con personalidad y un toque saludable.",
      imagen: "imagenes/cupcake_zanahoria.jpg"
    },

    29:{
      id: 29,
      nombre: "Brioche",
      precio: 12.00,
      descripcion: "Pan dulce de origen francés, suave como algodón y con una miga aireada que se deshace en la boca. Elaborado con mantequilla fresca, huevos y leche, el brioche tiene una textura rica y un sabor ligeramente dulce que lo convierte en el acompañante perfecto para desayunos, tostadas gourmet o rellenos salados. Su corteza dorada y aroma delicado lo hacen irresistible desde el primer vistazo.",
      imagen: "imagenes/brioche.jpg"
    },

    30:{
      id: 30,
      nombre: "Pan de maíz",
      precio: 10.00,
      descripcion: "Tradicional y reconfortante. Nuestro pan de maíz se elabora con harina de maíz amarillo, mantequilla y un toque de azúcar, logrando una textura suave y un sabor ligeramente dulce. Perfecto para acompañar platos criollos, disfrutar en el desayuno o servir como base para bocadillos artesanales. Su color dorado y aroma cálido evocan lo mejor de la cocina casera.",
      imagen: "imagenes/pan_maiz.jpg"
    },

    31:{
      id: 31,
      nombre: "Panetón",
      precio: 45.00,
      descripcion: "Aromático, húmedo y lleno de sabor. Este cupcake combina zanahoria rallada, especias suaves y nueces tostadas, logrando una textura rica y equilibrada. Cubierto con frosting de queso crema y decoraciones naturales, es una opción deliciosa para quienes aman los postres con personalidad y un toque saludable.",
      imagen: "imagenes/paneton.jpg"
    },

    32:{
      id: 32,
      nombre: "Berlinesas",
      precio: 7.50,
      descripcion: "El clásico de la temporada navideña, elaborado con masa suave y esponjosa enriquecida con mantequilla, huevos y ralladura de cítricos. Nuestro panetón está generosamente relleno con frutas confitadas y pasas, logrando un equilibrio perfecto entre dulzura y textura. Ideal para compartir en familia, regalar o disfrutar con una taza de chocolate caliente. Su presentación festiva lo convierte en el protagonista de cualquier mesa navideña.",
      imagen: "imagenes/berlinesa.jpg"
    }

  };

  const id = localStorage.getItem("productoSeleccionado");
  const producto = productos[id];

  if(producto){
    producto.id = id;

    if(producto){
      document.getElementById("nombre").textContent = producto.nombre;
      document.getElementById("descripcion").textContent = producto.descripcion;
      document.getElementById("imagen").src = producto.imagen;
      document.getElementById("precio").textContent = "S/. " + producto.precio.toFixed(2);
    }

    document.getElementById("btn-agregar").addEventListener("click", () => {
      agregarAlCarrito(producto);
      const alerta = document.getElementById("alerta");
      alerta.style.display = "block";

      alerta.addEventListener("click", () => {
        alerta.style.display = "none";
      });
    });
  };
});