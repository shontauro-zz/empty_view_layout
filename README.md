empty_view_layout
=================

English:

EmptyViewLayout is a view used with views such as ListViews, LinearLayouts, RelativeLayouts, etc.  when there isn't content to show, when is loading content and when occurs an error getting the content. You can show the correct view depends of the data state , for example if the adapter is empty you should show the EmptyView or if you are loading data you should show the LoadingView, and so on. 

Spanish:
EmptyViewLayout es un view que puede usarse con views como ListView, LinearLayout, RelativeLayout, etc. cuando no halla contenido para mostrar, cuando estes cargando contenido o cuando ucurra algun error al cargar el contenido. Tu puedes mostrar una pantalla de acuerdo al estado de los datos con los que estas trabajando por ejemplo si estas consumiendo datos de un servicio web entonces puedes mostrar el view loading mientras consumes los datos de la web, si ocurrio algun error al cargar los datos entonces puedes mostrar un view error con un mensaje correspondiente y configurar un button para que ejecute alguna tarea especifica en caso de error.

## Usage

#Instantiate an EmptyViewLayout / Instanciar un EmptyViewLayout

EmptyViewLayout favors composition over inheritance, So first you need to define a member variable of kind EmptyViewLayou in your Activity or Fragment and then instantiates It, using the constructor public EmptyViewLayout(Context context, View contentView) where the parameter contentView is a View inside of the hierarchies of views and this View can't be the root view.

(EmptyViewLayout favorece la composicion sobre la herencia, Entonces primero necesitas definir una variable miembro de tipo EmptyViewLayou dentro de tu Activity o Fragment y luego instanciar esta usando el constructor EmptyViewLayout(Context context, View contentView) donde el parametro contentView es una vista dentro de la jerarquia de vistas y esta vista no puede ser el root view.)

mEmptyViewLayout = new EmptyViewLayout(this, mListView);

//mListView is a view inside of the hierarchy views 

#Setup your EmptyViewLayout / Configurar tu EmptyViewLayout

You need to setup your EmptyViewLayout properties before uses it, otherwise EmptyViewLayout will work with the default parameters.

(Necesitas configurar las propiedades o atributos de tu EmptyViewLayout antes de usar este de otra forma trabajara con las propiedades por defecto)

//set an empty message and an error message (establece tu mensaje para cuando la data esta vacia o cuando hay error)
mEmptyViewLayout.setEmptyMessage(getString(R.string.empty_msg));
mEmptyViewLayout.setErrorMessage(getString(R.string.error_msg));

//set a View.OnClickListener for your EmptyButton otherwise It wont be showed in the EmptyView
(establece un View.OnClickListener para tu boton vacio de otra forma este no se mostrara cuando muestres el EmptyView)
mEmptyViewLayout.setEmptyButtonClickListener(mEmptyClickListener);
//set a View.OnClickListener for your ErrorButton otherwise It wont be showed in the ErrorView
(establece un View.OnClickListener para tu boton error de otra forma este no se mostrara cuando muestres el ErrorView
mEmptyViewLayout.setErrorButtonClickListener(mErrorClickListener);)

#show the corresponding views / muestra las vistas correspondientes

If you are getting or loading data you must call the mehotd mEmptyViewLayout.showLoading();
(si estas cargando u obteniendo datos llama al metodo mEmptyViewLayout.showLoading())

If you have empty data after you have loaded or gotten the data,you must call the method mEmptyViewLayout.showEmpty();
(si despues de cargar u obtener los datos estos estan vacios llama al metodo mEmptyViewLayout.showEmpty())

If you have an error getting or loading the data you must call the method mEmptyViewLayout.showError();
(si ocurre un error al cargar u obtener los datos llama al metodo mEmptyViewLayout.showError())

and If you got the data sucessfully you must call the method mEmptyViewLayout.showContentView();
(Si despues de cargar u obtener los datos estos no estan vacios llama al metodo mEmptyViewLayout.showContentView())

You can play calling the methods mEmptyViewLayout.showLoading(),
mEmptyViewLayout.showEmpty(),mEmptyViewLayout.showError() and mEmptyViewLayout.showContentView() in order to show the corresponding view according to your data state.

(Puedes jugar llamando a los metodos mEmptyViewLayout.showLoading(), mEmptyViewLayout.showEmpty(),mEmptyViewLayout.showError() and mEmptyViewLayout.showContentView()) de acuerdo al estado de tus datos.

#Screenshots 

![Screenshot](https://raw.github.com/shontauro/empty_view_layout/master/loading_view.png)
![Screenshot](https://raw.github.com/shontauro/empty_view_layout/master/empty_view.png)
![Screenshot](https://raw.github.com/shontauro/empty_view_layout/master/error_view.png)
![Screenshot](https://raw.github.com/shontauro/empty_view_layout/master/content_view.png)
