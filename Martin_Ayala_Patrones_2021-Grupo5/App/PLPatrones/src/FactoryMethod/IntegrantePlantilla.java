package FactoryMethod;

import DAO.DAO;

/**
 * Producto abstracto
 *
 * @author Javier y Christian
 */
public abstract class IntegrantePlantilla {

    /**
     * Crea un objeto PostgreSQL, para ser utilizado después junto al patrón DAO
     *
     * @return Integrante de la plantilla tipo DAO
     */
    public abstract DAO crearIntegrantePostgreSQL();

}
