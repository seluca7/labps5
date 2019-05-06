package com.ps.lab.controller;

import com.ps.lab.model.User;
import com.ps.lab.repository.ItemRepository;
import com.ps.lab.repository.ShoppingBasketItemRepository;
import com.ps.lab.repository.ShoppingBasketRepository;
import com.ps.lab.repository.UserRepository;
import com.ps.lab.repository.impl.*;
import com.ps.lab.service.ItemService;
import com.ps.lab.service.ShoppingBasketService;
import com.ps.lab.service.UserService;
import com.ps.lab.service.impl.ItemServiceImpl;
import com.ps.lab.service.impl.ShoppingBasketDecoratorImpl;
import com.ps.lab.service.impl.ShoppingBasketServiceImpl;
import com.ps.lab.service.impl.UserServiceImpl;
import com.ps.lab.utils.DataConverter;
import com.ps.lab.utils.impl.DataConverterImpl;
import com.ps.lab.view.AdminW;
import com.ps.lab.view.LoginView;
import com.ps.lab.view.LoginW;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    final String schema = "bookdb";
    private JDBConnectionWrapper jdbConnectionWrapper = new JDBConnectionWrapper(schema);
    private UserRepository userRepository = new UserRepositoryImpl(jdbConnectionWrapper);
    private ItemRepository bookRepository = new ItemRepositoryImpl(jdbConnectionWrapper);
    private UserServiceImpl userService = new UserServiceImpl(userRepository);
    private ItemService bookService = new ItemServiceImpl(bookRepository);
    private ShoppingBasketItemRepository shoppingBasketBookRepository = new ShoppingBasketItemRepositoryImpl(jdbConnectionWrapper);
    private ShoppingBasketRepository shoppingBasketRepository = new ShoppingBasketRepositoryImpl(jdbConnectionWrapper, shoppingBasketBookRepository);
    private DataConverter dataConverter = new DataConverterImpl();
    private ShoppingBasketService shoppingBasketService = new ShoppingBasketServiceImpl(bookRepository,
            shoppingBasketBookRepository,
            shoppingBasketRepository);
    private ShoppingBasketService shoppingBasketServiceDecorator = new ShoppingBasketDecoratorImpl(shoppingBasketService);
    private AdminW adminW = new AdminW();
   // private UserPresentation userPresentation = new UserPresentation();
    //private LoginWindow loginWindow = new LoginWindow();
   private LoginW loginW = new LoginW();

    AdminController adminController = new AdminController(adminW, userService, dataConverter);
    //UserController userController = new UserController(userPresentation,
         //   bookService,
         //   dataConverter,
         //   shoppingBasketServiceDecorator,
         //   shoppingBasketBookRepository,
         //   userService);

    public LoginController()

    {
        loginW.addLoginActionListener(new LoginActionListener());
    }

    private class LoginActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String username = loginW.getUsername();
            String password = loginW.getPassword();
            User user = userService.login(username,password);

            if(user.equals(null)){
                System.out.println("login failed");
            }
            else {
                if (user.isAdmin()) {
                    System.out.println("esti admin");
                    adminW.setVisible(true);
                } else {
                    System.out.println("esti user normal");
                    //userPresentation.setVisible(true);
                }
            }

        }
    }




    /*

    private final UserService userService;

    public LoginController(LoginView loginView,
                           UserService userService) {

        this.userService = userService;

        //culegem date din model (service, etc)
            //mapari de obiecte

        //populam UI-ul
    }

    //cate o clasa privata care implementeaza
    //ActionListener pentru fiecare buton
    private class LoginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            String username = ui.getUsername();
//            String password = ui.getPassword();
//
//            User currentUser = userService.login(username, password);
//            if(currentUser != null) {
//                //successful login
//                contextHolder.setCurrentUser(currentUser);
//                getOuter().setVisible(false);
//                if(currentUser.isAdmin()) {
//                    System.out.println("open admin panel");
//                } else {
//                    Main.openUserView();
//                }
//            } else {
//                cleatInputs();
//            }
        }
    }

    //metode private ajutatoare

*/
}
