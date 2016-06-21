package ru.home.appMain;

import ru.home.dao.*;
import ru.home.utils.DbHelper;
import ru.home.utils.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static ru.home.dao.RoleId.*;

/**
 * Created by Иван on 11.06.2016.
 */
public class AppMain {

    public static void main(String[] args) {
//ПЕРЕД ЗАПУСКОМ УБЕДИТЕСЬ ЧТО МАКСИМАЛЬНАЯ ДЛИНА ПАРОЛЯ В БАЗЕ НЕ МЕНЕЕ 32 СИМВОЛОВ
        EntityManager em = DbHelper.getEm();

/*------------- Добавление записей в базу
        em.getTransaction().begin();
        Role roleRes = new Role(RESIDENT, "Resident");
        Role roleProv = new Role(PROVIDER_EMP,"Provider employee");
        Role roleAdmin = new Role(ADMIN,"Administrator");
        Role roleHoas = new Role(HOA_EMP, "Hoa employee");

        em.merge(roleRes);
        em.merge(roleHoas);
        em.merge(roleProv);
        em.merge(roleAdmin);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int hoaId = DbHelper.getNewId(Hoa.class);
        Hoa hoa1 = new Hoa(hoaId++,"Mercury","Ленина 42","wwww.vvv.com","222-22-22");
        Hoa hoa2 = new Hoa(hoaId++,"Матрёна","Пушкина 22","wwww.ссс.com","8-800-555-35-35");
        Hoa hoa3 = new Hoa(hoaId++,"Супер ТСЖ","Суворова 12","wwww.vk.com","222-22-23");
        Hoa hoa4 = new Hoa(hoaId++,"Ораньжевая желеточка","Революционная 22","wwww.fb.com","02");
        em.merge(hoa1);
        em.merge(hoa2);
        em.merge(hoa3);
        em.merge(hoa4);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int addressId = DbHelper.getNewId(Address.class);
        Address address1 = new Address(addressId++, 2,2,2,"Пушкина",22,null,245);
        Address address2 = new Address(addressId++, 4,1,2,"Пушкина",22,null,247);
        Address address3 = new Address(addressId++, 1,3,2,"Пушкина",22,null,241);
        Address address4 = new Address(addressId++, 1,1,3,"Суворова",12,null,2);
        Address address5 = new Address(addressId++, 2,3,4,"Революционная",22,null,6);
        Address address6 = new Address(addressId++, 3,3,1,"Ленина",42,null,3);
        em.merge(address1);
        em.merge(address2);
        em.merge(address3);
        em.merge(address4);
        em.merge(address5);
        em.merge(address6);
        em.getTransaction().commit();

        em.getTransaction().begin();
        User administrator = new User("Admin",PasswordEncoder.md5Apache("Admin"),1,ADMIN);
        User providerEmp = new User("Prov",PasswordEncoder.md5Apache("Prov"),1,PROVIDER_EMP);
        User resident = new User("Resident",PasswordEncoder.md5Apache("Resident"),3,RESIDENT);
        User hoasEmp = new User("HoasEmp",PasswordEncoder.md5Apache("Hoas"),4,HOA_EMP);
        em.merge(administrator);
        em.merge(providerEmp);
        em.merge(resident);
        em.merge(hoasEmp);

        em.getTransaction().commit();
        */
        em.getTransaction().begin();
        int providerId = DbHelper.getNewId(Provider.class);
        Provider provider = new Provider(providerId++,"Dom.ru","Москва");
        Provider provider2 = new Provider(providerId++,"Водоканал","Самара");
        Provider provider3 = new Provider(providerId++,"Газовая компания","Самара");
        Provider provider4 = new Provider(providerId++,"Диван тв","Казань");
        Provider provider5 = new Provider(providerId++,"Грузоперевозка","Хабаровск");
        em.merge(provider);
        em.merge(provider2);
        em.merge(provider3);
        em.merge(provider4);
        em.merge(provider5);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int serviceId = DbHelper.getNewId(Service.class);
        Service service = new Service(serviceId++,"Интернет",1,false);
        Service service2 = new Service(serviceId++,"Водоснабжение",2,true);
        Service service3 = new Service(serviceId++,"Газ",3,true);
        Service service4 = new Service(serviceId++,"Кабельное ТВ",4,false);
        Service service5 = new Service(serviceId++,"Перевоз мебели",5,false);
        em.merge(service);
        em.merge(service2);
        em.merge(service3);
        em.merge(service4);
        em.merge(service5);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int abonentId = DbHelper.getNewId(Abonent.class);
        Abonent abonent = new Abonent(abonentId++,1,111111111,4);
        Abonent abonent2 = new Abonent(abonentId++,2,222222222,4);
        Abonent abonent3 = new Abonent(abonentId++,3,333333333,4);
        Abonent abonent4 = new Abonent(abonentId++,4,444444444,4);
        Abonent abonent5 = new Abonent(abonentId++,5,555555555,4);
        em.merge(abonent);
        em.merge(abonent2);
        em.merge(abonent3);
        em.merge(abonent4);
        em.merge(abonent5);
        em.getTransaction().commit();

        em.getTransaction().begin();
        int chargeId = DbHelper.getNewId(Charge.class);
        Charge charge = new Charge(chargeId++,1,600,new Date("01.02.2016"),new Date("01.03.2016"),true);
        Charge charge2 = new Charge(chargeId++,2,100,new Date("01.02.2016"),new Date("01.03.2016"),false);
        Charge charge3 = new Charge(chargeId++,3,600,new Date("01.01.2016"),new Date("01.03.2016"),true);
        Charge charge4 = new Charge(chargeId++,4,600,new Date("01.03.2016"),new Date("01.05.2016"),false);
        Charge charge5 = new Charge(chargeId++,5,600,new Date("01.01.2016"),new Date("01.04.2016"),true);
        em.getTransaction().commit();

        




/*-------------- Вытаскивание из базы по первичному ключу.
        User admin = em.find(User.class,"Admin");
*/

/*-------------- Получение списка всех записей в таблице
        TypedQuery<Role> query = DbHelper.getEm().createQuery("SELECT c FROM Role c",Role.class);
        for (Role role :query.getResultList()) {
            System.out.println(role.getRoleName());
        }
*/
    }


}
