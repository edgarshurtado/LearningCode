/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Entidad.SeguroAnotaciones;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtil;

/**
 *
 * @author Rumil
 */
public class Ejer2 {
	public static void main(String[] args) {
		// Insertar un seguro
		SeguroAnotaciones seguro1 = new SeguroAnotaciones(3, "200P", "Edgar", "S.", "Hurtado", 26, 0, new Date());
		
		readSeguro(2);

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		sessionFactory.close();
		
	}

	public static void insertSeguro(SeguroAnotaciones seguro){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(seguro);

		session.getTransaction().commit();
		session.close();


	}

	public static SeguroAnotaciones readSeguro(int clavePrimaria){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		SeguroAnotaciones seguro = (SeguroAnotaciones)session.get(SeguroAnotaciones.class, clavePrimaria);
		
		System.out.println(seguro.getNombre());
		

		session.close();

		return seguro;
		
	}

	public static void updateSeguro(SeguroAnotaciones seguro){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		seguro.setNombre("Edgar Modificado");

		session.beginTransaction();
		session.update(seguro);
		session.getTransaction().commit();

		session.close();
	}

	public static void deleteSeguro(SeguroAnotaciones seguro){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.delete(seguro);
		session.getTransaction().commit();

		session.close();
		
	}
}
