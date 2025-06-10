package com.fpmislata.MeLoPido.domain.service.user;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.model.User;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.domain.repository.UserRepository;
import com.fpmislata.MeLoPido.domain.usecase.model.command.UserCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.GroupQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.ProductQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.UserQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.query.*;
import com.fpmislata.MeLoPido.domain.usecase.user.command.DeleteUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.InsertUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.UpdateUser;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindAllUserByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindUserByCriterial;
import com.fpmislata.MeLoPido.util.exception.PagedCollectionException;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

public class UserQueryService implements FindAllUserByCriterial, FindUserByCriterial {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final LetterRepository letterRepository;
    private final String currentUser = "Ana Ortiz Gomez";
    private final List<String> currentGroup = List.of("Reyes Familia Ortiz");

    public UserQueryService(UserRepository userRepository, ProductRepository productRepository, LetterRepository letterRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.letterRepository = letterRepository;
    }

    @Override
    public ListWithCount<UserBasicQuery> findAll(int page, int pageSize) {
        verifyPageAndSize(page, pageSize);

        ListWithCount<User> userList = userRepository.findAll(page, pageSize);
        return new ListWithCount<>(userList.getList().stream().map(UserQueryMapper::toUserBasicQuery).toList(), userList.getCount());
    }

    @Override
    public ListWithCount<UserBasicQuery> findAllByGroup(int page, int pageSize, String idGroup) {
        verifyPageAndSize(page, pageSize);

        ListWithCount<User> userList = userRepository.findAllByGroup(page, pageSize, idGroup);
        return new ListWithCount<>(userList.getList().stream().map(UserQueryMapper::toUserBasicQuery).toList(), userList.getCount());
    }

    @Override
    public UserQuery findById(String idUser) {
        UserQuery userQuery = UserQueryMapper.toUserQuery(userRepository.findById(idUser).orElseThrow(() -> new RessourceNotFoundException("User not found")));

        List<ProductBasicQuery> productsAssigned = ProductQueryMapper.toProductBasicQueryList(productRepository.findAllAssignedToUser( 0, 15, idUser).getList());
        userQuery.setProducts(productsAssigned);

        List<LetterBasicQuery> letters = LetterQueryMapper.toLetterBasicQueryList(letterRepository.findAllByUser(0, 15, idUser).getList());
        userQuery.setLetters(letters);
        return userQuery;
    }

    @Override
    public UserQuery findByProductId(String idProduct) {
        return null;
    }

    private void verifyCurrentUser(String idUser) {
        System.out.println("user:" + idUser);
        if (!idUser.equals(currentUser)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyCurrentUserOrGroup(String idUser, String idGroup) {
        System.out.println("user:" + idUser + "group:" + idGroup);
        if (!idUser.equals(currentUser) && !currentGroup.contains(idGroup)) {
            throw new UnauthorizedAccessException("User does not have the necessary permissions");
        }
    }

    private void verifyPageAndSize(int page, int pageSize) {
        if (page < 0 || pageSize <= 0) {
            throw new PagedCollectionException("Page number and size must be greater than 0");
        }
    }
}
