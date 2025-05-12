package com.fpmislata.MeLoPido.api.controller;

import com.fpmislata.MeLoPido.api.container.*;
import com.fpmislata.MeLoPido.api.webModel.command.UserRequest;
import com.fpmislata.MeLoPido.api.webModel.mapper.*;
import com.fpmislata.MeLoPido.api.webModel.query.*;
import com.fpmislata.MeLoPido.domain.usecase.chat.query.FindAllChatByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindAllGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.query.*;
import com.fpmislata.MeLoPido.domain.usecase.product.query.FindAllProductByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.user.command.DeleteUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.InsertUser;
import com.fpmislata.MeLoPido.domain.usecase.user.command.UpdateUser;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindAllUserByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.user.query.FindUserByCriterial;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.util.pagination.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.URL)
public class UserController {
    public static final String URL = "/api/users";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final FindAllUserByCriterial findAllUserByCriterial;
    private final FindUserByCriterial findUserByCriterial;
    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;
    private final InsertUser insertUser;

    private final FindAllLetterByCriterial findAllLetterByCriterial;
    private final FindAllGroupByCriterial findAllGroupByCriterial;
    private final FindAllProductByCriterial findAllProductByCriterial;
    private final FindAllChatByCriterial findAllChatByCriterial;

    public UserController() {
        this.findAllUserByCriterial = UserIoC.getFindAllUserByCriterial();
        this.findUserByCriterial = UserIoC.getFindUserByCriterial();
        this.deleteUser = UserIoC.getDeleteUser();
        this.updateUser = UserIoC.getUpdateUser();
        this.insertUser = UserIoC.getInsertUser();
        this.findAllLetterByCriterial = LetterIoC.getFindAllLetterByCriterial();
        this.findAllGroupByCriterial = GroupIoC.getFindAllGroupByCriterial();
        this.findAllProductByCriterial = ProductIoC.getFindAllProductByCriterial();
        this.findAllChatByCriterial = ChatIoC.getFindAllChatByCriterial();
    }

    @GetMapping()
    public ResponseEntity<Page<UserBasicResponse>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<UserBasicQuery> userBasicQuery = findAllUserByCriterial.findAll(page - 1, pageSize);
        Page<UserBasicResponse> pageResponse = new Page<>(userBasicQuery.getList().stream().map(UserWebModelMapper::toUserBasicResponse).toList(), page, pageSize, userBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailResponse> findById(@PathVariable String id) {
        return new ResponseEntity<>(UserWebModelMapper.toUserDetailResponse(findUserByCriterial.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}/letters")
    public ResponseEntity<Page<LetterBasicResponse>> findAllLettersByUserId(
            @PathVariable String id,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<LetterBasicQuery> letterBasicQuery = findAllLetterByCriterial.findAllByUser(page - 1, pageSize, id);
        Page<LetterBasicResponse> pageResponse = new Page<>(letterBasicQuery.getList().stream().map(LetterWebModelMapper::toLetterBasicResponse).toList(), page, pageSize, letterBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/groups")
    public ResponseEntity<Page<GroupBasicResponse>> findAllGroupsByUserId(
            @PathVariable String id,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<GroupBasicQuery> groupBasicQuery = findAllGroupByCriterial.findAllByUser(page - 1, pageSize, id);
        Page<GroupBasicResponse> pageResponse = new Page<>(GroupWebModelMapper.toGroupBasicResponseList(groupBasicQuery.getList()), page, pageSize, groupBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/productsAssigned")
    public ResponseEntity<Page<ProductBasicResponse>> findAllProductsAssignedByUserId(
            @PathVariable String id,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<ProductBasicQuery> productsBasicQuery = findAllProductByCriterial.findAllAssignedToUser(page - 1, pageSize, id);
        Page<ProductBasicResponse> pageResponse = new Page<>(ProductWebModelMapper.toProductBasicResponseList(productsBasicQuery.getList()), page, pageSize, productsBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}/chats")
    public ResponseEntity<Page<ChatDetailResponse>> findAllChatsByUserId(
            @PathVariable String id,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<ChatQuery> chatQuery = findAllChatByCriterial.findAllByUser(page - 1, pageSize, id);
        Page<ChatDetailResponse> pageResponse = new Page<>(chatQuery.getList().stream().map(ChatWebModelMapper::toChatDetailResponse).toList(), page, pageSize, chatQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteUser.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody UserRequest userRequest) {
        insertUser.insert(UserWebModelMapper.toUserCommand(userRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserRequest userRequest) {
        updateUser.update(id, UserWebModelMapper.toUserCommand(userRequest));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/groups/{idGroup}")
    public ResponseEntity<Void> addToGroup(@PathVariable String id, @PathVariable String idGroup) {
        updateUser.addToGroup(id, idGroup);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}/groups/{idGroup}")
    public ResponseEntity<Void> removeFromGroup(@PathVariable String id, @PathVariable String idGroup) {
        deleteUser.removeFromGroup(id, idGroup);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
