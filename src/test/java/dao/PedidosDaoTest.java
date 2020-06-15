/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import dao.PedidosDao;
import dao.Pedido;
import dao.Detalle;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author alvar
 */
public class PedidosDaoTest {
    static PedidosDao pedidos = new PedidosDao();
    static Pedido pedido = new Pedido(11081,4,5, new Date(1992-6-3), new Date(1992-6-5), new Date(1992-6-7),1 ,new BigDecimal(30.60),"destinatario","direccion","ciudad","region","28049","España");
    
    public PedidosDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexion method, of class PedidosDao.
     */
    //TEST 
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        PedidosDao instance = new PedidosDao();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertNotEquals(expResult, result);
        
    }

    /**
     * Test of read method, of class PedidosDao.
     */
    //TEST BIEN
    @Test
    public void testRead() {
        //Despues de hacer el delete, este no funciona porque el pedido se ha eliminado
        System.out.println("read");
        Integer idPedido = 11076;
        Pedido result = pedidos.read(idPedido);
        assertEquals(result.getId(), idPedido);
        
    }

    /**
     * Test of insert method, of class PedidosDao.
     */
    @Test
    public void testInsert() {
        //TEST BIEN
        //En este test habrá que ir sumando 1 cada vez que hagamos un test
        //Ya que no se puede crear el mismo pedido dos veces
        System.out.println("insert");
        //devuelve el id del pedido que acabo de crear
        Integer result = pedidos.insert(pedido);
        assertNotNull(result);
        assertEquals(result,pedido.getId());
        
    }

    /**
     * Test of update method, of class PedidosDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pedido pedido = null;
        PedidosDao instance = new PedidosDao();
        Integer expResult = 0;
        //al ser 0, quiere decir que si funciona, si queremos que no funcione pondríamos un -1, que quiere decir que no se ha hecho la update
        Integer result = instance.update(pedido);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class PedidosDao.
     */
    @Test
    //TEST BIEN
    public void testDelete() {
        System.out.println("delete");
        int result = pedidos.delete(11077);
        //si funciona porque es un id que SI existe
        //No funciona seguido porque el pedido se elimina y al no encontrarlo el test no pasa
        assertEquals(result, 0);
        
//        result = pedidos.delete(000001);
//        //No funcionaria porque es un id que NO existe
//        assertNotEquals(result, 1);
        
    }

    /**
     * Test of listar method, of class PedidosDao.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        Integer posicion = 9;
        PedidosDao instance = new PedidosDao();
        ArrayList<Pedido> expResult = new ArrayList<>();
        Pedido pedido2 = new Pedido(10926,4,5, new Date(1992-6-3), new Date(1992-6-5), new Date(1992-6-7),1 ,new BigDecimal(30.60),"destinatario","direccion","ciudad","region","28049","España");
        expResult.add(pedido);
        ArrayList<Pedido> result = instance.listar(posicion);
        assertEquals(result.get(0).getId(), pedido2.getId());
        
    }
    
}
