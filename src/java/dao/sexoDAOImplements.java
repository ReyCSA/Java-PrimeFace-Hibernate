package dao;

import java.util.List;
import model.Sexo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.NewHibernateUtil;

public class sexoDAOImplements implements sexoDAO
{

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
