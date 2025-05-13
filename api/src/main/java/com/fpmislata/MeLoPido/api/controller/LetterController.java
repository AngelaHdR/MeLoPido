package com.fpmislata.MeLoPido.api.controller;

import com.fpmislata.MeLoPido.api.container.LetterIoC;
import com.fpmislata.MeLoPido.api.webModel.command.LetterRequest;
import com.fpmislata.MeLoPido.api.webModel.mapper.LetterWebModelMapper;
import com.fpmislata.MeLoPido.api.webModel.query.LetterBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.LetterDetailResponse;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.DeleteLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.InsertLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.UpdateLetter;
import com.fpmislata.MeLoPido.util.pagination.ListWithCount;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LetterController.URL)
public class LetterController {
    public static final String URL = "/api/letters";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final FindAllLetterByCriterial findAllLetterByCriterial;
    private final FindLetterByCriterial findLetterByCriterial;
    private final DeleteLetter deleteLetter;
    private final UpdateLetter updateLetter;
    private final InsertLetter insertLetter;

    public LetterController() {
        this.findAllLetterByCriterial = LetterIoC.getFindAllLetterByCriterial();
        this.findLetterByCriterial = LetterIoC.getFindLetterByCriterial();
        this.deleteLetter = LetterIoC.getDeleteLetter();
        this.updateLetter = LetterIoC.getUpdateLetter();
        this.insertLetter = LetterIoC.getInsertLetter();
    }

    @GetMapping()
    public ResponseEntity<Page<LetterBasicResponse>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(required = false) Integer size
    ) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<LetterBasicQuery> letterBasicQuery = findAllLetterByCriterial.findAll(page - 1, pageSize);
        Page<LetterBasicResponse> pageResponse = new Page<>(letterBasicQuery.getList().stream().map(LetterWebModelMapper::toLetterBasicResponse).toList(), page, pageSize, letterBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LetterDetailResponse> findById(@PathVariable String id) {
        return new ResponseEntity<>(LetterWebModelMapper.toLetterDetailResponse(findLetterByCriterial.findById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteLetter.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody LetterRequest letterRequest) {
        insertLetter.insert(LetterWebModelMapper.toLetterCommand(letterRequest));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @RequestBody LetterRequest letterRequest) {
        updateLetter.update(id, LetterWebModelMapper.toLetterCommand(letterRequest));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/groups/{idGroup}")
    public ResponseEntity<Void> sendoToGroup(
            @PathVariable String id,
            @PathVariable String idGroup,
            @RequestBody String expirationDate
    ) {
        updateLetter.sendToGroup(id, idGroup, expirationDate.replace("\"", ""));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}/groups/{idGroup}")
    public ResponseEntity<Void> removeFromGroup(@PathVariable String id,
                                                @PathVariable String idGroup){
        deleteLetter.removeFromGroup(id,idGroup);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
