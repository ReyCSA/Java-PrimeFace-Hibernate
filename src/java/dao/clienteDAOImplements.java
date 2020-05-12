package dao;

import java.util.List;
import model.Cliente;
import model.Sexo;
import model.TipoCliente;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class clienteDAOImplements implements clienteDAO
{

    @Override
    public void insertarCliente(Cliente cliente) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cliente);
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
    public void modificarCliente(Cliente cliente)  
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cliente);
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
    public void eliminarCliente(Cliente cliente) 
    {
        Session session = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(cliente);
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
    public List<Cliente> mostrarCliente()  
    {
        Session session = null;
        List<Cliente> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from Cliente as e inner join fetch e.sexo left join fetch e.tipoCliente");
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

    @Override
    public List<TipoCliente> mostrarTipo() 
    {
        Session session = null;
        List<TipoCliente> lista = null;
        try
        {
            session = NewHibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from TipoCliente");
            lista = (List<TipoCliente>) query.list();
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
