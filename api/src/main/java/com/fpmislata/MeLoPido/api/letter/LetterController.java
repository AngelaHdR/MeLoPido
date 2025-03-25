package com.fpmislata.MeLoPido.api.letter;

import com.fpmislata.MeLoPido.api.webModel.mapper.LetterWebModelMapper;
import com.fpmislata.MeLoPido.api.webModel.query.LetterBasicResponse;
import com.fpmislata.MeLoPido.api.webModel.query.LetterDetailResponse;
import com.fpmislata.MeLoPido.domain.model.ListWithCount;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindAllLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.letter.query.FindLetterByCriterial;
import com.fpmislata.MeLoPido.domain.usecase.model.query.LetterBasicQuery;
import com.fpmislata.MeLoPido.util.pagination.Page;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class LetterController {
    public static final String URL = "/api/letters";
    @Value("${app.base.url}")
    private String baseUrl;

    @Value("${app.pageSize.default}")
    private String defaultPageSize;

    private final FindAllLetterByCriterial findAllLetterByCriterial;
    private final FindLetterByCriterial findLetterByCriterial;

    public LetterController(FindAllLetterByCriterial findAllLetterByCriterial, FindLetterByCriterial findLetterByCriterial) {
        this.findAllLetterByCriterial = findAllLetterByCriterial;
        this.findLetterByCriterial = findLetterByCriterial;
    }

    @GetMapping()
    public ResponseEntity<Page<LetterBasicResponse>> findAll(@RequestParam(defaultValue = "1") int page, @RequestParam(required = false) Integer size) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<LetterBasicQuery> letterBasicQuery = findAllLetterByCriterial.findAll(page, pageSize);
        Page<LetterBasicResponse> pageResponse = new Page<>(letterBasicQuery.getList().stream().map(LetterWebModelMapper::toLetterBasicResponse).toList(), page, pageSize, letterBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/users/idUser")
    public ResponseEntity<Page<LetterBasicResponse>> findAllByUser(@RequestParam(defaultValue = "1") int page, @RequestParam(required = false) Integer size, @PathVariable String idUser) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<LetterBasicQuery> letterBasicQuery = findAllLetterByCriterial.findAllByUser(page, pageSize, idUser);
        Page<LetterBasicResponse> pageResponse = new Page<>(letterBasicQuery.getList().stream().map(LetterWebModelMapper::toLetterBasicResponse).toList(), page, pageSize, letterBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/groups/idGroup")
    public ResponseEntity<Page<LetterBasicResponse>> findAllByGroup(@RequestParam(defaultValue = "1") int page, @RequestParam(required = false) Integer size, @PathVariable String idGroup) {
        int pageSize = (size != null) ? size : Integer.parseInt((defaultPageSize));

        ListWithCount<LetterBasicQuery> letterBasicQuery = findAllLetterByCriterial.findAllByGroup(page, pageSize, idGroup);
        Page<LetterBasicResponse> pageResponse = new Page<>(letterBasicQuery.getList().stream().map(LetterWebModelMapper::toLetterBasicResponse).toList(), page, pageSize, letterBasicQuery.getCount());
        return new ResponseEntity<>(pageResponse, HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<LetterDetailResponse> findById(@PathVariable String id) {
        return new ResponseEntity<>(LetterWebModelMapper.toLetterDetailResponse(findLetterByCriterial.findById(id)), HttpStatus.OK);
    }
}
