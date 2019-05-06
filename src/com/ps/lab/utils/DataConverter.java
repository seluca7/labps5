package com.ps.lab.utils;

import com.ps.lab.model.Book;
import com.ps.lab.model.ShoppingBasket;
import com.ps.lab.model.User;

import java.util.List;

public interface DataConverter {

    Object[][] itemToTableData(List<Book> items);

    Object[][] shoppingBasketToTableData(ShoppingBasket shoppingBasket);

    String[] itemToTableColumnNames();

    Object[][] userToTableData(List<User> users);

    String[] shoppingBasketToTableColumnNames();

    String[] userToTableColumnNames();
}
