package dao;

import java.util.List;
import model.Sexo;
import model.Vendedor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class vendedorDAOImplements implements vendedorDAO
{

    @Override
    public void insertarVendedor(Vendedor vendedor)
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vendedor);
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
             System.out.println(e.getMessage());
             session.getTransaction().rollback();
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void modificarVendedor(Vendedor vendedor) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(vendedor);
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
             System.out.println(e.getMessage());
             session.getTransaction().rollback();
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
    }

    @Override
    public void eliminarVendedor(Vendedor vendedor)
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(vendedor);
            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
             System.out.println(e.getMessage());
             session.getTransaction().rollback();
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
    }
    
    @Override
    public List<Vendedor> mostrarVendedor() 
    {
        Session session = null;
        List<Vendedor> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Vendedor as e inner join fetch e.sexo");
            lista = (List<Vendedor>) query.list();
        }
        catch(HibernateException e)
        {
             System.out.println(e.getMessage());
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public List<Sexo> mostrarSexo() 
    {
        Session session = null;
        List<Sexo> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Sexo");
            lista = (List<Sexo>) query.list();
        }
        catch(HibernateException e)
        {
             System.out.println(e.getMessage());
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }
        return lista;
    }
    
}
