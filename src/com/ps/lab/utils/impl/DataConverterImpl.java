package com.ps.lab.utils.impl;

import com.ps.lab.model.Book;
import com.ps.lab.model.ShoppingBasket;
import com.ps.lab.model.User;
import com.ps.lab.utils.DataConverter;

import java.util.List;

public class DataConverterImpl implements DataConverter {
    public Object[][] itemToTableData(List<Book> books) {
        Object[][] data = new Object[books.size()][5];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = books.get(row).getId();
            data[row][1] = books.get(row).getTitle();
            data[row][2] = books.get(row).getAuthor();
            data[row][3] = books.get(row).getGenre();
            data[row][4] = books.get(row).getPrice();
        }
        return data;
    }

    public Object[][] shoppingBasketToTableData(ShoppingBasket shoppingBasket) {
        Object[][] data = new Object[shoppingBasket.getItems().size()][4];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = shoppingBasket.getItems().get(row).getId();
            data[row][1] = shoppingBasket.getItems().get(row).getBook().getTitle();
            data[row][2] = shoppingBasket.getItems().get(row).getBook().getPrice();
            data[row][3] = shoppingBasket.getItems().get(row).getQuantity();
        }
        return data;
    }

    @Override
    public Object[][] userToTableData(List<User> users) {
        Object[][] data = new Object[users.size()][4];
        for(int row = 0; row<data.length;row++){
            data[row][0] = users.get(row).getId();
            data[row][1] = users.get(row).getUsername();
            data[row][2] = users.get(row).getPassword();
            data[row][3] = users.get(row).isAdmin();
        }
        return data;
    }

    @Override
    public String[] userToTableColumnNames() { return new String[]{"Id", "Username", "Password", "Admin"}; }

    public String[] itemToTableColumnNames() {
        return new String[]{"Id", "Title","Author","Genre", "Price"};
    }

    public String[] shoppingBasketToTableColumnNames() {
        return new String[]{"Id", "Title","Price", "Quantity"};
    }


}

/*

public class DataConverterImpl implements DataConverter {
    public Object[][] itemToTableData(List<Book> items) {
        Object[][] data = new Object[items.size()][3];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = items.get(row).getId();
            data[row][1] = items.get(row).getTitle();
            data[row][2] = items.get(row).getPrice();
        }
        return data;
    }

    public Object[][] shoppingBasketToTableData(ShoppingBasket shoppingBasket) {
        Object[][] data = new Object[shoppingBasket.getItems().size()][3];
        for (int row = 0; row < data.length; row++) {
            data[row][0] = shoppingBasket.getItems().get(row).getId();
            data[row][1] = shoppingBasket.getItems().get(row).getBook().getTitle();
            data[row][2] = shoppingBasket.getItems().get(row).getQuantity();
        }
        return data;
    }

    public String[] itemToTableColumnNames() {
        return new String[]{"Id", "Name", "Price"};
    }

    public String[] shoppingBasketToTableColumnNames() {
        return new String[]{"Id", "Name", "Quantity"};
    }
}

*/
