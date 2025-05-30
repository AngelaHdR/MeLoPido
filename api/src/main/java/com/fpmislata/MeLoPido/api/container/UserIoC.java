package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.domain.service.user.UserCommandService;
import com.fpmislata.MeLoPido.domain.service.user.UserQueryService;
import com.fpmislata.MeLoPido.domain.usecase.user.command.DeleteUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.InsertUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.UpdateUser;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindAllUserByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindUserByCriterial;
import com.fpmislata.MeLoPido.persistence.dao.UserDao;
import com.fpmislata.MeLoPido.persistence.dao.jpa.UserDaoJpa;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.UserJpaRepository;
import com.fpmislata.MeLoPido.persistence.repository.impl.user.UserRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import static com.fpmislata.MeLoPido.api.container.GroupIoC.getGroupRepository;
import static com.fpmislata.MeLoPido.api.container.LetterIoC.getLetterRepository;
import static com.fpmislata.MeLoPido.api.container.ProductIoC.getProductRepository;

public class UserIoC {
    private static UserQueryService userQueryService = new UserQueryService(getUserRepository(), getProductRepository(), getLetterRepository());

    private static UserCommandService userCommandService = new UserCommandService(getUserRepository(), getGroupRepository());

    private static UserRepository userRepository;

    public static FindAllUserByCriterial getFindAllUserByCriterial() {
        return userQueryService;
    }

    public static FindUserByCriterial getFindUserByCriterial() {
        return userQueryService;
    }

    public static DeleteUser getDeleteUser() {
        return userCommandService;
    }

    public static UpdateUser getUpdateUser() {
        return userCommandService;
    }

    public static InsertUser getInsertUser() {
        return userCommandService;
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            //userRepository = new UserRepositoryImpl(getUserJpaRepository());
            userRepository = new UserRepositoryImpl(getUserDao());
        }
        return userRepository;
    }

    public static UserJpaRepository getUserJpaRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meLoPidoUnit");
        EntityManager em = emf.createEntityManager();

        JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
        return factory.getRepository(UserJpaRepository.class);
    }

    public static UserDao getUserDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meLoPidoUnit");
        EntityManager em = emf.createEntityManager();
        return new UserDaoJpa(em);
    }

    public static void setUserQueryService(UserQueryService userService) {
        UserIoC.userQueryService = userService;
    }

    public static void setUserCommandService(UserCommandService userCommandService) {
        UserIoC.userCommandService = userCommandService;
    }

    public static void setUserRepository(UserRepository userRepository) {
        UserIoC.userRepository = userRepository;
    }

    public static void reset() {
        userQueryService = null;
        userCommandService = null;
        userRepository = null;
    }
}
