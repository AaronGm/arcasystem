package controllers;

import views.View;

public interface Controller<Obj> {

    View create();

    View update(Obj obj);

    View show();

    void destroy(Obj obj);

}
