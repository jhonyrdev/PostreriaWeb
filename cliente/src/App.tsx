import { useState } from 'react'
import './App.css'
import axios from "axios";

// 🔹 Definir tipo de factura
interface FacturaItem {
  nombre: string;
  fecha: string;
  nomProducto: string;
  precioUnitario: number;
  cantidad: number;
  subtotal: number;
}
function App() {

  const [nfac, setNfac] = useState<string>("");
  const [factura, setFactura] = useState<FacturaItem[]>([]);
  const [existeFactura, setExisteFactura] = useState<boolean>(false);

  const buscarFactura = (nfac: string) => {
    axios
      .get<FacturaItem[]>(`http://localhost:8009/facturas/${nfac}`)
      .then((res) => {
        setFactura(res.data);
        setExisteFactura(true);
      })
      .catch(() => {
        setFactura([]);
        setExisteFactura(true);
      });
  };

  const totalCompra = (): number => {
    return factura.reduce((suma, item) => suma + item.subtotal, 0);
  };

  return (
    <div className="container p-4">
      <div className="row">
        <div className="col-12 col-md-3 col-xl-3">
          <div className="form-group">
            <label className="form-label fw-bold">
              Ingresa el número de factura:
            </label>
            <input
              className="form-control"
              value={nfac}
              onChange={(e: React.ChangeEvent<HTMLInputElement>) =>
                setNfac(e.target.value)
              }
              required
            />
          </div>
          <button
            className="btn btn-danger mt-2"
            onClick={() => buscarFactura(nfac)}
          >
            Consultar
          </button>
        </div>
      </div>

      <div className="row mt-5">
        <div className="col-12">
          {factura.length > 0 ? (
            <div className="card border-danger shadow">
              <div className="card-body">
                <div>
                  <h3 className="text-danger text-center fw-bold">
                    Factura
                  </h3>
                  <hr />
                  <p>
                    <strong>Cliente: </strong>
                    <span>{factura[0].nombre}</span>
                  </p>
                  <p>
                    <strong>Fecha: </strong>
                    <span>{factura[0].fecha}</span>
                  </p>
                </div>

                <table className="table text-center">
                  <thead className="table-danger">
                    <tr>
                      <th>Producto</th>
                      <th>Precio</th>
                      <th>Cantidad</th>
                      <th>Subtotal</th>
                    </tr>
                  </thead>
                  <tbody>
                    {factura.map((f, index) => (
                      <tr key={index}>
                        <td>{f.nomProducto}</td>
                        <td>S/. {f.precioUnitario}</td>
                        <td>{f.cantidad}</td>
                        <td>S/. {f.subtotal}</td>
                      </tr>
                    ))}
                  </tbody>
                </table>

                <hr />
                <h5>
                  <strong className="text-danger">
                    Total de compra:{" "}
                  </strong>
                  <span>S/. {totalCompra()}</span>
                </h5>
              </div>
            </div>
          ) : (
            existeFactura && (
              <p className="text-danger mt-2 fw-bold">
                No existe la factura 😢
              </p>
            )
          )}
        </div>
      </div>
    </div>
  );
};

export default App
