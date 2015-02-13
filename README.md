# Proyecto

####USER
AGREGO USUARIOS:	/addUser	? String user, String pass .

REMOVER USUARIOS:	/removeUser	? String user, String pass .

BUSCAR USUARIO(ID):	/searchUseR	? int userId
BUSCAR USUARIO(NOMBRE):	/getUser	? String user
TODOS LOS USUARIOS:	/allUsers

####PRODUCTOS
AGREGAR PRODUCTO:	/addProduct	? String name, double uniPrice, String category
REMOVER PRODUCTO:	/removeProduct	? String name
BUSCAR PRODUCTO(ID):	/searchProductId ? int id	
BUSCAR PRODUCTO(NOMBRE):/searchProductName ? String name
BUSCAR PRODUCTO(CATEGORIA):/searchProductCategory ? String category
MODIFICAR PRECIO UNITARIO:/setUniPrice	? int id, double uniPrice

####CART
AGREGAR CARRO:		/addCart	? int userId
BORRA CARRO:		/removeCart	? int id
BUSCAR CARRO:		/searchCart	? int userId
OBTENER CARRO:		/getCart	? int id
TODOS LOS CARROS:	/allCarts

####COMPRAS
AGREGAR COMPRA:		/addCompra	? int cartId,int productId, int quantity
REMOVER COMPRA:		/removeCompra	? int compraId
BUSCAR COMPRA(CART):	/searchCompraByCart ? int cartId
BUSCAR COMPRA(PRODUCTO):/searchCompraByProduct ? int productId
TODAS LAS COMPRAS:	/allCompras
COMFIRMAR COMPRA:	/ConfirmaCompra	? int cartId, int payOption(1=paypal, 2=cash, 3=credit card)
COMPRAS CONFIRMADAS:	/comprasConfirmadas 
COMPRAS NO CONFIRMADAS:	/comprasNoConfirmadas

