package com.ps.lab.model;

import java.util.List;

public class ShoppingBasket extends EntityObject {
    private User user;
    private List<ShoppingBasketItem> books;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ShoppingBasketItem> getItems() {
        return books;
    }

    public void setItems(List<ShoppingBasketItem> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ShoppingBasket id=" + super.getId() + " of user=" + user.getUsername();
    }
}
