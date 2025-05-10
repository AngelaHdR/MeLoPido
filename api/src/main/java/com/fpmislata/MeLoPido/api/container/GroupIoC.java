package com.fpmislata.MeLoPido.api.container;

import com.fpmislata.MeLoPido.domain.repository.GroupRepository;
import com.fpmislata.MeLoPido.domain.service.group.GroupCommandService;
import com.fpmislata.MeLoPido.domain.service.group.GroupQueryService;
import com.fpmislata.MeLoPido.domain.usecase.group.command.DeleteGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.InsertGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.UpdateGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindAllGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindGroupByCriterial;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.GroupJpaRepository;
import com.fpmislata.MeLoPido.persistence.dao.jpa.repository.LetterJpaRepository;
import com.fpmislata.MeLoPido.persistence.repository.impl.group.GroupRepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

import static com.fpmislata.MeLoPido.api.container.LetterIoC.getLetterRepository;
import static com.fpmislata.MeLoPido.api.container.UserIoC.getUserRepository;

public class GroupIoC {
    private static GroupQueryService groupQueryService = new GroupQueryService(getGroupRepository(), getUserRepository(), getLetterRepository());
    private static GroupCommandService groupCommandService = new GroupCommandService(getGroupRepository());

    private static GroupRepository groupRepository;

    public static FindAllGroupByCriterial getFindAllGroupByCriterial() {
        return groupQueryService;
    }

    public static FindGroupByCriterial getFindGroupByCriterial() {
        return groupQueryService;
    }

    public static DeleteGroup getDeleteGroup() {
        return groupCommandService;
    }

    public static UpdateGroup getUpdateGroup() {
        return groupCommandService;
    }

    public static InsertGroup getInsertGroup() {
        return groupCommandService;
    }

    public static GroupRepository getGroupRepository() {
        if (groupRepository == null) {
            groupRepository = new GroupRepositoryImpl(getGroupJpaRepository());
        }
        return groupRepository;
    }

    public static GroupJpaRepository getGroupJpaRepository() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meLoPidoUnit");
        EntityManager em = emf.createEntityManager();

        JpaRepositoryFactory factory = new JpaRepositoryFactory(em);
        return factory.getRepository(GroupJpaRepository.class);
    }

    public static void setGroupQueryService(GroupQueryService groupService) {
        GroupIoC.groupQueryService = groupService;
    }

    public static void setGroupCommandService(GroupCommandService groupCommandService) {
        GroupIoC.groupCommandService = groupCommandService;
    }

    public static void setGroupRepository(GroupRepository groupRepository) {
        GroupIoC.groupRepository = groupRepository;
    }

    public static void reset() {
        groupQueryService = null;
        groupCommandService = null;
        groupRepository = null;
    }
}
