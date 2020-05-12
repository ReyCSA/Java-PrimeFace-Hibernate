package dao;

import java.util.List;
import model.Auto;
import model.Proveedor;
import model.TipoAuto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class autoDAOImplements implements autoDAO
{

    @Override
    public void insertarAuto(Auto auto) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(auto);
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
    public void modificarAuto(Auto auto)
    {
         Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(auto);
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
    public void eliminarAuto(Auto auto) 
    {
         Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(auto);
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
    public List<Auto> mostrarAuto() 
    {
        Session session = null;
        List<Auto> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Auto as e inner join fetch e.proveedor left join fetch e.tipoAuto");
            lista = (List<Auto>) query.list();
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
    public List<Proveedor> mostrarProveedor()
    {
        Session session = null;
        List<Proveedor> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Proveedor");
            lista = (List<Proveedor>) query.list();
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
    public List<TipoAuto> mostrarTipo()
    {
        Session session = null;
        List<TipoAuto> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from TipoAuto");
            lista = (List<TipoAuto>) query.list();
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
