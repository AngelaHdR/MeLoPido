package com.fpmislata.MeLoPido.api.controller;

import com.fpmislata.MeLoPido.api.container.LetterIoC;
import com.fpmislata.MeLoPido.api.container.GroupIoC;
import com.fpmislata.MeLoPido.api.webModel.command.GroupRequest;
import com.fpmislata.MeLoPido.api.webModel.mapper.LetterWebModelMapper;
import com.fpmislata.MeLoPido.api.webModel.mapper.GroupWebModelMapper;
import com.fpmislata.MeLoPido.api.webModel.query.LetterBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.GroupBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.GroupDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.model.query.GroupBasicQuery;
import com.fpmislata.MeLoPido.domain.usecase.group.command.DeleteGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.InsertGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.command.UpdateGroup;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindAllGroupByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.group.query.FindGroupByCriterial;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.util.pagination.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(GroupController.URL)
public class GroupController {
    public static final String URL = "/api/groups";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final FindAllGroupByCriterial findAllGroupByCriterial;
    private final FindAllLetterByCriterial findAllLetterByCriterial;
    private final FindGroupByCriterial findGroupByCriterial;
    private final DeleteGroup deleteGroup;
    private final UpdateGroup updateGroup;
    private final InsertGroup insertGroup;

    public GroupController() {
        this.findAllGroupByCriterial = GroupIoC.getFindAllGroupByCriterial();
        this.findAllLetterByCriterial = LetterIoC.getFindAllLetterByCriterial();
        this.findGroupByCriterial = GroupIoC.getFindGroupByCriterial();
        this.deleteGroup = GroupIoC.getDeleteGroup();
        this.updateGroup = GroupIoC.getUpdateGroup();
        this.insertGroup = GroupIoC.getInsertGroup();
    }

    @GetMapping()
    public ResponseEntity<Page<GroupBasicResponse>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<GroupBasicQuery> groupBasicQuery = findAllGroupByCriterial.findAll(page - 1, pageSize);
        Page<GroupBasicResponse> pageResponse = new Page<>(groupBasicQuery.getList().stream().map(GroupWebModelMapper::toGroupBasicResponse).toList(), page, pageSize, groupBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDetailResponse> findById(@PathVariable String id) {
        return new ResponseEntity<>(GroupWebModelMapper.toGroupDetailResponse(findGroupByCriterial.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/{id}/letters")
    public ResponseEntity<Page<LetterBasicResponse>> findAllLettersByGroupId(
            @PathVariable String id,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<LetterBasicQuery> letterBasicQuery = findAllLetterByCriterial.findAllByGroup(page - 1, pageSize, id);
        Page<LetterBasicResponse> pageResponse = new Page<>(letterBasicQuery.getList().stream().map(LetterWebModelMapper::toLetterBasicResponse).toList(), page, pageSize, letterBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteGroup.deleteGroup(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody GroupRequest groupRequest) {
        insertGroup.insert(GroupWebModelMapper.toGroupCommand(groupRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody GroupRequest groupRequest) {
        updateGroup.update(id, GroupWebModelMapper.toGroupCommand(groupRequest));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
