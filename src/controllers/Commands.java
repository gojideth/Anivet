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

    //Mostar filtros de tablas
    C_SHOW_FILTER_TYPE,
    C_SHOW_FILTER_PRESENTATION,
    C_SHOW_FILTER_QUANTITY_AVAILABLE,
    C_SHOW_FILTER_PRICE,

    //mostrar panel de graficos
    C_SHOW_PANEL_GRAPHICS_BUTTONS,

    //Mostrar panel de filtros
    C_SHOW_PANEL_TABLES,

    //Mostrar filtros de graficos
    C_SHOW_GRAPHIC_MINOR_TO_HIGH,
    C_SHOW_GRAPHIC_MOST_SELLED,
    C_SHOW_GRAPHIC_QUANTITIES,
    C_SHOW_GRAPHIC_NIIDEA_QUANTITIES,

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
