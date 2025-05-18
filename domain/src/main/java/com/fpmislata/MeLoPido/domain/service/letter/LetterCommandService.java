package com.fpmislata.MeLoPido.domain.service.letter;

import com.fpmislata.MeLoPido.domain.model.Group;
import com.fpmislata.MeLoPido.domain.model.Letter;
import com.fpmislata.MeLoPido.domain.model.Product;
import com.fpmislata.MeLoPido.domain.repository.LetterRepository;
import com.fpmislata.MeLoPido.domain.repository.ProductRepository;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.DeleteLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.InsertLetter;
import com.fpmislata.MeLoPido.domain.usecase.letter.command.UpdateLetter;
import com.fpmislata.MeLoPido.domain.usecase.model.command.LetterCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;

import java.util.*;

public class LetterCommandService implements DeleteLetter, InsertLetter, UpdateLetter {
    private final LetterRepository letterRepository;
    private final ProductRepository productRepository;
    private final String currentUser = "2";
    private final List<String> currentGroup = List.of("1");

    public LetterCommandService(LetterRepository letterRepository, ProductRepository productRepository) {
        this.letterRepository = letterRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void delete(String idLetter) {
        Letter letter = letterRepository.findById(idLetter).orElseThrow(() -> new RessourceNotFoundException("Letter not found"));
        verifyCurrentUser(letter.getUser().getIdUser());
        letterRepository.delete(idLetter);
    }

    @Override
    public void removeFromGroup(String id, String idGroup) {
        Letter letterExisting = letterRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Letter not found"));
        if(!letterExisting.getGroup().getIdGroup().equals(idGroup)){
            throw new UnauthorizedAccessException("User doesn't belong to group");
        }
        letterExisting.setGroup(null);
        letterExisting.setExpirationDate(null);
        letterRepository.save(letterExisting);
    }

    @Override
    public String insert(LetterCommand letter) {
        verifyCurrentUser(letter.idUser());
        return letterRepository.save(LetterQueryMapper.toLetter(letter));
    }

    @Override
    public void update(String idLetter, LetterCommand letter) {
        Letter letterExisting = letterRepository.findById(idLetter).orElseThrow(() -> new RessourceNotFoundException("Letter not found"));
        Letter newLetter = LetterQueryMapper.toLetter(letter);

        verifyCurrentUser(letterExisting.getUser().getIdUser());

        boolean changed = false;

        if (!letterExisting.getDescription().equals(newLetter.getDescription())) {
            letterExisting.setDescription(newLetter.getDescription());
            changed = true;
        }

        List<Product> incomingProducts = newLetter.getProducts();
        List<Product> currentProducts = letterExisting.getProducts() != null
                ? new ArrayList<>(letterExisting.getProducts())
                : new ArrayList<>();

        if (diferentProducts(currentProducts, incomingProducts)) {
            List<Product> updatedProducts = mergeProducts(currentProducts, incomingProducts, letterExisting.getGroup() != null);
            letterExisting.setProducts(updatedProducts);
            changed = true;
        }

        if (changed){
            letterRepository.save(letterExisting);
        }
    }

    private boolean diferentProducts(List<Product> productsExisting, List<Product> newProducts) {
        if (productsExisting.size() != newProducts.size()) return true;

        for (Product product : newProducts) {
            if (productsExisting.stream().noneMatch(productExisting ->
                    productExisting.getIdProduct().equals(product.getIdProduct()))) {
                return true;
            }
        }
        return false;
    }

    private List<Product> mergeProducts(List<Product> existing, List<Product> incoming, boolean isGroupLetter) {
        List<Product> result = new ArrayList<>(existing);

        for (Product product : incoming) {
            if (product.getIdProduct() == null || result.stream().noneMatch(p -> p.getIdProduct().equals(product.getIdProduct()))) {
                result.add(product);
            }
        }

        if (!isGroupLetter) {
            existing.forEach(product -> {
                if (incoming.stream().noneMatch(productNew -> productNew.getIdProduct().equals(product.getIdProduct()))) {
                    result.remove(product);
                    //productRepository.delete(product.getIdProduct());
                }
            });
        }

        return result;
    }


    @Override
    public void sendToGroup(String idLetter, String idGroup, String expirationDate) {
        Letter letter = letterRepository.findById(idLetter).orElseThrow(() -> new RessourceNotFoundException("Letter not found"));
        verifyCurrentUser(letter.getUser().getIdUser());

        if (letter.getGroup() != null) {
            throw new RuntimeException("The letter already has a group");
        }
        letter.setExpirationDate(expirationDate);
        letter.setSendDate(new Date().toString());
        letter.setGroup(new Group(idGroup));
        letterRepository.save(letter);
    }

    private void verifyCurrentUser(String idUser) {
        System.out.println("user:" + idUser);
        if (!idUser.equals(currentUser)) {
            throw new UnauthorizedAccessException("The user hasn't the right permits");
        }
    }
}