package com.ps.lab.model;

public class ShoppingBasketItem extends EntityObject {
    private Long shoppingBasketId;
    private Book book;
    private Integer quantity;

    public Long getShoppingBasketId() {
        return shoppingBasketId;
    }

    public void setShoppingBasketId(Long shoppingBasketId) {
        this.shoppingBasketId = shoppingBasketId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
