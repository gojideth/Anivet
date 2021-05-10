package controllers;

public enum Commands {

    LOGIN_BUTTON,
    LOGOUT,

    //Dialogs
    CREATE_CLIENT_DIALOG,
    CREATE_PRODUCT_DIALOG_AND_CLOSE,
    CREAT_ADMIN_DIALOG,

    //Mostrar o esconder paneles
    C_SHOW_DIALOG_CLIENT,
    C_SHOW_HOMEPAGE,
    C_SHOW_TABLE,
    C_SHOW_DIALOG_PRODUCT,
    C_SHOW_DIALOG_ADMIN,
    C_SHOW_CART,

    //ChangeIdioms
    I_CHANGE_TO_SPANISH,
    I_CHANGE_TO_ENGLISH,



    //Comandos de botones,
    C_ADD_PRODUCT,
    C_DELETE_PRODUCT,
    C_ORGANICE_PRODUCTS,
    C_BUY_PRODUCTS,
    C_LIST_PRODUCTS,
    C_PROCEED_BUY,
    C_ADD_TO_CART,
    SIGN_IN ;
}
