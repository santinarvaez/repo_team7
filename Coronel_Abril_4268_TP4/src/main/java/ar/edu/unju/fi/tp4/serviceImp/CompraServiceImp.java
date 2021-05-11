package ar.edu.unju.fi.tp4.serviceImp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.Util.TablaCompra;
import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;

@Service("CompraImp")
public class CompraServiceImp implements ICompraService{
	private List<Compra> compras;
	
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	
	
	@Autowired
	Producto producto;
	
	public void generarTablaCompras(){
		Producto e1 = new Producto("Notebook", 1234, 15000, "Hp", 1000 );
		LOGGER.info("----------->" + e1.getNombre());
		compras = TablaCompra.listaCompras;
		compras.add(new Compra(145,e1,4,200));
		
	}
	
	public void guardarCompras(Compra compra){
		if(compra==null) {
			generarTablaCompras();
		}
		compras.add(compra);
	}
	
	public List<Compra> obtenerCompras(){
		LOGGER.info("->>"+ compras);
		return compras;
	
	}

}
