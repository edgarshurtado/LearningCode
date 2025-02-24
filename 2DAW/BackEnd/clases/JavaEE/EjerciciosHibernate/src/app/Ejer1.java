/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Entidad.Seguro;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author Rumil
 */
public class Ejer1 {
	public static void main(String[] args) {
		// Insertar un seguro
		Seguro seguro1 = new Seguro(3, "200P", "Edgar", "S.", "Hurtado", 26, 0, new Date());
		
		readSeguro(2);

		// EL cierre de la SessionFactory ha de hacerse al final del programa debido a que en
		// HibernateUtils sólo se instancia una vez, con lo que si lo cerramos durante la ejecución
		// del programa, luego nos dará error al intentar volver a obtener el SessionFactory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		sessionFactory.close();
		
	}

	public static void insertSeguro(Seguro seguro){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(seguro);

		session.getTransaction().commit();
		session.close();


	}

	public static Seguro readSeguro(int clavePrimaria){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		Seguro seguro = (Seguro)session.get(Seguro.class, clavePrimaria);
		
		System.out.println(seguro.getNombre());
		

		session.close();

		return seguro;
		
	}

	public static void updateSeguro(Seguro seguro){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		seguro.setNombre("Edgar Modificado");

		session.beginTransaction();
		session.update(seguro);
		session.getTransaction().commit();

		session.close();
	}

	public static void deleteSeguro(Seguro seguro){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.delete(seguro);
		session.getTransaction().commit();

		session.close();
		
	}
}
