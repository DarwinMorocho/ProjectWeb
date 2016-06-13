package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the detalle_factura database table.
 * 
 */
@Entity
@Table(name="DetalleFactura")
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetalle", query = "SELECT d FROM DetalleFactura d WHERE d.idDetalle = :idDetalle"),
    @NamedQuery(name = "DetalleFactura.findByDetCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.detCantidad = :detCantidad"),
    @NamedQuery(name = "DetalleFactura.findByFactura", query = "SELECT d FROM DetalleFactura d WHERE d.factura = :factura"),
    @NamedQuery(name = "DetalleFactura.findByDetDescripcion", query = "SELECT d FROM DetalleFactura d WHERE d.detDescripcion = :detDescripcion"),
    @NamedQuery(name = "DetalleFactura.findByDetSubtotal", query = "SELECT d FROM DetalleFactura d WHERE d.detSubtotal = :detSubtotal"),
    @NamedQuery(name = "DetalleFactura.findByDetTotal", query = "SELECT d FROM DetalleFactura d WHERE d.detTotal = :detTotal")})
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private int idDetalle;

	@Column(name="det_cantidad")
	private BigDecimal detCantidad;

	@Column(name="det_descripcion")
	private String detDescripcion;

	@Column(name="det_subtotal")
	private BigDecimal detSubtotal;

	@Column(name="det_total")
	private BigDecimal detTotal;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="id_factura")
	private Factura factura;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	public DetalleFactura() {
	}

	public int getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}

	public BigDecimal getDetCantidad() {
		return this.detCantidad;
	}

	public void setDetCantidad(BigDecimal detCantidad) {
		this.detCantidad = detCantidad;
	}

	public String getDetDescripcion() {
		return this.detDescripcion;
	}

	public void setDetDescripcion(String detDescripcion) {
		this.detDescripcion = detDescripcion;
	}

	public BigDecimal getDetSubtotal() {
		return this.detSubtotal;
	}

	public void setDetSubtotal(BigDecimal detSubtotal) {
		this.detSubtotal = detSubtotal;
	}

	public BigDecimal getDetTotal() {
		return this.detTotal;
	}

	public void setDetTotal(BigDecimal detTotal) {
		this.detTotal = detTotal;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleFactura [idDetalle=" + idDetalle + ", detCantidad=" + detCantidad + ", detDescripcion="
				+ detDescripcion + ", detSubtotal=" + detSubtotal + ", detTotal=" + detTotal + ", factura=" + factura
				+ ", producto=" + producto + "]";
	}

	
}