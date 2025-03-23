package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.DeleteLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.InsertLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.UpdateLetter;
import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.ProductQueryMapper;

public class LetterCommandService implements DeleteLetter, InsertLetter, UpdateLetter {
    private final LetterRepository letterRepository;

    public LetterCommandService(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public void delete(Integer idLetter) {
        Letter letter = letterRepository.findById(idLetter);
        if (letter == null) {
            throw new RuntimeException("Letter not found");
        }
        letterRepository.delete(idLetter);
    }

    @Override
    public void insert(LetterCommand letter) {
        letterRepository.save(letter);
        //Guardar los productos, luego guardar la carta y asignar los productos a la carta
    }

    @Override
    public void update(Integer idLetter, LetterCommand letter) {
        Letter letterExisting = letterRepository.findById(idLetter);
        if (letter == null) {
            throw new RuntimeException("Letter not found");
        }
        if (!letterExisting.getDescription().equals(letter.description())) {
            letterExisting.setDescription(letter.description());
        }
        if (letterExisting.getProducts().size() != letter.products().size()) {
            letterExisting.setProducts(ProductQueryMapper.toProductList(letter.products()));
        }
        letterRepository.save(idLetter, letter);
    }
}