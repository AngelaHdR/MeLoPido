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
import com.fpmislata.MeLoPido.domain.usecase.model.command.ProductCommand;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.LetterQueryMapper;
import com.fpmislata.MeLoPido.domain.usecase.model.mapper.ProductQueryMapper;
import com.fpmislata.MeLoPido.util.exception.RessourceNotFoundException;
import com.fpmislata.MeLoPido.util.exception.UnauthorizedAccessException;

import java.util.Date;
import java.util.List;

public class LetterCommandService implements DeleteLetter, InsertLetter, UpdateLetter {
    private final LetterRepository letterRepository;
    private final ProductRepository productRepository;
    private final String currentUser = "1";
    private final List<String> currentGroup = List.of("1", "2");

    public LetterCommandService(LetterRepository letterRepository, ProductRepository productRepository) {
        this.letterRepository = letterRepository;
        this.productRepository = productRepository; //product ioc get repository
    }

    @Override
    public void delete(String idLetter) {
        Letter letter = letterRepository.findById(idLetter).orElseThrow(() -> new RessourceNotFoundException("Letter not found"));
        verifyCurrentUser(letter.getUser().getIdUser());

        letterRepository.delete(idLetter);
    }

    @Override
    public void insert(LetterCommand letter) {
        verifyCurrentUser(letter.idUser());

        letter.products().forEach(product -> productRepository.save(ProductQueryMapper.toProduct(product)));
        letterRepository.save(LetterQueryMapper.toLetter(letter));
    }

    @Override
    public void update(String idLetter, LetterCommand letter) {
        Letter letterExisting = letterRepository.findById(idLetter).orElseThrow(() -> new RessourceNotFoundException("Letter not found"));
        verifyCurrentUser(letterExisting.getUser().getIdUser());

        if (!letterExisting.getDescription().equals(letter.description())) {
            letterExisting.setDescription(letter.description());
        }
        if (diferentProducts(letterExisting.getProducts(), letter.products())) {
            if (letterExisting.getGroup() != null) {
                letterExisting.setProducts(addProducts(letterExisting.getProducts(), letter.products()));
            } else {
                letterExisting.setProducts(addProducts(letterExisting.getProducts(), letter.products()));
                letterExisting.setProducts(removeProducts(letterExisting.getProducts(), letter.products()));
            }
        }
        letterRepository.save(letterExisting);
    }

    private boolean diferentProducts(List<Product> productsExisting, List<ProductCommand> products) {
        List<Product> newProducts = ProductQueryMapper.toProductList(products);

        if (productsExisting.size() != newProducts.size()) {
            return true;
        }
        for (Product product : newProducts) {
            if (productsExisting.stream().noneMatch(productExisting ->
                    productExisting.getIdProduct().equals(product.getIdProduct()))) {
                return true;
            }
        }
        return false;
    }

    private List<Product> addProducts(List<Product> productsExisting, List<ProductCommand> products) {
        List<Product> newProducts = ProductQueryMapper.toProductList(products);
        newProducts.forEach(product -> {
            if (productsExisting.stream().noneMatch(productExisting -> productExisting.getIdProduct().equals(product.getIdProduct()))) {
                productsExisting.add(product);
                productRepository.save(product);
            }
        });
        return productsExisting;
    }

    private List<Product> removeProducts(List<Product> productsExisting, List<ProductCommand> products) {
        List<Product> newProducts = ProductQueryMapper.toProductList(products);
        productsExisting.forEach(product -> {
            if (newProducts.stream().noneMatch(productNew -> productNew.getIdProduct().equals(product.getIdProduct()))) {
                productsExisting.remove(product);
                productRepository.delete(product.getIdProduct());
            }
        });
        return productsExisting;
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
        if (idUser.equals(currentUser)) {
            throw new UnauthorizedAccessException("The user hasn't the right permits");
        }
    }
}