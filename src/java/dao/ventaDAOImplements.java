package dao;

import java.util.List;
import model.Auto;
import model.Cliente;
import model.Vendedor;
import model.Venta;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class ventaDAOImplements implements ventaDAO
{

    @Override
    public void insertarVenta(Venta venta) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(venta);
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
    public void modificarVenta(Venta venta)  
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(venta);
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
    public void eliminarVenta(Venta venta)  
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(venta);
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
    public List<Venta> mostrarVentas()  
    {
        Session session = null;
        List<Venta> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Venta as e inner join fetch e.vendedor left join fetch e.cliente left join fetch e.auto");
            lista = (List<Venta>) query.list();
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
    public List<Vendedor> mostrarVendedor() 
    {
        Session session = null;
        List<Vendedor> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Vendedor");
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
    public List<Cliente> mostrarCliente() 
    {
        Session session = null;
        List<Cliente> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Cliente");
            lista = (List<Cliente>) query.list();
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
    public List<Auto> mostrarAuto()  
    {
        Session session = null;
        List<Auto> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Auto");
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
    
}
