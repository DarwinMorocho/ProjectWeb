package modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura"),
    @NamedQuery(name = "Factura.findByFacNumero", query = "SELECT f FROM Factura f WHERE f.facNumero = :facNumero"),
    @NamedQuery(name = "Factura.findByFacFecha", query = "SELECT f FROM Factura f WHERE f.facFecha = :facFecha"),
    @NamedQuery(name = "Factura.findByFacSubtotal", query = "SELECT f FROM Factura f WHERE f.facSubtotal = :facSubtotal"),
    @NamedQuery(name = "Factura.findByFacIva", query = "SELECT f FROM Factura f WHERE f.facIva = :facIva"),
    @NamedQuery(name = "Factura.findByFacTotal", query = "SELECT f FROM Factura f WHERE f.facTotal = :facTotal"),
    @NamedQuery(name = "Factura.findByFacEstado", query = "SELECT f FROM Factura f WHERE f.facEstado = :facEstado"),
    @NamedQuery(name = "Factura.findByFacTipo", query = "SELECT f FROM Factura f WHERE f.facTipo = :facTipo")})
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura")
	private int idFactura;

	@Column(name="fac_estado")
	private String facEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="fac_fecha")
	private Date facFecha;

	@Column(name="fac_iva")
	private BigDecimal facIva;

	@Column(name="fac_numero")
	private int facNumero;

	@Column(name="fac_subtotal")
	private BigDecimal facSubtotal;

	@Column(name="fac_tipo")
	private String facTipo;

	@Column(name="fac_total")
	private BigDecimal facTotal;

	//bi-directional many-to-one association to DetalleFactura
	@OneToMany(mappedBy="factura")//,cascade = CascadeType.ALL,fetch=FetchType.EAGER )
	private List<DetalleFactura> detalleFacturas;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Factura() {
	}

	
	public Factura(Cliente cliente, Usuario usuario, int facNumero, Date facFecha, BigDecimal facSubtotal,
			BigDecimal facIva, BigDecimal facTotal) {
		super();
		this.cliente = cliente;
		this.usuario = usuario;
		this.facNumero = facNumero;
		this.facFecha = facFecha;
		this.facSubtotal = facSubtotal;
		this.facIva = facIva;
		this.facTotal = facTotal;
		//this.detalleFacturas = null;
	}


	public int getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public String getFacEstado() {
		return this.facEstado;
	}

	public void setFacEstado(String facEstado) {
		this.facEstado = facEstado;
	}

	public Date getFacFecha() {
		return this.facFecha;
	}

	public void setFacFecha(Date facFecha) {
		this.facFecha = facFecha;
	}

	public BigDecimal getFacIva() {
		return this.facIva;
	}

	public void setFacIva(BigDecimal facIva) {
		this.facIva = facIva;
	}

	public int getFacNumero() {
		return this.facNumero;
	}

	public void setFacNumero(int facNumero) {
		this.facNumero = facNumero;
	}

	public BigDecimal getFacSubtotal() {
		return this.facSubtotal;
	}

	public void setFacSubtotal(BigDecimal facSubtotal) {
		this.facSubtotal = facSubtotal;
	}

	public String getFacTipo() {
		return this.facTipo;
	}

	public void setFacTipo(String facTipo) {
		this.facTipo = facTipo;
	}

	public BigDecimal getFacTotal() {
		return this.facTotal;
	}

	public void setFacTotal(BigDecimal facTotal) {
		this.facTotal = facTotal;
	}

	public List<DetalleFactura> getDetalleFacturas() {
		return this.detalleFacturas;
	}

	public void setDetalleFacturas(List<DetalleFactura> detalleFacturas) {
		this.detalleFacturas = detalleFacturas;
	}

	public DetalleFactura addDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().add(detalleFactura);
		detalleFactura.setFactura(this);

		return detalleFactura;
	}

	public DetalleFactura removeDetalleFactura(DetalleFactura detalleFactura) {
		getDetalleFacturas().remove(detalleFactura);
		detalleFactura.setFactura(null);

		return detalleFactura;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}