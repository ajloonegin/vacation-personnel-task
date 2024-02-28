//package State2;
//import java.util.List;
//
//import State2.entity.Personnel;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//public class App {
//    public static void main(String[] args) {
//
//        Personnel p1 = new Personnel(1,"Ali","gholami","06102616","Arak");
//        Personnel p2 = new Personnel(2,"hossein","rahimi","06102612","karaj");
//        Transaction transaction = null;
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            // start a transaction
//            transaction = session.beginTransaction();
//            // save the student objects
//            session.save(p1);
//            session.save(p2);
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//
//        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//            List < Personnel > Personnels = session.createQuery("from Personnel ", Personnel.class).list();
//            Personnels.forEach(s -> System.out.println(s.getFirstName()));
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//    }
//}
