package dao;

import java.util.List;
import model.TipoCliente;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class tipoClienteDAOImplements implements tipoClienteDAO
{

    @Override
    public List<TipoCliente> mostrarTipoCliente()
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
