package Cuenta;
/**
 * Cuenta baten datuak gordetzen dute
 * @author Erik
 * @version 30/03/2023
 */
public class CuentaDoc {
	private String numero;
	private float saldo;
	/**
	 * Kuenta objetu bat eratzen du, numero eta saldo inicializatzen
	 * @param numCta zenbaki atributua inizializatuko den balioa izango da
	 * @param saldoCta saldoa atributua inizializatuko den balioa izango da
	 */
	public CuentaDoc(String numCta, float saldoCta){
		numero=numCta;
		saldo=saldoCta;

	}
	/**
	 * Kuentaren zenbakia bueltatzen du
	 * @return Zenbaki atributuaren balioa
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * Kuentaren zenbakia ezartzen du
	 * @param numero  Zenbaki atributuaren balioa
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * Kuentaren saldoa bueltatzen du
	 * @return Saldoa atributuaren balioa
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * Kuentaren saldoa ezartzen du
	 * @param saldo Saldoa atributuaren balioa
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	/**
	 * Kuentan saldoa gehitzen du
	 * @param importe Saldoan zenbat sartuko den adierazten du
	 */
	public void ingresarDinero(float importe){
		saldo=saldo + importe;
	}
	/**
	 * Kuentatik saldua aterazten du
	 * @param importe Saldotik zenbat aterako den adierazten du
	 */
	public void extraerDinero(float importe){
		saldo=saldo - importe;
		
	}
	/**
	 * Muestra los datos de la cuenta actual
	 */
	public void mostrarCuenta(){
		System.out.println(" Nº cuenta " +getNumero());
		System.out.println("Saldo : "+getSaldo());
	}
}
