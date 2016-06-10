package modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByProdCodigo", query = "SELECT p FROM Producto p WHERE p.prodCodigo = :prodCodigo"),
    @NamedQuery(name = "Producto.findByProdNombre", query = "SELECT p FROM Producto p WHERE p.prodNombre = :prodNombre"),
    @NamedQuery(name = "Producto.findByPordCostoVentaRef", query = "SELECT p FROM Producto p WHERE p.pordCostoVentaRef = :pordCostoVentaRef"),
    @NamedQuery(name = "Producto.findByPordCostoVentaFinal", query = "SELECT p FROM Producto p WHERE p.pordCostoVentaFinal = :pordCostoVentaFinal"),
    @NamedQuery(name = "Producto.findByProdEstado", query = "SELECT p FROM Producto p WHERE p.prodEstado = :prodEstado")})
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;

	@Column(name="pord_costo_venta_final")
	private BigDecimal pordCostoVentaFinal;

	@Column(name="pord_costo_venta_ref")
	private BigDecimal pordCostoVentaRef;

	@Column(name="prod_codigo")
	private String prodCodigo;

	@Column(name="prod_estado")
	private int prodEstado;

	@Column(name="prod_nombre")
	private String prodNombre;


	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	//bi-directional many-to-one association to DetalleFactura
		@OneToMany(mappedBy="producto")
		private List<DetalleFactura> detalleFacturas;

	
	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public BigDecimal getPordCostoVentaFinal() {
		return this.pordCostoVentaFinal;
	}

	public void setPordCostoVentaFinal(BigDecimal pordCostoVentaFinal) {
		this.pordCostoVentaFinal = pordCostoVentaFinal;
	}

	public BigDecimal getPordCostoVentaRef() {
		return this.pordCostoVentaRef;
	}

	public void setPordCostoVentaRef(BigDecimal pordCostoVentaRef) {
		this.pordCostoVentaRef = pordCostoVentaRef;
	}

	public String getProdCodigo() {
		return this.prodCodigo;
	}

	public void setProdCodigo(String prodCodigo) {
		this.prodCodigo = prodCodigo;
	}

	public int getProdEstado() {
		return this.prodEstado;
	}

	public void setProdEstado(int prodEstado) {
		this.prodEstado = prodEstado;
	}

	public String getProdNombre() {
		return this.prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}


	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}
	

}