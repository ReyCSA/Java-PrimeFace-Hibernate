package dao;

import java.util.List;
import model.Pedidos;
import model.Proveedor;
import model.TipoAuto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class pedidosDAOImplements implements pedidosDAO
{

    @Override
    public void insertarPedido(Pedidos pedido) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pedido);
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
    public void modificarPedido(Pedidos pedido)  
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(pedido);
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
    public void eliminarPedido(Pedidos pedido) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(pedido);
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
    public List<Pedidos> mostrarPedidos()  
    {
        Session session = null;
        List<Pedidos> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Pedidos as e inner join fetch e.proveedor left join fetch e.tipoAuto");
            lista = (List<Pedidos>) query.list();
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
