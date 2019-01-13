package controllers;

import views.View;

public interface Controller<Obj> {

    View create(View view);

    View update(View view, Obj obj);

    View show(View view);

    void destroy(Obj obj);

}
