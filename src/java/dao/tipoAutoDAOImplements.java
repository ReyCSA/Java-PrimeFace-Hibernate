package dao;

import java.util.List;
import model.TipoAuto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class tipoAutoDAOImplements implements tipoAutoDAO
{

    @Override
    public List<TipoAuto> mostrarTipoAuto() 
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
