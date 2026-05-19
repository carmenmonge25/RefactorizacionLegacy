
package facturacion;

/**
 * Clase Legacy del sistema de facturación
 * ADVERTENCIA: Código con alta deuda tecnica. No modificar la firma del método.
 */

public class FacturacionLegacy {
    private static final double DESCUENTO_ESTANDAR = 0.05;
    private static final double DESCUENTO_VIP = 0.15;
    private static final double DESCUENTO_VIP_EXTRA = 0.25;
    // Método a refactorizar
    /**
     * 
     * @param importeBase recibe el importe base de tipo double
     * @param tipoCliente recibe el tipo de cliente de tipo int
     * @param esSocioVip recibe si es socio vip de tipo boolean 
     * @return devuelve el importe final, aplicando el debido descuento 
     */
    public double carlcularTotal(double importeBase, int tipoCliente, 
            boolean esSocioVip){
        if(importeBase > 0){
            if(tipoCliente==1){
                if(esSocioVip==true) return importeBase - (importeBase*
                        DESCUENTO_VIP_EXTRA);
                else return importeBase - (importeBase*DESCUENTO_VIP);
            }else{
                if(tipoCliente==2) return importeBase-(importeBase*
                        DESCUENTO_ESTANDAR);
                else return importeBase;
            }
        }else return 0;
    }
}
