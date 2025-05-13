package com.fpmislata.MeLoPido.persistence.dao.jpa.mapper;

import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.persistence.dao.jpa.entity.LetterEntity;

public class LetterEntityMapper {
    public static Letter toLetter(LetterEntity letterEntity) {
        if (letterEntity == null) {
            return null;
        }
        Letter letter = new Letter();
        letter.setIdLetter(letterEntity.getIdLetter());
        letter.setDescription(letterEntity.getDescription());
        letter.setCreationDate(letterEntity.getCreationDate());
        letter.setSendDate(letterEntity.getSendDate());
        letter.setExpirationDate(letterEntity.getExpirationDate());
        letter.setUser(UserEntityMapper.toUser(letterEntity.getUser()));
        letter.setGroup(GroupEntityMapper.toGroup(letterEntity.getGroup()));
        letter.setProducts(ProductEntityMapper.toProductList(letterEntity.getProducts()));
        return letter;
    }

    public static LetterEntity toLetterEntity(Letter letter) {
        if (letter == null) {
            return null;
        }
        LetterEntity letterEntity = new LetterEntity();
        letterEntity.setIdLetter(letter.getIdLetter());
        letterEntity.setDescription(letter.getDescription());
        letterEntity.setCreationDate(letter.getCreationDate());
        letterEntity.setSendDate(letter.getSendDate());
        letterEntity.setExpirationDate(letter.getExpirationDate());
        letterEntity.setUser(UserEntityMapper.toUserEntity(letter.getUser()));
        letterEntity.setGroup(GroupEntityMapper.toGroupEntity(letter.getGroup()));
        letterEntity.setProducts(ProductEntityMapper.toProductEntityList(letter.getProducts()));
        return letterEntity;
    }
}
